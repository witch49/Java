package jspbook.ch14;

import org.slf4j.*;

public class LogTest {
	private static final Logger LOG = LoggerFactory.getLogger(LogTest.class);
	
	public static void main(String[] args) {
		String msg = "Hello Log!!";
		LOG.info("Test LOG");
		LOG.warn("test log : {}", msg);
		LOG.debug("debug level test");
		LOG.trace("trace level test");
	}

}
