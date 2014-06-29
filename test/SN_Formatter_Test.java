package com.dogstar.shakenext.test;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.dogstar.shakenext.apiclient.*;
import com.dogstar.shakenext.apiclient.formatter.SN_FormatterFactory;
import com.dogstar.shakenext.apiclient.formatter.SN_FormatterProxy;

public class SN_Formatter_Test extends TestCase {
	public void testJsonFormatter() {
		SN_FormatterProxy formatter = new SN_FormatterProxy(SN_FormatterFactory.create("json"));
		String result = "{\"status\":\"OK\",\"data\":\"Welcome to use zenphpWS3!\",\"error\":\"\",\"debug\":{\"msg\":\"This is default service!\"}}";
		SN_Response response = formatter.parse(result);
		
		Assert.assertEquals(SN_Response_Status.OK, response.getStatus());
		Assert.assertEquals("", response.getError());
		Assert.assertEquals("Welcome to use zenphpWS3!", response.getData());
		Assert.assertEquals("{\"msg\":\"This is default service!\"}", response.getDebug());
	}
	
	public void testFactory() {
		Assert.assertEquals("class com.dogstar.shakenext.apiclient.formatter.impl.SN_JsonFormatter", SN_FormatterFactory.create("json").getClass().toString());
		Assert.assertEquals("class com.dogstar.shakenext.apiclient.formatter.impl.SN_XmlFormatter", SN_FormatterFactory.create("xml").getClass().toString());
		Assert.assertEquals("class com.dogstar.shakenext.apiclient.formatter.impl.SN_NoneFormatter", SN_FormatterFactory.create("none").getClass().toString());
		Assert.assertEquals("class com.dogstar.shakenext.apiclient.formatter.impl.SN_NoneFormatter", SN_FormatterFactory.create("unknow").getClass().toString());
	}
}
