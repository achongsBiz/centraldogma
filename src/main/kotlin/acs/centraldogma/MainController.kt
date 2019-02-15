package acs.centraldogma

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class MainController {
    @GetMapping(value = "/dna")
    fun dnaRequest(@RequestParam dnaWebObject: DNAWebObject) {


    }

    @GetMapping(value = "/rna")
    fun rnaRequest(@RequestParam rnaWebObject: RNAWebObject) {

    }

    fun prepSequence(a: DNAWebObject): JsonNode {

        val length = a.translationSequence.length
        val modulo = length % 3
        val totalCodons = length / 3
        val totalParsedLength = totalCodons * 3
        val unParsedSequence = a.translationSequence.substring(totalParsedLength)
        val parsedSequence = a.translationSequence.substring(0, totalParsedLength)

        val outputData = "{" +
                "\"length\" : \"$length\"," +
                "\"modulo\" : \"$modulo\"," +
                "\"totalParsedLength\" : \"$totalParsedLength\"," +
                "\"unParsedSequence\" : \"$unParsedSequence\"," +
                "\"parsedSequence\" : \"$parsedSequence\"," +
                "\"totalCodons\" : \"$totalCodons\"}"


        val something : JsonNode = ObjectMapper().readTree(outputData)
        return something

    }

}