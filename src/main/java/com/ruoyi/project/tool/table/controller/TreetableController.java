package com.ruoyi.project.tool.table.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ruoyi.framework.web.controller.BaseController;

/**
 * 树列表演示地址
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/tool/treetable")
public class TreetableController extends BaseController
{
    private String prefix = "tool/treetable";

    @GetMapping("/radio")
    public String radio()
    {
        return prefix + "/radio";
    }

    @GetMapping("/check")
    public String check()
    {
        return prefix + "/check";
    }

    @GetMapping("/ajaxParams")
    public String ajaxParams()
    {
        return prefix + "/ajaxParams";
    }
}
