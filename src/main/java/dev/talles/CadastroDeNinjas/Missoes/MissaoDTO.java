package dev.talles.CadastroDeNinjas.Missoes;

import dev.talles.CadastroDeNinjas.Ninjas.NinjaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissaoDTO {
    private Long id;
    private String nome;
    private char rank;
    private boolean concluida;
    private List<NinjaDTO> ninjas;

}
