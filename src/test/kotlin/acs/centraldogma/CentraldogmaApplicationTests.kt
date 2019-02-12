package acs.centraldogma

import org.fest.assertions.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class CentraldogmaApplicationTests {

	@Test
	fun `Correct Translation from DNA to RNA`() {
		val firstTestDNACodon = DNACodon(Base.A, Base.G, Base.C)
		val firstExpectedRNAOutput = listOf(Base.U, Base.C, Base.G)
        assertThat(firstTestDNACodon.outputRNASequence).isEqualTo(firstExpectedRNAOutput)

		val secondTestDNACodon = DNACodon(Base.U, Base.C, Base.G)
		val secondExpectedRNAOutput = listOf(Base.A, Base.G, Base.C)
		assertThat(secondTestDNACodon.outputRNASequence).isEqualTo(secondExpectedRNAOutput)
	}

	@Test
	fun `Correct Translation from RNA to Amino Acid`() {
		


	}


}

