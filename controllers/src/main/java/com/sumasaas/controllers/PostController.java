package com.sumasaas.controllers;

import com.sumasaas.models.dtos.PostDTO;
import com.sumasaas.models.dtos.PostDTOMongoExample;
import com.sumasaas.models.interfaces.PostMongoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@Slf4j
public class PostController {

  @Autowired public PostMongoService postService;

  @GetMapping
  public List<PostDTO> rest() {
        log.info("obtener informacion desde el rest client");
      return postService.allRemote();
  }

  @GetMapping("post")
  public Flux<PostDTOMongoExample> findAll() {
      log.info("obtener todos los post de la bd");
    return this.postService.findAll();
  }

  @GetMapping("post/{id}")
  public Flux<PostDTOMongoExample> findOne(@PathVariable() Integer id) {
        log.info(String.format("consultando post: %d", id));
      return this.postService.findAllByUser(id);
  }

  @PostMapping()
  public Mono<PostDTOMongoExample> save(
      @RequestBody final PostDTOMongoExample postDTOMongoExample
  ) {
      log.info(String.format("guardando post: %s", postDTOMongoExample.toString()));
    return this.postService.create(postDTOMongoExample);
  }
}
