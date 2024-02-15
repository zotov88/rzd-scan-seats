package org.example.rzdscanseats.repository;

import jakarta.transaction.Transactional;
import org.example.rzdscanseats.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TrainRepository extends JpaRepository<Train, Long> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = """
            delete from rzd.trains where id = :id
            """)
    void myDelete(Long id);
}
