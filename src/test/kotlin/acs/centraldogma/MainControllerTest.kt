package acs.centraldogma

import org.fest.assertions.Assertions.assertThat
import org.junit.Test

class MainControllerTest {

    @Test
    fun `Prep sequence should correctly output parsed sections and unparsed sections`() {

        val a  = MainController()
        val preparedSequence = a.prepDNASequence(WebObject("ATGCGGTTAA", "dna"))

        assertThat(preparedSequence.length).isEqualTo(10)
        assertThat(preparedSequence.modulo).isEqualTo(1)
        assertThat(preparedSequence.totalCodons).isEqualTo(3)
        assertThat(preparedSequence.totalParsedLength).isEqualTo(9)
        assertThat(preparedSequence.unParsedSequence).isEqualTo("A")
        assertThat(preparedSequence.parsedSequence).isEqualTo("ATGCGGTTA")
    }


    @Test
    fun `DNA Codon is Parsed correctly`() {

        val x = WebObject("ATGCGGTTAA", "dna")

        val a  = MainController()
        a.dnaRequest(x)
    }

    @Test
    fun `RNA Codon is Parsed correctly`() {

        val x = WebObject("UUUGUUU", "amino")

        val a  = MainController()
        a.rnaRequest(x)
    }
}