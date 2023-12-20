package com.example.liblog.service;

import com.example.liblog.dto.dto_response.DtoPost;
import com.example.liblog.error.exception.NotExistUserException;
import com.example.liblog.error.exception.ReturnNullException;
import com.example.liblog.models.Post;
import com.example.liblog.models.Usuario;
import com.example.liblog.repository.RepositoryPostagem;
import com.example.liblog.repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePostagem {
    @Autowired
    RepositoryPostagem repositoryPostagem;
    @Autowired
    RepositoryUsuario repositoryUsuario;

    public List<DtoPost> findAll(){
        List<Post> listaLivros = repositoryPostagem.findAll();
        return repositoryPostagem.
                findAll()
                .stream()
                .map(livro -> new DtoPost(livro.getNome(), livro.getComentario(), livro.getUrl(), livro.getData(), livro.getHoursdate()))
                .toList();
    }

    public DtoPost findByName(String name){
       Post livro = repositoryPostagem.findByName(name);
       isNull(livro);
       DtoPost dto = new DtoPost(livro.getNome(), livro.getComentario(), livro.getUrl(), livro.getData(), livro.getHoursdate());
       return dto;
    }

    public DtoPost create(Post livro){
        ExistUser(livro);
        repositoryPostagem.save(livro);
        DtoPost tuple_dto = new DtoPost(livro.getNome(),livro.getComentario(), livro.getUrl(), livro.getData(), livro.getHoursdate());
        return tuple_dto;
    }

    public void delete(String name){
        Post dto = repositoryPostagem.findByName(name);
        repositoryPostagem.delete(dto);
    }

    private void isNull(Post livro){
        if(livro == null){
            throw new ReturnNullException("Elemento não encontrado");
        }
    }
    private void ExistUser(Post post){
        Usuario element = repositoryUsuario.findById(post.getUser().getId()).orElseThrow( () -> {throw new NotExistUserException("usuario não existe");});
    }

}
