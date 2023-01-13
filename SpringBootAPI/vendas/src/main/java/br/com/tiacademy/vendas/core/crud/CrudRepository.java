package br.com.tiacademy.vendas.core.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

//T == Tipo - ID == Identificador
@NoRepositoryBean
public interface CrudRepository<T, ID> extends JpaRepository<T, ID> {

}
