package ru.spring.web.flux.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.spring.web.flux.dto.CityDto;
import ru.spring.web.flux.service.CityService;

import java.util.Random;
import java.util.UUID;


@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CityController {

    private final CityService cityService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<CityDto> findAllCities() {
        return cityService.findAllCities();
    }

    @Scheduled(fixedRate = 3_000)
    public void createCity() {
        CityDto cityDto = new CityDto();
        cityDto.setCountry("Russia");
        cityDto.setName(UUID.randomUUID().toString());
        cityDto.setTemperature(String.valueOf(new Random().nextInt()));
        cityService.createCity(cityDto);
    }
}
