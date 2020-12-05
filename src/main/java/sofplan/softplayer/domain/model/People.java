package sofplan.softplayer.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import sofplan.softplayer.domain.model.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Gender gender = Gender.MALE;
    private String email;
    @JsonProperty("date_birth")
    @Column(name = "date_birth")
    private LocalDate dateBirth;
    private String naturalness;
    private String nationality;
    @Column(unique=true)
    private String cpf;

    @CreationTimestamp
    @JsonIgnore
    private OffsetDateTime createdAt;
    @UpdateTimestamp
    @JsonIgnore
    private OffsetDateTime updatedAt;
}
