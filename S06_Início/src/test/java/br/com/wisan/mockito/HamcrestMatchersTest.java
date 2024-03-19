package br.com.wisan.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class HamcrestMatchersTest {

	@Test
	void testHamcrestMatchers() {
		
		List<Integer> scores = Arrays.asList(99,100,101,105);
		
		assertThat(scores, hasSize(4));
		assertThat(scores, hasItems(100,101));
		assertThat(scores, everyItem(greaterThan(98)));
		assertThat(scores, everyItem(lessThan(106)));
		
		//check strings
		
		assertThat("", is(emptyString()));
		assertThat(null, is(emptyOrNullString()));
		
		//Arrays
		Integer [] myArray = {1,2,3};
		assertThat(myArray, arrayWithSize(3));
		assertThat(myArray, arrayContaining(1,2,3));
		assertThat(myArray, arrayContainingInAnyOrder(1,3,2));




	}

}
