package com.app.foodDelivery.Repository;

import com.app.foodDelivery.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository< Order,Long> {
}
