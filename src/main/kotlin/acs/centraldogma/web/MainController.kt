package acs.centraldogma.web

import acs.centraldogma.domain.DNASequenceDomainObject
import acs.centraldogma.orchestration.DNARequestOrchestrator
import acs.centraldogma.orchestration.RNARequestOrchestrator
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class MainController {
    @PostMapping(value = "/dna")
    fun dnaRequest(@RequestBody dnaWebRequestObject: WebRequestObject) : ResponseEntity<WebReturnObject> {

        val dnaValidationLogic = fun(webRequestObject : WebRequestObject) : Boolean{
            if (webRequestObject.requestedTranslation != "rna" && webRequestObject.requestedTranslation != "amino") {
                return false
            }
            return true
        }
        if (!verifyWebObject(dnaValidationLogic, dnaWebRequestObject)) {

            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }

        val dnaSequenceDomainObject = prepDNASequence(dnaWebRequestObject)
        val output = DNARequestOrchestrator(dnaSequenceDomainObject, dnaWebRequestObject.requestedTranslation).evaluateDNACodons()
        val returnObject = WebReturnObject(output, dnaSequenceDomainObject.unParsedSequence)
        return ResponseEntity(returnObject,HttpStatus.OK)
    }

    @PostMapping(value = "/rna")
    fun rnaRequest(@RequestBody rnaWebRequestObject: WebRequestObject) : ResponseEntity<WebReturnObject> {

        val rnaValidationLogic = fun(webRequestObject : WebRequestObject) : Boolean{
            if (webRequestObject.requestedTranslation != "amino") {
                return false
            }
            return true
        }
        if (!verifyWebObject(rnaValidationLogic, rnaWebRequestObject)) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }

        val rnaSequenceDomainObject = prepDNASequence(rnaWebRequestObject)
        val output = RNARequestOrchestrator(rnaSequenceDomainObject, rnaWebRequestObject.requestedTranslation).evaluateRNACodons()
        val returnObject = WebReturnObject(output, rnaSequenceDomainObject.unParsedSequence)
        return ResponseEntity(returnObject, HttpStatus.OK)
    }

    fun prepDNASequence(a: WebRequestObject): DNASequenceDomainObject {

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

    fun verifyWebObject(validationOperation : (WebRequestObject) -> Boolean, webRequestObject : WebRequestObject) : Boolean {

        return validationOperation.invoke(webRequestObject)
    }
}