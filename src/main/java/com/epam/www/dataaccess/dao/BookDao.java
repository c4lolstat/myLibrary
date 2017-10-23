package com.epam.www.dataaccess.dao;

import com.epam.www.dataaccess.entity.Book;
import com.epam.www.forms.AddForm;
import com.epam.www.forms.ChangeForm;
import com.epam.www.forms.IdForm;
import com.epam.www.DTO.BookDTO;
import com.epam.www.projections.ChangeProjection;
import com.epam.www.projections.UserProjection;

import java.util.List;

/**
 * Created by Farkas on 2017.03.15..
 */
public interface BookDao {

    void createBook(BookDTO bookDTO);

    void createBook(AddForm addForm);

    void deleteBook(IdForm idForm);

    List<Book> readBookList();

    List<UserProjection> readBookListForUser();

    ChangeProjection readBookForChange(int id);

    void updateBook(ChangeForm changeForm);
}
