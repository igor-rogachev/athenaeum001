package com.igorrogachev.athenaeum.controller;

import com.igorrogachev.athenaeum.businessDomain.GenreTrans;
import com.igorrogachev.athenaeum.service.GenreService;
import com.igorrogachev.athenaeum.utils.constants.MapInOutConstants;
import com.igorrogachev.athenaeum.utils.constants.ModelAttributeNameConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller    // This means that this class is a Controller
@RequestMapping(value=MapInOutConstants.GENRE_IN_MAP) // This means URL's start with /demo (after Application path)
public class GenreController {

    @Autowired
    private GenreService service;

    @GetMapping(MapInOutConstants.ADD_IN_MAP)
    public String addNewGenre(
                    @RequestParam String name,
                    Model model
            )
    {
        GenreTrans genre = new GenreTrans(name);
        return save(genre, model);
    }

    // @ModelAttribute("loginModel")Login loginModel
    // Списано отсюда https://spring.io/guides/gs/handling-form-submission/
    @PostMapping(MapInOutConstants.ADD_IN_MAP)
    public String addNewGenreByForm(
            @ModelAttribute(ModelAttributeNameConstants.INPUT_GENRE_TRANS) GenreTrans inputGenreTrans,
                    Model model
    )
    {
        return save(inputGenreTrans, model);
    }

    private String save(@ModelAttribute(ModelAttributeNameConstants.INPUT_GENRE_TRANS) GenreTrans inputGenreTrans, Model model) {
        service.save(inputGenreTrans, model);
        service.putGenresListToModel(model);
        return MapInOutConstants.GENRE_OUT_MAP;
    }

    @PostMapping(MapInOutConstants.EDIT_IN_MAP)
    public String editNewGenreByForm(
            @ModelAttribute(ModelAttributeNameConstants.INPUT_GENRE_TRANS) GenreTrans inputGenreTrans,
            Model model
    )
    {
        return save(inputGenreTrans, model);
//        service.save(inputGenreTrans, model);
//        service.putGenresListToModel(model);
//        return MapInOutConstants.GENRE_OUT_MAP;
    }

    @GetMapping(path= MapInOutConstants.ALL_IN_MAP)
    public String getAllGenres(Model model) {
        service.putGenresListToModel(model);
        return MapInOutConstants.GENRE_OUT_MAP;
    }

}
