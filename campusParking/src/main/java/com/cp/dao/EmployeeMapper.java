package com.cp.dao;

import com.cp.model.Employee;

public interface EmployeeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated
     */
    int insert(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated
     */
    int insertSelective(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated
     */
    Employee selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Employee record);
}