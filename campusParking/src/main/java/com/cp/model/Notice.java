package com.cp.model;

import java.util.Date;

public class Notice {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.publish_time
     *
     * @mbggenerated
     */
    private Date publishTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.publish_user
     *
     * @mbggenerated
     */
    private String publishUser;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.id
     *
     * @return the value of notice.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.id
     *
     * @param id the value for notice.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.title
     *
     * @return the value of notice.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.title
     *
     * @param title the value for notice.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.content
     *
     * @return the value of notice.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.content
     *
     * @param content the value for notice.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.publish_time
     *
     * @return the value of notice.publish_time
     *
     * @mbggenerated
     */
    public Date getPublishTime() {
        return publishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.publish_time
     *
     * @param publishTime the value for notice.publish_time
     *
     * @mbggenerated
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.publish_user
     *
     * @return the value of notice.publish_user
     *
     * @mbggenerated
     */
    public String getPublishUser() {
        return publishUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.publish_user
     *
     * @param publishUser the value for notice.publish_user
     *
     * @mbggenerated
     */
    public void setPublishUser(String publishUser) {
        this.publishUser = publishUser == null ? null : publishUser.trim();
    }
}