package sofplan.softplayer.api.v1.requests;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import sofplan.softplayer.domain.model.Gender;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
public class PeoplePutRequestBody {
    private Long id;
    private String name;
    private Gender gender = Gender.MALE;
    private String email;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateBirth;
    private String naturalness;
    private String nationality;
    private String cpf;

    @CreationTimestamp
    private OffsetDateTime createdAt;
    @UpdateTimestamp
    private OffsetDateTime updatedAt;
}
