package ro.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.domain.Abstract;
import ro.domain.Author;
import ro.domain.Paper;
import ro.domain.PublishedPaper;
import ro.dto.PublishedPaperDto;
import ro.repository.AbstractRepository;
import ro.repository.AuthorRepository;
import ro.repository.MyUserRepository;
import ro.repository.PaperRepository;

@Component
public class PublishedPaperConverter extends BaseConverter<PublishedPaper, PublishedPaperDto> {
    @Autowired
    AbstractRepository abstractRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    MyUserRepository myUserRepository;
    @Autowired
    PaperRepository paperRepository;

    @Override
    public PublishedPaper convertDtoToModel(PublishedPaperDto dto) {
        return null;
    }

    @Override
    public PublishedPaperDto convertModelToDto(PublishedPaper publishedPaper) {
        // todo: make it less taranesque
        Paper paper = paperRepository.findById(publishedPaper.getPaper_id()).get();
        Long userID = authorRepository.findById(paper.getAuthor_id()).get().getUser_id();

        PublishedPaperDto publishedPaperDto = new PublishedPaperDto(paper.getDocument(),
                paper.getConference_id(),
                paper.getAuthor_id(),
                paper.getAbstract_id(),
                publishedPaper.getSection_id(),
                abstractRepository.findById(paper.getAbstract_id()).get().getName(),
                abstractRepository.findById(paper.getAbstract_id()).get().getContent(),
                myUserRepository.findById(userID).get().getFullName());
        publishedPaperDto.setId(paper.getId());
        return publishedPaperDto;
    }
}
