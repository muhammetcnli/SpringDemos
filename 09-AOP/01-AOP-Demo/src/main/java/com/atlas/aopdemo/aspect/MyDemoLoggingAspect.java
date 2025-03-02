package com.atlas.aopdemo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where all the advices for logging

    // @Before("execution(public void add*())")
    @Before("execution(* add*())")
    public void beforeAddAccountAdvice(){

        System.out.println("\n======> Executing @Before advice on addAccount()");
    }
}
