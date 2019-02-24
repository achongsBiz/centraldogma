package acs.centraldogma

import org.fest.assertions.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class MainControllerTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `Prep sequence should correctly output parsed sections and unparsed sections`() {

        val a  = MainController()
        val preparedSequence = a.prepDNASequence(DNAWebObject("ATGCGGTTAA", "dna"))

        assertThat(preparedSequence.length).isEqualTo(10)
        assertThat(preparedSequence.modulo).isEqualTo(1)
        assertThat(preparedSequence.totalCodons).isEqualTo(3)
        assertThat(preparedSequence.totalParsedLength).isEqualTo(9)
        assertThat(preparedSequence.unParsedSequence).isEqualTo("A")
        assertThat(preparedSequence.parsedSequence).isEqualTo("ATGCGGTTA")
    }


    @Test
    fun `Codon is Parsed`() {

        val x = DNAWebObject("ATGCGGTTAA", "dna")

        val a  = MainController()
        a.dnaRequest(x)





    }
}