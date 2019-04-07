package com.igorrogachev.athenaeum.controller;

import com.igorrogachev.athenaeum.businessDomain.BookTrans;
import com.igorrogachev.athenaeum.service.BookService;
import com.igorrogachev.athenaeum.utils.constants.MapInOutConstants;
import com.igorrogachev.athenaeum.utils.constants.ModelAttributeNameConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(MapInOutConstants.BOOK_IN_MAP)
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping(MapInOutConstants.ADD_IN_MAP)
    public String addNewBook(
                    @RequestParam String title,
                    @RequestParam String yearStringInOut,
                    @RequestParam String genreStringIntInOut,
                    Model model
    )
    {
        BookTrans bookTrans = new BookTrans(title, yearStringInOut, genreStringIntInOut);
        service.save(bookTrans, model);
        service.createBooksList(model);
        return MapInOutConstants.BOOK_OUT_MAP;
    }

    @PostMapping(MapInOutConstants.ADD_IN_MAP)
    public String addNewBookByForm(
            @ModelAttribute(ModelAttributeNameConstants.INPUT_BOOK_TRANS) BookTrans inputBookTrans,
            Model model
    )
    {
        service.save(inputBookTrans, model);
        service.createBooksList(model);
        return MapInOutConstants.BOOK_OUT_MAP;
    }

    @GetMapping(path= MapInOutConstants.ALL_IN_MAP)
    public String getAllBooks(Model model) {
        service.createBooksList(model);
        return MapInOutConstants.BOOK_OUT_MAP;
    }

}

