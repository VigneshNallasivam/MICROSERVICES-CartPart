package com.spring.cartpart.repository;

import com.spring.cartpart.model.CartModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartModel,Long> {
//    @Transactional
//    @Modifying
//    @Query(value = "delete from carts.cart where cart.cart_id=:id",nativeQuery = true)
//    void deleteById(Long id);
}
