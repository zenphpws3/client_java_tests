package com.dogstar.shakenext.test;

import com.dogstar.shakenext.apiclient.SN_Params;

import junit.framework.Assert;
import junit.framework.TestCase;

public class SN_Params_Test extends TestCase {
	public void testNewInstance() {
		//should not use as bello
		SN_Params params = SN_Params.newInsance();
		Assert.assertEquals(":80/index.php?f=json&p=http", params.getUrl());
	}
	
	public void testNewInstanceWithHost() {
		SN_Params params = SN_Params.newInsance("http://dogstar.api.shakenext.com/");
		Assert.assertEquals("http://dogstar.api.shakenext.com/:80/index.php?f=json&p=http", params.getUrl());
	}
	
	public void testNewInstanceWithBusinessQuery() {
		SN_Params params = SN_Params.newInsance("http://dogstar.api.shakenext.com/");
		params.set("name", "dogstar").set("year", 2014 + "").set("sex", "male");
		params.set("v", "ingnore").set("h", "ignore");
		Assert.assertEquals("http://dogstar.api.shakenext.com/:80/index.php?f=json&sex=male&year=2014&name=dogstar&p=http", params.getUrl());
	}
	
	public void testNewInstanceWithSystemQuery() {
		SN_Params params = SN_Params.newInsance();
		params.withHost("http://dogstar.api.shakenext.com/").withAction("actionName").withController("controllerName");
		Assert.assertEquals("http://dogstar.api.shakenext.com/:80/index.php?f=json&c=controllerName&a=actionName&p=http", params.getUrl());
	}
}
