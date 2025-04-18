package dev.talles.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso " + novoNinja.getNome() + "[ID:" +
                        novoNinja.getId()+"]");

    }

    //Mostar Ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
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
    public ResponseEntity<String> deletarNinjaId(@PathVariable Long id){
        if (ninjaService.ninjasPorId(id) != null) {
            ninjaService.deleterNinja(id);
            return ResponseEntity.ok("Ninja deletado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não encontrado");
    }
}
