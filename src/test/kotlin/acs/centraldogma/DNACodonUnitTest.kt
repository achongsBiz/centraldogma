package acs.centraldogma

import org.fest.assertions.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class DNACodonUnitTest {

	@Test
	fun `Correct Translation from DNA to RNA`() {
		val firstTestDNACodon = DNACodon("AGC")
		val firstExpectedRNAOutput = listOf(Base.U, Base.C, Base.G)
        assertThat(firstTestDNACodon.outputRNASequence).isEqualTo(firstExpectedRNAOutput)

		val secondTestDNACodon = DNACodon("UCG")
		val secondExpectedRNAOutput = listOf(Base.A, Base.G, Base.C)
		assertThat(secondTestDNACodon.outputRNASequence).isEqualTo(secondExpectedRNAOutput)
	}

	@Test
	fun `Correct Translation from DNA to DNA`() {
		val firstTestDNACodon = DNACodon("AGC")
		val firstExpectedDNAOutput = listOf(Base.T, Base.C, Base.G)
		assertThat(firstTestDNACodon.outputDNASequence).isEqualTo(firstExpectedDNAOutput)

		val secondTestDNACodon = DNACodon("TCG")
		val secondExpectedDNAOutput = listOf(Base.A, Base.G, Base.C)
		assertThat(secondTestDNACodon.outputDNASequence).isEqualTo(secondExpectedDNAOutput)
	}
}

