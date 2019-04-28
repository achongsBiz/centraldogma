package acs.centraldogma.orchestration

import acs.centraldogma.domain.DNASequenceDomainObject
import acs.centraldogma.domain.DNACodon

class DNARequestOrchestrator (private val dnaSequenceDomainObject : DNASequenceDomainObject,
                              private val requestedTranslation : String) {

    fun evaluateDNACodons() : List<String> {

        var i = 0
        val results : ArrayList<String> = arrayListOf()

        while (i < dnaSequenceDomainObject.totalParsedLength) {

            val codon = dnaSequenceDomainObject.parsedSequence.substring(i, i + 3)

            if (requestedTranslation == "dna") {
                val dnaCodon = DNACodon(codon)
                results.add(dnaCodon.outputDNASequence.toString())
            }
            else if (requestedTranslation == "rna") {
                val rnaCodon = DNACodon(codon)
                results.add(rnaCodon.outputRNASequence.toString())
            }
            else if (requestedTranslation == "amino") {
                val amino = DNACodon(codon).outputAmino
                results.add(amino)
            }
            i += 3
        }

        return results
    }
}