package br.com.tiacademy.catalogo.controller;

import br.com.tiacademy.catalogo.domain.Marca;
import br.com.tiacademy.catalogo.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public ResponseEntity<List<Marca>> listar() {
        var marcas = marcaService.listar();
        return ResponseEntity.ok(marcas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> especifico(@PathVariable("id") Long id) {
        var resultado = marcaService.porId(id);
        if (Objects.isNull(resultado)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultado);
    }

    @PostMapping
    public ResponseEntity<Marca> criar(@RequestBody Marca marca) {
        var salvo = marcaService.criar(marca);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> editar(@PathVariable("id") Long id, @RequestBody Marca marca) {
        return ResponseEntity.ok(marcaService.editar(id, marca));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        marcaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
