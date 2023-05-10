package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Finished extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String status;
    private Long storeId;
}
