package dev.artsman.flyfoods.domain.city;

import java.util.List;

public interface CityRepository {
	List<City> findAll();

	City findById(Long id);

	City create(City city);

	void remove(City city);
}
