package br.com.ecommerce.ecommerce.controller;

import br.com.ecommerce.ecommerce.persistance.entity.cart.CartItemDto;
import br.com.ecommerce.ecommerce.service.CartItemDtoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cartItem")
@CrossOrigin("*")
@RequiredArgsConstructor
public class CartItemDtoController {

    private final CartItemDtoService cartItemDtoService;

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


    @PostMapping
    public ResponseEntity<CartItemDto> create(@RequestBody CartItemDto cartItemDto,
                                              @RequestParam(value = "idProduct") Long idProduct,
                                              @RequestParam(value = "idCart") Long idCart
                                              ){
        CartItemDto obj = cartItemDtoService.create(idProduct, idCart, cartItemDto);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);

    }
}
