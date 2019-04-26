package jspbook.ch14;

import java.io.IOException;
import javax.servlet.*;
import org.slf4j.*;

public class LogFilter implements Filter {
	private static final Logger LOG = LoggerFactory.getLogger(LogFilter.class);
	
	public void destroy() {
		LOG.info("LogFilter stop");
	}
	
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
		LOG.debug("LogFilter run {}", arg0.getRemoteAddr());
	}
	
	public void init(FilterConfig arg0) throws ServletException {
		LOG.info("LogFilter start");
	}
}
