package com.br.leonardo.forum.controller;

import com.br.leonardo.forum.dto.TopicoDto;
import com.br.leonardo.forum.form.TopicoForm;
import com.br.leonardo.forum.model.Topico;
import com.br.leonardo.forum.repository.CursoRepository;
import com.br.leonardo.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<TopicoDto> listar(String nomeCurso) {

        if (nomeCurso == null) {

            List<Topico> topicos = topicoRepository.findAll();

            return TopicoDto.converter(topicos);

        } else {
            List<Topico> topicos = topicoRepository.findByCurso_Nome(nomeCurso);
            return TopicoDto.converter(topicos);
        }
    }

    @PostMapping
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody TopicoForm topicoForm, UriComponentsBuilder uriComponentsBuilder){

        Topico topico = topicoForm.converter(cursoRepository);

        topicoRepository.save(topico);

        URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }
}
