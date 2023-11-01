package dev.artsman.flyfoods.permission.domain.repository;

import dev.artsman.flyfoods.permission.domain.model.Permission;
import java.util.List;

public interface PermissionRepository {
	List<Permission> findAll();

	Permission finBy(Long id);

	Permission save(Permission permission);

	void remove(Permission permission);
}
