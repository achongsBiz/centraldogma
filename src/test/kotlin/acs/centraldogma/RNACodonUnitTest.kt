package acs.centraldogma

import org.fest.assertions.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class RNACodonUnitTest {

    @Test
    fun `Correct Translation from RNA to Amino Acid - First Base Uracil`() {
        val firstRNACodonTest = RNACodon("UUU")
        assertThat(firstRNACodonTest.outputAminoSequence).isEqualTo(Amino.Phe)

        val secondRNACodonTest = RNACodon("UUC")
        assertThat(secondRNACodonTest.outputAminoSequence).isEqualTo(Amino.Phe)

        val thirdRNACodonTest = RNACodon("UUA")
        assertThat(thirdRNACodonTest.outputAminoSequence).isEqualTo(Amino.Leu)

        val fourthRNACodonTest = RNACodon("UUG")
        assertThat(fourthRNACodonTest.outputAminoSequence).isEqualTo(Amino.Leu)

        val fifthRNACodonTest = RNACodon("UCU")
        assertThat(fifthRNACodonTest.outputAminoSequence).isEqualTo(Amino.Ser)

        val sixthRNACodonTest = RNACodon("UCC")
        assertThat(sixthRNACodonTest.outputAminoSequence).isEqualTo(Amino.Ser)

        val seventhRNACodonTest = RNACodon("UCA")
        assertThat(seventhRNACodonTest.outputAminoSequence).isEqualTo(Amino.Ser)

        val eighthRNACodonTest = RNACodon("UCG")
        assertThat(eighthRNACodonTest.outputAminoSequence).isEqualTo(Amino.Ser)

    }
}