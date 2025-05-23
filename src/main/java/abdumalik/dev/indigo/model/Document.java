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
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String documentType;
    @Column(nullable = false, unique = true)
    private Integer seriaNumber;
    @Column(nullable = false)
    private Integer number;
    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private LocalDate date;
    @Column
    private boolean issuedBy;
    @ManyToOne
    private Address address;

    @CreatedDate
    private LocalDateTime createdAt = LocalDateTime.now();

}