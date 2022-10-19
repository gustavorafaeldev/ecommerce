package br.com.ecommerce.ecommerce.controller;

import br.com.ecommerce.ecommerce.persistance.entity.cart.CartDto;
import br.com.ecommerce.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart")
@CrossOrigin("*")
public class CartDtoController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public ResponseEntity<List<CartDto>> findAll(){
        List<CartDto> cartDtoList = cartService.findAll();
        return new ResponseEntity<>(cartDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartDto> findById(@PathVariable Long id){
        CartDto obj = cartService.findById(id);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CartDto> create(@RequestBody CartDto cartDto) {
        CartDto obj = cartService.create(cartDto);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }
}
