package dev.artsman.flyfoods.domain.permission;

import dev.artsman.flyfoods.FlyFoodsApiApplication;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

class PermissionRepositoryImplTest {
	static PermissionRepository repository;

	@BeforeAll
	static void initAll() {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(FlyFoodsApiApplication.class).web(WebApplicationType.NONE).run();
		repository = context.getBean(PermissionRepository.class);
	}
	@Test
	void shouldFindAll() {
		List<Permission> permissions = repository.findAll();
		Assertions.assertEquals(2, permissions.size());
	}

	@Test
	void shouldFindById() {
		Permission read = repository.finBy(1L);
		Assertions.assertNotNull(read);
	}

	@Test
	void shouldCreate() {
		Permission readOnly = new Permission(null, "Read Only", "It is allowed read only");
		readOnly = repository.save(readOnly);
		Assertions.assertEquals(3L, readOnly.getId());
	}

	@Test
	void shouldUpdate() {

	}
}
