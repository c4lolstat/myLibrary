package com.epam.www.presentation;

import com.epam.www.forms.IdForm;
import com.epam.www.service.BookService;
import com.epam.www.service.LendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by Farkas on 2017.10.22..
 */

@Controller
public class UserController {

    @Autowired
    private BookService bookService;

    @Autowired
    private LendingService lendingService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getBookListForUser(Map<String, Object> model) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        model.put("books", bookService.getBookListForUser());
        model.put("userName", userName);
        return "user";
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public ResponseEntity extendBook(@RequestBody IdForm idForm) {
        lendingService.updateLending(idForm);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
