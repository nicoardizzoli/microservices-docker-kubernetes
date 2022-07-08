package org.nicoardizzoli.fraud;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "fraud_check_history")
@Entity(name = "FraudCheckHistory")
public class FraudCheckHistory {

    @Id
    @SequenceGenerator(name = "fraud_id_seq", sequenceName = "fraud_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fraud_id_seq")
    private Integer id;
    private Integer customerId;
    private Boolean isFraudster;
    private LocalDateTime createAt;

}
