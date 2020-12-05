package sofplan.softplayer.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "Este campo é o nome da pessoa", example = "Paulo Roberto")
    private String name;
    @Schema(description = "Este campo é o sexo da pessoa", example = "MALE - Masculino ou FEMALE - Feminino")
    private Gender gender = Gender.MALE;
    @Email(message = "Email inválido")
    @Schema(description = "Este campo é o email da pessoa", example = "pauloroberto@gmail.com", required = true)
    private String email;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "MM/dd/yyyy")
    @NotNull(message = "O campo data de nascimento não pode ser vazio")
    @JsonProperty("date_birth")
    @Schema(description = "Este campo é a data de nascimento da pessoa", example = "1970-08-07")
    private LocalDate dateBirth;
    @Schema(description = "Este campo é a naturalidade da pessoa", example = "Rio grande do sul, porto alegre")
    private String naturalness;
    @Schema(description = "Este campo é a nacionalidade da pessoa", example = "Brasil")
    private String nationality;
    @NotEmpty(message = "Preenchimento obrigatório")
    @CPF(message="CPF inválido, digite novamente")
    @Size(min = 14)
    @Schema(description = "Este campo é o CPF da pessoa", example = "247.822.620-00")
    private String cpf;

    @CreationTimestamp
    private OffsetDateTime createdAt;
    @UpdateTimestamp
    private OffsetDateTime updatedAt;
}
