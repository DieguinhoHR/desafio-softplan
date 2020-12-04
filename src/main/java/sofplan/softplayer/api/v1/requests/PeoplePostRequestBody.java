package sofplan.softplayer.api.v1.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.UniqueElements;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;
import sofplan.softplayer.domain.model.Gender;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PeoplePostRequestBody {
    @NotEmpty(message = "O campo nome não pode ser vazio")
    private String name;
    private Gender gender = Gender.MALE;
    @Email
    private String email;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    @NotNull(message = "O campo data de nascimento não pode ser vazio")
    @JsonProperty("date_birth")
    private LocalDate dateBirth;
    private String naturalness;
    private String nationality;
    @NotEmpty(message = "O campo CPF não pode ser vazio")
    @CPF(message="CPF inválido, digite novamente")
    @Size(min = 14)
    private String cpf;

    @CreationTimestamp
    private OffsetDateTime createdAt;
    @UpdateTimestamp
    private OffsetDateTime updatedAt;
}
