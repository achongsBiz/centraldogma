package acs.centraldogma

class DNACodon (firstElement : Base,
                secondElement : Base,
                thirdElement : Base
) {

    val baseSequence : ArrayList<Base>  = arrayListOf(firstElement, secondElement, thirdElement)
    val outputRNASequence: ArrayList<Base> = arrayListOf()

    init {

        baseSequence.forEach {outputRNASequence.add(translateToRNA(it))}
    }

    fun translateToRNA(base : Base) : Base {

        var antiCodon = Base.X

        val outputMatrix = mapOf(
                Base.A to Base.U,
                Base.U to Base.A,
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