package abdumalik.dev.indigo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToMany
    private List<Category> categoryId;

    @Column(nullable = false)
    private String priority;

    @OneToMany
    private List<Template> templateId;

    @OneToOne
    private Group groupId;

    @Column(nullable = false)
    private LocalDate formDate;
    @Column(nullable = false)
    private LocalDate toDate;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;

    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now();

}