package br.com.wisan.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.wisan.SimpleMath;

class SimpleMathTest {

	@Test
	void test() {
		SimpleMath math = new SimpleMath();
		Double actual = math.sum(6.2D, 2D);
		Double expected = 8.2D;
		Assertions.assertEquals(expected, actual);
	}

}
