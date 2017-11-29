package com.cp.util;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JSONUtil {

	public static JSONArray toJSONArray(List<Map<String, Object>> datas) {
		JSONArray ja = new JSONArray();
		
		for(Map<String, Object> data : datas)
			ja.add(new JSONObject(data));
		
		return ja;
	}
}
