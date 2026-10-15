package com.ruoyi.project.tool.thymeleaf.processor;

import java.util.ArrayList;
import java.util.List;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;
import org.unbescape.html.HtmlEscape;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.project.system.dict.domain.DictData;
import com.ruoyi.project.system.dict.service.DictDataServiceImpl;
import com.ruoyi.project.system.dict.service.IDictDataService;

/**
 * 自定义标签<dict:select>实现下拉框
 *
 * @author ruoyi
 */
public class SelectElementTagProcessor extends AbstractElementTagProcessor
{
    private static final String TAG_NAME = "select";
    private static final int PRECEDENCE = 1000;
    private IDictDataService dictDataService = SpringUtils.getBean(DictDataServiceImpl.class);

    public SelectElementTagProcessor(final String dialectPrefix)
    {
        super(TemplateMode.HTML, // 处理thymeleaf 的模型
                dialectPrefix, // 标签前缀名
                TAG_NAME, // 标签属性名
                true, // Apply dialect prefix to tag name
                null, // No attribute name: will match by tag name
                false, // No prefix to be applied to attribute name
                PRECEDENCE); // Precedence (inside dialect's own precedence)
    }

    @Override
    protected void doProcess(final ITemplateContext context, final IProcessableElementTag tag,
            final IElementTagStructureHandler structureHandler)
    {
        // html空格占位符
        List<String> options = new ArrayList<>();

        // 获取相关属性值
        String classValue = tag.getAttributeValue("class");
        final String id = tag.getAttributeValue("id");
        final String name = tag.getAttributeValue("name");
        final String style = tag.getAttributeValue("style");
        final Boolean headerKey = Boolean.parseBoolean(tag.getAttributeValue("headerKey"));
        final String headerValue = tag.getAttributeValue("headerValue");
        final String dict = tag.getAttributeValue("dict");
        if (StringUtils.isNotEmpty(dict))
        {
            List<DictData> dictDatas = dictDataService.selectDictDataByType(dict);
            for (DictData dictData : dictDatas)
            {
                StringBuilder option = new StringBuilder();
                option.append("<option value=\"");
                option.append(dictData.getDictValue());
                option.append("\">");
                option.append(dictData.getDictLabel());
                option.append("</option>");
                options.add(option.toString());
            }

            if (headerKey != null && headerValue != null)
            {
                StringBuilder defaultOption = new StringBuilder();
                defaultOption.append("<option value=\"").append(headerKey).append("\"");
                defaultOption.append(">").append(headerValue).append("</option>");
                options.add(0, defaultOption.toString());
            }
        }

        // 创建模型
        final IModelFactory modelFactory = context.getModelFactory();
        final IModel model = modelFactory.createModel();
        model.add(modelFactory.createText("\n\t"));
        // 添加模型元素
        IProcessableElementTag openElementTag = modelFactory.createOpenElementTag("select", "class", classValue);
        if (StringUtils.isNotEmpty(id))
        {
            openElementTag = modelFactory.setAttribute(openElementTag, "id", id);
        }
        if (StringUtils.isNotEmpty(name))
        {
            openElementTag = modelFactory.setAttribute(openElementTag, "name", name);
        }
        if (StringUtils.isNotEmpty(style))
        {
            openElementTag = modelFactory.setAttribute(openElementTag, "style", style);
        }
        model.add(openElementTag);
        model.add(modelFactory.createText("\n\t\t"));
        model.add(modelFactory.createText(HtmlEscape.unescapeHtml(String.join("\n\t\t", options))));
        model.add(modelFactory.createText("\n\t"));
        model.add(modelFactory.createCloseElementTag("select"));
        // 替换页面标签
        structureHandler.replaceWith(model, false);
    }
}