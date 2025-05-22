package abdumalik.dev.indigo.model;

import abdumalik.dev.indigo.model.entity.CheckType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Check {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private LocalDate fromDate;
    @Column(nullable = false)
    private LocalDate toDate;

    @Enumerated(EnumType.STRING)
    private CheckType checkType;

    @OneToOne
    private Group group;

    @Column(nullable = false)
    private boolean paid;
    @Column(nullable = false)
    private boolean unpaid;
    @Column(nullable = false)
    private Double summa;

    @ManyToOne
    private Profile profileId;

    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now();

}