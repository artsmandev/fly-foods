package dev.artsman.flyfoods.domain.restaurant;

import dev.artsman.flyfoods.FlyFoodsApiApplication;
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

		Restaurant indianGourmet = new Restaurant(null, "Indian Gourmet", new BigDecimal(30));

		Restaurant restaurantCreated = repository.save(indianGourmet);

		Assertions.assertEquals(3, restaurantCreated.getId());
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
