package ru.spring.web.flux.model;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "cities")
@Setter
@NoArgsConstructor
public class City implements Persistable<Long> {

    @Id
    @Column("id")
    private long id;

    @Column("name")
    private String name;

    @Column("country")
    private String country;

    @Column("temperature")
    private String temperature;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return 0 == id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getTemperature() {
        return temperature;
    }
}
