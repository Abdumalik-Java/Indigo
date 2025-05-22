package abdumalik.dev.indigo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    private Group groupName;

    @OneToMany
    private List<Task> taskId;

    @Column(nullable = false)
    private String status;

    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now();

}