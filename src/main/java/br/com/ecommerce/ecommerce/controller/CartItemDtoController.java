package br.com.ecommerce.ecommerce.controller;

import br.com.ecommerce.ecommerce.models.CartItemDto;
import br.com.ecommerce.ecommerce.services.CartItemDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
