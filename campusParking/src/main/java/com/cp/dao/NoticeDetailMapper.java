package com.cp.dao;

import com.cp.model.NoticeDetail;

public interface NoticeDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice_detail
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice_detail
     *
     * @mbggenerated
     */
    int insert(NoticeDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice_detail
     *
     * @mbggenerated
     */
    int insertSelective(NoticeDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice_detail
     *
     * @mbggenerated
     */
    NoticeDetail selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice_detail
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(NoticeDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice_detail
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(NoticeDetail record);
}