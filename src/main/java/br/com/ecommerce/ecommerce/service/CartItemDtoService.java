package br.com.ecommerce.ecommerce.service;

import br.com.ecommerce.ecommerce.exception.ObjectNotFoundException;
import br.com.ecommerce.ecommerce.persistance.entity.cart.CartItemDto;
import br.com.ecommerce.ecommerce.persistance.repository.cart.CartItemDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemDtoService {

    @Autowired
    private CartItemDtoRepository cartItemDtoRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    public List<CartItemDto> findAll() {
        return cartItemDtoRepository.findAll();
    }

    public CartItemDto findById(Long id){
        return cartItemDtoRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public CartItemDto create(Long id_product, Long id_cart, CartItemDto cartItemDto){
        cartItemDto.setCartDto(cartService.findById(id_cart));
        cartItemDto.setProductModel(productService.findById(id_product));
        return cartItemDtoRepository.save(cartItemDto);
    }
}
