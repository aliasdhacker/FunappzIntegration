package com.testing.blah;

import static org.junit.Assert.assertNotNull;

import com.testing.blah.Service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ConfigurationTests {
	
	private static final String USER_NAME_QUEUE = "userNameQueue";
	@Autowired
	private Service service;

	@Test
	public void testSimpleProperties() throws Exception {
		service.ConvertAndSend(USER_NAME_QUEUE, "This is a message!");
		
		System.out.println(service.receiveAndConvert(USER_NAME_QUEUE));
	}
	
}
