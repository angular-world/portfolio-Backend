package com.burgosmanuel.portfolio.security.repository;

import com.burgosmanuel.portfolio.security.entity.ERole;
import com.burgosmanuel.portfolio.security.entity.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
    Optional<Role> findByName(ERole name);
}
