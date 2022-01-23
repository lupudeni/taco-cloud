package sia.tacocloud.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
// * for JDBC: @Table
@Entity //* for JPA
@NoArgsConstructor
public class Taco {

    @Id //* should be import javax.persistence.Id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    //* If you use GenerationType.AUTO then by default hibernate uses hibernate_sequence for the sequence
    //* which is used by all tables and only one sequence value can be consumed at a time which means if sequence 1 is used
    //* then it can not be used anywhere else. But with GenerationType.IDENTITY the ids are only unique for that particular column
    private Long id;

    private Date createdAt = new Date();

    @NotNull //* the field can however be empty. (however, this is prevented by the size constraint)
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @NotNull
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    @ManyToMany
    //* A Taco can have many Ingredient objects,
    //* and an Ingredient can be a part of many Taco s.
    private List<Ingredient> ingredients;
}
