package com.ekip.KVMK.repository;

import com.ekip.KVMK.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Long> {
}
