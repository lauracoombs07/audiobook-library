package com.library.audiobooks.audiobook_library.controller;

import com.library.audiobooks.audiobook_library.dto.OwnerDTO;
import com.library.audiobooks.audiobook_library.model.Owner;
import com.library.audiobooks.audiobook_library.service.OwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/owners")
public class OwnerController {

  private final OwnerService ownerService;

  public OwnerController(OwnerService ownerService) {
    this.ownerService = ownerService;
  }

  /**
   * Get All {@link Owner}
   *
   * @return List of {@link Owner}
   */
  @GetMapping
  public ResponseEntity<List<Owner>> getAllOwners() {
    return ResponseEntity.status(HttpStatus.OK).body(ownerService.getAllOwners());
  }

  /**
   * Get {@link Owner} by optional Request Param
   *
   * @param id        optional id
   * @param lastName  optional lastName
   * @param firstName optional firstName
   * @return Owner
   */
  @GetMapping("/owner")
  public ResponseEntity<List<Owner>> getOwnerByRequestParam(
          @RequestParam Optional<Long> id,
          @RequestParam Optional<String> lastName,
          @RequestParam Optional<String> firstName
  ) {
    List<Owner> foundOwners = new ArrayList<>();
    if (id.isPresent()) {
      foundOwners.add(ownerService.getOwnerById(id.get()));
    }
    if (lastName.isPresent()) {
      foundOwners = ownerService.getOwnersByLastName(lastName.get());
    }
    if (firstName.isPresent()) {
      foundOwners = ownerService.getOwnersByFirstName(firstName.get());
    }

    return ResponseEntity.status(HttpStatus.OK).body(foundOwners);
  }

  /**
   * Create new {@link Owner}
   *
   * @return {@link OwnerDTO}
   */
  @PostMapping("/owner")
  public ResponseEntity<Owner> createNewOwner(
          @RequestBody OwnerDTO ownerToCreate
  ) {
    Owner createdOwner = ownerService.createOwner(ownerToCreate);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdOwner);
  }
}
