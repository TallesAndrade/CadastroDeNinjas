package dev.talles.CadastroDeNinjas.Missoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissaoController {
    @Autowired
    private MissaoService missaoService;

    //POST - mandar requisição pra criar missões
    @PostMapping("/criar")
    public MissaoModel criarMissao(@RequestBody MissaoModel missaoModel){
        return missaoService.criarMissao(missaoModel);
    }

    //GET - mandar requisição pra listar missões
    @GetMapping("/listar")
    public List<MissaoModel> listarMissao(){
        return missaoService.listarMissao();
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
