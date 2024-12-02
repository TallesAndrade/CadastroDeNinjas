package dev.talles.CadastroDeNinjas.Missoes;

import dev.talles.CadastroDeNinjas.Ninjas.NinjaDTO;
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
    public MissaoDTO criarMissao(@RequestBody MissaoDTO missaoDTO){
        return missaoService.criarMissao(missaoDTO);
    }

    //GET - mandar requisição pra listar missões
    @GetMapping("/listar")
    public List<MissaoDTO> listarMissao(){
        return missaoService.listarMissao();
    }

    //PUT - mandar requisição pra alterar missões
    @PutMapping("/alterar/{id}")
    public MissaoDTO alterarMissao(@PathVariable Long id, @RequestBody MissaoDTO missaoAtualizada){
        return missaoService.alterarMissao(missaoAtualizada,id);
    }

    //DELETE - mandar requisição pra deletar missões
    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id){
        missaoService.deleterMissao(id);
    }

    @GetMapping("/listarNinjasMissao/{id}")
    public List<NinjaDTO> ninjasMissao(@PathVariable Long id){
        return missaoService.ninjasMissao(id);
    }
}
