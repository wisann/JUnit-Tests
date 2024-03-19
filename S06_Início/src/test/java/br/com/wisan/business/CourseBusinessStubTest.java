package br.com.wisan.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.wisan.service.CourseService;
import br.com.wisan.service.stubs.CourseServiceStub;

class CourseBusinessStubTest {

	@Test
	void testCourseRelatedToSpring_When_UsingAStub() {
		CourseService stubService = new CourseServiceStub();
		CourseBusiness business = new CourseBusiness(stubService);
		
		var filteredCourses = business.retrieveCoursesRelatedToSpring("Leandro");
		assertEquals(4, filteredCourses.size());
	}
	
	@Test
	void testCourseRelatedToSpring_When_UsingAFoorBarStudent() {
		CourseService stubService = new CourseServiceStub();
		CourseBusiness business = new CourseBusiness(stubService);
		
		var filteredCourses = business.retrieveCoursesRelatedToSpring("Foo Bar");
		assertEquals(0, filteredCourses.size());
	}

}
