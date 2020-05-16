package ro.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.domain.Abstract;
import ro.domain.Author;
import ro.domain.Paper;
import ro.dto.PublishedPaperDto;
import ro.repository.AbstractRepository;
import ro.repository.AuthorRepository;
import ro.repository.MyUserRepository;

@Component
public class PublishedPaperConverter extends BaseConverter<Paper, PublishedPaperDto> {
    @Autowired
    AbstractRepository abstractRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    MyUserRepository myUserRepository;

    @Override
    public Paper convertDtoToModel(PublishedPaperDto dto) {
        return null;
    }

    @Override
    public PublishedPaperDto convertModelToDto(Paper paper) {
        // todo: make it less taranesque
        Long userID = authorRepository.findById(paper.getAuthor_id()).get().getUser_id();

        PublishedPaperDto publishedPaperDto = new PublishedPaperDto(paper.getDocument(),
                paper.getConference_id(),
                paper.getAuthor_id(),
                paper.getAbstract_id(),
                paper.getSection_id(),
                abstractRepository.findById(paper.getAbstract_id()).get().getName(),
                abstractRepository.findById(paper.getAbstract_id()).get().getContent(),
                myUserRepository.findById(userID).get().getFullName());
        publishedPaperDto.setId(paper.getId());
        return publishedPaperDto;
    }
}
