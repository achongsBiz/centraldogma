package acs.centraldogma

class RNACodon(val RNASequence: List<Base>) {

    fun translateToAmino(aminoSequence: ArrayList<Base>) : Amino {

        val sequence = RNASequence[0].toString() + RNASequence[1].toString() + RNASequence[2].toString()

        return matchToMatrix(sequence)
    }

    fun matchToMatrix(sequence : String) : Amino {

        var amino = Amino.STOP

        val outputMatrix = mapOf(
                "UUU" to Amino.Phe,
                "UUC" to Amino.Phe,
                "UUA" to Amino.Leu,
                "UUG" to Amino.Leu,

                "CUU" to Amino.Leu,
                "CUC" to Amino.Leu,
                "CUA" to Amino.Leu,
                "CUG" to Amino.Leu,

                "AUU" to Amino.Ile,
                "AUC" to Amino.Ile,
                "AUA" to Amino.Ile,
                "AUG" to Amino.Met,

                "GUU" to Amino.Val,
                "GUC" to Amino.Val,
                "GUA" to Amino.Val,
                "GUG" to Amino.Val,

                "UCU" to Amino.Ser,
                "UCC" to Amino.Ser,
                "UCA" to Amino.Ser,
                "UCG" to Amino.Ser,

                "CCU" to Amino.Pro,
                "CCC" to Amino.Pro,
                "CCA" to Amino.Pro,
                "CCG" to Amino.Pro,

                "ACU" to Amino.Thr,
                "ACC" to Amino.Thr,
                "ACA" to Amino.Thr,
                "ACG" to Amino.Thr,

                "GCU" to Amino.Ala,
                "GCC" to Amino.Ala,
                "GCA" to Amino.Ala,
                "GCG" to Amino.Ala,

                "UAC" to Amino.Tyr,
                "UAU" to Amino.Tyr,
                "UAA" to Amino.STOP,
                "UAG" to Amino.STOP,

                "CAU" to Amino.His,
                "CAC" to Amino.His,
                "CAA" to Amino.Gln,
                "CAG" to Amino.Gln,

                "AAU" to Amino.Asn,
                "AAC" to Amino.Asn,
                "AAA" to Amino.Lys,
                "AAG" to Amino.Lys,

                "GAU" to Amino.Asp,
                "GAC" to Amino.Asp,
                "GAA" to Amino.Glu,
                "GAG" to Amino.Glu,

                "UGU" to Amino.Cys,
                "UGC" to Amino.Cys,
                "UGA" to Amino.STOP,
                "UGG" to Amino.Trp,

                "CGU" to Amino.Arg,
                "CGC" to Amino.Arg,
                "CGA" to Amino.Arg,
                "CGG" to Amino.Arg,

                "AGU" to Amino.Ser,
                "AGC" to Amino.Ser,
                "AGA" to Amino.Arg,
                "AGG" to Amino.Arg,

                "GGU" to Amino.Gly,
                "GGC" to Amino.Gly,
                "GGA" to Amino.Gly,
                "GGG" to Amino.Gly
        )

        for (entry in outputMatrix) {
            if (entry.key == sequence) {
                amino = entry.value
                break
            }
        }

        return amino
    }
}