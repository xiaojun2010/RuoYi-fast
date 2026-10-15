package com.ruoyi.project.tool.employee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.tool.employee.domain.Employee;
import com.ruoyi.project.tool.employee.service.IEmployeeService;

/**
 * 员工信息操作处理
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/tool/employee")
public class EmployeeController extends BaseController
{
    private String prefix = "tool/employee";

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/server")
    public String employee()
    {
        return "tool/table/server";
    }

    @GetMapping("/footer")
    public String footer()
    {
        return "tool/table/footer";
    }

    @GetMapping("/serverMulti")
    public String serverMulti()
    {
        return "tool/table/serverMulti";
    }

    @GetMapping("/client")
    public String client()
    {
        return "tool/table/client";
    }

    @GetMapping("/rememberSelected")
    public String rememberSelected()
    {
        return "tool/table/rememberSelected";
    }

    @GetMapping("/fixedColumns")
    public String fixedColumns()
    {
        return "tool/table/fixedColumns";
    }

    @GetMapping("/rowStyle")
    public String rowStyle()
    {
        return "tool/table/rowStyle";
    }

    @GetMapping("/queryParams")
    public String queryParams()
    {
        return "tool/table/queryParams";
    }

    /**
     * 查询员工列表（不分页）
     */
    @PostMapping("/client/list")
    @ResponseBody
    public TableDataInfo clientList(Employee employee)
    {
        List<Employee> list = employeeService.selectEmployeeList(employee);
        return getDataTable(list);
    }

    /**
     * 查询员工列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Employee employee)
    {
        startPage();
        List<Employee> list = employeeService.selectEmployeeList(employee);
        return getDataTable(list);
    }

    /**
     * 导出员工列表
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Employee employee)
    {
        List<Employee> list = employeeService.selectEmployeeList(employee);
        ExcelUtil<Employee> util = new ExcelUtil<Employee>(Employee.class);
        return util.exportExcel(list, "employee");
    }

    /**
     * 新增员工
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存员工
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Employee employee)
    {
        return toAjax(employeeService.insertEmployee(employee));
    }

    /**
     * 修改员工
     */
    @GetMapping("/edit/{employeeId}")
    public String edit(@PathVariable("employeeId") Long employeeId, ModelMap mmap)
    {
        Employee employee = employeeService.selectEmployeeById(employeeId);
        mmap.put("employee", employee);
        return prefix + "/edit";
    }

    /**
     * 修改保存员工
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Employee employee)
    {
        return toAjax(employeeService.updateEmployee(employee));
    }

    /**
     * 删除员工
     */
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(employeeService.deleteEmployeeByIds(ids));
    }

}
