package dev.artsman.flyfoods.domain.cuisine;

import dev.artsman.flyfoods.FlyFoodsApiApplication;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

class CuisineRepositoryTest {
	@Test
	void shouldFindAll() {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(FlyFoodsApiApplication.class).web(WebApplicationType.NONE).run("");
		CuisineRepository repository = applicationContext.getBean(CuisineRepository.class);

		List<Cuisine> cuisines = repository.findAll();

		Set<Cuisine> expected = Set.of(new Cuisine(1L, "Thailand"), new Cuisine(2L, "Ireland"));
		Assertions.assertTrue(cuisines.containsAll(expected));
	}

	@Test
	void shouldCreate() {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(FlyFoodsApiApplication.class).web(WebApplicationType.NONE).run("");
		CuisineRepository repository = applicationContext.getBean(CuisineRepository.class);

		Assertions.assertEquals(2, repository.findAll().size());

		Cuisine brazilian = new Cuisine(null, "Brazilian");
		Cuisine brazilianCreated = repository.save(brazilian);

		Assertions.assertEquals(3, brazilianCreated.getId());
	}

	@Test
	void shouldFindById() {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(FlyFoodsApiApplication.class).web(WebApplicationType.NONE).run("");
		CuisineRepository repository = applicationContext.getBean(CuisineRepository.class);

		Cuisine thailand = repository.findBy(1L);

		Assertions.assertEquals(1L, thailand.getId());
		Assertions.assertEquals("Ireland", thailand.getName());
	}

	@Test
	void shouldUpdate() {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(FlyFoodsApiApplication.class).web(WebApplicationType.NONE).run("");
		CuisineRepository repository = applicationContext.getBean(CuisineRepository.class);

		Cuisine ireland = repository.findBy(1L);
		Assertions.assertEquals("Ireland", ireland.getName());

		Cuisine updateIrelandToFrench = new Cuisine(1L, "French");
		Cuisine french = repository.save(updateIrelandToFrench);

		Assertions.assertEquals(1L, french.getId());
		Assertions.assertEquals("French", french.getName());
	}

	@Test
	void shouldRemove() {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(FlyFoodsApiApplication.class).web(WebApplicationType.NONE).run("");
		CuisineRepository repository = applicationContext.getBean(CuisineRepository.class);

		Cuisine cuisine = repository.findBy(1L);
		Assertions.assertNotNull(cuisine);

		repository.remove(cuisine);
		Assertions.assertNull(repository.findBy(1L));
	}
}
