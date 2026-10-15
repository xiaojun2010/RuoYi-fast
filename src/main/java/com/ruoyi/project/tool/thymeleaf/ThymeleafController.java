package com.ruoyi.project.tool.thymeleaf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.project.system.user.domain.User;

/**
 * Thymeleaf 测试
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/tool/thymeleaf")
public class ThymeleafController extends BaseController
{
    private String prefix = "tool/thymeleaf";

    @SuppressWarnings("rawtypes")
    @RequiresPermissions("tool:thymeleaf:view")
    @GetMapping("/objUse")
    public String objUse(ModelMap mmap)
    {
        // 设置用户集合变量
        List<User> users = new ArrayList<User>();
        User user1 = new User();
        user1.setUserId(1L);
        user1.setUserName("张三");
        users.add(user1);
        User user2 = new User();
        user2.setUserId(2L);
        user2.setUserName("李四");
        users.add(user2);
        mmap.put("user", user1);
        mmap.put("users", users);

        // 设置Map变量
        Map<String, User> userMap = new HashMap<String, User>();
        userMap.put("user1", user1);
        userMap.put("user2", user2);
        mmap.put("userMap", userMap);

        // 设置数组变量
        User[] userArr = new User[] { user1, user2 };
        mmap.put("userArr", userArr);

        // 设置数字对象
        Double[] arr = new Double[] { 100D, 155.941 };
        List list = Arrays.asList(arr);
        @SuppressWarnings("unchecked")
        Set set = new HashSet<>(list);
        mmap.put("arr", arr);
        mmap.put("list", list);
        mmap.put("set", set);

        // 设置当前日期
        mmap.put("date", DateUtils.getNowDate());
        return prefix + "/objUse";
    }

    @RequiresPermissions("tool:thymeleaf:view")
    @GetMapping("/grammar")
    public String grammar(ModelMap mmap)
    {
        // 设置用户集合变量
        List<User> users = new ArrayList<User>();
        User user1 = new User();
        user1.setUserId(1L);
        user1.setUserName("张三");
        users.add(user1);
        User user2 = new User();
        user2.setUserId(2L);
        user2.setUserName("李四");
        users.add(user2);
        mmap.put("users", users);

        // 设置Map变量
        Map<String, User> userMap = new HashMap<String, User>();
        userMap.put("user1", user1);
        userMap.put("user2", user2);
        mmap.put("userMap", userMap);
        return prefix + "/grammar";
    }

    @RequiresPermissions("tool:thymeleaf:view")
    @GetMapping("/fragment")
    public String fragment(ModelMap mmap)
    {
        // 设置用户集合变量
        List<User> users = new ArrayList<User>();
        User user1 = new User();
        user1.setUserId(1L);
        user1.setUserName("张三");
        users.add(user1);
        User user2 = new User();
        user2.setUserId(2L);
        user2.setUserName("李四");
        users.add(user2);
        mmap.put("users", users);
        return prefix + "/fragment";
    }

    @RequiresPermissions("tool:thymeleaf:view")
    @GetMapping("/inlining")
    public String inlining(ModelMap mmap)
    {
        // 设置用户集合变量
        User user = new User();
        user.setUserId(1L);
        user.setUserName("张三");
        mmap.put("user", user);
        return prefix + "/inlining";
    }

    @RequiresPermissions("tool:thymeleaf:view")
    @GetMapping("/management")
    public String management(ModelMap mmap)
    {
        return prefix + "/management";
    }

    @RequiresPermissions("tool:thymeleaf:view")
    @GetMapping("/dialect")
    public String dialect(ModelMap mmap)
    {
        return prefix + "/dialect";
    }
    
    @RequiresPermissions("tool:thymeleaf:view")
    @GetMapping("/objExp")
    public String objExp(ModelMap mmap)
    {
        return prefix + "/objExp";
    }
}
