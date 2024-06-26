package project.java.sa.mapper;

import org.springframework.stereotype.Component;
import project.java.sa.dto.ClientDTO;
import project.java.sa.entites.Client;

import java.util.function.Function;

@Component
public class ClientDTOMapper implements Function<Client, ClientDTO> {




    @Override
    public ClientDTO apply(Client client) {
        return new ClientDTO(client.getId(), client.getEmail(), client.getTelephone());
    }
}
