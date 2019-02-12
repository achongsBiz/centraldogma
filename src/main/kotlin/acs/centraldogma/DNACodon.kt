package acs.centraldogma

class DNACodon (override val firstElement : BaseEnum,
                override val secondElement : BaseEnum,
                override val thirdElement : BaseEnum
): Codon {

    val baseSequence : ArrayList<BaseEnum>  = arrayListOf(firstElement, secondElement, thirdElement)
    val outputRNASequence: ArrayList<BaseEnum> = arrayListOf()

    init {

        baseSequence.forEach {outputRNASequence.add(translateToRNA(it))}
    }

    fun translateToRNA(base : BaseEnum) : BaseEnum {

        var antiCodon = BaseEnum.X

        val outputMatrix = mapOf(
                BaseEnum.A to BaseEnum.U,
                BaseEnum.U to BaseEnum.A,
                BaseEnum.G to BaseEnum.C,
                BaseEnum.C to BaseEnum.G
        )

        for (entry in outputMatrix)
            if (entry.key == base) {
                antiCodon =  entry.value
                break
            }

        return antiCodon
    }
}