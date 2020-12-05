package sofplan.softplayer.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dom4j.tree.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(unique = true)
    @Schema(description = "Este campo representa o nome do usuário de acesso ao sistema", example = "bucky")
    private String username;
    @NotEmpty
    @Schema(description = "Este campo representa a senha do usuário", example = "Teste2020")
    private String password;
    @NotEmpty
    @Schema(description = "Este campo representa o nome do usuário", example = "Bucky")
    private String name;
    @Schema(description = "Este campo represeta se o usuário é admin ou não", example = "1 - admin,0 - usuario comum")
    private boolean admin;
}
