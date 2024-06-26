package project.java.sa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.java.sa.entites.Reaction;
import project.java.sa.enums.Type;

import java.util.List;

public interface ReactionRepository extends JpaRepository<Reaction, Integer> {
    List<Reaction> findByType(Type type);
}
