package dev.artsman.flyfoods.domain.state;

import dev.artsman.flyfoods.FlyFoodsApiApplication;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

class StateRepositoryTest {
	static StateRepository repository;

	@BeforeAll
	static void initAll() {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(FlyFoodsApiApplication.class).web(WebApplicationType.NONE).run();
		repository = applicationContext.getBean(StateRepository.class);
	}

	@Test
	void shouldFindAll() {
		List<State> states = repository.findAll();
		Assertions.assertEquals(2, states.size());
	}

	@Test
	void shouldFindById() {
		State lisbon = repository.findById(1L);
		Assertions.assertEquals(1L, lisbon.getId());
		Assertions.assertEquals("Lisbon", lisbon.getName());
	}

	@Test
	void shouldCreate() {
		List<State> states = repository.findAll();
		Assertions.assertEquals(2, states.size());

		State coimbra = repository.create(new State(null, "Coimbra"));
		Assertions.assertNotNull(coimbra);

		states = repository.findAll();
		Assertions.assertEquals(3, states.size());
	}

	@Test
	void shouldRemove() {
		State lisbon = repository.findById(1L);
		Assertions.assertNotNull(lisbon);

		repository.remove(lisbon);

		lisbon = repository.findById(1L);
		Assertions.assertNull(lisbon);
	}
}
