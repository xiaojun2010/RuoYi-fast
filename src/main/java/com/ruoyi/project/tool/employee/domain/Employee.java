package com.ruoyi.project.tool.employee.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.math.BigDecimal;

/**
 * 员工表 sys_employee
 * 
 * @author ruoyi
 */
public class Employee extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 员工ID */
    private Long employeeId;

    /** 员工编号 */
    private String employeeCode;

    /** 员工姓名 */
    private String employeeName;

    /** 员工性别 */
    private String employeeSex;

    /** 员工手机 */
    private String employeePhone;

    /** 员工邮箱 */
    private String employeeEmail;

    /** 员工余额 */
    private BigDecimal employeeBalance;

    /** 员工状态（0正常 1停用） */
    private String status;

    public void setEmployeeId(Long employeeId)
    {
        this.employeeId = employeeId;
    }

    public Long getEmployeeId()
    {
        return employeeId;
    }

    public void setEmployeeCode(String employeeCode)
    {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeCode()
    {
        return employeeCode;
    }

    public void setEmployeeName(String employeeName)
    {
        this.employeeName = employeeName;
    }

    public String getEmployeeName()
    {
        return employeeName;
    }

    public void setEmployeeSex(String employeeSex)
    {
        this.employeeSex = employeeSex;
    }

    public String getEmployeeSex()
    {
        return employeeSex;
    }

    public void setEmployeePhone(String employeePhone)
    {
        this.employeePhone = employeePhone;
    }

    public String getEmployeePhone()
    {
        return employeePhone;
    }

    public void setEmployeeEmail(String employeeEmail)
    {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeEmail()
    {
        return employeeEmail;
    }

    public void setEmployeeBalance(BigDecimal employeeBalance)
    {
        this.employeeBalance = employeeBalance;
    }

    public BigDecimal getEmployeeBalance()
    {
        return employeeBalance;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("employeeId", getEmployeeId())
                .append("employeeCode", getEmployeeCode()).append("employeeName", getEmployeeName())
                .append("employeeSex", getEmployeeSex()).append("employeePhone", getEmployeePhone())
                .append("employeeEmail", getEmployeeEmail()).append("employeeBalance", getEmployeeBalance())
                .append("status", getStatus()).append("createBy", getCreateBy()).append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy()).append("updateTime", getUpdateTime()).append("remark", getRemark())
                .toString();
    }
}
