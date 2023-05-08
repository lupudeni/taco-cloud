package sia.tacocloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import sia.tacocloud.repository.OrderRepository;
import sia.tacocloud.service.OrderAdminService;

@Service
public class OrderAdminServiceImpl implements OrderAdminService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @PreAuthorize("hasRole('ADMIN')") // * this expression is checking if the user has ROLE_ADMIN
    //* in case the call to this method is blocked, the AccessDeniedException will be thrown => http 403
    public void deleteAll() {
        orderRepository.deleteAll();
    }
}
