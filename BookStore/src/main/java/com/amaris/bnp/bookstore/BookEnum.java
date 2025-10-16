package com.amaris.bnp.bookstore;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum BookEnum {



    CLEAN_CODE(new Book("Clean Code", "Robert Martin", 2008, 50d)),
    THE_CLEAN_CODER(new Book("The Clean Coder", "Robert Martin", 2011, 50d)),
    CLEAN_ARCHITECTURE(new Book("Clean Architecture", "Robert Martin", 2017, 50d)),
    TEST_DRIVEN_DEVELOPMENT(new Book("Test Driven Development by Example", "Kent Beck", 2003, 50d)),
    WORKING_EFFECTIVELY_WITH_LEGACY_CODE(new Book("Working Effectively With Legacy Code", "Michael C. Feathers", 2004, 50d));

    private final Book book;
    BookEnum(Book book) {
        this.book = book;
    }


    public static List<Book> getBooks() {
        return Arrays.stream(values()).map(BookEnum::getBook).toList();
    }




}
