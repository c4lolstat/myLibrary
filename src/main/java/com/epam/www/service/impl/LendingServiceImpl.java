package com.epam.www.service.impl;

import com.epam.www.dataaccess.dao.LendingDao;
import com.epam.www.forms.IdForm;
import com.epam.www.forms.LendingForm;
import com.epam.www.service.LendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Farkas on 2017.10.23..
 */

@Component
public class LendingServiceImpl implements LendingService {

    @Autowired
    private LendingDao lendingDao;

    @Override
    public void deleteLending(IdForm idForm) {
        lendingDao.deleteLending(idForm);
    }

    @Override
    public void createLending(LendingForm lendingForm) {
        lendingDao.createLending(lendingForm);
    }

    @Override
    public void updateLending(IdForm idForm) {
        lendingDao.updateLending(idForm);
    }
}
