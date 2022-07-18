package deloittetodo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

/*
This class builds our TodoElements, nothing crazy going on
here, it's just properties with constructors.
 */

@Entity
public class TodoElement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @NotBlank(message = "Description is required")
    private String description;

    @Getter
    @Setter
    private boolean complete;

    @Getter
    @Setter
    private Instant lastModified;

    public TodoElement() {}

    public TodoElement(String description) {
        this.description = description;
        this.complete = false;
        this.lastModified = Instant.now();
    }

    @Override
    public String toString() {
        return String.format("TodoElement{id=%d, description='%s', complete='%s', lastModified='%s'}",
                id, description, complete, lastModified);
    }
}
