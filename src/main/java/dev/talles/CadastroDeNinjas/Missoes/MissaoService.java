package dev.talles.CadastroDeNinjas.Missoes;

import dev.talles.CadastroDeNinjas.Ninjas.NinjaModel;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MissaoService {
    private MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    public List<MissaoModel> listarMissao(){
        return missaoRepository.findAll();
    }


    public MissaoModel criarMissao(MissaoModel missaoModel){

        return missaoRepository.save(missaoModel);
    }

    public MissaoModel alterarMissao(MissaoModel missaoAtualizada,Long id){
        MissaoModel missaoExistente = missaoRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException(id,"MissaoModel"));

        if (missaoAtualizada.getNome() != null){
            missaoExistente.setNome(missaoAtualizada.getNome());
        }
        if (missaoAtualizada.getRank() != '\u0000'){
            missaoExistente.setRank(missaoAtualizada.getRank());

        }
        return missaoRepository.save(missaoExistente);

    }

    public List<NinjaModel> ninjasMissao(Long id){
        MissaoModel missaoModel = missaoRepository.findById(id).orElseThrow();

        return missaoModel.getNinjas();
    }

}
