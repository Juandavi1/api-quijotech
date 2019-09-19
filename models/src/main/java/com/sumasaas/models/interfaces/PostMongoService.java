package com.sumasaas.models.interfaces;

import com.sumasaas.models.dtos.PostDTO;
import com.sumasaas.models.dtos.PostDTOMongoExample;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PostMongoService {

    List<PostDTO> allRemote();

    /**
     *
     * @param postDTOMongoExample
     * @return
     */
    Mono<PostDTOMongoExample> create(final PostDTOMongoExample postDTOMongoExample);

    /**
     *
     * @return
     */
    Flux<PostDTOMongoExample> findAll();

    /**
     *
     * @return
     */
    Flux<PostDTOMongoExample> findAllByUser(final Integer id);
}
