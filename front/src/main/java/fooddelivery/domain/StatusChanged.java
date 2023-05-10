package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class StatusChanged extends AbstractEvent {

    private Long id;
    private String status;

    public StatusChanged(Order aggregate) {
        super(aggregate);
    }

    public StatusChanged() {
        super();
    }
}
