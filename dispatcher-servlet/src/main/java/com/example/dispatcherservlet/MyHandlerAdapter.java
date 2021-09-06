package com.example.dispatcherservlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MyHandlerAdapter {

    boolean supports(Object handler);

    Object handle(HttpServletRequest request, HttpServletResponse response, Object handler);
}
