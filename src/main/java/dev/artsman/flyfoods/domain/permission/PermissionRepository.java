package dev.artsman.flyfoods.domain.permission;

import java.util.List;

public interface PermissionRepository {
	List<Permission> findAll();

	Permission finBy(Long id);

	Permission save(Permission permission);
}
