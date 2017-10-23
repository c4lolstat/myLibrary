package com.epam.www.dataaccess.dao;

import com.epam.www.forms.IdForm;
import com.epam.www.forms.LendingForm;

/**
 * Created by Farkas on 2017.10.22..
 */
public interface LendingDao {

    void deleteLending(IdForm idForm);

    void createLending(LendingForm lendingForm);

    void updateLending(IdForm idForm);
}
