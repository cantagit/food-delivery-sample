package fooddelivery.domain;

import fooddelivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "orderAndCooks",
    path = "orderAndCooks"
)
public interface OrderAndCookRepository
    extends PagingAndSortingRepository<OrderAndCook, Long> {}
