package dev.artsman.flyfoods.domain.permission.infraestructure;

import dev.artsman.flyfoods.domain.permission.Permission;
import dev.artsman.flyfoods.domain.permission.PermissionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
class PermissionRepositoryImpl implements PermissionRepository {
	@PersistenceContext
	private final EntityManager entityManager;

	@Override
	public List<Permission> findAll() {
		return entityManager.createQuery("from Permission", Permission.class).getResultList();
	}

	@Override
	public Permission finBy(Long id) {
		return entityManager.find(Permission.class, id);
	}

	@Override
	@Transactional
	public Permission save(Permission permission) {
		return entityManager.merge(permission);
	}
}
