package project.java.sa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.java.sa.entites.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByEmail(String email);
}
