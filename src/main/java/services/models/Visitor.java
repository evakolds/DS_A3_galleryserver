package services.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Table(name = "visitors")

public class Visitor {
    @Id
    private String visitor_id;
    String name;
    String surname;

    public Visitor(String name,
                   String surname) {
        this.name = name;
        this.surname = surname;
        this.visitor_id = UUID.randomUUID().toString();
    }

    public Visitor() {

    }

    public String getVisitor_id() {
        return visitor_id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

}

}