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
    public String criarNinja(){
        return "Ninja Criado";
    }

    //Mostar Ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    //Mostar Ninjas ID (READ)
    @GetMapping("/listarID")
    public String ninjasPorId(){
        return "Ninjas Por ID";
    }

    //Alterar dados ninja(UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaId(){
        return "Alterar Ninja ID";
    }

    //Deletar ninja(DELETE)
    @DeleteMapping("deletarId")
    public String deletarNinjaId(){
        return "Ninja Deletado Por ID";
    }
}
