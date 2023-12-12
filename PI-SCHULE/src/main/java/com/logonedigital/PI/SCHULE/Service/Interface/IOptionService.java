package com.logonedigital.PI.SCHULE.Service.Interface;

import com.logonedigital.PI.SCHULE.Entity.Option;

import java.util.List;

public interface IOptionService {
    Option addOption (Option option);
    List<Option> getOption ();

    Option getByName(String nom);
    Option updateOption (String nom,Option option);
    void deleteOption (String nom);
}
