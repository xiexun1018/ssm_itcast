package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.SysLog;
import cn.itcast.ssm.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author:xiexun
 * @date:2018/11/16
 * @time:9:41
 */
@Component
@Aspect
public class LogAop {
    private Date visitTime;
    private Class clazz;
    private Method method;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private SysLogService sysLogService;

    @Before("execution(* cn.itcast.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        visitTime = new Date();//开始访问的时间
        clazz = jp.getTarget().getClass();//具体要访问的类
        String methodName = jp.getSignature().getName();//要访问的方法名称
        Object[] args = jp.getArgs();//要访问的方法的参数
        if(args==null||args.length==0) {
            method = clazz.getMethod(methodName);//获取没有参数的方法
        }else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i]=args[i].getClass();
            }
            method=clazz.getMethod(methodName,classArgs);//获取有参数的方法
        }
    }

    @After("execution(* cn.itcast.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint jp) {
        Long time = new Date().getTime()-visitTime.getTime();//获取访问时长
        String url="";
        if(clazz!=null&&method!=null&&clazz!=LogAop.class){
            //获取类上的注解
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if(classAnnotation!=null){
                //获取类上注解的属性值
                String[] classValue = classAnnotation.value();
                //获取方法上的注解
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if(methodAnnotation!=null){
                    //获取方法上注解的属性值
                    String[] methodValue = methodAnnotation.value();
                    url=classValue[0]+methodValue[0];
                    //获取ip
                    String ip = request.getRemoteAddr();
                    //获取当前操作的用户
            /*SecurityContext context = SecurityContextHolder.getContext();
            User user = (User) context.getAuthentication().getPrincipal();
            String username = user.getUsername();*/
                    //User user = (User) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
                    //封装成SysLog对象
                    SecurityContext context = SecurityContextHolder.getContext();
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();
                    SysLog sysLog = new SysLog();
                    sysLog.setVisitTime(visitTime);
                    sysLog.setExecutionTime(time);
                    sysLog.setIp(ip);
                    sysLog.setUsername(username);
                    sysLog.setUrl(url);
                    sysLog.setMethod("[类名] "+clazz.getName()+"[方法名] "+method.getName());
                    //调用service的save方法
                    sysLogService.save(sysLog);
                }
            }

        }

    }
}
