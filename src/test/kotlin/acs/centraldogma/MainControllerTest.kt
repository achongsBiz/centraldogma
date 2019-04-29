package acs.centraldogma

import acs.centraldogma.domain.DNACodon
import acs.centraldogma.domain.RNACodon
import acs.centraldogma.web.MainController
import acs.centraldogma.web.WebRequestObject
import acs.centraldogma.web.WebReturnObject
import com.fasterxml.jackson.databind.ObjectMapper
import org.fest.assertions.Assertions.assertThat
import org.json.JSONObject
import org.junit.Test
import org.springframework.http.ResponseEntity

class MainControllerTest {

    @Test
    fun `Prep sequence should correctly output parsed sections and unparsed sections`() {

        val a  = MainController()
        val preparedSequence = a.prepDNASequence(WebRequestObject("ATGCGGTTAA", "dna"))

        assertThat(preparedSequence.length).isEqualTo(10)
        assertThat(preparedSequence.modulo).isEqualTo(1)
        assertThat(preparedSequence.totalCodons).isEqualTo(3)
        assertThat(preparedSequence.totalParsedLength).isEqualTo(9)
        assertThat(preparedSequence.unParsedSequence).isEqualTo("A")
        assertThat(preparedSequence.parsedSequence).isEqualTo("ATGCGGTTA")
    }


    @Test
    fun `DNA Codon is Parsed correctly`() {

        val webRequest = WebRequestObject("ATGCGGTTAA", "rna")
        val firstExpectedTriplet = DNACodon("ATG")
        val secondExpectedTriplet = DNACodon("CGG")
        val thirdExpectedTriplet = DNACodon("TTA")
        val expectedListofTriplets = listOf(firstExpectedTriplet.outputRNASequence.toString()
                , secondExpectedTriplet.outputRNASequence.toString()
                , thirdExpectedTriplet.outputRNASequence.toString())

        val controller  = MainController()
        val response = controller.dnaRequest(webRequest)
        val testCallResponse : WebReturnObject? = response.body

        verifySuccessfulCall(response)
        assertThat(testCallResponse?.results).isEqualTo(expectedListofTriplets)
    }

    @Test
    fun `RNA Codon is Parsed correctly`() {

        val webRequest = WebRequestObject("UUUGUUG", "amino")
        val firstExpectedTriplet = RNACodon("UUU")
        val secondExpectedTriplet = RNACodon("GUU")
        val expectedListOfAminos = listOf(firstExpectedTriplet.outputAminoSequence.toString(), secondExpectedTriplet.outputAminoSequence.toString())

        val controller  = MainController()
        val response = controller.rnaRequest(webRequest)
        val testCallResponse : WebReturnObject? = response.body

        verifySuccessfulCall(response)
        assertThat(testCallResponse?.results).isEqualTo(expectedListOfAminos)
    }

    fun verifySuccessfulCall(response : ResponseEntity<WebReturnObject>) {

        assertThat(response.statusCode.toString()).isEqualTo("200 OK")
    }
}