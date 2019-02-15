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
        val preparedSequence = a.prepSequence(DNAWebObject("ATGCGGTTAA", "dna"))

        assertThat(preparedSequence.path("length").asInt()).isEqualTo(10)
        assertThat(preparedSequence.path("modulo").asInt()).isEqualTo(1)
        assertThat(preparedSequence.path("totalCodons").asInt()).isEqualTo(3)
        assertThat(preparedSequence.path("totalParsedLength").asInt()).isEqualTo(9)
        assertThat(preparedSequence.path("unParsedSequence").textValue()).isEqualTo("A")
        assertThat(preparedSequence.path("parsedSequence").textValue()).isEqualTo("ATGCGGTTA")
    }

}