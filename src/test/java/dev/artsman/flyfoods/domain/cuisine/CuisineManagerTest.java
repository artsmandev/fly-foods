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
}
