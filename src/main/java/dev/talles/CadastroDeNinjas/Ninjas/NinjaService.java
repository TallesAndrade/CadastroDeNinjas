package dev.talles.CadastroDeNinjas.Ninjas;

import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    


    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    public NinjaModel ninjasPorId(Long id){
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.orElse(null);
    }

    public NinjaModel criarNinja(NinjaModel ninja){

        return ninjaRepository.save(ninja);
    }

    public void deleterNinja(Long id){
        ninjaRepository.deleteById(id);
    }

    public NinjaModel atulizarNinja(NinjaModel ninjaAtualizado , Long id){
        NinjaModel ninjaExistente = ninjaRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id,"NinjaModel"));
       if (ninjaAtualizado.getNome() != null){
           ninjaExistente.setNome(ninjaAtualizado.getNome());
       }
        if (ninjaAtualizado.getEmail() != null){
            ninjaExistente.setEmail(ninjaAtualizado.getEmail());
        }
        if (ninjaAtualizado.getIdade() != 0){
            ninjaExistente.setIdade(ninjaAtualizado.getIdade());
        }
        if (ninjaAtualizado.getImgUrl() != null){
            ninjaExistente.setImgUrl(ninjaAtualizado.getImgUrl());
        }
        if (ninjaAtualizado.getMissao() != null ){
            ninjaExistente.setMissao(ninjaAtualizado.getMissao());
        }
        return ninjaRepository.save(ninjaExistente) ;
    }
}
