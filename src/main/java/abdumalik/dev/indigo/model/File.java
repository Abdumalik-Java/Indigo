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
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String filename;
    @Column(nullable = false)
    private String contentType;
    @Column(nullable = false)
    private String byteData;

    @CreatedDate
    private LocalDateTime createdDateTime = LocalDateTime.now();

}