package aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {
    @Pointcut("execution(* addTest*(..))") // - правильная сигнатура * add*(..), закоментировано, чтобы логирование не пересекалось с Test3.java
    public void allAddMethods(){}

/*
    @Pointcut("execution(* get*())")
    public void allGetMethods() {
    }
 */
}
