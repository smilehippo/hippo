package com.smilehippo.common.hippo.web;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by clude on 9/29/16.
 */
public class FreeMarkerEngine  {

    /**
     * The FreeMarker configuration
     */
    private Configuration configuration;

    /**
     * Creates a FreeMarkerEngine
     */
    public FreeMarkerEngine() {
        this.configuration = createDefaultConfiguration();
    }

    /**
     * Creates a FreeMarkerEngine with a configuration
     *
     * @param configuration The Freemarker configuration
     */
    public FreeMarkerEngine(Configuration configuration) {
        this.configuration = configuration;
    }


    public String render(ModelAndView modelAndView) {
        return render(modelAndView.getModel(), modelAndView.getViewName());
    }

    public String render(Object model,  String view) {
        try {
            StringWriter stringWriter = new StringWriter();

            Template template = configuration.getTemplate(view);
            template.process(model, stringWriter);

            return stringWriter.toString();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        } catch (TemplateException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * Sets FreeMarker configuration.
     * Note: If configuration is not set the default configuration
     * will be used.
     *
     * @param configuration the configuration to set
     */
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    private Configuration createDefaultConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(FreeMarkerEngine.class, "");
        return configuration;
    }

}
