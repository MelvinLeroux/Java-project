package project.java.sa.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import project.java.sa.dto.ClientDTO;
import project.java.sa.entites.Client;
import project.java.sa.mapper.ClientDTOMapper;
import project.java.sa.repository.ClientRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ClientService {
    private final ClientDTOMapper ClientDTOMapper;
    private final ClientRepository clientRepository;
    public ClientService(ClientDTOMapper clientDTOMapper, ClientRepository clientRepository) {
        this.ClientDTOMapper = clientDTOMapper;
        this.clientRepository = clientRepository;
    }
    public void create( Client client) {
       Client clientInsideBDD = this.clientRepository.findByEmail(client.getEmail());
       if (clientInsideBDD == null) {
           this.clientRepository.save(client);
       }

    }
    public Stream<ClientDTO> search() {
        return this.clientRepository.findAll()
                .stream().map(ClientDTOMapper);
    }

    public Client lire(int id) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        return optionalClient.orElseThrow(
                ()->new EntityNotFoundException("aucun client n'existe avec cet identifiant"));
    }

    public Client readOrCreate(Client clientToCreate) {
        Client clientInsideBDD = this.clientRepository.findByEmail(clientToCreate.getEmail());
        if (clientInsideBDD == null) {
            clientInsideBDD = this.clientRepository.save(clientToCreate);
        }
        return clientInsideBDD;
    }

    public void update(int id, Client client) {
        Client clientInsideBDD = this.lire(id);
        if (clientInsideBDD.getId()== client.getId()) {
            clientInsideBDD.setEmail(client.getEmail());
            clientInsideBDD.setTelephone(client.getTelephone());
            this.clientRepository.save(clientInsideBDD);
        }
    }
}
