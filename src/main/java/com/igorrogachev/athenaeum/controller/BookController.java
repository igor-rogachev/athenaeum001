package com.igorrogachev.athenaeum.controller;


import com.igorrogachev.athenaeum.data.entity.Book;
import com.igorrogachev.athenaeum.data.entity.Genre;
import com.igorrogachev.athenaeum.data.repository.BookRepository;
import com.igorrogachev.athenaeum.data.repository.GenreRepository;
import com.igorrogachev.athenaeum.utils.constants.ErrorPrefixConstants;
import com.igorrogachev.athenaeum.utils.constants.MapInOutConstants;
import com.igorrogachev.athenaeum.utils.constants.ModelAttributeNameConstants;
import com.igorrogachev.athenaeum.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(MapInOutConstants.BOOK_IN_MAP)
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private GenreRepository genreRepository;

    @GetMapping(MapInOutConstants.ADD_IN_MAP)
    public String addNewBook(
                    @RequestParam String title,
                    @RequestParam Date year,
                    @RequestParam Genre genre,
                    Model model
    )
    {
        Book book = new Book(title, year, genre);
        bookRepository.save(book);

        createBooksList(model);

        return MapInOutConstants.BOOK_OUT_MAP;
    }

    @PostMapping(MapInOutConstants.ADD_IN_MAP)
    public String addNewBookByForm(
            @ModelAttribute(ModelAttributeNameConstants.INPUT_BOOK) Book inputBook,
            Model model
    )
    {
        saveBook(inputBook, model);

        // ну и отобразим, что получилось
        createBooksList(model);

        return MapInOutConstants.BOOK_OUT_MAP;
    }

    @GetMapping(path= MapInOutConstants.ALL_IN_MAP)
    public String getAllBooks(Model model) {
        // ну и отобразим, что получилось
        createBooksList(model);

        return MapInOutConstants.BOOK_OUT_MAP;
    }

    private void saveBook(@ModelAttribute(ModelAttributeNameConstants.INPUT_BOOK) Book inputBook, Model model) {
        try {
            Integer genre_id = Integer.decode(inputBook.getTempGenreIdInput());
            Genre g = genreRepository.findById(genre_id).get();
            inputBook.setGenre(g);
            bookRepository.save(inputBook);
        }
        catch (Exception e) {
            String errDescriptionPrefix = ErrorPrefixConstants.ПРОИЗОШЛА_ОШИБКА_ПРИ_ДОБАВЛЕНИИ_НОВОЙ_КНИГИ;
            Utils.exceptionProcessing(model, e, errDescriptionPrefix);
        }
    }

    private void createBooksList(Model model) {
        Iterable<Book> books = bookRepository.findAll();
        List<Book> booksList = new ArrayList();
        books.forEach(booksList::add);
        model.addAttribute(ModelAttributeNameConstants.BOOKS_LIST, booksList);
        // Добавим пустую КНИГУ для ввода
        model.addAttribute(ModelAttributeNameConstants.INPUT_BOOK, new Book());
    }

}

