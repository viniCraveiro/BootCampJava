package br.com.tiacademy.vendas.service;

import br.com.tiacademy.vendas.core.crud.CrudService;
import br.com.tiacademy.vendas.domain.Vendedor;
import br.com.tiacademy.vendas.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class VendedorService extends CrudService<Vendedor, Long> {


    @Autowired
    private VendedorRepository vendedorRepository;


    public Vendedor editar(Long id, Vendedor editado){
        var recuperado = porId(id);
        if(Objects.isNull(recuperado)){
            throw new RuntimeException("Não foi encontrado");
        }

        recuperado.setNome(editado.getNome());
        return Repository.save(recuperado);
    }


}
