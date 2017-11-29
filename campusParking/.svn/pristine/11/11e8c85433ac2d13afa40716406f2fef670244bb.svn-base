package com.cp.util;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.alibaba.fastjson.JSONObject;

public class ResponseUtil {

	public static final String MSG_403 = "{\"msg\" : \" 403 Forbidden\"}";
	public static final String MSG_401 = "{\"msg\" : \"401 unauthorized\"}";
	public static final String MSG_400 = "{\"msg\" : \" 400 Bad Request\"}";
	
	/**
	 * 返回状态的键
	 * */
	public static final String RS_KEY = "status";
	
	/**
	 * 返回失败状态的json串
	 * */
	public static final String FAIL_RS = "{\"" + RS_KEY + "\":\"false\"}";
	
	/**
	 * 返回成功状态的json串
	 * */
	public static final String SUCCESS_RS = "{\"" + RS_KEY + "\":\"true\"}";
	
	/**
	 * 获取请求参数无效时的返回实体
	 * */
	public static ResponseEntity<String> getResponseEntityWhenInvalidReqParams() {
		return new ResponseEntity<String>(MSG_400, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * 获取返回用户请求的数据时的返回实体，对应Get，状态值为200
	 * */
	public static ResponseEntity<String> getResEntityForGet(String data) {
		return new ResponseEntity<String>(data, HttpStatus.OK);
	}
	
	/**
	 * 将map返回为json
	 * */
	public static ResponseEntity<String> getResEntityForGetAndJson(Map<String,Object> data) {
		if(data == null)
			return ResponseUtil.getResEntityForGet();
		
		return getResEntityForGet(new JSONObject(data).toJSONString());
	}
	
	/**
	 * 返回jsonarray的返回实体
	 * */
	public static ResponseEntity<String> getResEntityForGetAndJsonArray(List<Map<String, Object>> datas) {
		if(datas == null)
			return ResponseUtil.getResEntityForGet();
		
		return getResEntityForGet(JSONUtil.toJSONArray(datas).toJSONString());
	}
	
	/**
	 * 获取返回用户请求的数据时的返回实体，对应Get，状态值为200
	 *  不返回其他的值，仅仅需要告诉前端该操作成功
	 * */
	public static ResponseEntity<String> getResEntityForGetWhenSuccess() {
		return new ResponseEntity<String>(SUCCESS_RS, HttpStatus.OK);
	}
	
	/**
	 * 获取返回用户请求的数据时的返回实体，对应Get，状态值为200
	 *  不返回其他的值，仅仅需要告诉前端该操作失败
	 * */
	public static ResponseEntity<String> getResEntityForGetWhenFail() {
		return new ResponseEntity<String>(FAIL_RS, HttpStatus.OK);
	}
	
	/**
	 * 获取返回用户请求的数据时的返回实体，对应Get，状态值为200
	 *  返回一个空字符串
	 * */
	public static ResponseEntity<String> getResEntityForGet() {
		return new ResponseEntity<String>("", HttpStatus.OK);
	}
	
	/**
	 * 获取用户新增或修改数据时的返回实体，对应POST/PUT/PATCH，状态值为201
	 * 不返回其他的值，仅仅需要告诉前端该操作成功
	 * */
	public static ResponseEntity<String> getResEntityForPPPWhenSuccess() {
		return new ResponseEntity<String>(SUCCESS_RS, HttpStatus.CREATED);
	}
	
	/**
	 * 获取用户新增或修改数据时的返回实体，对应POST/PUT/PATCH，状态值为201
	 * 不返回其他的值，仅仅需要告诉前端该操作失败
	 * */
	public static ResponseEntity<String> getResEntityForPPPWhenFail() {
		return new ResponseEntity<String>(FAIL_RS, HttpStatus.CREATED);
	}
	
	/**
	 * 获取用户新增或修改数据时的返回实体，对应POST/PUT/PATCH，状态值为201
	 * */
	public static ResponseEntity<String> getResEntityForPPP(String data) {
		return new ResponseEntity<String>(data, HttpStatus.CREATED);
	}
	
	/**
	 * 获取用户新增或修改数据时的返回实体，对应POST/PUT/PATCH，状态值为201
	 * */
	public static ResponseEntity<String> getResEntityForPPPAndJson(Map<String, Object> data) {
		if(data == null)
			return getResEntityForPPPWhenFail();
		return new ResponseEntity<String>(new JSONObject(data).toJSONString(), HttpStatus.CREATED);
	}
	
	/**
	 * 获取用户新增或修改数据时的返回实体，对应POST/PUT/PATCH，状态值为201
	 * */
	public static ResponseEntity<String> getResEntityForPPPAndJsonArray(List<Map<String, Object>> datas) {
		if(datas == null)
			return ResponseUtil.getResEntityForPPPWhenFail();
		
		return getResEntityForPPP(JSONUtil.toJSONArray(datas).toJSONString());
	}
}
