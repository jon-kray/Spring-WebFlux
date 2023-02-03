package ru.spring.web.flux.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.spring.web.flux.dto.CityDto;
import ru.spring.web.flux.model.City;
import ru.spring.web.flux.repository.CityReposiyory;

import java.time.Duration;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class CityService {

    private final CityReposiyory cityReposiyory;

    public Mono<Void> createCity(CityDto cityDto) {
        City city = new City();
        city.setCountry(cityDto.getCountry());
        city.setName(cityDto.getName());
        city.setTemperature(cityDto.getTemperature());
        cityReposiyory.save(city)
                .doOnNext(entity -> log.info("Entity ith id - {} has bean saved", entity.getId()))
                .subscribe();
        return Mono.empty();

    }

    public Flux<CityDto> findAllCities() {
        return cityReposiyory.findAll()
                .map(entity -> CityDto.builder()
                        .country(entity.getCountry())
                        .name(entity.getName())
                        .temperature(entity.getTemperature())
                        .build())
                .zipWith(Flux.interval(Duration.ofSeconds(3)), (item, time) -> item);

    }

}
