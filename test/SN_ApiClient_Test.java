package com.dogstar.shakenext.test;

import com.dogstar.shakenext.apiclient.*;

import junit.framework.Assert;
import junit.framework.TestCase;

public class SN_ApiClient_Test extends TestCase {
	public void testHttpClient() {
		SN_ApiClient client = SN_ApiClient.getInstance();
		SN_Params params = SN_Params.newInsance("http://dogstar.api.shakenext.com");
		SN_Response response = client.request(params);
		
		Assert.assertEquals(SN_Response_Status.OK, response.getStatus());
		Assert.assertEquals("", response.getError());
		Assert.assertEquals("Welcome to use zenphpWS3!", response.getData());
		Assert.assertEquals("{\"msg\":\"This is default service!\"}", response.getDebug());
	}
	
	public void testHelloWorld() {
		SN_ApiClient client = SN_ApiClient.getInstance();
		SN_Params params = SN_Params.newInsance()
				.withHost("http://dogstar.api.shakenext.com")
				.withController("Examples")
				.withAction("getWelcome")
				.set("name", "dogstar");
		SN_Response response = client.request(params);
		
		Assert.assertEquals(SN_Response_Status.OK, response.getStatus());
		Assert.assertEquals("", response.getError());
		Assert.assertEquals("{\"content\":\"Hello Wolrd\",\"name\":\"dogstar\"}", response.getData());
		Assert.assertEquals("[]", response.getDebug());
	}
}
