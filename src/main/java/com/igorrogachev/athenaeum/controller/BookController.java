package com.igorrogachev.athenaeum.controller;


import com.igorrogachev.athenaeum.entity.Book;
import com.igorrogachev.athenaeum.entity.Genre;
import com.igorrogachev.athenaeum.dao.BookDao;
import com.igorrogachev.athenaeum.dao.GenreDao;
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
    private BookDao bookDao;
    @Autowired
    private GenreDao genreDao;

    @GetMapping(MapInOutConstants.ADD_IN_MAP)
    public String addNewBook(
                    @RequestParam String title,
                    @RequestParam Date year,
                    @RequestParam Genre genre,
                    Model model
    )
    {
        Book book = new Book(title, year, genre);
        bookDao.save(book);

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
            Genre g = genreDao.findById(genre_id).get();
            inputBook.setGenre(g);
            bookDao.save(inputBook);
        }
        catch (Exception e) {
            String errDescriptionPrefix = ErrorPrefixConstants.ADD_NEW_BOOK_ERROR;
            Utils.exceptionProcessing(model, e, errDescriptionPrefix);
        }
    }

    private void createBooksList(Model model) {
        Iterable<Book> books = bookDao.findAll();
        List<Book> booksList = new ArrayList();
        books.forEach(booksList::add);
        model.addAttribute(ModelAttributeNameConstants.BOOKS_LIST, booksList);
        // Добавим пустую КНИГУ для ввода
        model.addAttribute(ModelAttributeNameConstants.INPUT_BOOK, new Book());
    }

}

