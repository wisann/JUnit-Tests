package br.com.wisan.math;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Order(1)
class MethodOrderedRadonlyTest {

	@Test
	@Order(1)
	void testA() {
		System.out.println("Running from test A");
	}
	
	@Test
	@Order(3)
	void testB() {
		System.out.println("Running from test B");
	}
	@Test
	@Order(2)
	void testC() {
		System.out.println("Running from test C");
	}

}
