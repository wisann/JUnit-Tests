package br.com.wisan.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.mockito.Mockito.*;

import static org.mockito.BDDMockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ListTest2 {

	@Test
	void testMockingList_WhenSizeIsCalled_ShoudReturn10() {
		List<?> list = mock(List.class);
		when(list.size()).thenReturn(10);

		assertEquals(10, list.size());
	}

	@Test
	void testMockingList_WhenSizeIsCalled_ShoudReturnMultipleValues() {
		List<?> list = mock(List.class);
		given(list.size()).willReturn(10).willReturn(20).willReturn(30);

		assertThat(list.size(), is(10));
		assertThat(list.size(), is(20));
		assertThat(list.size(), is(30));

	}

	@Test
	void testMockingList_WhenGetIsCalled_ShoudReturnWisan() {
		var list = mock(List.class);
		given(list.get(0)).willReturn("Wisan");

		assertThat(list.get(0), is("Wisan"));
	}

	@Test
	void testMockingList_WhenThorwsAnException() {
		var list = mock(List.class);
		given(list.get(anyInt())).willThrow(new RuntimeException("Something it's not working!"));

		assertThrows(RuntimeException.class, () -> {
			list.get(anyInt());
		}, () -> "Should have Thrown and RunTimeException"); 
	}
	
}
