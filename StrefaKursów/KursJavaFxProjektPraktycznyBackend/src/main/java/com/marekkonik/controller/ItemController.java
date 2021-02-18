package com.marekkonik.controller;

import com.marekkonik.entity.Item;
import com.marekkonik.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;

    @PostMapping("/items")
    Item newItem(@RequestBody Item newItem) {
        return itemRepository.save(newItem);
    }

    @GetMapping("/items")
    List<Item> listItme() {
        return itemRepository.findAll();
    }

    @DeleteMapping("/items")
    ResponseEntity deleteItem(@RequestBody Long idItem){
        itemRepository.deleteById(idItem);
        return ResponseEntity.ok().build();
    }


}
