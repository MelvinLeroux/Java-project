package project.java.sa.service;

import org.springframework.stereotype.Service;
import project.java.sa.entites.Client;
import project.java.sa.entites.Reaction;
import project.java.sa.repository.ReactionRepository;

import java.util.List;

@Service
public class ReactionService {
    private ClientService clientService;
    private ReactionRepository reactionRepository;

    public ReactionService(ClientService clientService, ReactionRepository reactionRepository) {
        this.clientService = clientService;
        this.reactionRepository = reactionRepository;
    }

    public void create(Reaction reaction) {
        Client client = this.clientService.readOrCreate(reaction.getClient());
        reaction.setClient(client);
        this.reactionRepository.save(reaction);
    }

    public List<Reaction> search(){
    return   this.reactionRepository.findAll();
    }

    public void delete(int id) {
        this.reactionRepository.deleteById(id);
    }
}
