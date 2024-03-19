package br.com.wisan.business;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ListTest {

	@Test
	void testMockingList_WhenSizeIsCalled_ShoudReturn10() {
		List<?> list = mock(List.class);
		when(list.size()).thenReturn(10);

		assertEquals(10, list.size());
	}

	@Test
	void testMockingList_WhenSizeIsCalled_ShoudReturnMultipleValues() {
		List<?> list = mock(List.class);
		when(list.size()).thenReturn(10).thenReturn(20);

		assertEquals(10, list.size());
		assertEquals(20, list.size());
		assertEquals(20, list.size());

	}

	@Test
	void testMockingList_WhenGetIsCalled_ShoudReturnWisan() {
		var list = mock(List.class);
		when(list.get(0)).thenReturn("Wisan");

		assertEquals("Wisan", list.get(0));
	}

	@Test
	void testMockingList_WhenThorwsAnException() {
		var list = mock(List.class);
		when(list.get(anyInt())).thenThrow(new RuntimeException("Foo Bar!!"));

		assertThrows(RuntimeException.class, () -> {
			list.get(anyInt());
		}, () -> "Should have Thrown and RunTimeException");
	}
}
