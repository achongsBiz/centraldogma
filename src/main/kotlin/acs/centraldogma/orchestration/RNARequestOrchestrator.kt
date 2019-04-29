package acs.centraldogma.orchestration

import acs.centraldogma.domain.DNASequenceDomainObject
import acs.centraldogma.domain.RNACodon

class RNARequestOrchestrator (private val rnaSequenceDomainObject : DNASequenceDomainObject,
                              private val requestedTranslation : String)  {

    fun evaluateRNACodons() : List<String> {

        var i = 0
        val results : ArrayList<String> = arrayListOf()

        while (i < rnaSequenceDomainObject.totalParsedLength) {

            val codon = rnaSequenceDomainObject.parsedSequence.substring(i, i + 3)

            if (requestedTranslation == "amino") {
                val rnaCodon = RNACodon(codon)
                results.add(rnaCodon.outputAminoSequence.toString())
            }

            i += 3
        }

        return results
    }
}