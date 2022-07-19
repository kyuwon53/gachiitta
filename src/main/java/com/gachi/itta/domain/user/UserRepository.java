package com.gachi.itta.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 사용자 CRUD 기능을 제공합니다.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * email에 해당하는 사용자를 찾는다.
     * @param email
     * @return
     */
    Optional<User> findByEmail(String email);
}
