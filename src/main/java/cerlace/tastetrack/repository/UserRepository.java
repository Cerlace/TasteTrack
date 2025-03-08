package cerlace.tastetrack.repository;

import cerlace.tastetrack.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
    void deleteByUsername(String username);
}
