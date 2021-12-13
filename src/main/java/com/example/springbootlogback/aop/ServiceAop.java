package com.example.springbootlogback.aop;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/***
 *1.service方法
 *2.打印入参
 *3.打印异常信息
 */
@Component
@Aspect
@Slf4j
public class ServiceAop {

    //切入点
    @Pointcut("execution(public * com.example.springbootlogback.service..*.*(..))")
    public void point() {
    }

    /**
     * 在切点之前织入
     * @param joinPoint
     * @throws Throwable
     */
    @Before("point()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 打印调用 service 的全路径以及执行方法
        log.info("   Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 打印请求入参
        log.info("   Request Args   : {}", new Gson().toJson(joinPoint.getArgs()));
    }

    @AfterThrowing(value = "point()",throwing = "throwInfo")
    public void myThrows(Exception throwInfo){
//        log.error("exception-message!!{},堆栈：{}", throwInfo.getMessage(),getStackList(throwInfo));
    }

    /**
     * 环绕
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("point()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = proceedingJoinPoint.proceed();
        // 打印出参
        log.info("   Response Args  : {}", new Gson().toJson(result));
        return result;
    }

    /**
     * 在切点之后织入
     * @throws Throwable
     */
    @After("point()")
    public void doAfter() throws Throwable {
        // 每个请求之间空一行
        log.info("");
    }

    /**
     * 堆栈信息
     * @param ex
     * @return
     */
    public static String getStackList(Exception ex) {
        List<StackTraceElement> collect = Arrays.stream(ex.getStackTrace()).filter(x -> !"<generated>".equals(x.getFileName())).collect(toList());
        List<String> collect1 = collect.stream().map(StackTraceElement::toString).collect(toList());
        return StringUtils.join(collect1, " \r\n ");
    }

}