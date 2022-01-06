package com.br.leonardo.forum.controller;

import com.br.leonardo.forum.dto.TopicoDto;
import com.br.leonardo.forum.model.Curso;
import com.br.leonardo.forum.model.Topico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicosController {

    @RequestMapping("/topicos")
    public List<TopicoDto> listar() {
        Topico topico = new Topico("Duvida", "Duvida Spring", new Curso("Spring", "Programação"));

        return TopicoDto.converter(Arrays.asList(topico, topico, topico));
    }
}
