package org.pack.platformeaide.repository;

import org.pack.platformeaide.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
