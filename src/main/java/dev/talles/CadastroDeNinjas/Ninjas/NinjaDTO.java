package dev.talles.CadastroDeNinjas.Ninjas;

import dev.talles.CadastroDeNinjas.Missoes.MissaoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {
    private Long id;
    private String nome;
    private String email;
    private String imgUrl;
    private int idade;
    private MissaoModel missao;
    private String rank;
}
