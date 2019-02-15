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
        val firstRNACodonTest = RNACodon(arrayListOf(Base.U, Base.U, Base.U))
        assertThat(firstRNACodonTest.outputAminoSequence).isEqualTo(Amino.Phe)

        val secondRNACodonTest = RNACodon(arrayListOf(Base.U, Base.U, Base.C))
        assertThat(secondRNACodonTest.outputAminoSequence).isEqualTo(Amino.Phe)

        val thirdRNACodonTest = RNACodon(arrayListOf(Base.U, Base.U, Base.A))
        assertThat(thirdRNACodonTest.outputAminoSequence).isEqualTo(Amino.Leu)

        val fourthRNACodonTest = RNACodon(arrayListOf(Base.U, Base.U, Base.G))
        assertThat(fourthRNACodonTest.outputAminoSequence).isEqualTo(Amino.Leu)

        val fifthRNACodonTest = RNACodon(arrayListOf(Base.U, Base.C, Base.U))
        assertThat(fifthRNACodonTest.outputAminoSequence).isEqualTo(Amino.Ser)

        val sixthRNACodonTest = RNACodon(arrayListOf(Base.U, Base.C, Base.C))
        assertThat(sixthRNACodonTest.outputAminoSequence).isEqualTo(Amino.Ser)

        val seventhRNACodonTest = RNACodon(arrayListOf(Base.U, Base.C, Base.A))
        assertThat(seventhRNACodonTest.outputAminoSequence).isEqualTo(Amino.Ser)

        val eighthRNACodonTest = RNACodon(arrayListOf(Base.U, Base.C, Base.G))
        assertThat(eighthRNACodonTest.outputAminoSequence).isEqualTo(Amino.Ser)

    }
}