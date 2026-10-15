package com.ruoyi.project.tool.thymeleaf.object;

import org.thymeleaf.dialect.IExpressionObjectDialect;
import org.thymeleaf.expression.IExpressionObjectFactory;

/**
 * 自定义的时间工具对象
 * 
 * @author ruoyi
 */
public class DateUtilsExpDialect implements IExpressionObjectDialect
{
    @Override
    public String getName()
    {
        return "DateUtils Dialect";
    }

    @Override
    public IExpressionObjectFactory getExpressionObjectFactory()
    {
        return new DateUtilsObjectFactory();
    }
}
