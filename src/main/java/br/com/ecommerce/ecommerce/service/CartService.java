package br.com.ecommerce.ecommerce.service;

import br.com.ecommerce.ecommerce.exception.ObjectNotFoundException;
import br.com.ecommerce.ecommerce.persistance.entity.cart.CartDto;
import br.com.ecommerce.ecommerce.persistance.repository.cart.CartDtoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CartService {

    private final CartDtoRepository cartDtoRepository;

    public List<CartDto> findAll() {
        return cartDtoRepository.findAll();
    }

    public CartDto create(CartDto cartDto) {
        return cartDtoRepository.save(cartDto);
    }

    public CartDto findById(Long id) {
        return cartDtoRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
