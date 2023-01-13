package br.com.tiacademy.vendas.core.crud;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//Uma classe abastrata, não pode ser instanciada, EX: var service =new ClienteService();
public abstract class CrudService<T,ID> {

    @Autowired
    protected CrudRepository<T,ID> repository;

    public List<T> listar(){
        return repository.findAll();
    }

    public T porId(ID id){
        return repository.findById(id).orElse(null);
    }

    public T criar(T entity){
        return repository.save(entity);
    }

    public void  excluir(ID id){
        repository.deleteById(id);
    }

    //ELE VAI FAZER.
    //criar
    //ler
    //editar
    //excluir
}
