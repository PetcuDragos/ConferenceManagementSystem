package ro.converter;

import org.springframework.stereotype.Component;
import ro.domain.Paper;
import ro.dto.PaperDto;

@Component
public class PaperConverter extends BaseConverter<Paper, PaperDto> {
    @Override
    public Paper convertDtoToModel(PaperDto dto) {
        return null;
    }

    @Override
    public PaperDto convertModelToDto(Paper paper) {
        PaperDto paperDto = new PaperDto(paper.getDocument(),paper.getConference_id(),paper.getAuthor_id(),paper.getAbstract_id());
        paperDto.setId(paper.getId());
        return paperDto;
    }
}
