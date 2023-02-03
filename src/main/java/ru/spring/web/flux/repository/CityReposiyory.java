package ru.spring.web.flux.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import ru.spring.web.flux.model.City;

@Repository
public interface CityReposiyory extends ReactiveCrudRepository<City, Long> {
}
