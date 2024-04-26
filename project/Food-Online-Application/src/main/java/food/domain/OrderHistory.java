package food.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    private Long userId;

    @ElementCollection
    @CollectionTable(name = "order_history_menu_names",
            joinColumns = @JoinColumn(name = "order_history_id"))
    private List<String> menuNames = new ArrayList<>();

    private Double totalPrice;
}
