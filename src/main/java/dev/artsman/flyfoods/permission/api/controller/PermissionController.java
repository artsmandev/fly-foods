package dev.artsman.flyfoods.permission.api.controller;

import dev.artsman.flyfoods.permission.domain.model.Permission;
import dev.artsman.flyfoods.permission.domain.repository.PermissionRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
class PermissionController {
	private final PermissionRepository repository;

	@GetMapping
	List<Permission> findAll() {
		return repository.findAll();
	}
}
