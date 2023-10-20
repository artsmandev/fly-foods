package dev.artsman.flyfoods.domain.cuisine;

import dev.artsman.flyfoods.FlyFoodsApiApplication;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

class CuisineManagerTest {
	@Test
	void shouldFindAllCuisines() {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(FlyFoodsApiApplication.class).web(WebApplicationType.NONE)
																																																									.run("");
		CuisineManager manager = applicationContext.getBean(CuisineManager.class);
		Set<Cuisine> cuisines = manager.findAll();

		Set<Cuisine> expected = Set.of(new Cuisine(1L, "Thailand"), new Cuisine(2L, "Ireland"));
		Assertions.assertTrue(cuisines.containsAll(expected));
	}

	@Test
	void shouldCreateCuisine() {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(FlyFoodsApiApplication.class).web(WebApplicationType.NONE)
																																																									.run("");

		CuisineManager manager = applicationContext.getBean(CuisineManager.class);

		Assertions.assertEquals(2, manager.findAll().size());

		Cuisine brazilian = new Cuisine(null, "Brazilian");
		Cuisine brazilianCreated = manager.save(brazilian);

		Assertions.assertEquals(3, brazilianCreated.getId());
	}

	@Test
	void shouldFindById() {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(FlyFoodsApiApplication.class).web(WebApplicationType.NONE).run("");
		CuisineManager manager = applicationContext.getBean(CuisineManager.class);

		Cuisine thailand = manager.findBy(1L);

		Assertions.assertEquals(1L, thailand.getId());
		Assertions.assertEquals("Ireland", thailand.getName());
	}

	@Test
	void shouldUpdateCuisine() {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(FlyFoodsApiApplication.class).web(WebApplicationType.NONE).run("");
		CuisineManager manager = applicationContext.getBean(CuisineManager.class);

		Cuisine ireland = manager.findBy(1L);
		Assertions.assertEquals("Ireland", ireland.getName());

		Cuisine updateIrelandToFrench = new Cuisine(1L, "French");
		Cuisine french = manager.save(updateIrelandToFrench);

		Assertions.assertEquals(1L, french.getId());
		Assertions.assertEquals("French", french.getName());
	}
}
