package com.library.audiobooks.audiobook_library.service;

import com.library.audiobooks.audiobook_library.dto.OwnerDTO;
import com.library.audiobooks.audiobook_library.model.Owner;
import com.library.audiobooks.audiobook_library.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // if not here, Service May not have been initialized...
public class OwnerService {
  private final OwnerRepository ownerRepository;

  public List<Owner> getAllOwners() {
    return ownerRepository.findAll();
  }

  public Owner getOwnerById(Long id){
    return ownerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Owner id does not exist in the database"));
  }

  public List<Owner> getOwnersByLastName(String lastName) {
    return ownerRepository.findAllByLastName(lastName);
  }

  public List<Owner> getOwnersByFirstName(String firstName) {
    return ownerRepository.findAllByFirstName(firstName);
  }

  public Owner createOwner(OwnerDTO ownerDTO) {

    Owner ownerDAO = new Owner();
    BeanUtils.copyProperties(ownerDTO, ownerDAO);
    return ownerRepository.save(ownerDAO);
  }

}
