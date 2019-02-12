package acs.centraldogma

class RNACodon (override val firstElement : BaseEnum,
                override val secondElement : BaseEnum,
                override val thirdElement : BaseEnum
): Codon {

    val baseSequence : ArrayList<BaseEnum>  = arrayListOf(firstElement, secondElement, thirdElement)
    val outputAminoSequence: ArrayList<BaseEnum> = arrayListOf()

    fun translateToAmino(){}
}