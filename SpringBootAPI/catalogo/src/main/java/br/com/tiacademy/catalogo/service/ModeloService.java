package br.com.tiacademy.catalogo.service;

import br.com.tiacademy.catalogo.domain.Modelo;
import br.com.tiacademy.catalogo.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ModeloService {
    @Autowired
    private ModeloRepository modeloRepository;

    public List<Modelo> listar() {
        return modeloRepository.findAll();
    }

    public Modelo porId(Long id) {
        return modeloRepository.findById(id).orElse(null);
    }

    public Modelo criar(Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    public Modelo editar(Long id, Modelo editado) {
        var recuperado = porId(id);
        if (Objects.isNull(recuperado)) {
            throw new RuntimeException("Não foi localizado");
        }
        recuperado.setNome(editado.getNome());
        return modeloRepository.save(recuperado);
    }

    public void excluir(Long id) {
        modeloRepository.deleteById(id);
    }

}
