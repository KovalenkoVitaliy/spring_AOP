package aop;

import aop.aspects.Student;
import aop.aspects.University;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.w3c.dom.ls.LSOutput;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        University university = context.getBean("university", University.class);
        university.addStudents();
        try {
            List<Student> studetns = university.getStudents();
            System.out.println(studetns);
        } catch (Exception e) {
            System.out.println("Было поймано исключение " + e);
        }

        context.close();
    }
}
