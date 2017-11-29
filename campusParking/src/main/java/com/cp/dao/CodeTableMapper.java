package com.cp.dao;

import com.cp.model.CodeTable;

public interface CodeTableMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code_table
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String code);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code_table
     *
     * @mbggenerated
     */
    int insert(CodeTable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code_table
     *
     * @mbggenerated
     */
    int insertSelective(CodeTable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code_table
     *
     * @mbggenerated
     */
    CodeTable selectByPrimaryKey(String code);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code_table
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CodeTable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code_table
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CodeTable record);
}