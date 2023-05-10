package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookFinished extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String menu;
    private Integer qty;
    private String status;
    private String deliveryAddress;
    private Long storeId;
    private String storeAddress;
    private String userName;
    private String userPhoneNumber;

    public CookFinished(OrderAndCook aggregate) {
        super(aggregate);
    }

    public CookFinished() {
        super();
    }
}
