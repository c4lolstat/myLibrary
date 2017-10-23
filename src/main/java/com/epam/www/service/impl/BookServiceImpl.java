package com.epam.www.service.impl;

import com.epam.www.dataaccess.dao.BookDao;
import com.epam.www.dataaccess.entity.Book;
import com.epam.www.forms.AddForm;
import com.epam.www.forms.ChangeForm;
import com.epam.www.forms.IdForm;
import com.epam.www.DTO.BookDTO;
import com.epam.www.projections.ChangeProjection;
import com.epam.www.projections.UserProjection;
import com.epam.www.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Farkas on 2017.03.15..
 */
@Component
public class BookServiceImpl implements BookService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private BookDao bookDao;

    @Override
    public void createBook(BookDTO bookDTO) {
        bookDao.createBook(bookDTO);
    }

    @Override
    public List<Book> getBooks() {

        Comparator<Book> byTitle = (b1, b2) -> b1.getTitle().compareTo(b2.getTitle());

        Comparator<Book> byLended = (b1, b2) -> Boolean.compare(b1.isLended(),b2.isLended());

        Comparator<Book> byDelete = (b1, b2) -> Boolean.compare(b1.isDeleted(),b2.isDeleted());

        return bookDao.readBookList().stream().sorted(
                byDelete
                        .thenComparing(byLended)
                        .thenComparing(byTitle))
                .collect(Collectors.toList());
    }

    @Override
    public void addBook(AddForm addForm) {
        bookDao.createBook(addForm);
    }

    @Override
    public void deleteBook(IdForm idForm) {
        bookDao.deleteBook(idForm);
    }

    @Override
    public List<UserProjection> getBookListForUser() {

        Comparator<UserProjection> byTitle = (p1, p2) -> p1.getTitle().compareTo(p2.getTitle());

        Comparator<UserProjection> byLended = (p1, p2) -> Boolean.compare(p1.isLended(), p2.isLended());

        return bookDao.readBookListForUser().stream().sorted(
                byLended
                .thenComparing(byTitle))
                .collect(Collectors.toList());
    }

    @Override
    public ChangeProjection getBook(int id) {
        return bookDao.readBookForChange(id);
    }

    @Override
    public void updateBook(ChangeForm changeForm) {
        bookDao.updateBook(changeForm);
    }
}
