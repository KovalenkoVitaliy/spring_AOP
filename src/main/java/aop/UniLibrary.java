package aop;

import aop.aspects.Book;
import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstarctLibrary{

    public void getBook(Book book){
        System.out.println("Мы берём книгу из UniLibrary " + book.getName());
    }

    public void getBook(){
        System.out.println("Мы берём книгу из UniLibrary");
        System.out.println("-------------------------------------");
    }

    public void getMagazine(){
        System.out.println("Мы берём журнал из UniLibrary");
        System.out.println("-------------------------------------");
    }

    public String returnBook(){
        int a = 10/0;
        System.out.println("Мы возвращаем книгу в UniLibrary");
        return "War and Peace";
    }

    public void returnMagazine(){
        System.out.println("Мы возвращаем журнал из UniLibrary");
        System.out.println("-------------------------------------");
    }

    public void addBook(String person_name, Book book){
        System.out.println("Мы добавили книгу из UniLibrary");
        System.out.println("-------------------------------------");
    }

    public void addMagazine(){
        System.out.println("Мы добавляем журнал из UniLibrary");
        System.out.println("-------------------------------------");
    }
}
