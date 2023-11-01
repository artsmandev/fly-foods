package dev.artsman.flyfoods.city.domain.repository;

import dev.artsman.flyfoods.city.domain.model.City;
import java.util.List;

public interface CityRepository {
	List<City> findAll();

	City findById(Long id);

	City create(City city);

	void remove(City city);
}
