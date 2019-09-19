package com.sumasaas.services;

import com.sumasaas.maps.PostMapper;
import com.sumasaas.maps.PostMapperMongoExample;
import com.sumasaas.models.dtos.PostDTO;
import com.sumasaas.models.dtos.PostDTOMongoExample;
import com.sumasaas.models.interfaces.PostMongoService;
import com.sumasaas.remote.PostClient;
import com.sumasaas.repository.persistence.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements PostMongoService {

    @Autowired
    public PostClient postClient;

    @Autowired
    public PostMapper postMapper;

    @Autowired
    public PostMapperMongoExample postMapperMongoExample;

    @Autowired
    public PostRepository postRepository;

    /**
     *
     * @return
     */
    @Override
    public List<PostDTO> allRemote() {
        return this.postClient
                .getAll()
                .stream()
                .map(this.postMapper::remoteToDto)
                .collect(Collectors.toList());
    }

    /**
     *
     * @param postDTOMongoExample
     * @return
     */
    @Override
    public Mono<PostDTOMongoExample> create(final PostDTOMongoExample postDTOMongoExample){
        return this.postRepository
                .save(this.postMapperMongoExample.dtoToPost(postDTOMongoExample))
                .map(this.postMapperMongoExample::postToDto);
    }

    /**
     *
     * @return
     */
    @Override
    public Flux<PostDTOMongoExample> findAll(){
        return this.postRepository
                .findAll()
                .map(this.postMapperMongoExample::postToDto);
    }

    /**
     *
     * @return
     */
    @Override
    public Flux<PostDTOMongoExample> findAllByUser(final Integer id){
        return this.postRepository
                .findAllByUserId(id)
                .map(this.postMapperMongoExample::postToDto);
    }
}
