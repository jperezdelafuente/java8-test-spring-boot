package org.lab.ExampleText;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab.ExampleJava8Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ExampleJava8Application.class)
public class ExamplePrintJustifiedTextTest {

	@Autowired
	private ExamplePrintJustifiedText service;

	@Test
	public void contextLoads() {
		String phrase = "Dispatching mechanisms from the core of distributed object computing (DOC) middleware.";
		for (int sizeLine = 11; sizeLine <= 86; sizeLine++) {
			System.out.println("----------------- Size Line: " + sizeLine);
			service.printJustifiedText(phrase, sizeLine);
		}
	}

}
