package br.com.tiacademy.vendas.service;

import br.com.tiacademy.vendas.core.crud.CrudService;
import br.com.tiacademy.vendas.domain.Cliente;
import org.aspectj.apache.bcel.Repository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ClienteService extends CrudService<Cliente, Long> {


    public Cliente editar(Long id, Cliente editado){
        var recuperado = porId(id);
        if(Objects.isNull(recuperado)){
            throw new RuntimeException("Não foi encontrado");
        }
        recuperado.setNome(editado.getNome());
        return Repository.save(recuperado);
    }
}
