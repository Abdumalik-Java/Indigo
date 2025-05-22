package abdumalik.dev.indigo.model;

import abdumalik.dev.indigo.model.entity.Gender;
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
public class ProfileKids {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    private Photo photoId;
    @OneToOne
    private Group groupId;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private LocalDate birthday;

    @OneToOne
    private Address addressId;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    private String status;

    @CreatedDate
    private LocalDateTime createdDateTime = LocalDateTime.now();

}