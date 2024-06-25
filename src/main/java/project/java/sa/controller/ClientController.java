package project.java.sa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project.java.sa.entites.Client;
import project.java.sa.service.ClientService;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "client")
public class ClientController {
    private  ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@RequestBody Client client) {
        clientService.create(client);
    }
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Client> search() {
        return this.clientService.search();
    }
    @GetMapping(path ="{id}", produces = APPLICATION_JSON_VALUE)
    public Client lire(@PathVariable int id){
        return  this.clientService.lire(id);

    }
}
