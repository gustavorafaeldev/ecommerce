package br.com.ecommerce.ecommerce.services;

import br.com.ecommerce.ecommerce.models.CartItemDto;
import br.com.ecommerce.ecommerce.repository.CartItemDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemDtoService {

    @Autowired
    private CartItemDtoRepository cartItemDtoRepository;

    public List<CartItemDto> findAll() {
        return cartItemDtoRepository.findAll();
    }
}
