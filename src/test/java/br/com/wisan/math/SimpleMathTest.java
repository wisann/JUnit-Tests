package br.com.wisan.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.wisan.SimpleMath;

class SimpleMathTest {

	@Test
	void testSum() {
		SimpleMath math = new SimpleMath();
		Double firstNumber = 6.2D;
		Double secondNumber = 2D;
		Double actual = math.sum(firstNumber, secondNumber);
		Double expected = 8.2D;
		Assertions.assertEquals(expected, actual,
				() -> firstNumber + " + " + secondNumber + " Did not produce " + expected);
		assertNotEquals(9.2, actual);
		assertNotNull(actual);

	}

	@Test
	void testSubstraction() {
		SimpleMath math = new SimpleMath();
		Double firstNumber = 6.2D;
		Double secondNumber = 2D;
		Double actual = math.subtraction(firstNumber, secondNumber);
		Double expected = 4.2D;
		Assertions.assertEquals(expected, actual,
				() -> firstNumber + " - " + secondNumber + " Did not produce " + expected);

	}

	@Test
	void testMultiplication() {
		SimpleMath math = new SimpleMath();
		Double firstNumber = 2D;
		Double secondNumber = 2D;
		Double actual = math.multiplication(firstNumber, secondNumber);
		Double expected = 4D;
		Assertions.assertEquals(expected, actual,
				() -> firstNumber + " * " + secondNumber + " Did not produce " + expected);

	}

	@Test
	void TestDivision() {
		SimpleMath math = new SimpleMath();
		Double firstNumber = 2D;
		Double secondNumber = 2D;
		Double actual = math.division(firstNumber, secondNumber);
		Double expected = 1D;
		Assertions.assertEquals(expected, actual,
				() -> firstNumber + " / " + secondNumber + " Did not produce " + expected);
	}

	@Test
	void TestMean() {
		SimpleMath math = new SimpleMath();
		Double firstNumber = 4D;
		Double secondNumber = 2D;
		Double actual = math.mean(firstNumber, secondNumber);
		Double expected = 3D;
		Assertions.assertEquals(expected, actual,
				() -> firstNumber + " mean " + secondNumber + " /2 Did not produce " + expected);

	}

	@Test
	void TestSquareRoot() {
		SimpleMath math = new SimpleMath();
		Double number = 4D;
		Double actual = math.squareRoot(number);
		Double expected = 2D;
		Assertions.assertEquals(expected, actual, 
				() -> number + " squareroot did not produce " + expected);
		
	}

}
