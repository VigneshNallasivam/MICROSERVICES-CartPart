package com.spring.cartpart.service;

import com.spring.cartpart.dto.CartDTO;
import com.spring.cartpart.model.CartModel;

import java.util.List;
import java.util.Optional;

public interface ICartService
{
    List<CartModel> getAll();

    Optional<CartModel> getById(Long id);
    void deleteById(Long id);

    CartModel updateById(CartDTO cartDTO,Long id);

    CartModel UpdateQuantity(CartDTO cartDTO, Long id);

    CartModel insert(CartDTO cartDTO);
}
