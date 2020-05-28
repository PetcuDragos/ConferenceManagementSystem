package ro.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.domain.*;
import ro.dto.PublishedPaperDto;
import ro.repository.*;

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

    @Autowired
    SectionRepository sectionRepository;

    @Override
    public PublishedPaper convertDtoToModel(PublishedPaperDto dto) {
        return null;
    }

    @Override
    public PublishedPaperDto convertModelToDto(PublishedPaper publishedPaper) {
        // todo: make it less taranesque
        Paper paper = paperRepository.findById(publishedPaper.getPaper_id()).get();
        Long userID = authorRepository.findById(paper.getAuthor_id()).get().getUser_id();
        Section section = sectionRepository.findById(publishedPaper.getSection_id()).orElse(null);
        String section_name = null;
        if(section!=null) section_name = section.getName();
        PublishedPaperDto publishedPaperDto = new PublishedPaperDto(paper.getDocument(),
                paper.getConference_id(),
                paper.getAuthor_id(),
                paper.getAbstract_id(),
                section_name,
                abstractRepository.findById(paper.getAbstract_id()).get().getName(),
                abstractRepository.findById(paper.getAbstract_id()).get().getContent(),
                myUserRepository.findById(userID).get().getFullName());
        publishedPaperDto.setId(paper.getId());
        return publishedPaperDto;
    }
}
