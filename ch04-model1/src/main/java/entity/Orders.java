package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn( name = "Member_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete( action = OnDeleteAction.CASCADE)
    private Member member;

    @Column
    private Date ordereDate;

    @OneToMany(mappedBy = "orders")
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public void setMember(Member member){
        if(this.member!=null){
            this.member.getOrders().remove(this);
        }
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrders(this);
    }
}
