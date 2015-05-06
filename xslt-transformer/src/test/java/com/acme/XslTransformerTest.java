package com.acme;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aramex.bdl.ingest.processors.XsltTransformerModuleConfig;





/*
 *
 * Copyright (c) 2015 Pivotal Software, Inc. All Rights Reserved
 *
 * This software contains the intellectual property of Pivotal Software, Inc. or is
 * licensed to Pivotal Software, Inc. from third parties. Use of this software and
 * the intellectual property contained therein is expressly limited to the
 * terms and conditions of the License Agreement under which it is provided
 * by or on behalf of Pivotal Software, Inc.
 */

/**
 * @author Muhammad Ali
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:xslt-transformer-test-context.xml"})
public class XslTransformerTest {
	
	
	@Test
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		Properties properties = new Properties();
		properties.put("xslt","classpath:awbs-test.xsl");
		context.getEnvironment().getPropertySources().addLast(new PropertiesPropertySource("options", properties));
		context.register(TestConfiguration.class);
		context.refresh();

		MessageChannel input = context.getBean("input", MessageChannel.class);
		SubscribableChannel output = context.getBean("output", SubscribableChannel.class);

		final AtomicBoolean handled = new AtomicBoolean();
		output.subscribe(new MessageHandler() {
			@Override
			public void handleMessage(Message<?> message) throws MessagingException {
				handled.set(true);
				assertEquals("124,SENDING PACKAGE", message.getPayload());
			}
		});
		
		 @SuppressWarnings("resource")
		Scanner scanner = new Scanner(File.class.getResourceAsStream("/test.xml")).useDelimiter("\\Z");
	
	    String content = scanner.next();
		input.send(new GenericMessage<String>(content));
		assertTrue(handled.get());
	}

	@Configuration
	@Import(XsltTransformerModuleConfig.class)
	//@ImportResource("classpath:xslt-transformer-test-context.xml")
	static class TestConfiguration {
		@Bean
		public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
			PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new
					PropertySourcesPlaceholderConfigurer();
			return propertySourcesPlaceholderConfigurer;
		}
	}
//	@Autowired
//	ConfigurableApplicationContext applicationContext;
//
//	private static SingleNodeApplication application;
//
//	private static int RECEIVE_TIMEOUT = 10000;
//
//	private static String moduleName = "xslt-transformer";
//	
//	@BeforeClass
//	  public static void setUp() {
//	    RandomConfigurationSupport randomConfigSupport = new RandomConfigurationSupport();
//	    
//	    application = new SingleNodeApplication().run();
//	    
//		SingleNodeIntegrationTestSupport singleNodeIntegrationTestSupport = new SingleNodeIntegrationTestSupport
//	        (application);
//	    singleNodeIntegrationTestSupport.addModuleRegistry(new SingletonModuleRegistry(ModuleType.processor,
//	        moduleName));
//
//	  }
//	
//	 @Test
//	  public void test() throws IOException{
//	    String streamName = "xsltTransformTest";
//	  
//	    String processingChainUnderTest = moduleName +" --xsltFile=awbs-test.xsl" ;
//	    
//	   // Properties properties = new Properties();
//	    //Thread.dumpStack();
//		//properties.put("xsltFile","awbs-test.xsl");		
//		//application.containerContext().getEnvironment().getPropertySources().addLast(new PropertiesPropertySource("options", properties));
//		//application.adminContext().getEnvironment().getPropertySources().addLast(new PropertiesPropertySource("options", properties));
//		
//
//	    SingleNodeProcessingChain chain = chain(application, streamName, processingChainUnderTest);
//	  
//	    @SuppressWarnings("resource")
//		Scanner scanner = new Scanner(File.class.getResourceAsStream("/test.xml")).useDelimiter("\\Z");
//
//	    String content = scanner.next();
//
//	    System.out.println("contents"+content);
//	    chain.sendPayload(content);
//
//	    String result = (String) chain.receivePayload(RECEIVE_TIMEOUT);
//
//	    assertEquals("124,SENDING PACKAGE", result);
//
//	    //Unbind the source and sink channels from the message bus
//	    chain.destroy();
//	    
//
//	    scanner.close();
//	  }
}

