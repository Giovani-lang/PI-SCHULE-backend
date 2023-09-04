package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.Note;
import com.logonedigital.PI.SCHULE.Entity.Releve;
import com.logonedigital.PI.SCHULE.Exception.RessourceExistException;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Mapper.ReleveMapper;
import com.logonedigital.PI.SCHULE.Repository.NoteRepository;
import com.logonedigital.PI.SCHULE.Repository.ReleveRepository;
import com.logonedigital.PI.SCHULE.Service.Interface.IReleveService;
import com.logonedigital.PI.SCHULE.dto.releve_dto.ReleveRequest;
import com.logonedigital.PI.SCHULE.dto.releve_dto.ReleveResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ReleveServiceImpl implements IReleveService {

    private final ReleveRepository releveRepo;
    private final ReleveMapper releveMapper;
    private final NoteRepository noteRepo;

    public ReleveServiceImpl(ReleveRepository releveRepo, ReleveMapper releveMapper, NoteRepository noteRepo) {
        this.releveRepo = releveRepo;
        this.releveMapper = releveMapper;
        this.noteRepo = noteRepo;
    }

    @Override
    public ReleveResponse addModule(ReleveRequest releve) throws RessourceExistException {
        Releve re = this.releveMapper.fromReleveRequest(releve);
        Optional<Releve> rel = this.releveRepo.findByModule(releve.getModule());
        if (rel.isPresent()){
            throw new RessourceExistException("A module with this name already exists");
        }
//        Note note = this.noteRepo.findByCodeMatiere(releve.getCodeMatiere())
//                .orElseThrow(()-> new RessourceNotFoundException("This matiere doesn't exist, add it if you want to use it"));
//        re.setNotes((List<Note>) note);
        return this.releveMapper.fromReleve(this.releveRepo.save(re));
    }
    @Override
    public ReleveResponse getModule(String module) throws RessourceNotFoundException {
       try {
           return this.releveMapper.fromReleve(this.releveRepo.findById(module).get());
       }catch (Exception ex){
           throw new RessourceNotFoundException("this module : "+module+" doesn't exist in our data base");
       }
    }

    @Override
    public List<ReleveResponse> getModule() {
        List<Releve> releves = this.releveRepo.findAll();
        List<ReleveResponse> releveResponses = new ArrayList<>();
        releves.forEach(releve -> releveResponses.add(this.releveMapper.fromReleve(releve)));
        return releveResponses;
    }

    @Override
    public ReleveResponse updateModule(String module, ReleveRequest releve) throws RessourceNotFoundException{
        try {
            Releve newReleve = this.releveRepo.findById(module).get();
            newReleve.setDecision(releve.getDecision());
            newReleve.setModule(releve.getModule());
            return this.releveMapper.fromReleve(this.releveRepo.saveAndFlush(newReleve));
        }catch (Exception ex){
            throw new RessourceNotFoundException("this module : "+module+" doesn't exist in our data base");
        }
    }

    @Override
    public void deleteModule(String module) throws RessourceNotFoundException{
            try {
                this.releveRepo.deleteById(module);
            }catch (Exception ex){
                throw new RessourceNotFoundException("this module : "+module+" doesn't exist in our data base");
            }
    }

}
