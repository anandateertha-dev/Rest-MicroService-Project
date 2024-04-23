package com.microservice.ecommerce.Interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserInterceptor implements HandlerInterceptor {

    final Logger log = LoggerFactory.getLogger(UserInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        try {

            String userId = request.getHeader("userId");
            String userName = request.getHeader("userName");

            log.info("Request being passed to the service.");
            log.info("User Id is " + userId);
            log.info("Username is " + userName);
            log.info("Request being passed to the service.");

            if (userName.length() != 10 & !(userId.length() != 4) & userName.matches("[a-zA-Z]+")) {
                ResponseEntity<String> errorResponse = ResponseEntity.badRequest().body(
                        "User name length should be less than or equal to 10 characters and userId length should be less than or equal to 4 characters");
                response.getWriter().write(errorResponse.getBody());
                response.setStatus(406);
                return false;
            }
            return true;
        } catch (Exception e) {
            log.error("Internal Server Error", e.getMessage());
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        log.info(" Response of the service.");
        log.info("User registred successfully.");
        log.info(" Response of the service.");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        log.info("Inside aftercompletion");
    }
}
