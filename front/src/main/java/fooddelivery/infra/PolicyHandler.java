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
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderCancelled'"
    )
    public void wheneverOrderCancelled_UpdateOrderStatus(
        @Payload OrderCancelled orderCancelled
    ) {
        OrderCancelled event = orderCancelled;
        System.out.println(
            "\n\n##### listener UpdateOrderStatus : " + orderCancelled + "\n\n"
        );

        // Sample Logic //
        Order.updateOrderStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookStarted'"
    )
    public void wheneverCookStarted_UpdateOrderStatus(
        @Payload CookStarted cookStarted
    ) {
        CookStarted event = cookStarted;
        System.out.println(
            "\n\n##### listener UpdateOrderStatus : " + cookStarted + "\n\n"
        );

        // Sample Logic //
        Order.updateOrderStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookFinished'"
    )
    public void wheneverCookFinished_UpdateOrderStatus(
        @Payload CookFinished cookFinished
    ) {
        CookFinished event = cookFinished;
        System.out.println(
            "\n\n##### listener UpdateOrderStatus : " + cookFinished + "\n\n"
        );

        // Sample Logic //
        Order.updateOrderStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderAccepted'"
    )
    public void wheneverOrderAccepted_UpdateOrderStatus(
        @Payload OrderAccepted orderAccepted
    ) {
        OrderAccepted event = orderAccepted;
        System.out.println(
            "\n\n##### listener UpdateOrderStatus : " + orderAccepted + "\n\n"
        );

        // Sample Logic //
        Order.updateOrderStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Finished'"
    )
    public void wheneverFinished_UpdateOrderStatus(@Payload Finished finished) {
        Finished event = finished;
        System.out.println(
            "\n\n##### listener UpdateOrderStatus : " + finished + "\n\n"
        );

        // Sample Logic //
        Order.updateOrderStatus(event);
    }
}
