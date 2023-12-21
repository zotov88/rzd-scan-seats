package org.example.rzdscanseats.repository;

import org.example.rzdscanseats.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TrainRepository extends JpaRepository<Train, Long> {

    @Query(nativeQuery = true,
    value = """
            delete from rzd.trains where id = :id
            """)
    void deleteBy(Long id);
}
