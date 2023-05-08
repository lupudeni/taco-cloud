package sia.tacocloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sia.tacocloud.domain.TacoOrder;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

    //* Spring Data defines a sort of miniature domain-specific language (DSL) where persistence details are expressed in
    //* repository method signatures. It "translates" it into a query, so be very specific.
    //* Repository methods are composed of a verb, an optional subject, the word By, and a predicate
    List<TacoOrder> findByDeliveryZip(String deliveryZip);

    //* Spring Data understands find, read, and get as synonymous for fetching one or more entities.
    //* However, there is a difference between findBy and getBy: https://szymonkrajewski.pl/the-practical-difference-between-findby-and-getby-in-repositories/
    //* when using GET, if the object does not exist, the operation will throw an EntityNotFoundException.
    //* when using FIND, if the object does not exist in the db, it will simply return null
    List<TacoOrder> readByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);


    //* getById() returns a reference to the entity with the given identifier. It invokes EntityManager.getReference() and returns a lazy proxy.
    //* So when you are out of transaction with this response - you will get LazyInitializationException when trying to get lazy fields.
    //* findById() fetches real object from database.
}
