package com.epam.www.service;

import com.epam.www.dataaccess.entity.Book;
import com.epam.www.forms.AddForm;
import com.epam.www.forms.ChangeForm;
import com.epam.www.forms.IdForm;
import com.epam.www.forms.LendingForm;
import com.epam.www.DTO.BookDTO;
import com.epam.www.projections.ChangeProjection;
import com.epam.www.projections.UserProjection;

import java.util.List;

/**
 * Created by Farkas on 2017.03.15..
 */
public interface BookService {

    void createBook(BookDTO bookDTO);

    List<Book> getBooks();

    void addBook(AddForm addForm);

    void deleteBook(IdForm idForm);

    List<UserProjection> getBookListForUser();

    ChangeProjection getBook(int id);

    void updateBook(ChangeForm changeForm);

}
