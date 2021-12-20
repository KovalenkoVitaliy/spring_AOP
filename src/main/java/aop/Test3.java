package aop;

import aop.aspects.Student;
import aop.aspects.University;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.w3c.dom.ls.LSOutput;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("Method main starts");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        String bookname = uniLibrary.returnBook();
        System.out.println("В библиотеку вернули книгу " + bookname);

        context.close();
        System.out.println("Method main ends");
    }
}
