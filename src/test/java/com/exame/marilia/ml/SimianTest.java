package com.exame.marilia.ml;

import org.junit.Assert;
import org.junit.Test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class SimianTest extends MlApplicationTests {

	@Test
	public void testResultStatsSuccess() throws Exception {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:9001/ml/stats";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(true, result.getBody().contains("count_mutant_dna"));
	}

	@Test
	public void testResultStatsFail() throws Exception {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:9001/ml/stat";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		try
		{
			restTemplate.postForEntity(uri, result, String.class);
			Assert.fail();
		}
		catch(HttpClientErrorException ex)
		{
			Assert.assertEquals(400, ex.getRawStatusCode());
		}
	}
}