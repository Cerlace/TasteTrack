package cerlace.tastetrack.repository;

import cerlace.tastetrack.entity.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends JpaRepository<DishEntity, Long>,
                                        JpaSpecificationExecutor<DishEntity> {
}