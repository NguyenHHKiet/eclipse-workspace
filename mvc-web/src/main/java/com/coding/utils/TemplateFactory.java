package com.coding.utils;

import java.util.Locale;
import java.util.Map;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class TemplateFactory {
    private static TemplateEngine templateEngine;
	static {
	    ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setPrefix("/templates/");// default path : /src/main/resources/
        resolver.setSuffix(".html");

        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);
	}
	public static String viewResolve(String viewName, Map<String, Object> model) {
        Context context = new Context();
        context.setVariable("locale", Locale.getDefault());
        if( model != null ) {
	        model.keySet().forEach(k -> {
	            context.setVariable(k, model.get(k));        	
	        });
        }
        return templateEngine.process(viewName, context);
	}
}
