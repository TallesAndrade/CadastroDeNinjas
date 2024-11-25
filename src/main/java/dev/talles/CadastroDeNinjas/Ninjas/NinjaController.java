package dev.talles.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/hello-world")
    public String boasVinda(){
        return "Hello World";

    }

    //Add Ninja(CREATE)
    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinja(ninja);

    }

    //Mostar Ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    //Mostar Ninjas ID (READ)
    @GetMapping("/listar/{id}")
    public NinjaDTO ninjasPorId(@PathVariable Long id){
       return ninjaService.ninjasPorId(id);
    }



    //Alterar dados ninja(UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinjaId(@PathVariable Long id,@RequestBody NinjaDTO ninjaAtualizado){
        return ninjaService.atulizarNinja(ninjaAtualizado,id);
    }

    //Deletar ninja(DELETE)
    @DeleteMapping("deletar/{id}")
    public void deletarNinjaId(@PathVariable Long id){
        ninjaService.deleterNinja(id);
    }
}
