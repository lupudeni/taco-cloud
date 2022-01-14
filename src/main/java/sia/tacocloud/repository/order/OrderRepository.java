package sia.tacocloud.repository.order;

import sia.tacocloud.domain.TacoOrder;

public interface OrderRepository {

    TacoOrder save(TacoOrder tacoOrder);
}
