/**
 * 
 */
package com.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ashish.gupta
 *
 */
public class CacheControleFilter implements javax.servlet.Filter {
	FilterConfig filterConfig = null;

	public void init(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		String sCache = filterConfig.getInitParameter("cache");

		if (sCache != null) {
			((HttpServletResponse) res).setHeader("Cache-Control", sCache);
		}

		chain.doFilter(req, res);
	}

	public void destroy() {
		this.filterConfig = null;
	}
}
