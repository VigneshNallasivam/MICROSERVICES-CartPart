package com.spring.cartpart.model;
//import jakarta.persistence.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Table(name = "cart")
@NoArgsConstructor
public class CartModel
{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartId;
//    @OneToOne(cascade = {CascadeType.ALL})
//    @JoinColumn(name = "cart_user_id")
    private Long userId;
//    @ManyToOne(cascade = {CascadeType.ALL})
//    @JoinColumn(name = "cart_book_id")
    private Long bookId;
    private long quantity;
    public CartModel(Long user,Long book,long quantity)
    {
        this.userId=user;
        this.bookId=book;
        this.quantity=quantity;
    }
}