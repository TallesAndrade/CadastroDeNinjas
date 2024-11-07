package dev.talles.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissaoController {

    //POST - mandar requisição pra criar missões
    @PostMapping("/criar")
    public String criarMissao(){
        return "missao criada";
    }

    //GET - mandar requisição pra listar missões
    @GetMapping("/listar")
    public String mostrarMissoes(){
        return "Missoes";
    }

    //PUT - mandar requisição pra alterar missões
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missao alterad com sucesso";
    }

    //DELETE - mandar requisição pra deletar missões
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao deletada";
    }
}
