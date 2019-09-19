package com.sumasaas.maps;

import com.sumasaas.models.dtos.PostDTO;
import com.sumasaas.remote.RemotePost;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 *
 */
@Mapper(componentModel = "spring")
public interface PostMapper {

    List<RemotePost> dtoToRemote(final List<PostDTO> source);

    @Mapping(target="id_random", source="id")
    PostDTO remoteToDto(final RemotePost source);
}
