package com.example.demo;

import net.bytebuddy.agent.builder.AgentBuilder;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

import static net.bytebuddy.matcher.ElementMatchers.hasSuperType;
import static net.bytebuddy.matcher.ElementMatchers.named;

public class Agent {

    public static void premain(String agentArgs, Instrumentation inst) throws Exception {
        System.err.println("Agent.premain() called");
        new AgentBuilder.Default()
                .type(hasSuperType(named("jakarta.servlet.Servlet")))
                .transform(new AgentBuilder.Transformer.ForAdvice()
                        .include(Agent.class.getClassLoader())
                        .advice(named("service"), ServletAdvice.class.getName()))
                .installOn(inst);
    }
}
