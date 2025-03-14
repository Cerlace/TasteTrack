package cerlace.tastetrack.persistence.repository;

import cerlace.tastetrack.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    /**
     * Получает {@link UserEntity}, по имени пользователя
     *
     * @param username имя пользователя.
     * @return объект {@link UserEntity}
     */
    Optional<UserEntity> findByUsername(String username);

    /**
     * Удаляет {@link UserEntity} по имени пользователя
     *
     * @param username имя пользователя.
     */
    @Transactional
    void deleteByUsername(String username);
}
