package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.Option;
import com.logonedigital.PI.SCHULE.Repository.OptionRepository;
import com.logonedigital.PI.SCHULE.Service.Interface.IOptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OptionServiceImpl implements IOptionService {

    private final OptionRepository optionRepo;
    @Override
    public Option addOption(Option option) {
        return this.optionRepo.save(option);
    }

    @Override
    public List<Option> getOption() {
        return this.optionRepo.findAll();
    }

    @Override
    public Option getByName(String nom) {
        return this.optionRepo.findByNom(nom).get();
    }

    @Override
    public Option updateOption(String nom, Option option) {
        Option newOption = this.optionRepo.findByNom(nom).get();
        newOption.setNom(option.getNom());
        return this.optionRepo.saveAndFlush(newOption);
    }

    @Override
    public void deleteOption(String nom) {
        Option option = this.optionRepo.findByNom(nom).get();
        this.optionRepo.delete(option);
    }
}
