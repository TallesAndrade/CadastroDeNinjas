package dev.talles.CadastroDeNinjas.Missoes;

import dev.talles.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissaoController {

    private MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

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
    @PutMapping("/alterar/{id}")
    public MissaoModel alterarMissao(@PathVariable Long id, @RequestBody MissaoModel missaoAtualizada){
        return missaoService.alterarMissao(missaoAtualizada,id);
    }

    //DELETE - mandar requisição pra deletar missões
    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id){
        missaoService.deleterMissao(id);
    }

    @GetMapping("/listarNinjasMissao/{id}")
    public List<NinjaModel> ninjasMissao(@PathVariable Long id){
        return missaoService.ninjasMissao(id);
    }
}
