package dev.talles.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {
    public NinjaModel map(NinjaDTO ninjaDTO){
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setImgUrl(ninjaDTO.getImgUrl());
        ninjaModel.setMissao(ninjaDTO.getMissao());
        ninjaModel.setRank(ninjaModel.getRank());
        return ninjaModel;
    }
    public NinjaDTO map(NinjaModel ninjaModel) {
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setImgUrl(ninjaModel.getImgUrl());
        ninjaDTO.setMissao(ninjaModel.getMissao());
        ninjaDTO.setRank(ninjaModel.getRank());
        return ninjaDTO;
    }
}
