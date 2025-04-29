package com.library.audiobooks.audiobook_library.service;

import com.library.audiobooks.audiobook_library.dto.AudiobookSummaryDTO;
import com.library.audiobooks.audiobook_library.dto.AuthorDTO;
import com.library.audiobooks.audiobook_library.model.Author;
import com.library.audiobooks.audiobook_library.model.Audiobook;
import com.library.audiobooks.audiobook_library.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {

  private final AuthorRepository authorRepository;

  public AuthorDTO getAuthorById(Long id) {
    Author author = authorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Author not found"));

    // Map entity to DTO
    List<AudiobookSummaryDTO> sortedAudiobooks = author.getAudiobooks()
            .stream()
            .sorted(Comparator.comparing(Audiobook::getTitle))
            .map(a -> new AudiobookSummaryDTO(a.getId(), a.getTitle()))
            .collect(Collectors.toList());

    AuthorDTO dto = new AuthorDTO();
    dto.setId(author.getId());
    dto.setFirstName(author.getFirstName());
    dto.setLastName(author.getLastName());
    dto.setAudiobooks(sortedAudiobooks);

    return dto;
  }

  public Set<Author> findAuthorsByIds(List<Long> authorIds) {
    List<Author> authors = authorRepository.findAllById(authorIds);
    if (authors.isEmpty() || authors.size() != authorIds.size()) {
      throw new RuntimeException("One or more authors not found.");
    }
    System.out.println("AUTHORS:" + authors);
    return new HashSet<>(authors);
  }

  public List<AuthorDTO> convertToDTOs(Set<Author> authors) {
    return authors.stream().map(author -> {
      AuthorDTO dto = new AuthorDTO();
      BeanUtils.copyProperties(author, dto);
      return dto;
    }).collect(Collectors.toList());
  }

//  public AuthorDTO getAuthor(Long id) {
//    Author author = authorRepository.findById(id)
//            .orElseThrow(() -> new RuntimeException("Author not found"));
//
//    List<AudiobookSummaryDTO> sortedAudiobooks = author.getAudiobooks()
//            .stream()
//            .sorted(Comparator.comparing(Audiobook::getTitle))
//            .map(a -> new AudiobookSummaryDTO(a.getId(), a.getTitle()))
//            .collect(Collectors.toList());
//
//    AuthorDTO dto = new AuthorDTO();
//    dto.setId(author.getId());
//    dto.setFirstName(author.getFirstName());
//    dto.setLastName(author.getLastName());
//    dto.setAudiobooks(sortedAudiobooks);
//
//    return dto;
//  }
}


