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
public class BlockDirective {

    public final static String DIRECTIVE_NAME = "block";

    public void execute(Environment env,
                        Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {
        String name = DirectiveUtils.getRequiredParam(params, "name");
        OverrideDirective.TemplateDirectiveBodyOverrideWrapper overrideBody = DirectiveUtils.getOverrideBody(env, name);
        if (overrideBody == null) {
            if (body != null) {
                body.render(env.getOut());
            }
        } else {
            DirectiveUtils.setTopBodyForParentBody(env, new OverrideDirective.TemplateDirectiveBodyOverrideWrapper(body, env), overrideBody);
            overrideBody.render(env.getOut());
        }
    }

}
