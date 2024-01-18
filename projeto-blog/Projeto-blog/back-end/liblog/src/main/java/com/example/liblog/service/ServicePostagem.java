package com.example.liblog.service;

import com.example.liblog.dto.dto_response.DtoPost;
import com.example.liblog.models.Post;
import com.example.liblog.models.Usuario;
import com.example.liblog.repository.RepositoryPostagem;
import com.example.liblog.repository.RepositoryUsuario;
import com.example.liblog.service.util.SimplifierAction;
import com.example.liblog.service.util.Validates;
import com.github.slugify.Slugify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePostagem implements Validates, SimplifierAction {
    @Autowired
    RepositoryPostagem repositoryPostagem;

    private Slugify slug = new Slugify();
    @Autowired
    private RepositoryUsuario repositoryUsuario;
    public List<DtoPost> findAll(){
        List<Post> listaLivros = repositoryPostagem.findAll();
        return listInDtoPost(listaLivros);
    }
    public List findByName(String name){
        List post  = repositoryPostagem.findByNameContaining((name));
        emptyList(post,"post");
        return listInDtoPost(post);
    }
    public DtoPost create(Post livro){
        Usuario user = repositoryUsuario.findById(livro.getUser().getId()).orElseThrow();
        livro.setSlugTitle(slug.slugify(livro.getNome()));
        livro.setTokenuser(user.getToken());
        livro.setHoursdate(setTiming());
        livro.setData(setDate());
        repositoryPostagem.save(livro);
        return postInDtoPost(livro);
    }
    public DtoPost delete(String id){
        Post dto = repositoryPostagem.findByName(id);
        Exist(dto);
        repositoryPostagem.delete(dto);
        return postInDtoPost(dto);
    }
    public DtoPost update(Post post){
        Post postAfter = repositoryPostagem.findById(post.getId()).orElseThrow();
        Exist(postAfter);
        Post DtoPost = (Post) setterUpdate(post,postAfter);
        return postInDtoPost(DtoPost);
    }
    public void authorized(String token,String name){
        IsAuthorized(token,name,repositoryUsuario);
    }

}