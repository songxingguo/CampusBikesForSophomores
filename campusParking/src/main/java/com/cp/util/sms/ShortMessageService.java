package com.cp.util.sms;

import com.alibaba.fastjson.JSONArray;

/**
 * 默认国内短信
 * */
public interface ShortMessageService {
	
	/**
	 * 普通单发短信
	 * */
	String sendSingleMessage(String message, String phoneNumber, int type);
	
	/**
	 * 指定模板单发短信
	 * @param phoneNumber 接收人的电话号码
	 * @param templateId 指定模板的id，详情查看腾讯云短信服务的短信内容配置
	 * @param params 与你选择模板对应的参数，格式为:["param1","param2"]，详情参考https://cloud.tencent.com/document/product/382/5976
	 * */
	String sendSingleMessageWithTemplate(String phoneNumber, int templateId, JSONArray params);
}
