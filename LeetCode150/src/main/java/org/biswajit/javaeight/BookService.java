package org.biswajit.javaeight;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BookService {
    public List<Book> getBooksInSort() {
        List<Book> books = new BookDao().getBooks();
        books.sort((Book o1, Book o2)->
                o1.getName().compareTo(o2.getName())

    );
        return books;
    }

    public static void main(String[] args) {
        BookService bookService = new BookService();
        List<Book> books = bookService.getBooksInSort();
       // System.out.println(books);
       // Comparator.comparing()

        //find second highest pages in the books

        Optional<Book> book = books.stream().distinct().sorted((b1, b2)->b1.getPages() - b2.getPages()).skip(1).findFirst();
        book.ifPresent(System.out::println);

        //Find all duplicates ID
        List<Book> duplicateBooks = books.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(e->e.getValue() > 1)
                .map(Map.Entry::getKey).collect(Collectors.toList());

        System.out.println(duplicateBooks);
    }
}

//class MyComparator implements Comparator<Book>{
//
//    @Override
//    public int compare(Book o1, Book o2) {
//        return o1.getName().compareTo(o2.getName());
//    }
//}


