package com.epam.www.presentation;

import com.epam.www.forms.ChangeForm;
import com.epam.www.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by Farkas on 2017.10.23..
 */

@Controller
@RequestMapping(value = "/librarian/modify")
public class ModifyController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method =  RequestMethod.GET)
    public String getBookForUpdate(@RequestParam("id") int id, Map<String, Object> model){
        model.put("book", bookService.getBook(id));
        model.put("changeForm", new ChangeForm());
        return "modify";
    }

    @RequestMapping(method =  RequestMethod.POST)
    public String updateBook(@ModelAttribute @Valid ChangeForm changeForm, BindingResult bindingResult){
        String result = "redirect:/librarian";
        if (!bindingResult.hasErrors()) {
            bookService.updateBook(changeForm);
        } else {
            result = "modify";
        }
        return result;
    }
}
