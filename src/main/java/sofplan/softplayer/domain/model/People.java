package sofplan.softplayer.domain.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    //@Column(nullable = false, columnDefinition = "date")
    @JsonProperty("date_of_birth")
    private LocalDate dateBirth;
    private String naturalness;
    private String nationality;
    private String cpf;

    @CreationTimestamp
    @JsonIgnore
    private OffsetDateTime createdAt;
    @JsonIgnore
    @UpdateTimestamp
    private OffsetDateTime updatedAt;
}
