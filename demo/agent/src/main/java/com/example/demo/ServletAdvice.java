package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.bytebuddy.asm.Advice;


public class ServletAdvice {

    @Advice.OnMethodEnter
    public static long before(HttpServletRequest request, HttpServletResponse response) {
        return System.nanoTime();
    }

    @Advice.OnMethodExit
    public static void after(HttpServletRequest request, HttpServletResponse response, @Advice.Enter long startTime) {
        String method = request.getMethod();
        String path = request.getRequestURI();
        int status = response.getStatus();
        long duration = System.nanoTime() - startTime;
        System.err.println(method + " " + path + " returned status " + status + " after " + duration / 1000000 + "ms");
    }
}
