package com.spring.cartpart.service;
import com.spring.cartpart.dto.CartDTO;
import com.spring.cartpart.exception.CartException;
import com.spring.cartpart.model.BookModel;
import com.spring.cartpart.model.CartModel;
import com.spring.cartpart.model.UserModel;
import com.spring.cartpart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Optional;
@Service
public class CartService implements ICartService
{
    @Autowired
    RestTemplate restTemp;
    @Autowired
    CartRepository cartRepo;

    //    @Autowired
    //    UserRepository userRepo;
    //    @Autowired
    //    BookRepository bookRepo;
    @Override
    public CartModel insert(CartDTO cartDTO)
    {
//        Optional<UserModel> user=userRepo.findById(cartDTO.getUserId());
        UserModel user = restTemp.getForObject("http://localhost:8081/homeuser/getById/1", UserModel.class);
//        Optional<BookModel> book=bookRepo.findById(cartDTO.getBookId());
        BookModel book = restTemp.getForObject("http://localhost:8082/homebook/getById/1", BookModel.class);
        if (user!=null && book!=null)
        {
            CartModel cart = new CartModel(user.getUserId(), book.getBookId(), cartDTO.getQuantity());
            cartRepo.save(cart);
            return cart;
        }
        else
        {
            throw new CartException("Give correct details!");
        }
    }

    @Override
    public List<CartModel> getAll()
    {
        List<CartModel> cartList = cartRepo.findAll();
        return cartList;
    }

    @Override
    public Optional<CartModel> getById(Long id)
    {
        Optional<CartModel> cart = cartRepo.findById(id);
        if (cart.isPresent())
        {
            return cart;
        }
        else
        {
            throw new CartException("Cannot find the cart id: " + id);
        }
    }

    @Override
    public void deleteById(Long id)
    {
        Optional<CartModel> cart = cartRepo.findById(id);
        if (cart.isPresent())
        {
            cartRepo.deleteById(id);
        }
        else
        {
            throw new CartException("Cannot find cart id: " + id);
        }
    }

    @Override
    public CartModel updateById(CartDTO cartDTO, Long id)
    {
        //Optional<UserModel> user=userRepo.findById(cartDTO.getUserId());
        UserModel user = restTemp.getForObject("http://localhost:8081/homeuser/getById/1" + cartDTO.getUserId(), UserModel.class);
        //Optional<BookModel> book=bookRepo.findById(cartDTO.getBookId());
        BookModel book = restTemp.getForObject("http://localhost:8082/homebook/getById/1" + cartDTO.getBookId(), BookModel.class);
        CartModel cart=cartRepo.findById(id).get();
        if(cartRepo.findById(id).isPresent() && book!=null && user!=null)
        {
            cart.setUserId(user.getUserId());
            cart.setBookId(book.getBookId());
            cart.setQuantity(cartDTO.getQuantity());
            cartRepo.save(cart);
            return cart;
        }
        else
        {
            throw new CartException("Incorrect Details! check Again!");
        }
    }
    @Override
    public CartModel UpdateQuantity(CartDTO cartDTO, Long id)
    {
        CartModel cart=cartRepo.findById(id).get();
        if(cartRepo.findById(id).isPresent())
        {
            cart.setQuantity(cartDTO.getQuantity());
            cartRepo.save(cart);
            return cart;
        }
        else
        {
            throw new CartException("Cannot find cart id: "+id);
        }
    }
    }
