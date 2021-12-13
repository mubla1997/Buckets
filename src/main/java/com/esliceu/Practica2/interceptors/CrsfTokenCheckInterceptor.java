package com.esliceu.Practica2.interceptors;

import com.google.common.cache.Cache;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("tokenCheckInt")
public class CrsfTokenCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        if (!req.getMethod().equalsIgnoreCase("post")) {

            return true;
        }

        Cache <String, Boolean> tokenCache = CrsfTokenGenInterceptor.getCache(req);
        String csrf = req.getParameter("csrftoken");
        if (csrf == null || tokenCache.getIfPresent(csrf) == null) {
            res.sendError(403);
            return false;
        }
        return true;
    }
}
