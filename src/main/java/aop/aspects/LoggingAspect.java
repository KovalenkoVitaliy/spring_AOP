package aop.aspects;

import aop.UniLibrary;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(UniLibrary.class);
/*
    @Pointcut("execution(* aop.UniLibrary.get*(*))")
    private void allGetMethodsFromUniLibrary(){}

    @Pointcut("execution(* aop.UniLibrary.return*())")
    private void allReturnMethodsFromUniLibrary(){}

    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
    private void allGetAndReturnMethodsFromUniLibrary(){
    }
 */

    /*
    @Pointcut("execution (* aop.UniLibrary.*(..))")
    private void allMethodsFromUniLibrary(){}

    @Pointcut("execution(public void aop.UniLibrary.returnMagazine())")
    private void returnMagazineFromUniLibrary(){}

    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")
    private void allMethodsExceptReturnMagazineFromUniLibrary(){}

    @Before("allMethodsExceptReturnMagazineFromUniLibrary()")
    public void beforeAllMethodsExceptReturnMagazineAdvice(){
        System.out.println("beforeAllMethodsExceptReturnMagazineAdvice: writing Log #10");
    }
     */
/*
    @Before("allGetMethodsFromUniLibrary()")
    public void beforeGetLoggingAdvice(){
        System.out.println("beforeGetLoggingAdvice: writing Log #1");
    }

    @Before("allReturnMethodsFromUniLibrary()")
    public void beforeReturnLoggingAdvice(){
        System.out.println("beforeReturnLoggingAdvice: writing Log #2");
    }

    @Before("allGetAndReturnMethodsFromUniLibrary()")
    public void beforeGetAndReturnLoggingAdvice(){
        System.out.println("beforeGetAndReturnLoggingAdvice: writing Log #3");
    }
 */

//    @Pointcut("execution(* get*())")
//    public void allGetMethods(){}

//    @Before("execution(public void aop.UniLibrary.getBook())")
//    @Before("execution(public void get*(String))")
//    @Before("execution(public void get*(..))")
    @Before("execution(public void get*(aop.aspects.Book))")
    public void beforeGetLoggingAdvice(){
//        logger.info("beforeGetBookAdvice: попытка получить книгу");
        System.out.println("beforeGetLoggingAdvice: логирование попытки получить книгу/журнал");
    }

//    @Before("allGetMethods()")
//    public void beforeGetSecurityAdvice(){
//        System.out.println("beforeGetSecurityAdvice: проверка прав на получение книги/журнал");
//    }

//    @Before("execution(public * returnBook())")
//    public void beforeReturnBookAdvice(){
//        System.out.println("beforeGetBookAdvice: попытка вернуть книгу");
//    }


    @Before("aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println(" MethodSignature = " + methodSignature);
        System.out.println(" MethodSignature.getMethod() = " + methodSignature.getMethod());
        System.out.println(" MethodSignature.getReturnType() = " + methodSignature.getReturnType());
        System.out.println(" MethodSignature.getName() = " + methodSignature.getName());

        if (methodSignature.getName().equals("addBook")) {
            Object[] arguments = joinPoint.getArgs();
            for (Object obj: arguments){
                if (obj instanceof Book) {
                    Book mybook = (Book) obj;
                    System.out.println("Информация о книге: название - " + mybook.getName() + " автор - " + mybook.getAuthor() + " , год издания - " + mybook.getYearOfPublication());
                } else if (obj instanceof String) {
                    System.out.println("книгу в библиотеку добавляет " + obj);
                }
            }
        }
        System.out.println("beforeAddLoggingAdvice: логирование попытки добавить книгу");
        System.out.println("-------------------------------------");
    }
}
