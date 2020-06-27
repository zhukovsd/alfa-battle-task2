package com.zhukovsd.alfabattle.task2.analytics;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Component
//public class AnalyticsControllerExceptionResolver extends AbstractHandlerExceptionResolver {
//
//    @Override
//    protected ModelAndView doResolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
//        try {
//            if (e instanceof IllegalArgumentException) {
//                return handleIllegalArgument(
//                        (IllegalArgumentException) ex, response, handler);
//            }
//        } catch (Exception handlerException) {
////            logger.warn("Handling of [" + ex.getClass().getName() + "]
////                    resulted in Exception", handlerException);
//        }
//        return null;
//    }
//}
