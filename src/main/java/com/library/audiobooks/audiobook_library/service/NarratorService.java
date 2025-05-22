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

  // --------------------------- return CompleteDTO

  public NarratorCompleteDTO getNarratorCompleteById(Long id) {
    Narrator narratorDAO = narratorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Unable to find a Narrator with that id in the database"));
    NarratorCompleteDTO blah = new NarratorCompleteDTO();
    BeanUtils.copyProperties(narratorDAO, blah);
    blah.setAudiobooks(narratorDAO.getAudiobooks());
    return blah;
  }

  // --------------------------- return DAO

  public Narrator getNarratorById(Long id) {
    return narratorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cannot find Narrator with this id"));
  }

  public List<Narrator> getNarratorByFirstName(String firstName) {
    return narratorRepository.findAllByLastName(firstName);
  }

  public List<Narrator> getNarratorByLastName(String lastName) {
    return narratorRepository.findAllByLastName(lastName);
  }

  // --------------------------- Create

  public Narrator createNarrator(NarratorDTO narratorDTO) {
    Narrator narratorDAO = new Narrator();
    BeanUtils.copyProperties(narratorDTO, narratorDAO);
    return narratorRepository.save(narratorDAO);
  }
}
