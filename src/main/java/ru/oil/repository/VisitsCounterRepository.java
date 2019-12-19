package ru.oil.repository;

public interface VisitsCounterRepository {
    void addVisit();
    Long getCount();
}
