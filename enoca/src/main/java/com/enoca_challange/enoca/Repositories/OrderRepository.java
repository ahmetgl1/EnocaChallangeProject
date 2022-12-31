package com.enoca_challange.enoca.Repositories;


import com.enoca_challange.enoca.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
