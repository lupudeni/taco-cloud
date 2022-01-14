package sia.tacocloud.domain;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//* domain objects may carry logic. If no logic is in them however, they can be the same as a DTO
@Data
@Table //* this is optional. It maps directly to table Taco_Order. However, if the table you are mapping to has a different name, specify in the arguments of this annotation
public class TacoOrder implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id //* the identity of TacoOrder. Has to be unique
   private Long id;

   private Date placedAt;

   @NotBlank(message = "Delivery name is required") //* The annotated element must not be null and must contain at least one non-whitespace character
   private String deliveryName;

   @NotBlank(message="Street is required")
   private String deliveryStreet;

   @NotBlank(message="City is required")
   private String deliveryCity;

   @NotBlank(message="State is required")
   private String deliveryState;

   @NotBlank(message="Zip code is required")
   private String deliveryZip;

   @CreditCardNumber(message="Not a valid credit card number") //* passes the Luhn algorith check
   private String ccNumber;

   @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
           message="Must be formatted MM/YY")
   private String ccExpiration;

   @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
   private String ccCVV;

   private List<Taco> tacos = new ArrayList<>();

   public void addTaco(Taco taco) {
       this.tacos.add(taco);
   }
}
