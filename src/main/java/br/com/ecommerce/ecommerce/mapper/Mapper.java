package br.com.ecommerce.ecommerce.mapper;

public interface Mapper<E, T> {

    T map(E e);

}