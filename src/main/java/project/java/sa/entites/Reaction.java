package project.java.sa.entites;

import jakarta.persistence.*;
import project.java.sa.enums.Type;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "REACTION")
public class Reaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String texte;
    private Type type;
    @ManyToOne(cascade = {PERSIST, MERGE})
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    public Reaction() {
    }

    public Reaction(String text, Type type, Client client, int reaction) {
        this.texte = text;
        this.type = type;
        this.client = client;
    }





    public String getText() {
        return texte;
    }

    public void setText(String text) {
        this.texte  = text;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
