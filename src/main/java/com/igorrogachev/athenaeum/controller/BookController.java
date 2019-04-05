package com.igorrogachev.athenaeum.controller;


import com.igorrogachev.athenaeum.domain.Book;
import com.igorrogachev.athenaeum.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(MapInOutConstants.BOOK_IN_MAP)
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(MapInOutConstants.ADD_IN_MAP)
    public String addNewBook(
                    @RequestParam String title,
                    @RequestParam Date year,
                    Model model
    )
    {
        Book book = new Book(title, year);
        bookRepository.save(book);

        createBookList(model);

        return MapInOutConstants.BOOK_OUT_MAP;
    }

    private void createBookList(Model model) {
        Iterable<Book> books = bookRepository.findAll();
        List<Book> booksList = new ArrayList();
        books.forEach(booksList::add);
        model.addAttribute("booksList", booksList);
        // Добавим пустую КНИГУ для ввода
        model.addAttribute("inputBook", new Book());
    }


}

