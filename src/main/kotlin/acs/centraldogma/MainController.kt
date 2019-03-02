package acs.centraldogma

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class MainController {
    @PostMapping(value = "dna")
    fun dnaRequest(@RequestBody webObject: WebObject) : ResponseEntity<Any> {

        val dnaSequenceDomainObject = prepDNASequence(webObject)
        val output = DNARequestOrchestrator(dnaSequenceDomainObject, webObject.requestedTranslation).evaluateDNACodons()
        val returnObject = DNAReturnObject(output, dnaSequenceDomainObject.unParsedSequence)
        return ResponseEntity(returnObject,HttpStatus.OK)
    }

    @PostMapping(value = "/rna")
    fun rnaRequest(@RequestBody rnaWebObject: WebObject) : ResponseEntity<Any> {

        val rnaSequenceDomainObject = prepDNASequence(rnaWebObject)
        val output = RNARequestOrchestrator(rnaSequenceDomainObject, rnaWebObject.requestedTranslation).evaluateRNACodons()
        val returnObject = DNAReturnObject(output, rnaSequenceDomainObject.unParsedSequence)

        println(returnObject)
        return ResponseEntity(returnObject, HttpStatus.OK)
    }

    fun prepDNASequence(a: WebObject): DNASequenceDomainObject {

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