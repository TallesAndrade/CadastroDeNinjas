package dev.talles.CadastroDeNinjas.Missoes;

import dev.talles.CadastroDeNinjas.Ninjas.NinjaDTO;
import dev.talles.CadastroDeNinjas.Ninjas.NinjaMapper;
import dev.talles.CadastroDeNinjas.Ninjas.NinjaModel;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MissaoService {
    private final MissaoRepository missaoRepository;
    private final  MissaoMapper missaoMapper;
    private final NinjaMapper ninjaMapper;


    public MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper,NinjaMapper ninjaMapper) {
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
        this.ninjaMapper = ninjaMapper;
    }

    public List<MissaoDTO> listarMissao(){
        List<MissaoModel> missaoModelList = missaoRepository.findAll();
        List<MissaoDTO> missaoDTOList = new ArrayList<>();
        for (MissaoModel missaoModel : missaoModelList){
            MissaoDTO missaoDTO = missaoMapper.map(missaoModel);
            missaoDTOList.add(missaoDTO);
        }
        return missaoDTOList;
    }


    public MissaoDTO criarMissao(MissaoDTO missaoDTO){
        MissaoModel missao = missaoMapper.map(missaoDTO);
        missao = missaoRepository.save(missao);
        return missaoMapper.map(missao);
    }

    public MissaoDTO alterarMissao(MissaoDTO missaoDTO,Long id){
        MissaoModel missaoExistente = missaoRepository.findById(id).orElseThrow();

        if (missaoDTO.getNome() != null){
            missaoExistente.setNome(missaoDTO.getNome());
        }
        if (missaoDTO.getRank() != '\u0000'){
            missaoExistente.setRank(missaoDTO.getRank());

        }
        if (missaoDTO.isConcluida()){
            missaoExistente.setConcluida(missaoDTO.isConcluida());
        }
        return missaoMapper.map(missaoRepository.save(missaoExistente));

    }

    public void deleterMissao(Long id){
        missaoRepository.deleteById(id);
    }

    public List<NinjaDTO> ninjasMissao(Long id){
        MissaoModel missaoModel = missaoRepository.findById(id).orElseThrow();
        List<NinjaDTO> ninjaDTOS = new ArrayList<>();
        for (NinjaModel ninjaModel: missaoModel.getNinjas()){
            ninjaDTOS.add(ninjaMapper.map(ninjaModel));
        }
        return ninjaDTOS;
    }

}
