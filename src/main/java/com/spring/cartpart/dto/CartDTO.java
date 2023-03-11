package com.spring.cartpart.dto;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class CartDTO
{
    private Long userId;
    private Long bookId;
    private long quantity;
}
