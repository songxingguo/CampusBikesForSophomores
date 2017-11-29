package com.cp.model;

import java.util.Date;

public class Bicycle {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bicycle.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bicycle.bicycle_no
     *
     * @mbggenerated
     */
    private String bicycleNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bicycle.operator_id
     *
     * @mbggenerated
     */
    private String operatorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bicycle.entry_time
     *
     * @mbggenerated
     */
    private Date entryTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bicycle.color
     *
     * @mbggenerated
     */
    private String color;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bicycle.bicycle_type
     *
     * @mbggenerated
     */
    private String bicycleType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bicycle.brand
     *
     * @mbggenerated
     */
    private String brand;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bicycle.id
     *
     * @return the value of bicycle.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bicycle.id
     *
     * @param id the value for bicycle.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bicycle.bicycle_no
     *
     * @return the value of bicycle.bicycle_no
     *
     * @mbggenerated
     */
    public String getBicycleNo() {
        return bicycleNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bicycle.bicycle_no
     *
     * @param bicycleNo the value for bicycle.bicycle_no
     *
     * @mbggenerated
     */
    public void setBicycleNo(String bicycleNo) {
        this.bicycleNo = bicycleNo == null ? null : bicycleNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bicycle.operator_id
     *
     * @return the value of bicycle.operator_id
     *
     * @mbggenerated
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bicycle.operator_id
     *
     * @param operatorId the value for bicycle.operator_id
     *
     * @mbggenerated
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bicycle.entry_time
     *
     * @return the value of bicycle.entry_time
     *
     * @mbggenerated
     */
    public Date getEntryTime() {
        return entryTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bicycle.entry_time
     *
     * @param entryTime the value for bicycle.entry_time
     *
     * @mbggenerated
     */
    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bicycle.color
     *
     * @return the value of bicycle.color
     *
     * @mbggenerated
     */
    public String getColor() {
        return color;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bicycle.color
     *
     * @param color the value for bicycle.color
     *
     * @mbggenerated
     */
    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bicycle.bicycle_type
     *
     * @return the value of bicycle.bicycle_type
     *
     * @mbggenerated
     */
    public String getBicycleType() {
        return bicycleType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bicycle.bicycle_type
     *
     * @param bicycleType the value for bicycle.bicycle_type
     *
     * @mbggenerated
     */
    public void setBicycleType(String bicycleType) {
        this.bicycleType = bicycleType == null ? null : bicycleType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bicycle.brand
     *
     * @return the value of bicycle.brand
     *
     * @mbggenerated
     */
    public String getBrand() {
        return brand;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bicycle.brand
     *
     * @param brand the value for bicycle.brand
     *
     * @mbggenerated
     */
    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }
}