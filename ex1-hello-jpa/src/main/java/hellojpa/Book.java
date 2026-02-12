package hellojpa;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@DiscriminatorValue("B")
@Inheritance(strategy =  InheritanceType.JOINED)
public class Book extends Item {
    private String author;
    private String isbn;
}
