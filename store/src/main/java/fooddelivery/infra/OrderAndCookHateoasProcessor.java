package fooddelivery.infra;

import fooddelivery.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class OrderAndCookHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<OrderAndCook>> {

    @Override
    public EntityModel<OrderAndCook> process(EntityModel<OrderAndCook> model) {
        return model;
    }
}
