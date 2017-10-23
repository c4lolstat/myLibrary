package com.epam.www.presentation;

import com.epam.www.forms.IdForm;
import com.epam.www.forms.LendingForm;
import com.epam.www.service.LendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Farkas on 2017.10.23..
 */

@Controller
@RequestMapping(value = "/librarian/lending")
public class LendingControler {

    @Autowired
    private LendingService lendingService;

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteLending(@RequestBody IdForm idForm){
        lendingService.deleteLending(idForm);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addLending(@RequestBody LendingForm lendingForm){
        lendingService.createLending(lendingForm);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
