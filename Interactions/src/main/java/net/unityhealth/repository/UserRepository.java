package net.unityhealth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.unityhealth.model.AdminUsers;


public interface UserRepository  extends JpaRepository<AdminUsers, Long> {
	AdminUsers findByUsername(String username);
}
