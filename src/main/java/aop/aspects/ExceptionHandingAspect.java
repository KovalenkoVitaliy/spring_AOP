package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class ExceptionHandingAspect {
    @Before("aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddExceptionHandingAdvide(){
        System.out.println("beforeGetExceptionHandingAdvide ловим/обрабатываем исключения при попытке получить книгу/журнал" );
        System.out.println("-------------------------------------");
    }
}
