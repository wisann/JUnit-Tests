package br.com.wisan.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import br.com.wisan.SimpleMath;

class DemoRepeatedTest {

	SimpleMath math;
	@BeforeEach
	void beforeEaxchMethod() {
		math = new SimpleMath();
		System.out.println("Running @BeforeEachMethod");
	}
	
	@RepeatedTest(3)
	void TestDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticException() {
		Double firstNumber = 6.2D;
		Double secondNumber = 0D;
		var expectedMessage = "Impossible to divide by zero";
		ArithmeticException actual =  assertThrows(ArithmeticException.class, ()-> {
		math.division(firstNumber, secondNumber);
		}, () -> "Division by zero should throw and Arithmetic Exception");
		assertEquals(expectedMessage, actual.getMessage(), ()-> "Unexpected exception message" );
	}

}
