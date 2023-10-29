package dev.artsman.flyfoods.domain.city;

import dev.artsman.flyfoods.FlyFoodsApiApplication;
import dev.artsman.flyfoods.domain.state.State;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

class CityRepositoryTest {
	static CityRepository repository;

	@BeforeAll
	static void initAll() {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(FlyFoodsApiApplication.class).web(WebApplicationType.NONE).run();
		repository = applicationContext.getBean(CityRepository.class);
	}

	@Test
	void shouldFindAll() {
		List<City> cities = repository.findAll();
		Assertions.assertEquals(2, cities.size());
	}

	@Test
	void shouldFindById() {
		City lisbon = repository.findById(1L);
		Assertions.assertNotNull(lisbon);
	}

	@Test
	void shouldCreate() {
		City sintra = new City(null, "Sintra", new State(1L, "Lisbon"));
		sintra = repository.create(sintra);
		Assertions.assertEquals(3, sintra.getId());
	}

	@Test
	void shouldRemove() {
		City lisbon = repository.findById(1L);
		Assertions.assertNotNull(lisbon);

		repository.remove(lisbon);

		lisbon = repository.findById(1L);
		Assertions.assertNull(lisbon);
	}
}
