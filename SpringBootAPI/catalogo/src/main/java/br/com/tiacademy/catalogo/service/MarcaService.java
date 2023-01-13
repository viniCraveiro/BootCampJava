package br.com.tiacademy.catalogo.service;

import br.com.tiacademy.catalogo.domain.Marca;
import br.com.tiacademy.catalogo.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> listar() {
        return marcaRepository.findAll();
    }

    public Marca porId(Long id) {
        return marcaRepository.findById(id).orElse(null);
    }

    public Marca criar(Marca marca) {
        return marcaRepository.save(marca);
    }

    public Marca editar(Long id, Marca editado) {
        var recuperado = porId(id);
        if (Objects.isNull(recuperado)) {
            throw new RuntimeException("Não foi encontrado");
        }
        recuperado.setNome(editado.getNome());
        return marcaRepository.save(recuperado);
    }

    public void excluir(Long id) {
        marcaRepository.deleteById(id);
    }

}
