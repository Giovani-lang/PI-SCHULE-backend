package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.Releve;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Repository.ReleveRepository;
import com.logonedigital.PI.SCHULE.Service.Interface.IReleveService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReleveServiceImpl implements IReleveService {

    private final ReleveRepository releveRepo;

    public ReleveServiceImpl(ReleveRepository releveRepo) {
        this.releveRepo = releveRepo;
    }

    @Override
    public Releve addModule(Releve releve) {
        return this.releveRepo.save(releve);
    }

    @Override
    public Releve getModule(String module) throws RessourceNotFoundException {
       try {
           return this.releveRepo.findById(module).get();
       }catch (Exception ex){
           throw new RessourceNotFoundException("this module : "+module+" doesn't exist in our data base");
       }
    }

    @Override
    public List<Releve> getModule() {
        return this.releveRepo.findAll();
    }

    @Override
    public Releve updateModule(String module, Releve releve) throws RessourceNotFoundException{
        try {
            Releve newReleve = this.releveRepo.findById(module).get();
            newReleve.setStatut(releve.getStatut());
            return this.releveRepo.save(newReleve);
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
