package ru.oil.service;

import ru.oil.repository.VisitsCounterRepository;
import ru.oil.repository.VisitsCounterRepositoryImpl;

/**
 * @author Iskander Valiev
 * created by isko
 * on 12/19/19
 */
public class VisitsCounterServiceImpl implements VisitsCounterService {

    private VisitsCounterRepository repository;

    public VisitsCounterServiceImpl() {
        this.repository = new VisitsCounterRepositoryImpl();
    }

    public void updateVisitsCount() {
        repository.addVisit();
    }

    @Override
    public Long getVisitsCount() {
        return repository.getCount();
    }
}
