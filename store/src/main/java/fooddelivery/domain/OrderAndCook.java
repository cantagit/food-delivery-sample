package fooddelivery.domain;

import fooddelivery.StoreApplication;
import fooddelivery.domain.CookFinished;
import fooddelivery.domain.CookStarted;
import fooddelivery.domain.OrderAccepted;
import fooddelivery.domain.OrderCancelled;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "OrderAndCook_table")
@Data
public class OrderAndCook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    private String menu;

    private Integer qty;

    private String deliveryAddress;

    private String status;

    private Long storeId;

    private String storeAddress;

    private String userName;

    private String userPhoneNumber;

    @PostPersist
    public void onPostPersist() {
        OrderAccepted orderAccepted = new OrderAccepted(this);
        orderAccepted.publishAfterCommit();
    }

    @PostRemove
    public void onPostRemove() {
        OrderCancelled orderCancelled = new OrderCancelled(this);
        orderCancelled.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {
        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();

        CookFinished cookFinished = new CookFinished(this);
        cookFinished.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {}

    public static OrderAndCookRepository repository() {
        OrderAndCookRepository orderAndCookRepository = StoreApplication.applicationContext.getBean(
            OrderAndCookRepository.class
        );
        return orderAndCookRepository;
    }

    public static void orderReceive(OrderPlaced orderPlaced) {
        /** Example 1:  new item 
        OrderAndCook orderAndCook = new OrderAndCook();
        repository().save(orderAndCook);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(orderAndCook->{
            
            orderAndCook // do something
            repository().save(orderAndCook);


         });
        */

    }

    public static void orderCancel(OrderCancelled orderCancelled) {
        /** Example 1:  new item 
        OrderAndCook orderAndCook = new OrderAndCook();
        repository().save(orderAndCook);

        OrderCancelled orderCancelled = new OrderCancelled(orderAndCook);
        orderCancelled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderCancelled.get???()).ifPresent(orderAndCook->{
            
            orderAndCook // do something
            repository().save(orderAndCook);

            OrderCancelled orderCancelled = new OrderCancelled(orderAndCook);
            orderCancelled.publishAfterCommit();

         });
        */

    }

    public static void orderFinish(Finished finished) {
        /** Example 1:  new item 
        OrderAndCook orderAndCook = new OrderAndCook();
        repository().save(orderAndCook);

        */

        /** Example 2:  finding and process
        
        repository().findById(finished.get???()).ifPresent(orderAndCook->{
            
            orderAndCook // do something
            repository().save(orderAndCook);


         });
        */

    }
}
