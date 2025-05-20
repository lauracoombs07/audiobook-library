package com.library.audiobooks.audiobook_library.service;

import com.library.audiobooks.audiobook_library.dto.NarratorCompleteDTO;
import com.library.audiobooks.audiobook_library.dto.NarratorDTO;
import com.library.audiobooks.audiobook_library.model.Narrator;
import com.library.audiobooks.audiobook_library.repository.NarratorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NarratorService {

  private final NarratorRepository narratorRepository;

  public List<Narrator> getAllNarrators() {
    return narratorRepository.findAll();
  }

  public NarratorCompleteDTO getNarratorById(Long id) {
    Narrator narratorDAO = narratorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Unable to find a Narrator with that id in the database"));
    NarratorCompleteDTO blah = new NarratorCompleteDTO();
    BeanUtils.copyProperties(narratorDAO, blah);
    blah.setAudiobooks(narratorDAO.getAudiobooks());
    System.out.println("COMPLETE DTO" + blah);
    return blah;
  }

  public Narrator createNarrator(NarratorDTO narratorDTO) {
    Narrator narratorDAO = new Narrator();
    BeanUtils.copyProperties(narratorDTO, narratorDAO);
    return narratorRepository.save(narratorDAO);
  }
}
