package br.com.ecommerce.ecommerce.service;

import java.util.List;
import java.util.Optional;

public interface AbstractService<K, V> {

    V create(K k);
    Optional<V> findById(Long id);
    List<V> findAll();

    V update(Long id, K k);

    void delete(Long id);

}
