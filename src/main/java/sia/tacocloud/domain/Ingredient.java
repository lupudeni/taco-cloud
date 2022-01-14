package sia.tacocloud.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true) //* access level for generated methods and fields. All are now private
// * @NoArgsConstructor will generate a constructor with no parameters. If this is not possible (because of final fields),
// * a compiler error will result instead, unless @NoArgsConstructor(force = true) is used,
// * then all final fields are initialized with 0 / false / null
@Table
public class Ingredient implements Persistable<String> {

    private final String id;

    private final String name;

    private final Type type;

    @Override
    public boolean isNew() {
        return false;
    }

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
