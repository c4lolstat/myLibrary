package com.epam.www.service;

import com.epam.www.forms.IdForm;
import com.epam.www.forms.LendingForm;

/**
 * Created by Farkas on 2017.10.23..
 */
public interface LendingService {

    void deleteLending(IdForm idForm);

    void createLending(LendingForm lendingForm);

    void updateLending(IdForm idForm);
}
