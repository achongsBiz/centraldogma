package acs.centraldogma

class DNACodon (tripleSequence : String
) {

    val firstElement = Base.valueOf(tripleSequence.substring(0,1))
    val secondElement = Base.valueOf(tripleSequence.substring(1,2))
    val thirdElement = Base.valueOf(tripleSequence.substring(2,3))

    val baseSequence : ArrayList<Base>  = arrayListOf(firstElement, secondElement, thirdElement)
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
        println(outputAmino)
        }



    fun translateToDNA(base : Base) : Base {

        var antiCodon = Base.X

        val outputMatrix = mapOf(
                Base.A to Base.T,
                Base.C to Base.G,
                Base.T to Base.A,
                Base.G to Base.C
        )

        for (entry in outputMatrix)
            if (entry.key == base) {
                antiCodon =  entry.value
                break
            }

        return antiCodon
    }

    fun translateToRNA(base : Base) : Base {

        var antiCodon = Base.X

        val outputMatrix = mapOf(
                Base.A to Base.U,
                Base.T to Base.A,
                Base.G to Base.C,
                Base.C to Base.G
        )

        for (entry in outputMatrix)
            if (entry.key == base) {
                antiCodon =  entry.value
                break
            }

        return antiCodon
    }
}