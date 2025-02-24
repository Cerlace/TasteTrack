package cerlace.tastetrack.repository;

import cerlace.tastetrack.entity.MealEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<MealEntity, Long> {
    List<MealEntity> getAllByUserId(Long userId);
}