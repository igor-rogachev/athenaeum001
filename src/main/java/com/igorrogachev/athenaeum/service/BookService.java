package com.igorrogachev.athenaeum.service;

import com.igorrogachev.athenaeum.businessDomain.BookTrans;
import com.igorrogachev.athenaeum.dao.BookDao;
import com.igorrogachev.athenaeum.dao.GenreDao;
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
public class BookService {
    private final BookDao bookDao;
    private final GenreDao genreDao;

    @Autowired
    public BookService(BookDao bookDao, GenreDao genreDao) {
        this.bookDao = bookDao;
        this.genreDao = genreDao;
    }

    public void save(BookTrans bookTrans, Model model) {
        try {
            // create Book object
            Genre genre = genreDao.findById(bookTrans.getGenreIntIn()).get();
            Book book = new Book(bookTrans.getTitle(), bookTrans.getYear(), genre);
            // save book object by DAO
            bookDao.save(book);
        } catch (Exception e) {
            String errDescriptionPrefix = ErrorPrefixConstants.ADD_NEW_BOOK_ERROR;
            Utils.exceptionProcessing(model, e, errDescriptionPrefix);
        }
    }

    public void createBooksList(Model model) {
        Iterable<Book> books = bookDao.findAll();
        // List<Book> booksList = new ArrayList();
        // books.forEach(booksList::add);
        List<BookTrans> booksTransList = new ArrayList();
        // пока тупо через for, переделать через лябда или через потоки
        for (Book b: books) {
            booksTransList.add(
                    new BookTrans(
                            b.getId(),
                            b.getTitle(),
                            b.getYear(),
                            new SimpleDateFormat(FormatConstants.COMMON_DATE_FORMAT_YYYY_MM_DD).format(b.getYear()),
                            b.getGenre().getId().toString(),
                            b.getGenre().getId(),
                            b.getGenre().getName()
                    )
            );
        }
        model.addAttribute(ModelAttributeNameConstants.BOOKS_TRANS_LIST, booksTransList);
        // Добавим пустую КНИГУ для ввода
        model.addAttribute(ModelAttributeNameConstants.INPUT_BOOK_TRANS, new BookTrans());
     }

}
