package ru.netology.SpringBootDemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
	@Autowired
	TestRestTemplate restTemplate;

	@Container
	private static final GenericContainer<?> containerDev = new GenericContainer<>("devapp")
			.withExposedPorts(8080);

	@Container
	private static final GenericContainer<?> containerProd = new GenericContainer<>("prodapp")
			.withExposedPorts(8081);

	@Test
	void contextLoads() {
		Integer devAppPort = containerDev.getMappedPort(8080);
		Integer prodAppPort = containerProd.getMappedPort(8081);

		ResponseEntity<String> forEntityDev = restTemplate.getForEntity("http://localhost:" + devAppPort + "/profile", String.class);
		ResponseEntity<String> forEntityProd = restTemplate.getForEntity("http://localhost:" + prodAppPort + "/profile", String.class);

		System.out.println(forEntityDev.getBody());
		System.out.println(forEntityProd.getBody());

		Assertions.assertEquals("Current profile is dev", forEntityDev.getBody());
		Assertions.assertEquals("Current profile is production", forEntityProd.getBody());
	}
}