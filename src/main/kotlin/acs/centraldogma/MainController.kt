package acs.centraldogma

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class MainController {
    @PostMapping(value = "dna")
    fun dnaRequest(@RequestBody dnaWebObject: DNAWebObject) : ResponseEntity<Any> {

        val dnaSequenceDomainObject = prepSequence(dnaWebObject)
        val output = evaluateCodons(dnaSequenceDomainObject, dnaWebObject.requestedTranslation)

        val returnObject = DNAReturnObject(output, dnaSequenceDomainObject.unParsedSequence)

        return ResponseEntity(returnObject,HttpStatus.OK)

    }

    @PostMapping(value = "/rna")
    fun rnaRequest(@RequestBody rnaWebObject: RNAWebObject) {

    }

    fun prepSequence(a: DNAWebObject): DNASequenceDomainObject {

        val length = a.translationSequence.length
        val modulo = length % 3
        val totalCodons = length / 3
        val totalParsedLength = totalCodons * 3
        val parsedSequence = a.translationSequence.substring(0, totalParsedLength)
        val unParsedSequence = a.translationSequence.substring(totalParsedLength)
        val unParsedSequenceLength = unParsedSequence.length

        return DNASequenceDomainObject(
                length = length,
                modulo = modulo,
                totalCodons = totalCodons,
                totalParsedLength = totalParsedLength,
                unParsedLength = unParsedSequenceLength,
                unParsedSequence = unParsedSequence,
                parsedSequence = parsedSequence)
    }

    fun evaluateCodons(dnaSequenceDomainObject : DNASequenceDomainObject, requestedTranslation : String) : List<String> {

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
                    val rnaCodon = DNACodon(codon)
                    results.add(rnaCodon.outputAmino)
                }
                i += 3
            }

        return results
    }
}