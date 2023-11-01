package dev.artsman.flyfoods.domain.permission;

import dev.artsman.flyfoods.FlyFoodsApiApplication;
import dev.artsman.flyfoods.permission.domain.model.Permission;
import dev.artsman.flyfoods.permission.domain.repository.PermissionRepository;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

class PermissionRepositoryTest {
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
		Permission read = repository.finBy(1L);
		Assertions.assertNotNull(read);

		Permission writeOnly = new Permission(1L, "Write Only", "It's allowed to write only");
		repository.save(writeOnly);

		read = repository.finBy(1L);

		Assertions.assertEquals(1L, read.getId());
		Assertions.assertEquals("Write Only", read.getName());
		Assertions.assertEquals("It's allowed to write only", read.getDescription());
	}

	@Test
	void shouldRemove() {
		Permission read = repository.finBy(1L);
		Assertions.assertNotNull(read);

		repository.remove(read);

		Assertions.assertNull(repository.finBy(1L));
	}
}
