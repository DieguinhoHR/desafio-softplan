package sofplan.softplayer.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;
import sofplan.softplayer.domain.model.enums.Gender;

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
public class PeopleNewDTO {
    @NotEmpty(message = "O campo nome é obrigatório")
    @Length(min=5, max=120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String name;
    private Gender gender = Gender.MALE;
    @Email(message = "Email inválido")
    private String email;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "MM/dd/yyyy")
    @NotNull(message = "O campo data de nascimento não pode ser vazio")
    @JsonProperty("date_birth")
    private LocalDate dateBirth;
    private String naturalness;
    private String nationality;
    @NotEmpty(message = "Preenchimento obrigatório")
    @CPF(message="CPF inválido, digite novamente")
    @Size(min = 14)
    private String cpf;

    @CreationTimestamp
    private OffsetDateTime createdAt;
    @UpdateTimestamp
    private OffsetDateTime updatedAt;
}
