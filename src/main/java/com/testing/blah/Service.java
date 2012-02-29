package com.testing.blah;

/**
 * <p>
 * Main service interface for funappz.com
 * </p>
 * 
 * @author andrewcarr
 * 
 */
public interface Service {

	public void ConvertAndSend(String queueName, String message);
	
	public Object receiveAndConvert(String queuename);
}
