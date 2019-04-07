package com.igorrogachev.athenaeum.service;

import com.igorrogachev.athenaeum.businessDomain.GenreTrans;
import com.igorrogachev.athenaeum.entity.Genre;
import com.igorrogachev.athenaeum.dao.GenreDao;
import com.igorrogachev.athenaeum.utils.Utils;
import com.igorrogachev.athenaeum.utils.constants.ErrorPrefixConstants;
import com.igorrogachev.athenaeum.utils.constants.ModelAttributeNameConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreService {
    private final GenreDao genreDao;

    @Autowired
    public GenreService(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    public GenreTrans getForId(int id) {
        Genre genre = genreDao.findById(id).get();
        GenreTrans genreTrans = new GenreTrans(genre.getId(), genre.getName());
        return genreTrans;
    }

    public void save(GenreTrans genreTrans, Model model) {
        Genre genre = new Genre(genreTrans.getName());
        try {
            genreDao.save(genre);
        }
        // org.postgresql.util.PSQLException ???????????? Нет такой эксепции, не нешел, чтобы добавить
        catch (Exception e) {
            String errDescriptionPrefix = ErrorPrefixConstants.ADD_NEW_GENRE_ERROR;
            Utils.exceptionProcessing(model, e, errDescriptionPrefix);
        }
    }

    // рутина создания списка жанров для отображения
    public void putGenresListToModel(Model model) {
        Iterable<Genre> genres = genreDao.findAll();
        List<Genre> genresList = new ArrayList();
        genres.forEach(genresList::add);
        List<GenreTrans> genresTransList = new ArrayList();
        // пока тупо через for, переделать через лябда или через потоки
        for (Genre g: genres) {
            genresTransList.add(new GenreTrans(g.getId(), g.getName()));
        }
        model.addAttribute(ModelAttributeNameConstants.GENRES_TRANS_LIST, genresTransList);
        // Добавим пустой ЖАНР для ввода
        model.addAttribute(ModelAttributeNameConstants.INPUT_GENRE_TRANS, new GenreTrans());
    }

}
