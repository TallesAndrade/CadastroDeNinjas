package dev.talles.CadastroDeNinjas.Missoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class MissaoService {
    @Autowired
    private MissaoRepository missaoRepository;

    public List<MissaoModel> listarMissao(){
        return missaoRepository.findAll();
    }


    public MissaoModel criarMissao(MissaoModel missaoModel){

        return missaoRepository.save(missaoModel);
    }
}
