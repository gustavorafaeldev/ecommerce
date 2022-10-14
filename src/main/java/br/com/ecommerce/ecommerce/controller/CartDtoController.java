package br.com.ecommerce.ecommerce.controller;

import br.com.ecommerce.ecommerce.models.cart.CartDto;
import br.com.ecommerce.ecommerce.services.CartDtoService;
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
    private CartDtoService cartDtoService;

    @GetMapping
    public ResponseEntity<List<CartDto>> findAll(){
        List<CartDto> cartDtoList = cartDtoService.findAll();
        return new ResponseEntity<>(cartDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartDto> findById(@PathVariable Long id){
        CartDto obj = cartDtoService.findById(id);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CartDto> create(@RequestBody CartDto cartDto) {
        CartDto obj = cartDtoService.create(cartDto);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }
}
