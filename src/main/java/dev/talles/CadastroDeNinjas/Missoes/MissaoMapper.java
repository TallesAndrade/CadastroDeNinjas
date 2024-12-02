package dev.talles.CadastroDeNinjas.Missoes;
import dev.talles.CadastroDeNinjas.Ninjas.NinjaDTO;
import dev.talles.CadastroDeNinjas.Ninjas.NinjaMapper;
import dev.talles.CadastroDeNinjas.Ninjas.NinjaModel;
import java.util.ArrayList;
import java.util.List;

public class MissaoMapper {

    private  NinjaMapper ninjaMapper;

    public MissaoMapper(NinjaMapper ninjaMapper) {
        this.ninjaMapper = ninjaMapper;
    }
    public MissaoModel map(MissaoDTO missaoDTO){
        MissaoModel missaoModel = new MissaoModel();
        missaoModel.setNome(missaoDTO.getNome());
        missaoModel.setId(missaoDTO.getId());
        missaoModel.setRank(missaoDTO.getRank());
        missaoModel.setConcluida(missaoDTO.isConcluida());

        List<NinjaModel> ninjaModels = new ArrayList<>();
        for (NinjaDTO ninjaDTO :missaoDTO.getNinjas()){
            NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
            ninjaModels.add(ninjaModel);
        }
        missaoModel.setNinjas(ninjaModels);
     return missaoModel;
    }
    public MissaoDTO map(MissaoModel missaoModel){
        MissaoDTO missaoDTO = new MissaoDTO();
        missaoDTO.setNome(missaoModel.getNome());
        missaoDTO.setId(missaoModel.getId());
        missaoDTO.setRank(missaoModel.getRank());
        missaoDTO.setConcluida(missaoModel.isConcluida());
        List<NinjaDTO> ninjaDTOS = new ArrayList<>();

        for (NinjaModel ninjaModel : missaoModel.getNinjas()){
            NinjaDTO ninjaDTO = ninjaMapper.map(ninjaModel);
            ninjaDTOS.add(ninjaDTO);
        }
        missaoDTO.setNinjas(ninjaDTOS);
        return missaoDTO;
    }
}