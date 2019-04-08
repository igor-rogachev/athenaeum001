package com.igorrogachev.athenaeum.service;

import com.igorrogachev.athenaeum.businessDomain.AuthorTrans;
import com.igorrogachev.athenaeum.businessDomain.BookTrans;
import com.igorrogachev.athenaeum.dao.AuthorDao;
import com.igorrogachev.athenaeum.entity.Author;
import com.igorrogachev.athenaeum.entity.Book;
import com.igorrogachev.athenaeum.entity.Genre;
import com.igorrogachev.athenaeum.utils.Utils;
import com.igorrogachev.athenaeum.utils.constants.ErrorPrefixConstants;
import com.igorrogachev.athenaeum.utils.constants.FormatConstants;
import com.igorrogachev.athenaeum.utils.constants.ModelAttributeNameConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    private final AuthorDao authorDao;

    @Autowired
    public AuthorService(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public void save(AuthorTrans authorTrans, Model model) {
        try {
            // create Author object
            Author author = new Author(authorTrans.getFirstName(), authorTrans.getMiddleName(), authorTrans.getLastName(), authorTrans.getYear(), authorTrans.getBiography());
            // save author object by DAO
            authorDao.save(author);
        } catch (Exception e) {
            String errDescriptionPrefix = ErrorPrefixConstants.ADD_NEW_AUTHOR_ERROR;
            Utils.exceptionProcessing(model, e, errDescriptionPrefix);
        }
    }

    public void createAuthorsList(Model model) {
        Iterable<Author> authors = authorDao.findAll();
        // List<Author> authorsList = new ArrayList();
        // authors.forEach(authorsList::add);
        List<AuthorTrans> authorsTransList = new ArrayList();
        // пока тупо через for, переделать через лябда или через потоки
        for (Author a: authors) {
            authorsTransList.add(
                    new AuthorTrans(
                            a.getId(),
                            a.getFirstName(),
                            a.getMiddleName(),
                            a.getLastName(),
                            a.getYear(),
                            a.getBiography()
                    )
            );
        }
        model.addAttribute(ModelAttributeNameConstants.AUTHORS_TRANS_LIST, authorsTransList);
        // Добавим пустого АВТОРА для ввода
        model.addAttribute(ModelAttributeNameConstants.INPUT_AUTHOR_TRANS, new AuthorTrans());
    }

}
