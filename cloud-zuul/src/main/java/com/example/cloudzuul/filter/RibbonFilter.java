package com.example.cloudzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class RibbonFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return null;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {

		RequestContext currentContext = RequestContext.getCurrentContext();
		HttpServletRequest request = currentContext.getRequest();

		//获取 请求url
		String remoteAddr = request.getRemoteAddr();
//		和老地址 做匹配
		if(remoteAddr.contains("/sms-test3")) {
//			remoteAddr =>
			currentContext.set(FilterConstants.REQUEST_URI_KEY,"");
		}
		return null;
	}
}
