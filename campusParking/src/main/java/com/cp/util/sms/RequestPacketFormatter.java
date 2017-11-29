package com.cp.util.sms;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class RequestPacketFormatter {
	
	private String appKey;
		
	public String formatRequestPacket(String mobile, long time, long random, String message, int type) {
		JSONObject json = getCommunalParams(mobile, random, time);
		
		json.put("type", type);
		json.put("msg", message);
		
		return json.toJSONString();
	}
	
	public String formatRequestPacket(String mobile, long time, long random, int templateId, JSONArray params) {
		JSONObject json = getCommunalParams(mobile, random, time);
		
		json.put("tpl_id", templateId);
		json.put("params", params);
		
		return json.toJSONString();
	}
	
	private JSONObject getCommunalParams(String mobile, long random, long time) {
		JSONObject json = new JSONObject();
		
		json.put("tel", createTel(mobile));
		json.put("sig", createSig(mobile, appKey, random, time));
		json.put("time", time);
		json.put("extend", "");
		json.put("ext", "");
		
		return json;
	}
	
	private JSONObject createTel(String mobile) {
		JSONObject json = new JSONObject(2);
		
		json.put("nationcode", "86");
		json.put("mobile", mobile);
		
		return json;
	}
	
	private String createSig(String mobile, String appKey, long random, long time) {
		
		String sig = String.format("appkey=%s&random=%d&time=%d&mobile=%s",
        		appKey, random, time, mobile);
		
		return DataProcessing.strToHash(sig);
	}
	
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
}
