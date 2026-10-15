package com.ruoyi.project.tool.employee.service;

import java.util.List;
import com.ruoyi.project.tool.employee.domain.Employee;

/**
 * 员工 服务层
 * 
 * @author ruoyi
 */
public interface IEmployeeService
{
    /**
     * 查询员工信息
     * 
     * @param employeeId 员工ID
     * @return 员工信息
     */
    public Employee selectEmployeeById(Long employeeId);

    /**
     * 查询员工列表
     * 
     * @param employee 员工信息
     * @return 员工集合
     */
    public List<Employee> selectEmployeeList(Employee employee);

    /**
     * 新增员工
     * 
     * @param employee 员工信息
     * @return 结果
     */
    public int insertEmployee(Employee employee);

    /**
     * 修改员工
     * 
     * @param employee 员工信息
     * @return 结果
     */
    public int updateEmployee(Employee employee);

    /**
     * 删除员工信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEmployeeByIds(String ids);

}
