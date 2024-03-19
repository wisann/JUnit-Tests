package br.com.wisan.business;

import java.util.ArrayList;
import java.util.List;

import br.com.wisan.service.CourseService;

//System(Method/ SUT) under test
public class CourseBusiness {

	//
	private CourseService courseService;

	public CourseBusiness(CourseService courseService) {
		super();
		this.courseService = courseService;
	}

	public List<String> retrieveCoursesRelatedToSpring(String student) {
		var filteredCourses = new ArrayList<String>();
		if ("Foo Bar".equals(student))
			return filteredCourses;
		var allCourses = courseService.retrieveCourses(student);

		for (String course : allCourses) {
			if (course.contains("Spring")) {
				filteredCourses.add(course);
			}
		}
		return filteredCourses;
	}

	public void deleteCoursesNotRelatedToSpring(String student) {
		var allCourses = courseService.retrieveCourses(student);
		for (String course : allCourses) {
			if (!course.contains("Spring")) {
				courseService.deleteCourse(course);
			}

		}
	}

}
