package com.douleha.www.utils.freemarker.directive;

import freemarker.cache.TemplateCache;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

import java.io.IOException;
import java.util.Map;

/**
 * Created by ivan_ on 2015/8/12.
 */
public class ExtendsDirective {

    public final static String DIRECTIVE_NAME = "extends";

    public void execute(Environment env,
                        Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {

        String name = DirectiveUtils.getRequiredParam(params, "name");
        String encoding = DirectiveUtils.getParam(params, "encoding", null);
        String includeTemplateName = TemplateCache.getFullTemplatePath(env, getTemplatePath(env), name);
        env.include(includeTemplateName, encoding, true);
    }

    private String getTemplatePath(Environment env) {
        String templateName = env.getTemplate().getName();
        return templateName.lastIndexOf('/') == -1 ? "" : templateName.substring(0, templateName.lastIndexOf('/') + 1);
    }

}
