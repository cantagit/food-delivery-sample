package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Picked extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String menu;
    private Integer qty;
    private String status;
    private Long storeId;
    private String storeAddress;
    private String userName;
    private String userPhoneNumber;
    private String deliveryAddress;

    public Picked(Delivery aggregate) {
        super(aggregate);
    }

    public Picked() {
        super();
    }
}
