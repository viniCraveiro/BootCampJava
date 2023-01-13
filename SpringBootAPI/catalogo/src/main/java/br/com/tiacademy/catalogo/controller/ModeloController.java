package br.com.tiacademy.catalogo.controller;

import br.com.tiacademy.catalogo.domain.Modelo;
import br.com.tiacademy.catalogo.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/modelo")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @GetMapping
    public ResponseEntity<List<Modelo>> listar() {
        var modelos = modeloService.listar();
        return ResponseEntity.ok(modelos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modelo> especifico(@PathVariable("id") Long id) {
        var resultado = modeloService.porId(id);
        if (Objects.isNull(resultado)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultado);
    }

    @PostMapping
    public ResponseEntity<Modelo> criar(@RequestBody Modelo modelo) {
        var salvo = modeloService.criar(modelo);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modelo> editar(@PathVariable("id") Long id, @RequestBody Modelo modelo) {
        return ResponseEntity.ok(modeloService.editar(id, modelo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        modeloService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
