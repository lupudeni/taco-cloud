package sia.tacocloud.repository.order;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.domain.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

    TacoOrder save(TacoOrder tacoOrder);
}
