package br.com.ecommerce.ecommerce.services;

import br.com.ecommerce.ecommerce.exceptions.ObjectNotFoundException;
import br.com.ecommerce.ecommerce.models.CartDto;
import br.com.ecommerce.ecommerce.repository.CartDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CartDtoService {

    @Autowired
    private CartDtoRepository cartDtoRepository;

    public List<CartDto> findAll() {
        return cartDtoRepository.findAll();
    }

    public CartDto create(CartDto cartDto) {
        return cartDtoRepository.save(cartDto);
    }

    public CartDto findById(Long id) {
        return cartDtoRepository.findById(id).orElseThrow(
                ()-> new ObjectNotFoundException("Objeto não encotnrado"));
    }
}
