package cerlace.tastetrack.repository;

import cerlace.tastetrack.entity.RoleEntity;
import cerlace.tastetrack.enums.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
    RoleEntity findByName(Role name);
}
