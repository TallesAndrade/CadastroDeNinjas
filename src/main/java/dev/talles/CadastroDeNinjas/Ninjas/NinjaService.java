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

    public NinjaDTO atulizarNinja(NinjaDTO ninjaDTO  , Long id){
        NinjaModel ninjaExistente = ninjaRepository.findById(id)
                .orElseThrow();
       if (ninjaDTO.getNome() != null){
           ninjaExistente.setNome(ninjaDTO.getNome());
       }
        if (ninjaDTO.getEmail() != null){
            ninjaExistente.setEmail(ninjaDTO.getEmail());
        }
        if (ninjaDTO.getIdade() != 0){
            ninjaExistente.setIdade(ninjaDTO.getIdade());
        }
        if (ninjaDTO.getImgUrl() != null){
            ninjaExistente.setImgUrl(ninjaDTO.getImgUrl());
        }
        if (ninjaDTO.getMissao() != null ){
            ninjaExistente.setMissao(ninjaDTO.getMissao());
        }


        return ninjaMapper.map(ninjaRepository.save(ninjaExistente)) ;
    }
}
