package project.java.sa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project.java.sa.entites.Reaction;
import project.java.sa.service.ReactionService;

import java.util.List;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "reaction", produces = APPLICATION_JSON_VALUE)
public class ReactionController {
    private static final Logger logger = LoggerFactory.getLogger(ReactionController.class);

    private final ReactionService reactionService;

    public ReactionController(ReactionService reactionService) {
        this.reactionService = reactionService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Reaction reaction) {
        // Log the payload
        logger.info("Received payload: {}", reaction);

        // Call the service to create the reaction
        this.reactionService.create(reaction);
    }
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public @ResponseBody List<Reaction> search() {
        return this.reactionService.search();
    }
    @ResponseStatus(NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable int id) {
        this.reactionService.delete(id);
    }
}
