package project.java.sa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.java.sa.entites.Reaction;

public interface ReactionRepository extends JpaRepository<Reaction, Integer> {
}
