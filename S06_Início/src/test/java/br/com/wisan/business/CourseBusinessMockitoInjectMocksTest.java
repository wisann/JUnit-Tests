package br.com.wisan.business;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.wisan.service.CourseService;

@ExtendWith(MockitoExtension.class)
class CourseBusinessMockitoInjectMocksTest {
	
	@Mock
	CourseService mockService;
	@InjectMocks
	CourseBusiness business;
	@Captor
	ArgumentCaptor<String> argumentCaptor;
	List<String> courses;

	@BeforeEach
	void setup() {
		//business = new CourseBusiness(mockService);
		courses = Arrays.asList("REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
				"Agile Desmistificado com Scrum, XP, Kanban e Trello", "Spotify Engineering Culture Desmistificado",
				"REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
				"Docker do Zero à Maestria - Contêinerização Desmistificada",
				"Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
				"Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
				"Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
				"REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
				"Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
				"Microsserviços do 0 com Spring Cloud, Kotlin e Docker");
		when(mockService.retrieveCourses("Leandro")).thenReturn(courses);
	}

	@Test
	void testCourseRelatedToSpring_When_UsingAMock() {

		given(mockService.retrieveCourses("Leandro")).willReturn(courses);
		var filteredCourses = business.retrieveCoursesRelatedToSpring("Leandro");
		assertThat(filteredCourses.size(), is(4));
	}

	@Test
	@DisplayName("Delete Courses Not related to Spring Using Mockito Verify")
	void testDeleteCoursesNotRelatedtoSpring_UsingMockitoVerify_ShouldCallMethod() {
		given(mockService.retrieveCourses("Leandro")).willReturn(courses);
		business.deleteCoursesNotRelatedToSpring("Leandro");

		verify(mockService).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
	}

	/*@Test
	void testDeleteCoursesNotRelatedtoSpring_UsingMockitoVerify_ShouldCallMethodV2() {
		given(mockService.retrieveCourses("Leandro")).willReturn(courses);
		business.deleteCoursesNotRelatedToSpring("Leandro");

		String AgileCourse = "Agile Desmistificado com Scrum, XP, Kanban e Trello";
		then(mockService).should().deleteCourse(AgileCourse);
		String kotlinCourse = "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android";
		then(mockService).should(never()).deleteCourse(kotlinCourse);

	}*/

	@Test
	void testDeleteCoursesNotRelatedtoSpring_CapturingArguments_ShouldCallMethod_deleteCourse() {
		/*courses = Arrays.asList(
				"Agile Desmistificado com Scrum, XP, Kanban e Trello",
				"REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker");*/
		given(mockService.retrieveCourses("Leandro")).willReturn(courses);
		//ArgumentCaptor.forClass(String.class);
		//String AgileCourse = "Agile Desmistificado com Scrum, XP, Kanban e Trello";

		business.deleteCoursesNotRelatedToSpring("Leandro");

		then(mockService).should(times(7)).deleteCourse(argumentCaptor.capture());
		assertThat(argumentCaptor.getAllValues().size(), is(7));

	}

}
