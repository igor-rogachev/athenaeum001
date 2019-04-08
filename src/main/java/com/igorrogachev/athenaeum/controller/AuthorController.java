package com.igorrogachev.athenaeum.controller;

import com.igorrogachev.athenaeum.businessDomain.AuthorTrans;
import com.igorrogachev.athenaeum.businessDomain.BookTrans;
import com.igorrogachev.athenaeum.service.AuthorService;
import com.igorrogachev.athenaeum.utils.constants.MapInOutConstants;
import com.igorrogachev.athenaeum.utils.constants.ModelAttributeNameConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping(MapInOutConstants.AUTHOR_IN_MAP)
public class AuthorController {

    @Autowired
    private AuthorService service;

    public String addNewAuthor(
            @RequestParam String firstName,
            @RequestParam String middletName,
            @RequestParam String lastName,
            @RequestParam Date year,
            @RequestParam String biography,
            Model model
    )
    {
        AuthorTrans authorTrans = new AuthorTrans(firstName, middletName, lastName, year, biography);
        service.save(authorTrans, model);
        service.createAuthorsList(model);
    return MapInOutConstants.AUTHOR_OUT_MAP;
    }

    @PostMapping(MapInOutConstants.ADD_IN_MAP)
    public String addNewAuthorByForm(
            @ModelAttribute(ModelAttributeNameConstants.INPUT_AUTHOR_TRANS) AuthorTrans inputAuthorTrans,
            Model model
    )
    {
        service.save(inputAuthorTrans, model);
        service.createAuthorsList(model);
        return MapInOutConstants.AUTHOR_OUT_MAP;
    }

    @GetMapping(path= MapInOutConstants.ALL_IN_MAP)
    public String getAllAuthors(Model model) {
        service.createAuthorsList(model);
        return MapInOutConstants.AUTHOR_OUT_MAP;
    }

}
