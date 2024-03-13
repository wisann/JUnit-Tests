package br.com.wisan.math;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.wisan.SimpleMath;

@DisplayName("Test Math Operations in SimpleMath Class")
class SimpleMathTest {
	
	SimpleMath math;
	@BeforeAll
	static void setup() {
		System.out.println("Running @BeforeAll method");
	}
	
	@AfterAll
	static void cleanup() {
		System.out.println("Running @AfterAll method");
	}
	
	@BeforeEach
	void beforeEaxchMethod() {
		math = new SimpleMath();
		System.out.println("Running @BeforeEachMethod");
	}

	@AfterEach
	void afterEaxchMethod() {
		System.out.println("Running @AfterEachMethod");
	}

	@Test
	@DisplayName("Test 6.2 + 2 = 8.2")
	void testSum_WhenSixDotTwoIsAddedByTwo_ShouldReturnEightDotTwo() {
		
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
	@DisplayName("Test 6.2 - 2 = 4.2") 
	void testSubstraction() {
		Double firstNumber = 6.2D;
		Double secondNumber = 2D;
		Double actual = math.subtraction(firstNumber, secondNumber);
		Double expected = 4.2D;
		Assertions.assertEquals(expected, actual,
				() -> firstNumber + " - " + secondNumber + " Did not produce " + expected);

	}

	@Test
	@DisplayName("Test 2 * 2 = 4")
	void testMultiplication() {
		Double firstNumber = 2D;
		Double secondNumber = 2D;
		Double actual = math.multiplication(firstNumber, secondNumber);
		Double expected = 4D;
		Assertions.assertEquals(expected, actual,
				() -> firstNumber + " * " + secondNumber + " Did not produce " + expected);

	}

	@Test
	@DisplayName("Test 2 / 2 = 1")
	void TestDivision() {
		Double firstNumber = 2D;
		Double secondNumber = 2D;
		Double actual = math.division(firstNumber, secondNumber);
		Double expected = 1D;
		Assertions.assertEquals(expected, actual,
				() -> firstNumber + " / " + secondNumber + " Did not produce " + expected);
	}
	
	//@Disabled
	@Test
	void TestDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticException() {
		Double firstNumber = 6.2D;
		Double secondNumber = 0D;
		var expectedMessage = "Impossible to divide by zero";
		ArithmeticException actual =  assertThrows(ArithmeticException.class, ()-> {
		math.division(firstNumber, secondNumber);
		}, () -> "Division by zero should throw and Arithmetic Exception");
		assertEquals(expectedMessage, actual.getMessage(), ()-> "Unexpected exception message" );
	}

	@Test
	@DisplayName("Test mean (4 + 2) / 2 = 3")
	void TestMean() {
		Double firstNumber = 4D;
		Double secondNumber = 2D;
		Double actual = math.mean(firstNumber, secondNumber);
		Double expected = 3D;
		Assertions.assertEquals(expected, actual,
				() -> firstNumber + " mean " + secondNumber + " /2 Did not produce " + expected);

	}

	@Test
	@DisplayName("Test SquareRoot 4 = 2")
	void TestSquareRoot() {
		Double number = 4D;
		Double actual = math.squareRoot(number);
		Double expected = 2D;
		Assertions.assertEquals(expected, actual, 
				() -> number + " squareroot did not produce " + expected);
		
	}

}
