package com.enoca_challange.enoca.Services;

import com.enoca_challange.enoca.Entities.Book;
import com.enoca_challange.enoca.Entities.Order;
import com.enoca_challange.enoca.Repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {



    private final BookService bookService;
    private final OrderRepository orderRepository;

    public OrderService(BookService bookService, OrderRepository orderRepository) {
        this.bookService = bookService;

        this.orderRepository = orderRepository;
    }


  public Order putAnOrder(String userName , List<Integer> bookIdList){

      List<Optional<Book>> optionals = bookIdList.stream()
              .map(bookId -> bookService.findBookById(bookId))
              .collect(Collectors.toList());


      Double totalPrice = optionals.stream()
              .map(books -> books.map(bookPrice -> bookPrice.getPrice())
                      .orElse(0.0)).reduce(0.0, Double::sum);



        Order order = Order.builder()

                .userName(userName)
                .bookList(bookIdList)
                .totalPrice(totalPrice)
                .build();

        orderRepository.save(order);

        return order;
    }







}

