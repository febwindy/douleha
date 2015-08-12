package com.douleha.www.application.util.freemarker;

import com.douleha.www.application.util.freemarker.directive.DirectiveUtils;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;

/**
 * Created by ivan_ on 2015/8/12.
 */
public class FreeMarkerConfigurerExtension extends FreeMarkerConfigurer {

    @Override
    protected Configuration newConfiguration() throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        DirectiveUtils.exposeRapidMacros(configuration);
        return configuration;
    }

}
