package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

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

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
