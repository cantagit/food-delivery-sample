package fooddelivery.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import fooddelivery.config.kafka.KafkaProcessor;
import fooddelivery.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderAndCookRepository orderAndCookRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderPlaced'"
    )
    public void wheneverOrderPlaced_OrderReceive(
        @Payload OrderPlaced orderPlaced
    ) {
        OrderPlaced event = orderPlaced;
        System.out.println(
            "\n\n##### listener OrderReceive : " + orderPlaced + "\n\n"
        );

        // Sample Logic //
        OrderAndCook.orderReceive(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderCancelled'"
    )
    public void wheneverOrderCancelled_OrderCancel(
        @Payload OrderCancelled orderCancelled
    ) {
        OrderCancelled event = orderCancelled;
        System.out.println(
            "\n\n##### listener OrderCancel : " + orderCancelled + "\n\n"
        );

        // Sample Logic //
        OrderAndCook.orderCancel(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Finished'"
    )
    public void wheneverFinished_OrderFinish(@Payload Finished finished) {
        Finished event = finished;
        System.out.println(
            "\n\n##### listener OrderFinish : " + finished + "\n\n"
        );

        // Sample Logic //
        OrderAndCook.orderFinish(event);
    }
}
