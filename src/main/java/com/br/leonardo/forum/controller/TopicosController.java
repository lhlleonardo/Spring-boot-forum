package com.br.leonardo.forum.controller;

import com.br.leonardo.forum.dto.TopicoDto;
import com.br.leonardo.forum.model.Curso;
import com.br.leonardo.forum.model.Topico;
import com.br.leonardo.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @RequestMapping("/topicos")
    public List<TopicoDto> listar(String nomeCurso) {

        if (nomeCurso == null) {

            List<Topico> topicos = topicoRepository.findAll();

            return TopicoDto.converter(topicos);

        } else {
            List<Topico> topicos = topicoRepository.findByCurso_Nome(nomeCurso);
            return TopicoDto.converter(topicos);
        }
    }
}
