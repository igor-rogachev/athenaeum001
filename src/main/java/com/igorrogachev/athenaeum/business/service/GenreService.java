package com.igorrogachev.athenaeum.business.service;

import com.igorrogachev.athenaeum.business.domain.GenreTrans;
import com.igorrogachev.athenaeum.data.entity.Genre;
import com.igorrogachev.athenaeum.data.repository.GenreRepository;
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
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public GenreTrans getForId(int id) {
        Genre genre = genreRepository.findById(id).get();
        GenreTrans genreTrans = new GenreTrans(genre.getId(), genre.getName());
        return genreTrans;
    }

    public void save(GenreTrans genreTrans, Model model) {
        Genre genre = new Genre(genreTrans.getName());
        try {
            genreRepository.save(genre);
        }
        // org.postgresql.util.PSQLException ???????????? Нет такой эксепции, не нешел, чтобы добавить
        catch (Exception e) {
            String errDescriptionPrefix = ErrorPrefixConstants.ПРОИЗОШЛА_ОШИБКА_ПРИ_ДОБАВЛЕНИИ_НОВОГО_ЖАНРА;
            Utils.exceptionProcessing(model, e, errDescriptionPrefix);
        }
    }

    // рутина создания списка жанров для отображения
    public void putGenresListToModel(Model model) {
        Iterable<Genre> genres = genreRepository.findAll();
        List<Genre> genresList = new ArrayList();
        List<GenreTrans> genresTransList = new ArrayList();
        genres.forEach(genresList::add);
        // пока тупо через for, переделать через лябда или через потоки
        for (Genre g: genres) {
            genresTransList.add(new GenreTrans(g.getId(), g.getName()));
        }
        model.addAttribute(ModelAttributeNameConstants.GENRES_TRANS_LIST, genresTransList);
        // Добавим пустой ЖАНР для ввода
        model.addAttribute(ModelAttributeNameConstants.INPUT_GENRE, new GenreTrans());
    }


}
