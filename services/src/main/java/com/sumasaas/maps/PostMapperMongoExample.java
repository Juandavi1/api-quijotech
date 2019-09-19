package com.sumasaas.maps;

import com.sumasaas.models.dtos.PostDTO;
import com.sumasaas.models.dtos.PostDTOMongoExample;
import com.sumasaas.remote.RemotePost;
import com.sumasaas.repository.entities.PostMongoExample;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 *
 */
@Mapper(componentModel = "spring")
public interface PostMapperMongoExample {
    PostDTOMongoExample postToDto(final PostMongoExample source);
    PostMongoExample dtoToPost(final PostDTOMongoExample source);
}
