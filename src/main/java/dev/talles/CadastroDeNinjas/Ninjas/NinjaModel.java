package dev.talles.CadastroDeNinjas.Ninjas;

import dev.talles.CadastroDeNinjas.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private int idade;

    //@ManyToOne um ninja tem um missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Foreing key ou  chave estrangeira
    private MissaoModel missao;


}
