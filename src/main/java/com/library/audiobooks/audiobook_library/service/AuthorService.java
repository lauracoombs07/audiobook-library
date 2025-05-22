package com.library.audiobooks.audiobook_library.service;

import com.library.audiobooks.audiobook_library.dto.AuthorDTO;
import com.library.audiobooks.audiobook_library.model.Author;
import com.library.audiobooks.audiobook_library.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {

  private final AuthorRepository authorRepository;

  public List<Author> getAllAuthors() {
    return authorRepository.findAll();
  }

  public Author getAuthorById(Long id) {
    return authorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Author not found"));
  }

  public List<Author> getAuthorsByFirstName(String firstName) {
    return authorRepository.findAllByFirstName(firstName);
  }

  public List<Author> getAuthorsByLastName(String lastName) {
    return authorRepository.findAllByLastName(lastName);
  }

  public Author createAuthor(AuthorDTO authorDTO) {
    Author authorDAO = new Author();
    BeanUtils.copyProperties(authorDTO, authorDAO);
    return authorRepository.save(authorDAO);
  }

  public Author updateAuthor(AuthorDTO authorToUpdate, Long id) {
    Author existingAuthor = authorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cannot find Author to update in the database"));

    BeanUtils.copyProperties(authorToUpdate, existingAuthor);

    existingAuthor.setLastModifiedDate(new Date());
    return authorRepository.save(existingAuthor);
  }

  public void deleteAuthor(Long id) {
    authorRepository.deleteById(id);
  }

//  public AuthorDTO getAuthorById(Long id) {
//    Author author = authorRepository.findById(id)
//            .orElseThrow(() -> new RuntimeException("Author not found"));
//
//    // Map entity to DTO
//    List<AudiobookSummaryDTO> sortedAudiobooks = author.getAudiobooks()
//            .stream()
//            .sorted(Comparator.comparing(Audiobook::getAudiobookTitle))
//            .map(a -> new AudiobookSummaryDTO(a.getId(), a.getAudiobookTitle()))
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


