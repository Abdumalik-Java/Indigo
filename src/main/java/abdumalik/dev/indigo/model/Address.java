package abdumalik.dev.indigo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String region;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private Integer homeNumber;

}