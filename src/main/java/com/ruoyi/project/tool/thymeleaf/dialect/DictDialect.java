package com.ruoyi.project.tool.thymeleaf.dialect;

import java.util.HashSet;
import java.util.Set;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;
import com.ruoyi.project.tool.thymeleaf.processor.SelectElementTagProcessor;

/**
 * 自定义字典标签
 *
 * @author ruoyi
 **/
public class DictDialect extends AbstractProcessorDialect
{

    /**
     * 定义方言名称
     */
    private static final String NAME = "Dict";

    /**
     * 定义方言属性
     */
    public static final String PREFIX = "dict";

    public DictDialect()
    {
        super(NAME, PREFIX, StandardDialect.PROCESSOR_PRECEDENCE);
    }

    @Override
    public Set<IProcessor> getProcessors(final String dialectPrefix)
    {
        final Set<IProcessor> processors = new HashSet<>();
        processors.add(new SelectElementTagProcessor(dialectPrefix));
        return processors;
    }
}