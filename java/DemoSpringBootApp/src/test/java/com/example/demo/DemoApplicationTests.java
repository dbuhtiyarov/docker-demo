package com.example.demo;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() { 
	}

	@Test
	public void prolongTests() {

		Logger log = Logger.getLogger(DemoApplicationTests.class);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		}
		assertEquals(0, 0);
	}

}
