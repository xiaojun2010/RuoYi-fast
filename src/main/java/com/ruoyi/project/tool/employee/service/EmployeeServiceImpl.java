package com.ruoyi.project.tool.employee.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.tool.employee.domain.Employee;
import com.ruoyi.project.tool.employee.mapper.EmployeeMapper;

/**
 * 员工 服务层实现
 * 
 * @author ruoyi
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService
{
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 查询员工信息
     * 
     * @param employeeId 员工ID
     * @return 员工信息
     */
    @Override
    public Employee selectEmployeeById(Long employeeId)
    {
        return employeeMapper.selectEmployeeById(employeeId);
    }

    /**
     * 查询员工列表
     * 
     * @param employee 员工信息
     * @return 员工集合
     */
    @Override
    public List<Employee> selectEmployeeList(Employee employee)
    {
        return employeeMapper.selectEmployeeList(employee);
    }

    /**
     * 新增员工
     * 
     * @param employee 员工信息
     * @return 结果
     */
    @Override
    public int insertEmployee(Employee employee)
    {
        return employeeMapper.insertEmployee(employee);
    }

    /**
     * 修改员工
     * 
     * @param employee 员工信息
     * @return 结果
     */
    @Override
    public int updateEmployee(Employee employee)
    {
        return employeeMapper.updateEmployee(employee);
    }

    /**
     * 删除员工对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEmployeeByIds(String ids)
    {
        return employeeMapper.deleteEmployeeByIds(Convert.toStrArray(ids));
    }

}
