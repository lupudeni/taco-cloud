package sia.tacocloud.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
//* access level for generated methods and fields. All are now private
// * @NoArgsConstructor will generate a constructor with no parameters. If this is not possible (because of final fields),
// * a compiler error will result instead, unless @NoArgsConstructor(force = true) is used,
// * then all final fields are initialized with 0 / false / null
// ! JPA requires that an entity has a no args constructor
// ! @Table can be used for Spring Data JDBC and Spring JDBC Template, but not for JPA. For Spring Data JPA we use @Entity
@Entity
public class Ingredient {

    @Id
    private final String id;

    private final String name;

    private final Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
