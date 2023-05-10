package fooddelivery.domain;

import fooddelivery.FrontApplication;
import fooddelivery.domain.OrderCancelled;
import fooddelivery.domain.OrderPlaced;
import fooddelivery.domain.StatusChanged;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String menu;

    private Integer qty;

    private String status;

    private Long storeId;

    private String deliveryAddress;

    private String userName;

    private Integer userPhoneNumber;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

        StatusChanged statusChanged = new StatusChanged(this);
        statusChanged.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        OrderCancelled orderCancelled = new OrderCancelled(this);
        orderCancelled.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public static void updateOrderStatus(OrderCancelled orderCancelled) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        StatusChanged statusChanged = new StatusChanged(order);
        statusChanged.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderCancelled.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            StatusChanged statusChanged = new StatusChanged(order);
            statusChanged.publishAfterCommit();

         });
        */

    }

    public static void updateOrderStatus(CookStarted cookStarted) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        StatusChanged statusChanged = new StatusChanged(order);
        statusChanged.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(cookStarted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            StatusChanged statusChanged = new StatusChanged(order);
            statusChanged.publishAfterCommit();

         });
        */

    }

    public static void updateOrderStatus(CookFinished cookFinished) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        StatusChanged statusChanged = new StatusChanged(order);
        statusChanged.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(cookFinished.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            StatusChanged statusChanged = new StatusChanged(order);
            statusChanged.publishAfterCommit();

         });
        */

    }

    public static void updateOrderStatus(OrderAccepted orderAccepted) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        StatusChanged statusChanged = new StatusChanged(order);
        statusChanged.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderAccepted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            StatusChanged statusChanged = new StatusChanged(order);
            statusChanged.publishAfterCommit();

         });
        */

    }

    public static void updateOrderStatus(Finished finished) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        StatusChanged statusChanged = new StatusChanged(order);
        statusChanged.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(finished.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            StatusChanged statusChanged = new StatusChanged(order);
            statusChanged.publishAfterCommit();

         });
        */

    }
}
