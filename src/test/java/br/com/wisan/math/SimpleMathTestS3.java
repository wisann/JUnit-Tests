package br.com.wisan.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import br.com.wisan.SimpleMath;

@DisplayName("Test Math Operations in SimpleMath Class")
class SimpleMathTestS3 {

	SimpleMath math;

	@BeforeEach
	void beforeEaxchMethod() {
		math = new SimpleMath();
		System.out.println("Running @BeforeEachMethod");
	}

	@DisplayName("Test Double division [firstNumber, secondNumber, expected]")
	//@ParameterizedTest
	//@MethodSource("testDivisionInputParameters")
	//@MethodSource("testDivision")
	 /**@CsvSource({
		"6.2, 2, 3.1",
		"71, 14, 5.07", 
		"18.3, 3.1, 5.90"  }
	)
	*/
	
	@ParameterizedTest
	@ValueSource(strings = {"Pele", "Senna", "Keith Moon"})
	void testValueSource(String firstName) {
		System.out.println(firstName);
		assertNotNull(firstName);
	}
	
	
	@CsvFileSource(resources = "/testDivision.csv")
	void testDivision(double firstNumber, Double secondNumber, Double expected) {

		Double actual = math.division(firstNumber, secondNumber);
		assertEquals(expected, actual, 2D,
				() -> firstNumber + " / " + secondNumber + " Did not produce " + expected);
	}

	/**public static Stream<Arguments> testDivision() {
		return Stream.of(Arguments.of(6.2D, 2D, 3.1D), Arguments.of(71D, 14D, 5.07D), Arguments.of(18.3D, 3.1D, 5.90D));

	}
	*/
}
