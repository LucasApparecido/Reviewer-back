package br.ueg.reviewer.repository;

import br.ueg.reviewer.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Optional<Review> findById(Long Id);

    @Query("select p from Review p where upper(p.title) like upper(concat('%',:title,'%'))")
    List<Review> findByTitleContaining(@Param("title") String title);
}
