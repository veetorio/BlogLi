package com.example.liblog.service;

import com.example.liblog.dto.dto_response.DtoPost;
import com.example.liblog.models.Post;
import com.example.liblog.repository.RepositoryPostagem;
import com.example.liblog.service.util.SimplifierAction;
import com.example.liblog.service.util.Validates;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ServicePostagem implements Validates, SimplifierAction {
    @Autowired
    RepositoryPostagem repositoryPostagem;

    public List<DtoPost> findAll(){
        List<Post> listaLivros = repositoryPostagem.findAll();
        return listInDtoPost(listaLivros);
    }
    public List findByName(String name){
        List post  = repositoryPostagem.findByNameContaining(name);
        emptyList(post,"post");
        return listInDtoPost(post);
    }
    public DtoPost create(Post livro){
        repositoryPostagem.save(livro);
        return postInDtoPost(livro);
    }
    public DtoPost delete(Long id){
        Post dto = repositoryPostagem.findById(id).orElseThrow();
        repositoryPostagem.delete(dto);
        return postInDtoPost(dto);
    }
    public DtoPost update(Post post){
        Post postAfter = repositoryPostagem.findById(post.getId()).orElseThrow();
        Exist(postAfter);
        Post DtoPost = (Post) setterUpdate(post,postAfter);
        return postInDtoPost(DtoPost);
    }
}