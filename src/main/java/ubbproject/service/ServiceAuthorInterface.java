package ubbproject.service;

import ubbproject.domain.Author;

import java.util.List;

public interface ServiceAuthorInterface {

    void addAuthor(Author author);

    void deleteAuthor(Integer id);

    void updateAuthor(Author author);

    List<Author> getAllAuthors();
}
