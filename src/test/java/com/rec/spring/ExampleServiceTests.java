package com.rec.spring;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class ExampleServiceTests {

	private ApplicationContext context;

	@Before
	public void setUp() {
		context = new AnnotationConfigApplicationContext(AppConfig.class);
	}

	@After
	public void tearDown() {
		((AbstractApplicationContext) context).close();
	}

	@Test
	public void checkInstances() throws InterruptedException {
		Foo bean1 = context.getBean(Foo.class);
		Service service1 = bean1.getService();
		String message1 = service1.getMessage();

		Thread.sleep(10);

		Foo bean2 = context.getBean(Foo.class);
		Service service2 = bean2.getService();
		String message2 = service2.getMessage();

		assertTrue(bean1 == bean2);
		assertTrue(service1 == service2);
		assertFalse(message1.equals(message2));
	}

}
