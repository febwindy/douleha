package com.douleha.www.utils.freemarker.directive;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

import java.io.IOException;
import java.util.Map;

/**
 * Created by ivan_ on 2015/8/12.
 */
public class SuperDirective {

    public final static String DIRECTIVE_NAME = "super";

    public void execute(Environment env,
                        Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {

        OverrideDirective.TemplateDirectiveBodyOverrideWrapper current = (OverrideDirective.TemplateDirectiveBodyOverrideWrapper) env.getVariable(DirectiveUtils.OVERRIDE_CURRENT_NODE);
        if (current == null) {
            throw new TemplateException("<@super/> direction must be child of override", env);
        }
        TemplateDirectiveBody parent = current.parentBody;
        if (parent == null) {
            throw new TemplateException("not found parent for <@super/>", env);
        }
        parent.render(env.getOut());
    }

}
