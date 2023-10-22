package dev.artsman.flyfoods.domain.restaurant;

import dev.artsman.flyfoods.FlyFoodsApiApplication;
import dev.artsman.flyfoods.domain.cuisine.Cuisine;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

class RestaurantRepositoryTest {
	@Test
	void shouldFindAll() {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(FlyFoodsApiApplication.class).web(WebApplicationType.NONE).run("");
		RestaurantRepository repository = applicationContext.getBean(RestaurantRepository.class);

		List<Restaurant> restaurants = repository.findAll();

		Assertions.assertEquals(2, restaurants.size());
		Assertions.assertNotNull(restaurants.get(0).getCuisine());
		Assertions.assertNotNull(restaurants.get(1).getCuisine());
	}

	@Test
	void shouldFindById() {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(FlyFoodsApiApplication.class).web(WebApplicationType.NONE).run("");
		RestaurantRepository repository = applicationContext.getBean(RestaurantRepository.class);

		Long thaiGourmetId = 1L;
		Restaurant thaiGourmet = repository.findBy(thaiGourmetId);

		Assertions.assertNotNull(thaiGourmet);
	}

	@Test
	void shouldCreate() {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(FlyFoodsApiApplication.class).web(WebApplicationType.NONE).run("");
		RestaurantRepository repository = applicationContext.getBean(RestaurantRepository.class);

		Cuisine irelandCuisine = new Cuisine(1L, "Ireland");
		Restaurant indianGourmet = new Restaurant(null, "Ireland Gourmet", new BigDecimal(30), irelandCuisine);

		indianGourmet = repository.save(indianGourmet);

		Assertions.assertEquals(3, indianGourmet.getId());
	}

	@Test
	void shouldUpdate() {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(FlyFoodsApiApplication.class).web(WebApplicationType.NONE).run("");
		RestaurantRepository repository = applicationContext.getBean(RestaurantRepository.class);

		Restaurant thaiGourmet = repository.findBy(1L);
		Assertions.assertEquals("Ireland Gourmet", thaiGourmet.getName());

		Cuisine britishCuisine = new Cuisine(1L, "British");
		Restaurant updateThailandToBritish = new Restaurant(1L, "British Gourmet", new BigDecimal(40), britishCuisine);
		Restaurant british = repository.save(updateThailandToBritish);

		Assertions.assertEquals(1L, british.getId());
		Assertions.assertEquals("British Gourmet", british.getName());
		Assertions.assertEquals(new BigDecimal(40), british.getDeliveryFee());

		Assertions.assertEquals("British", britishCuisine.getName());
	}

	@Test
	void shouldRemove() {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(FlyFoodsApiApplication.class).web(WebApplicationType.NONE).run("");
		RestaurantRepository repository = applicationContext.getBean(RestaurantRepository.class);

		Restaurant thaiGourmet = repository.findBy(1L);
		Assertions.assertNotNull(thaiGourmet);

		repository.remove(thaiGourmet);

		Assertions.assertNull(repository.findBy(1L));
	}
}
