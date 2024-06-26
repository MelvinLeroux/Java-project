package project.java.sa.entites;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String email;
    private String telephone;
    private Date creation;
    @Column(name = "mis_a_jour")
    private Date MisAJour ;

    public Client(String telephone) {
        this.telephone = telephone;
    }


    public Client() {

    }

    public Client(int id, String email, String telephone, Date creation, Date misAJour) {
        this.id = id;
        this.email = email;
        this.telephone = telephone;
        this.creation = creation;
        MisAJour = misAJour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public Date getMisAJour() {
        return MisAJour;
    }

    public void setMisAJour(Date misAJour) {
        MisAJour = misAJour;
    }
}
