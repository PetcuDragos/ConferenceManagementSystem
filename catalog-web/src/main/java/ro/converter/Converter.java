package ro.converter;

import ro.domain.BaseEntity;
import ro.dto.BaseDto;


public interface Converter<Model extends BaseEntity, Dto extends BaseDto> {

    Dto convertModelToDto(Model model);
}

