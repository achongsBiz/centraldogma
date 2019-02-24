package acs.centraldogma

class RNACodon(val rnaSequence:String) : TranslationSyntax {

    var outputAminoSequence = Amino.STOP

    init {
        outputAminoSequence = translateToAmino(rnaSequence)
    }
}