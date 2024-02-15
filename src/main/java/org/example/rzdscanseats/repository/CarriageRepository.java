package org.example.rzdscanseats.repository;

import org.example.rzdscanseats.entity.Carriage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarriageRepository extends JpaRepository<Carriage, Long> {
}
