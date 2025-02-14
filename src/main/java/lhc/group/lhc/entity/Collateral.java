package lhc.group.lhc.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@SequenceGenerator(name = "collateralsIdGenerator", sequenceName = "collateral_id_seq", allocationSize = 1)
@Table(name = "collaterals")
public class Collateral {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "collateralsIdGenerator")
    @Column(name = "id", nullable = false)
    private Integer collateralId;
    private String type;
    private String value;
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime CreateDate;
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updateDate;
    @Column(name = "loan_id")
    private Integer LoanId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "loan_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Loan loan;

}
