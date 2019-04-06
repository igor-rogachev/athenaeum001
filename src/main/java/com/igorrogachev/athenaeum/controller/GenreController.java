package com.igorrogachev.athenaeum.controller;


import com.igorrogachev.athenaeum.business.domain.GenreTrans;
import com.igorrogachev.athenaeum.business.service.GenreService;
import com.igorrogachev.athenaeum.data.entity.Genre;
import com.igorrogachev.athenaeum.data.repository.GenreRepository;
import com.igorrogachev.athenaeum.utils.constants.MapInOutConstants;
import com.igorrogachev.athenaeum.utils.constants.ModelAttributeNameConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import java.util.List;

@Controller    // This means that this class is a Controller
@RequestMapping(value=MapInOutConstants.GENRE_IN_MAP) // This means URL's start with /demo (after Application path)
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping(MapInOutConstants.ADD_IN_MAP) // Add genre by GET Requests (command line parameters)
    public String addNewGenre(
                    @RequestParam String name,
                    Model model
            )
    {
        GenreTrans genre = new GenreTrans(name);
        genreService.save(genre, model);
        genreService.putGenresListToModel(model);
        return MapInOutConstants.GENRE_OUT_MAP;
    }

    // @ModelAttribute("loginModel")Login loginModel
    // Списано отсюда https://spring.io/guides/gs/handling-form-submission/
    @PostMapping(MapInOutConstants.ADD_IN_MAP) // Add by Post Requests (form)
    public String addNewGenreByForm(
            @ModelAttribute(ModelAttributeNameConstants.INPUT_GENRE) GenreTrans inputGenre,
                    Model model
    )
    {
        genreService.save(inputGenre, model);
        genreService.putGenresListToModel(model);
        return MapInOutConstants.GENRE_OUT_MAP;
    }

    @GetMapping(path= MapInOutConstants.ALL_IN_MAP)
    public String getAllGenres(Model model) {
        genreService.putGenresListToModel(model);
        return MapInOutConstants.GENRE_OUT_MAP;
    }

}
