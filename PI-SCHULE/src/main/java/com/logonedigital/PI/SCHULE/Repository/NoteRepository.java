package com.logonedigital.PI.SCHULE.Repository;

import com.logonedigital.PI.SCHULE.Entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, String> {
    Optional <Note>findByNomMatiere(String nomMatiere );
    Optional<Note>findByCodeMatiere(String codematiere);
}
