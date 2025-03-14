package cerlace.tastetrack.persistence.repository;

import cerlace.tastetrack.persistence.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
    /**
     * Получает {@link RoleEntity}, по названию
     *
     * @param name название роли.
     * @return объект {@link RoleEntity}
     */
    RoleEntity findByName(String name);
}
