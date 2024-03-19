package br.com.wisan.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.hamcrest.Matchers.*;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

 import org.junit.jupiter.api.Test;

public class SpyTest {
	
	@Test
	void testV1() {
		List<String> mockArrayList = spy(ArrayList.class); 
		assertEquals(0, mockArrayList.size());
		
		when(mockArrayList.size()).thenReturn(5);
		mockArrayList.add("Foo-Bar");
		assertEquals(5, mockArrayList.size());
	}
	
	@Test
	void testV2() {
		List<String> spyArrayList = spy(ArrayList.class); 
		assertEquals(0, spyArrayList.size());
		spyArrayList.add("Foo-Bar");
		assertEquals(1, spyArrayList.size());
		spyArrayList.remove("Foo-Bar");
		assertEquals(0, spyArrayList.size());
	}
	
	@Test
	void testV3() {
		List<String> spyArrayList = spy(ArrayList.class); 
		assertEquals(0, spyArrayList.size());
		when(spyArrayList.size()).thenReturn(5);
		assertEquals(5, spyArrayList.size());
		
	}

}
