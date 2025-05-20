package com.library.audiobooks.audiobook_library.controller;

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
   * Get All Owners
   * @return List of Owners
   */
  @GetMapping
  public ResponseEntity<List<Owner>> getAllOwners() {
    return ResponseEntity.status(HttpStatus.OK).body(ownerService.getAllOwners());
  }

  /**
   * Get a single Owner by Id
   * @return Owner
   */
  @GetMapping("/owner")
  public ResponseEntity<List<Owner>> getOwnerByRequestParam(
          @RequestParam Optional<Long> id,
          @RequestParam Optional<String> lastName,
          @RequestParam Optional<String> firstName
  ) {
    List<Owner> foundOwners = new ArrayList<>();
    if(id.isPresent()) {
      foundOwners.add(ownerService.getOwnerById(id.get()));
    }
    if(lastName.isPresent()) {
      foundOwners = ownerService.getOwnersByLastName(lastName.get());
    }
    if(firstName.isPresent()) {
      foundOwners = ownerService.getOwnersByFirstName(firstName.get());
    }

    return ResponseEntity.status(HttpStatus.OK).body(foundOwners);
  }

}
