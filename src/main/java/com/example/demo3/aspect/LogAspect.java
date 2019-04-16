package com.example.demo3.aspect;

import com.example.demo3.model.BusinessLog;
import com.example.demo3.model.SysLog;
import com.example.demo3.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class LogAspect {

    private static final ThreadLocal<SysLog> sysLogThreadLocal =  new NamedThreadLocal<SysLog>("ThreadLocal log");

    @Autowired
    private SysLogService sysLogService;

//    @Pointcut("@annotation(com.example.demo3.aspect.LogAnnotation)")
    @Pointcut("execution(* com.example.demo3.controller..*(..))")
    public void logPointCut(){};


    @Before(value = "logPointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("aop doBefore..");

        BusinessLog businessLog = new BusinessLog();
        SysLog sysLog = new SysLog();
        sysLog.setRequestTime(new Date());

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        sysLog.setRequestUrl(request.getRequestURI());
        //method
        String method = request.getMethod();
        sysLog.setRequestHttpMethod(method);
        //ip
        sysLog.setRequestClientIp(request.getRemoteAddr());
        //类方法
        sysLog.setRequestClassMethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //参数
//        Enumeration<String> paramter = request.getParameterNames();
//        while (paramter.hasMoreElements()) {
//            String str = paramter.nextElement();
//            sysLog.setRequestParamData(str + "{" + request.getParameter(str) + "}");
//        }
        String queryString = request.getQueryString();

        Object[] args = joinPoint.getArgs();
        String params = "";
        //获取请求参数集合并进行遍历拼接
        if(args.length>0){
            if("POST".equals(method)){
                Object object = args[0];
                Map map = getKeyAndValue(object);
//                params = JSON.toJSONString(map);;
                params = map.toString();
            }else if("GET".equals(method)){
                params = queryString;
            }
        }
        sysLog.setRequestParamData(params);


        sysLogThreadLocal.set(sysLog);
    }

    @AfterReturning(returning = "result",value = "logPointCut()")
    public void after(Object result){
        System.out.println("aop After..");
        SysLog sysLog = sysLogThreadLocal.get();
        sysLog.setReturnTime(new Date());
        sysLog.setReturnDate(result.toString());
        sysLogService.create(sysLog);
    }

//    @Around(value = "logPointCut()")
    public Object doAround(ProceedingJoinPoint joinPoint){
        Object result = null;

        System.out.println("aop doBefore..");

        BusinessLog businessLog = new BusinessLog();
        SysLog sysLog = new SysLog();
        sysLog.setRequestTime(new Date());

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        sysLog.setRequestUrl(request.getRequestURI());
        //method
        sysLog.setRequestHttpMethod(request.getMethod());
        //ip
        sysLog.setRequestClientIp(request.getRemoteAddr());
        //类方法
        sysLog.setRequestClassMethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //参数
        Enumeration<String> paramter = request.getParameterNames();
        while (paramter.hasMoreElements()) {
            String str = paramter.nextElement();
            sysLog.setRequestParamData(str + "{" + request.getParameter(str) + "}");
        }

        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println("aop exception..");
            throwable.printStackTrace();
        }

        System.out.println("aop doBefore..");
        sysLog.setReturnTime(new Date());
        sysLogService.create(sysLog);

        return result;
    }


    public static Map<String, Object> getKeyAndValue(Object obj) {
        Map<String, Object> map = new HashMap<>();
        // 得到类对象
        Class userCla = (Class) obj.getClass();
        /* 得到类中的所有属性集合 */
        Field[] fs = userCla.getDeclaredFields();
        for (int i = 0; i < fs.length; i++) {
            Field f = fs[i];
            f.setAccessible(true);
            // 设置些属性是可以访问的
            Object val = new Object();
            try {
                // 得到此属性的值
                val = f.get(obj);
                // 设置键值
                map.put(f.getName(), val);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }


}
