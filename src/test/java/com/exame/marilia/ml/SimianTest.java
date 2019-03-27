package com.exame.marilia.ml;

import com.exame.marilia.ml.model.Simian;
import org.junit.Assert;
import org.junit.Test;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

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

		try
		{
			restTemplate.getForEntity(uri, String.class);
			Assert.fail();
		}
		catch(HttpClientErrorException ex)
		{
			Assert.assertEquals(400, ex.getRawStatusCode());
		}
	}

	@Test
	public void testValidHumanSuccess() throws Exception {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:9001/ml/simian";
		URI uri = new URI(baseUrl);

		Simian simian = new Simian();

		HttpHeaders headers = new HttpHeaders();

		List<String> dnas   = new ArrayList<>();
		dnas.add("CTGAGA");
		dnas.add("CTATGC");
		dnas.add("TCTTCT");
		dnas.add("AGAGGG");
		dnas.add("CACCTA");
		dnas.add("TCACTG");

		simian.setDna(dnas);

		HttpEntity<Simian> request = new HttpEntity<>(simian, headers);

		try {
			restTemplate.postForEntity(uri, request, String.class);

		} catch(HttpClientErrorException e) {
			Assert.assertEquals(403, e.getRawStatusCode());
		}
	}

	@Test
	public void testValidSimianSuccess() throws Exception {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:9001/ml/simian";
		URI uri = new URI(baseUrl);

		Simian simian = new Simian();

		HttpHeaders headers = new HttpHeaders();

		List<String> dnas   = new ArrayList<>();
		dnas.add("CTGAGA");
		dnas.add("CTGAGC");
		dnas.add("TATTGT");
		dnas.add("AGAGGG");
		dnas.add("CCCCTA");
		dnas.add("TCACTG");

		simian.setDna(dnas);

		HttpEntity<Simian> request = new HttpEntity<>(simian, headers);

		ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
		Assert.assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	public void testValidArray() throws Exception {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:9001/ml/simian";
		URI uri = new URI(baseUrl);

		Simian simian = new Simian();

		HttpHeaders headers = new HttpHeaders();

		List<String> dnas   = new ArrayList<>();
		dnas.add("MTGAGA");
		dnas.add("CTATGC");
		dnas.add("TCTTCT");
		dnas.add("AGAGGG");
		dnas.add("CACCTA");
		dnas.add("TCACTG");

		simian.setDna(dnas);

		HttpEntity<Simian> request = new HttpEntity<>(simian, headers);

		try {
			restTemplate.postForEntity(uri, request, String.class);

		} catch(HttpClientErrorException e) {
			Assert.assertEquals(403, e.getRawStatusCode());
		}
	}
}