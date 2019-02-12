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
		val testDNACodon = DNACodon(BaseEnum.A, BaseEnum.G, BaseEnum.C)
		val expectedRNAOutput = listOf(BaseEnum.U, BaseEnum.C, BaseEnum.G)
        assertThat(testDNACodon.outputRNASequence).isEqualTo(expectedRNAOutput)
	}

}

