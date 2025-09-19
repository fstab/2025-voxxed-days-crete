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
        long duration = System.nanoTime() - startTime;
        System.err.println("Call to service() took " + duration / 1000000 + "ms");
    }
}
