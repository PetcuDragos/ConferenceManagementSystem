package ro.converter;

import ro.domain.BaseEntity;
import ro.dto.BaseDto;

/**
 * Created by radu.
 */

public interface Converter<Model extends BaseEntity, Dto extends BaseDto> {

    Model convertDtoToModel(Dto dto);

    Dto convertModelToDto(Model model);

}

