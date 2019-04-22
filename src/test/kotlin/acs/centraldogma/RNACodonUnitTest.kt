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

        val ninthRNACodonTest = RNACodon("UAU")
        assertThat(ninthRNACodonTest.outputAminoSequence).isEqualTo(Amino.Tyr)

        val tenthRNACodonTest = RNACodon("UAC")
        assertThat(tenthRNACodonTest.outputAminoSequence).isEqualTo(Amino.Tyr)

        val RNACodonTest11 = RNACodon("UAA")
        assertThat(RNACodonTest11.outputAminoSequence).isEqualTo(Amino.STOP)

        val RNACodonTest12 = RNACodon("UAG")
        assertThat(RNACodonTest12.outputAminoSequence).isEqualTo(Amino.STOP)

        val RNACodonTest13 = RNACodon("UGU")
        assertThat(RNACodonTest13.outputAminoSequence).isEqualTo(Amino.Cys)

        val RNACodonTest14 = RNACodon("UGC")
        assertThat(RNACodonTest14.outputAminoSequence).isEqualTo(Amino.Cys)

        val RNACodonTest15 = RNACodon("UGA")
        assertThat(RNACodonTest15.outputAminoSequence).isEqualTo(Amino.STOP)

        val RNACodonTest16 = RNACodon("UGG")
        assertThat(RNACodonTest16.outputAminoSequence).isEqualTo(Amino.Trp)

        val RNACodonTest17 = RNACodon("CUU")
        assertThat(RNACodonTest17.outputAminoSequence).isEqualTo(Amino.Leu)

        val RNACodonTest18 = RNACodon("CUC")
        assertThat(RNACodonTest18.outputAminoSequence).isEqualTo(Amino.Leu)

        val RNACodonTest19 = RNACodon("CUA")
        assertThat(RNACodonTest19.outputAminoSequence).isEqualTo(Amino.Leu)

        val RNACodonTest20 = RNACodon("CUG")
        assertThat(RNACodonTest20.outputAminoSequence).isEqualTo(Amino.Leu)

        val RNACodonTest21 = RNACodon("CCU")
        assertThat(RNACodonTest21.outputAminoSequence).isEqualTo(Amino.Pro)

        val RNACodonTest22 = RNACodon("CCC")
        assertThat(RNACodonTest22.outputAminoSequence).isEqualTo(Amino.Pro)

        val RNACodonTest23 = RNACodon("CCA")
        assertThat(RNACodonTest23.outputAminoSequence).isEqualTo(Amino.Pro)

        val RNACodonTest24 = RNACodon("CCG")
        assertThat(RNACodonTest24.outputAminoSequence).isEqualTo(Amino.Pro)

        val RNACodonTest25 = RNACodon("CCA")
        assertThat(RNACodonTest25.outputAminoSequence).isEqualTo(Amino.Pro)

        val RNACodonTest26 = RNACodon("CCG")
        assertThat(RNACodonTest26.outputAminoSequence).isEqualTo(Amino.Pro)

        val RNACodonTest27 = RNACodon("CAU")
        assertThat(RNACodonTest27.outputAminoSequence).isEqualTo(Amino.His)

        val RNACodonTest28 = RNACodon("CAC")
        assertThat(RNACodonTest28.outputAminoSequence).isEqualTo(Amino.His)

        val RNACodonTest29 = RNACodon("CAA")
        assertThat(RNACodonTest29.outputAminoSequence).isEqualTo(Amino.Gln)

        val RNACodonTest30 = RNACodon("CAG")
        assertThat(RNACodonTest30.outputAminoSequence).isEqualTo(Amino.Gln)

        val RNACodonTest31 = RNACodon("CGU")
        assertThat(RNACodonTest31.outputAminoSequence).isEqualTo(Amino.Arg)

        val RNACodonTest32 = RNACodon("CGC")
        assertThat(RNACodonTest32.outputAminoSequence).isEqualTo(Amino.Arg)

        val RNACodonTest33 = RNACodon("CGA")
        assertThat(RNACodonTest33.outputAminoSequence).isEqualTo(Amino.Arg)

        val RNACodonTest34 = RNACodon("CGG")
        assertThat(RNACodonTest34.outputAminoSequence).isEqualTo(Amino.Arg)

        val RNACodonTest35 = RNACodon("AUU")
        assertThat(RNACodonTest35.outputAminoSequence).isEqualTo(Amino.Ile)

        val RNACodonTest36 = RNACodon("AUC")
        assertThat(RNACodonTest36.outputAminoSequence).isEqualTo(Amino.Ile)

        val RNACodonTest37 = RNACodon("AUA")
        assertThat(RNACodonTest37.outputAminoSequence).isEqualTo(Amino.Ile)

        val RNACodonTest38 = RNACodon("ACU")
        assertThat(RNACodonTest38.outputAminoSequence).isEqualTo(Amino.Thr)

        val RNACodonTest39 = RNACodon("ACC")
        assertThat(RNACodonTest39.outputAminoSequence).isEqualTo(Amino.Thr)

        val RNACodonTest40 = RNACodon("ACA")
        assertThat(RNACodonTest40.outputAminoSequence).isEqualTo(Amino.Thr)

        val RNACodonTest41 = RNACodon("ACG")
        assertThat(RNACodonTest41.outputAminoSequence).isEqualTo(Amino.Thr)

        val RNACodonTest42 = RNACodon("AAU")
        assertThat(RNACodonTest42.outputAminoSequence).isEqualTo(Amino.Asn)

        val RNACodonTest43 = RNACodon("AAC")
        assertThat(RNACodonTest43.outputAminoSequence).isEqualTo(Amino.Asn)

        val RNACodonTest44 = RNACodon("AAA")
        assertThat(RNACodonTest44.outputAminoSequence).isEqualTo(Amino.Lys)

        val RNACodonTest45 = RNACodon("AAG")
        assertThat(RNACodonTest45.outputAminoSequence).isEqualTo(Amino.Lys)

        val RNACodonTest46 = RNACodon("AGA")
        assertThat(RNACodonTest46.outputAminoSequence).isEqualTo(Amino.Arg)

        val RNACodonTest48 = RNACodon("AGG")
        assertThat(RNACodonTest48.outputAminoSequence).isEqualTo(Amino.Arg)

        val RNACodonTest49 = RNACodon("GUU")
        assertThat(RNACodonTest49.outputAminoSequence).isEqualTo(Amino.Val)

        val RNACodonTest50 = RNACodon("GUC")
        assertThat(RNACodonTest50.outputAminoSequence).isEqualTo(Amino.Val)

        val RNACodonTest51 = RNACodon("GUA")
        assertThat(RNACodonTest51.outputAminoSequence).isEqualTo(Amino.Val)

        val RNACodonTest52 = RNACodon("GUG")
        assertThat(RNACodonTest52.outputAminoSequence).isEqualTo(Amino.Val)

        val RNACodonTest53 = RNACodon("GCU")
        assertThat(RNACodonTest53.outputAminoSequence).isEqualTo(Amino.Ala)

        val RNACodonTest54 = RNACodon("GCC")
        assertThat(RNACodonTest54.outputAminoSequence).isEqualTo(Amino.Ala)

        val RNACodonTest55 = RNACodon("GCA")
        assertThat(RNACodonTest55.outputAminoSequence).isEqualTo(Amino.Ala)

        val RNACodonTest56 = RNACodon("GCG")
        assertThat(RNACodonTest56.outputAminoSequence).isEqualTo(Amino.Ala)

        val RNACodonTest57 = RNACodon("GAU")
        assertThat(RNACodonTest57.outputAminoSequence).isEqualTo(Amino.Asp)

        val RNACodonTest58 = RNACodon("GAC")
        assertThat(RNACodonTest58.outputAminoSequence).isEqualTo(Amino.Asp)

        val RNACodonTest59 = RNACodon("GAA")
        assertThat(RNACodonTest59.outputAminoSequence).isEqualTo(Amino.Glu)

        val RNACodonTest60 = RNACodon("GAG")
        assertThat(RNACodonTest60.outputAminoSequence).isEqualTo(Amino.Glu)

        val RNACodonTest61 = RNACodon("GGU")
        assertThat(RNACodonTest61.outputAminoSequence).isEqualTo(Amino.Gly)

        val RNACodonTest62 = RNACodon("GGC")
        assertThat(RNACodonTest62.outputAminoSequence).isEqualTo(Amino.Gly)

        val RNACodonTest63 = RNACodon("GGA")
        assertThat(RNACodonTest63.outputAminoSequence).isEqualTo(Amino.Gly)

        val RNACodonTest64 = RNACodon("GGG")
        assertThat(RNACodonTest64.outputAminoSequence).isEqualTo(Amino.Gly)

    }
}