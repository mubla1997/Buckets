package com.esliceu.Practica2.interceptors;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component("tokenGenInt")
public class CrsfTokenGenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        Cache <String, Boolean> tokenCache = getCache(req);
        String token = generateToken();
        tokenCache.put(token, true);
        req.setAttribute("csrftoken", token);
        return true;
    }

    static Cache <String, Boolean> getCache(HttpServletRequest req) {
        Cache <String, Boolean> cache = (Cache <String, Boolean>) req.getSession().getAttribute("tokencache");
        if (cache == null) {
            cache = buildCache();
            req.getSession().setAttribute("tokencache", cache);
        }
        return cache;
    }

    static Cache <String, Boolean> buildCache() {
        return CacheBuilder.newBuilder()
                .maximumSize(3000)
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .build();
    }

    private String generateToken() {
        String lletres = "abcdefghijklmnopqrstuvwxyz1234567890";
        Random random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            sb.append(lletres.charAt(random.nextInt(lletres.length())));
        }
        return sb.toString();
    }
}
