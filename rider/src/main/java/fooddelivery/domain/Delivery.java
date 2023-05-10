package fooddelivery.domain;

import fooddelivery.RiderApplication;
import fooddelivery.domain.Finished;
import fooddelivery.domain.Picked;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Delivery_table")
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    private String menu;

    private Integer qty;

    private String storeAddress;

    private String status;

    private Long storeId;

    private String userName;

    private String userPhoneNumber;

    private String deliveryAddress;

    @PostPersist
    public void onPostPersist() {
        Finished finished = new Finished(this);
        finished.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {
        Picked picked = new Picked(this);
        picked.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = RiderApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    public static void requestDelivery(CookFinished cookFinished) {
        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookFinished.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

    }
}
