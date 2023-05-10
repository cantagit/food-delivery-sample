package fooddelivery.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MenuSearch_table")
@Data
public class MenuSearch {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
}
