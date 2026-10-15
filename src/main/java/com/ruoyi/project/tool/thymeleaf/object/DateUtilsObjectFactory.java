package com.ruoyi.project.tool.thymeleaf.object;

import java.util.HashSet;
import java.util.Set;
import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.expression.IExpressionObjectFactory;
import com.ruoyi.common.utils.DateUtils;

public class DateUtilsObjectFactory implements IExpressionObjectFactory
{
    /**
     * 自定义内置对象名称
     */
    private static final String EXPRESSION_OBJECT_NAME = "dateUtils";

    /**
     * 返回表达式对象的名称
     */
    @Override
    public Set<String> getAllExpressionObjectNames()
    {
        Set<String> names = new HashSet<>();
        names.add(EXPRESSION_OBJECT_NAME);
        return names;
    }

    /**
     * 创建内置对象的应用的实例
     */
    @Override
    public Object buildObject(IExpressionContext context, String expressionObjectName)
    {
        if (EXPRESSION_OBJECT_NAME.equals(expressionObjectName))
        {
            return new DateUtils();
        }
        return null;
    }

    /**
     * 是否缓存该对象
     */
    @Override
    public boolean isCacheable(String expressionObjectName)
    {
        return false;
    }
}
