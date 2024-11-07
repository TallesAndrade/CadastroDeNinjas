package dev.talles.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

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
    @GetMapping("/todos")
    public String montarTodosNinjas(){
        return "Ninjas";
    }

    //Mostar Ninjas ID (READ)
    @GetMapping("/todosID")
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
