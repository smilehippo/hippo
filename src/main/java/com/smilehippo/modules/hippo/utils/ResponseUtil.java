package com.smilehippo.modules.hippo.utils;



import com.smilehippo.common.hippo.web.FreeMarkerEngine;
import org.springframework.http.HttpRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//import com.sun.tools.javac.api.DiagnosticFormatter;

/**
 * Created by clude on 7/6/16.
 */
public class ResponseUtil {

    public static ModelAndView RenderView(String title, String template, Object model){
        Map<String, Object> map = new HashMap<>();
        map.put("data", model);
        map.put("title", title);

        return new ModelAndView(template, map);
    }


    public static ModelAndView RenderTpl(HttpServletRequest req, String title, String tpl, Object model){
        Map<String, Object> map = new HashMap<>();
        map.put("data", model);
        map.put("tpl", tpl);
        map.put("title", title);

        return new ModelAndView("hippo/layouts/base_tpl", map);
    }

    public static ModelAndView RenderTpl(HttpServletRequest req, String title, String tpl){
        return RenderTpl(req, title, tpl, true);
    }


//    public static String RenderView(String title, String template, Object model){
//        Map<String, Object> map = new HashMap<>();
//        map.put("data", model);
//        map.put("title", title);
//
//        ModelAndView mv = new ModelAndView(template, map);
//
//        return strictEngine().render( new ModelAndView(template, map) );
//    }

//    public static String RenderTpl(HttpRequest req, String title, String tpl, Object model){
//        Map<String, Object> map = new HashMap<>();
//        map.put("data", model);
//        map.put("tpl", tpl);
//        map.put("title", title);
////        map.put("userId", req.session().attribute(Constant.USER_SESSION_ID));
////        map.put("userName", req.session().attribute(Constant.USER_SESSION_NAME));
//        return strictEngine().render( new ModelAndView("base_tpl.ftl", map) );
//    }

//    public static String RenderTpl(HttpRequest req, String title, String tpl){
//        return RenderTpl(req, title, tpl, true);
//    }


    private static FreeMarkerEngine strictEngine() {
        FreeMarkerEngine configuredEngine = new FreeMarkerEngine();
//        configuredEngine.setConfiguration();
        return configuredEngine;
    }

}
