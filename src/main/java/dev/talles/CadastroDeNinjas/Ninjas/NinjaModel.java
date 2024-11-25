package dev.talles.CadastroDeNinjas.Ninjas;

import dev.talles.CadastroDeNinjas.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Table(name = "tb_cadastro")
@AllArgsConstructor
@NoArgsConstructor
@Data



public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "nome")
    private String nome;

    @Column (unique = true,name = "email")
    private String email;

    @Column (name = "img_url")
    private String imgUrl;

    @Column (name = "idade")
    private int idade;

    @Column(name = "rank")
    private String rank;

    //@ManyToOne um ninja tem um missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Foreing key ou  chave estrangeira
    private MissaoModel missao;


}
