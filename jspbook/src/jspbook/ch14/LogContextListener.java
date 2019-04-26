package jspbook.ch14;

import javax.servlet.*;
import javax.servlet.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class LogContextListener implements ServletContextListener{
	private static final Logger LOG = LoggerFactory.getLogger(LogContextListener.class);
	
	public void contextDestroyed(ServletContextEvent arg0) {
		LOG.info("LogContextListener stop");
	}
	
	public void contextInitialized(ServletContextEvent arg0) {
		LOG.info("LogContextListener start");
	}
	
}
