package com.cp.util.sms.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.cp.util.sms.RequestPacketFormatter;
import com.cp.util.sms.ShortMessageService;

import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

@Service
public class ShortMessageServiceImpl implements ShortMessageService {
	
	private String url;
	
	private int appId;
	
	private RequestPacketFormatter requestPacketFormatter;
	
	@Override
	public String sendSingleMessage(String message, String phoneNumber, int type) {
		long random = getRandom();
		long time = System.currentTimeMillis() / 1000;
		String wholeUrl = String.format("%s?sdkappid=%d&random=%d", url, appId, random);
		
		HttpRequest request = getPostRequest(wholeUrl);
		
	    request.body(requestPacketFormatter.formatRequestPacket(phoneNumber, time, random, message, type));
	    
	    HttpResponse response = request.send();
	    
		return response.bodyText();
	}
	
	@Override
	public String sendSingleMessageWithTemplate(String phoneNumber, int templateId, JSONArray params) {

		long random = getRandom();
		long time = System.currentTimeMillis() / 1000;
		String wholeUrl = String.format("%s?sdkappid=%d&random=%d", url, appId, random);
		
		HttpRequest request = getPostRequest(wholeUrl);
	    
	    request.body(requestPacketFormatter.formatRequestPacket(phoneNumber, time, random, templateId, params));
	    
	    HttpResponse response = request.send();
	   	    
		return response.bodyText();
	}
	
	private HttpRequest getPostRequest(String url) {
		HttpRequest request = HttpRequest.post(url);
		
		request.acceptEncoding("utf-8");
		request.header("Content-Type", "application/json");
	    request.header("Accept", "application/json");
		
		return request;
	}
	
	private long getRandom() {
		Random random = new Random();
		long l = Math.abs(random.nextLong());
		
		return l / 1000000000L;
	}
		
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void setAppId(int appId) {
		this.appId = appId;
	}
	
	public void setRequestPacketFormatter(RequestPacketFormatter requestPacketFormatter) {
		this.requestPacketFormatter = requestPacketFormatter;
	}
}
