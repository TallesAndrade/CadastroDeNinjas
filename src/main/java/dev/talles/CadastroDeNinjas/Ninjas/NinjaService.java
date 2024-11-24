package dev.talles.CadastroDeNinjas.Ninjas;

import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaDTO> listarNinjas(){
        List<NinjaModel> ninjaList = ninjaRepository.findAll();
        List<NinjaDTO> ninjaDTOList = new ArrayList<>();
        for (NinjaModel ninjaModel : ninjaList){
            NinjaDTO ninjaDTO = ninjaMapper.map(ninjaModel);
            ninjaDTOList.add(ninjaDTO);
        }

        return ninjaDTOList;

    }

    public NinjaDTO ninjasPorId(Long id){
        NinjaModel ninjaModel = ninjaRepository.findById(id).orElseThrow();
        NinjaDTO ninjaDTO = ninjaMapper.map(ninjaModel);

        return ninjaDTO;
    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
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
