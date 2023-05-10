package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderCancelled extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String status;

    public OrderCancelled(OrderAndCook aggregate) {
        super(aggregate);
    }

    public OrderCancelled() {
        super();
    }
}
