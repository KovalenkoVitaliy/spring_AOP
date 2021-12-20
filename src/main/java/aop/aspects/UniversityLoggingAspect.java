package aop.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {

    @Before("execution(* getStudents())")
    public void beforeGetStudentsLoggingAdvice(){
        System.out.println("beforeGetStudentsLoggingAdvice: логируем получение списка студентов перед методом getStudents");
    }

    @AfterReturning(pointcut = "execution(* getStudents())"
    ,returning = "studetns")
    public void afterReturningGetStudentsLoggingAdvice(List<Student> studetns){
        Student first = studetns.get(0);
        String nameSurname = first.getNameSurname();
        nameSurname = "Mr." + nameSurname;
        first.setNameSurname(nameSurname);

        double avgGrade = first.getAvgGrade();
        avgGrade = avgGrade + 1;
        first.setAvgGrade(avgGrade);

        System.out.println("afterReturningGetStudentsLoggingAdvice: логируем получение списка студентов после работы метода getStudents");
    }

//    @AfterThrowing( pointcut = "execution(* getStudents())", throwing = "exception")
//    public void afterThrowingGetStudentsLoggingAdvice(Throwable exception) {
//        System.out.println("afterThrowingGetStudentsLoggingAdvice: логируем выброс исключения " + exception);
//    }

    @After("execution (* getStudents())")
    public void afterGetStudentLoggingAdvice(){
        System.out.println("afterGetStudentLoggingAdvice: логируем нормальное завершение эдвайса или выброс исключения");
    }

}
