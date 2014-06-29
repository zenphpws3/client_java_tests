package com.dogstar.shakenext.test;

import com.dogstar.shakenext.apiclient.SN_Params;
import com.dogstar.shakenext.apiclient.request.SN_RequestFactory;
import com.dogstar.shakenext.apiclient.request.SN_RequestProxy;

import junit.framework.Assert;
import junit.framework.TestCase;

public class SN_Request_Test extends TestCase {
	public void testHttpRequest() {
		SN_RequestProxy requestProxy = new SN_RequestProxy(SN_RequestFactory.create("http"));
		SN_Params params = SN_Params.newInsance("http://dogstar.api.shakenext.com");
		//Assert.assertEquals("http://dogstar.api.shakenext.com:80/index.php?f=json&p=http&t=1404031975998", params.getUrl());
		String result = requestProxy.call(params);
		Assert.assertEquals("{\"status\":\"OK\",\"data\":\"Welcome to use zenphpWS3!\",\"error\":\"\",\"debug\":{\"msg\":\"This is default service!\"}}", result);
	}
	
	public void testRpcRequest() {
		SN_Params params = SN_Params.newInsance("http://dogstar.api.shakenext.com");
		params.withProtocol("rpc");
		//Assert.assertEquals("http://dogstar.api.shakenext.com:80/index.php?f=json&p=rpc&t=1404031975998", params.getUrl());
		
		SN_RequestProxy requestProxy = new SN_RequestProxy(SN_RequestFactory.create("rpc"));
		String result = requestProxy.call(params);
		Assert.assertEquals("{\"status\":\"OK\",\"data\":\"Welcome to use zenphpWS3!\",\"error\":\"\",\"debug\":{\"msg\":\"This is default service!\"}}", result);
	}
	
	public void testFactory() {
		Assert.assertEquals("class com.dogstar.shakenext.apiclient.request.impl.SN_RpcRequest", SN_RequestFactory.create("rpc").getClass().toString());
		Assert.assertEquals("class com.dogstar.shakenext.apiclient.request.impl.SN_HttpRequest", SN_RequestFactory.create("http").getClass().toString());
		Assert.assertEquals("class com.dogstar.shakenext.apiclient.request.impl.SN_NoneRequest", SN_RequestFactory.create("none").getClass().toString());
		Assert.assertEquals("class com.dogstar.shakenext.apiclient.request.impl.SN_NoneRequest", SN_RequestFactory.create("unkonw").getClass().toString());
	}
}
