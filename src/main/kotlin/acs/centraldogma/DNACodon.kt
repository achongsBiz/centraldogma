package acs.centraldogma

class DNACodon (tripleSequence : String) : TranslationSyntax
{

    private val firstElement = Base.valueOf(tripleSequence.substring(0,1))
    private val secondElement = Base.valueOf(tripleSequence.substring(1,2))
    private val thirdElement = Base.valueOf(tripleSequence.substring(2,3))
    private val baseSequence : ArrayList<Base>  = arrayListOf(firstElement, secondElement, thirdElement)

    val outputRNASequence: ArrayList<Base> = arrayListOf()
    val outputDNASequence : ArrayList<Base> = arrayListOf()
    var outputAmino : String

    init {

        baseSequence.forEach {outputRNASequence.add(translateToRNA(it))}
        baseSequence.forEach {outputDNASequence.add(translateToDNA(it))}

        var outputRNASequenceString  = ""

        for (item in outputRNASequence)
            outputRNASequenceString += item

        outputAmino = RNACodon(outputRNASequenceString).outputAminoSequence.toString()
    }
}