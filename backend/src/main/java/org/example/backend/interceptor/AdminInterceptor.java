package org.example.backend.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.backend.dox.User;
import org.example.backend.exception.Code;
import org.example.backend.exception.XException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (User.ADMIN.equals(request.getAttribute("role"))) {
            return true;
        }
        throw XException.builder().code(Code.FORBIDDEN).build();
    }
}
