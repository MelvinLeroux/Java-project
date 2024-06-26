package project.java.sa.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.java.sa.dto.ClientDTO;
import project.java.sa.dto.ErrorEntity;
import project.java.sa.entites.Client;
import project.java.sa.service.ClientService;

import java.util.stream.Stream;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
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
    public Stream<ClientDTO> search() {
         return this.clientService.search();
    }
    @GetMapping(path ="{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity lire(@PathVariable int id) {
        try {
            Client client = this.clientService.lire(id);
            return ResponseEntity.ok(client);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(BAD_REQUEST).body(new ErrorEntity(null, e.getMessage()));
        }

    }
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    public void update(@PathVariable int id, @RequestBody Client client){
        this.clientService.update(id, client);
    }

}
