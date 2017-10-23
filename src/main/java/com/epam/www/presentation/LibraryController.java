package com.epam.www.presentation;

import com.epam.www.forms.AddForm;
import com.epam.www.forms.IdForm;
import com.epam.www.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by Farkas on 2017.10.19..
 */

@Controller
@RequestMapping(value = "/librarian")
@SessionAttributes("addFrom")
public class LibraryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PopulateController.class);

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteBook(@RequestBody IdForm idForm){
        bookService.deleteBook(idForm);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addBook(@ModelAttribute @Valid AddForm addForm, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            bookService.addBook(addForm);
        }
        return "redirect:/librarian";
    }

    @RequestMapping(method =  RequestMethod.GET)
    public String getBooks(Map<String, Object> model){
        model.put("books", bookService.getBooks());
        model.put("addForm", new AddForm());
        return "librarian";
    }
}
