package abdumalik.dev.indigo.model;

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
public class TransferBaby {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    private ProfileKids profileKidsId;

    @Column(nullable = false)
    private LocalDate period;
    @Column(nullable = false)
    private String title;

    @OneToOne
    private Group group;

    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now();

}