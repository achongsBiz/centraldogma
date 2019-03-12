package acs.centraldogma

class RNACodon(val rnaSequence:String) : TranslationSyntax {

    var outputAminoSequence = Amino.NONE

    init {
        outputAminoSequence = translateToAmino(rnaSequence)
    }
}