package org.biswajit.javaeight;

import java.util.ArrayList;
import java.util.List;

public class BookDao {
    public List<Book> getBooks(){
        List<Book> books = new ArrayList<>();
        books.add(new Book(101,"Core Java",400));
        books.add(new Book(103,"Hibernate",401));
        books.add(new Book(104,"Spring Boot",402));
        books.add(new Book(105,"System Design",403));
        books.add(new Book(106,"Ds and algo",404));
        books.add(new Book(106,"Docker",404));
        books.add(new Book(106,"Ds and algo",404));
        return books;
    }
}
