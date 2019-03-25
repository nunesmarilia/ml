package com.exame.marilia.ml;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

public class SimianTest {

	@Test
	public void validSimian() throws Exception {
/*		Course mockCourse = new Course("1", "Smallest Number", "1", Arrays.asList("1", "2", "3", "4"));

		String [] dna = {"CTGAGA", "CTGAGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"};

		Mockito.when(studentService.addCourse(Mockito.anyString(), Mockito.any(Course.class))).thenReturn(mockCourse);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/simian")
				.accept(MediaType.APPLICATION_JSON)
				.content(exampleCourseJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON)).content(some_json_data)...


		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

		assertEquals("http://localhost/simian", response.getHeader(HttpHeaders.LOCATION));*/
	}
}