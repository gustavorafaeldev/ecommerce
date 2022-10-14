package br.com.ecommerce.ecommerce.controller;

import br.com.ecommerce.ecommerce.models.cart.CartItemDto;
import br.com.ecommerce.ecommerce.services.CartItemDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cartItem")
@CrossOrigin("*")
public class CartItemDtoController {

    @Autowired
    private CartItemDtoService cartItemDtoService;

    @GetMapping
    public ResponseEntity<List<CartItemDto>> findAll() {
        List<CartItemDto> cartItemDtoList = cartItemDtoService.findAll();
        return new ResponseEntity<>(cartItemDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItemDto> findById(@PathVariable Long id){
        CartItemDto cartItemDto = cartItemDtoService.findById(id);
        return new ResponseEntity<>(cartItemDto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CartItemDto> create(@RequestBody CartItemDto cartItemDto,
                                              @RequestParam(value = "product") Long id_product,
                                              @RequestParam(value = "cart") Long id_cart
                                              ){
        CartItemDto obj = cartItemDtoService.create(id_product, id_cart, cartItemDto);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);

    }
}
