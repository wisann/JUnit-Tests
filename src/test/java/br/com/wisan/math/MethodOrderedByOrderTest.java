package br.com.wisan.math;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.Random.class)
@Order(3)
class MethodOrderedByOrderTest {

	@Test
	void testA() {
		System.out.println("Running from test A");
	}
	
	@Test
	void testB() {
		System.out.println("Running from test B");
	}
	@Test
	void testC() {
		System.out.println("Running from test C");
	}

}
