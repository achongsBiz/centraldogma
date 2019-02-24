package acs.centraldogma

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class MainController {
    @PostMapping(value = "dna")
    fun dnaRequest(@RequestBody dnaWebObject: DNAWebObject) : ResponseEntity<Any> {

        val dnaSequenceDomainObject = prepDNASequence(dnaWebObject)
        val output = DNARequestOrchestrator(dnaSequenceDomainObject, dnaWebObject.requestedTranslation).evaluateDNACodons()
        val returnObject = DNAReturnObject(output, dnaSequenceDomainObject.unParsedSequence)
        return ResponseEntity(returnObject,HttpStatus.OK)
    }

    @PostMapping(value = "/rna")
    fun rnaRequest(@RequestBody rnaWebObject: RNAWebObject) {

    }

    fun prepDNASequence(a: DNAWebObject): DNASequenceDomainObject {

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
}