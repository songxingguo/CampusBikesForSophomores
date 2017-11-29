package com.cp.dto;

public class BicycleRentalRecordDTO {

	private String id;
	
	private String bicycleId;
	
	private String userId;
	
	private String startTime;
	
	private String endTime;
	
	private int consumptiveMoney;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBicycleId() {
		return bicycleId;
	}

	public void setBicycleId(String bicycleId) {
		this.bicycleId = bicycleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getConsumptiveMoney() {
		return consumptiveMoney;
	}

	public void setConsumptiveMoney(int consumptiveMoney) {
		this.consumptiveMoney = consumptiveMoney;
	}
}
