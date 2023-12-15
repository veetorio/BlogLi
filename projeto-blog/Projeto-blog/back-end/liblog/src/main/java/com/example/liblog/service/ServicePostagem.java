package com.example.liblog.service;

import com.example.liblog.dto.DtoPostagem;
import com.example.liblog.exception.DuplicateException;
import com.example.liblog.exception.ReturnNullException;
import com.example.liblog.models.PostagemLivro;
import com.example.liblog.repository.RepositoryPostagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePostagem {
    @Autowired
    RepositoryPostagem repositoryPostagem;

    public List<DtoPostagem> findAll(){
        List<PostagemLivro> listaLivros = repositoryPostagem.findAll();
        return DtoPostagem.convertListDto(listaLivros);
    }
    
    public DtoPostagem findByName(String name){
       PostagemLivro livro = repositoryPostagem.findByName(name);
       isNull(livro);
       DtoPostagem dto = new DtoPostagem(livro);
       return dto;
    }

    public DtoPostagem create(PostagemLivro postagemLivro){
        isDuplicate(postagemLivro);
        repositoryPostagem.save(postagemLivro);
        return new DtoPostagem(postagemLivro);
    }

    public void delete(String name){
        PostagemLivro dto = repositoryPostagem.findByName(name);
        repositoryPostagem.delete(dto);
    }

    private void isNull(PostagemLivro livro){
        if(livro == null){
            throw new ReturnNullException("Elemento não encontrado");
        }
    }
    private void isDuplicate(PostagemLivro livro){
        List<PostagemLivro> post = repositoryPostagem.findAll().stream().toList();
        post.forEach(dto -> {
            boolean equalsname = dto.getNome().equals(livro.getNome());
            boolean equalscommentary = dto.getComentario().equals(livro.getComentario());
            if(equalsname){
                throw new DuplicateException("este nome já existe");
            }else if (equalscommentary) {
                throw new DuplicateException("este comentário já existe");
            }
        }
        );
    }
}
