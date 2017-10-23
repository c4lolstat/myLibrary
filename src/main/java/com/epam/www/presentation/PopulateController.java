package com.epam.www.presentation;

import com.epam.www.DTO.BookDTO;
import com.epam.www.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Farkas on 2017.03.07..
 */
@RestController
@RequestMapping(value = "/populate")
public class PopulateController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PopulateController.class);

    private final ObjectMapper mapper = new ObjectMapper();
    private List<String> bookList = new ArrayList<>();


    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public void populate(){
        init();
        addBooks();
    }

    private void init(){
        bookList.add("{\"isbn\":\"0-671-68155-9\",\"author\":\"Clive Cussler\",\"title\":\"Sahara\",\"deleted\":\"false\",\"lendingFromDate\":\"0\",\"lendingToDate\":\"0\",\"lendedBy\":\"Dirk Pitt\",\"lended\":\"true\"}");
        bookList.add("{\"isbn\":\"0-671-68156-7\",\"author\":\"Clive Cussler\",\"title\":\"Inka Gold\",\"deleted\":\"false\",\"lendingFromDate\":\"0\",\"lendingToDate\":\"0\",\"lendedBy\":\"James Sandecker\",\"lended\":\"true\"}");
        bookList.add("{\"isbn\":\"0-671-62619-\",\"author\":\"Clive Cussler\",\"title\":\"Dragon\",\"deleted\":\"false\",\"lendingFromDate\":\"0\",\"lendingToDate\":\"0\",\"lendedBy\":\"\",\"lended\":\"false\"}");
        bookList.add("{\"isbn\":\"0-399-15369-1\",\"author\":\"Clive Cussler\",\"title\":\"Threasure of Khan\",\"deleted\":\"true\",\"lendingFromDate\":\"0\",\"lendingToDate\":\"0\",\"lendedBy\":\"\",\"lended\":\"false\"}");
        bookList.add("{\"isbn\":\"0-684-80297-X\",\"author\":\"Clive Cussler\",\"title\":\"Shockwave\",\"deleted\":\"false\",\"lendingFromDate\":\"0\",\"lendingToDate\":\"0\",\"lendedBy\":\"\",\"lended\":\"false\"}");
    }

    private void addBooks(){
        try {
            for (String book : bookList){
                bookService.createBook(mapper.readValue(book, BookDTO.class));
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
