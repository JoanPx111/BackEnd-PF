package com.uptc.entrenamiento.repositories;

import com.uptc.entrenamiento.models.ParteCuerpo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParteCuerpoRepository extends JpaRepository<ParteCuerpo, Long> {
}
