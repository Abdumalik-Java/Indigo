package abdumalik.dev.indigo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer size;
    @Column(nullable = false)
    private String path;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String byteData;

    @CreatedDate
    private LocalDateTime createdDateTime = LocalDateTime.now();

}