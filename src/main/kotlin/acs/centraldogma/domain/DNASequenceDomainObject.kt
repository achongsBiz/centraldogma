package acs.centraldogma.domain

data class DNASequenceDomainObject(
        val length : Int,
        val modulo : Int,
        val totalParsedLength : Int,
        val unParsedLength : Int,
        val parsedSequence: String,
        val unParsedSequence : String,
        val totalCodons : Int)