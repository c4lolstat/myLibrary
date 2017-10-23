package com.epam.www.dataaccess.dao.impl;

import com.epam.www.dataaccess.dao.BookDao;
import com.epam.www.dataaccess.entity.Book;
import com.epam.www.forms.AddForm;
import com.epam.www.forms.ChangeForm;
import com.epam.www.forms.IdForm;
import com.epam.www.DTO.BookDTO;
import com.epam.www.projections.ChangeProjection;
import com.epam.www.projections.UserProjection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Farkas on 2017.03.15..
 */
@Repository
public class BookHibernate implements BookDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookHibernate.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void createBook(BookDTO bookDTO) {
        Book book = new Book();
        updateEntityWithDTO(book, bookDTO);
        entityManager.persist(book);
    }

    @Override
    @Transactional
    public void createBook(AddForm addForm) {
        Book book = new Book();
        book.setAuthor(addForm.getAuthor());
        book.setTitle(addForm.getTitle());
        book.setIsbn(addForm.getIsbn());
        entityManager.persist(book);
    }

    @Override
    @Transactional
    public void deleteBook(IdForm idForm) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> bookRoot = cq.from(Book.class);
        cq.select(bookRoot);
        cq.where(cb.equal(bookRoot.get("id"), idForm.getId()));
        Book book = entityManager.createQuery(cq).getSingleResult();
        book.setDeleted(true);
    }

    @Override
    @Transactional
    public List<UserProjection> readBookListForUser() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserProjection> cq = cb.createQuery(UserProjection.class);
        Root<Book> bookRoot = cq.from(Book.class);
        cq.multiselect(bookRoot.get("id"),
                bookRoot.get("author"),
                bookRoot.get("title"),
                bookRoot.get("lended"),
                bookRoot.get("lendedTo"),
                bookRoot.get("lendingToDate"));
        cq.where(cb.isFalse(bookRoot.get("deleted")));
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    @Transactional
    public ChangeProjection readBookForChange(int id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ChangeProjection> cq = cb.createQuery(ChangeProjection.class);
        Root<Book> bookRoot = cq.from(Book.class);
        cq.multiselect(bookRoot.get("id"),
                bookRoot.get("author"),
                bookRoot.get("title"),
                bookRoot.get("deleted"),
                bookRoot.get("isbn"));
        cq.where(cb.equal(bookRoot.get("id"), id));
        return entityManager.createQuery(cq).getSingleResult();
    }

    @Override
    @Transactional
    public void updateBook(ChangeForm changeForm) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> bookRoot = cq.from(Book.class);
        cq.select(bookRoot);
        cq.where(cb.equal(bookRoot.get("id"), changeForm.getId()));
        Book book = entityManager.createQuery(cq).getSingleResult();
        book.setDeleted(changeForm.isDeleted());
        book.setIsbn(changeForm.getIsbn());
        book.setTitle(changeForm.getTitle());
        book.setAuthor(changeForm.getAuthor());
    }

    @Override
    @Transactional
    public List<Book> readBookList() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> bookRoot = cq.from(Book.class);
        cq.select(bookRoot);
        return entityManager.createQuery(cq).getResultList();
    }

    private void updateEntityWithDTO(Book book, BookDTO bookDTO) {
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setDeleted(bookDTO.isDeleted());
        book.setIsbn(bookDTO.getIsbn());
        book.setLended(bookDTO.isLended());
        book.setLendedTo(bookDTO.getLendedBy());
        book.setLendingFromDate(bookDTO.getLendingFromDate());
        book.setLendingToDate(bookDTO.getLendingToDate());
    }
}
