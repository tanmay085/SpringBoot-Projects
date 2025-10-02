package com.app.foodDelivery.Repository;

import com.app.foodDelivery.Entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository< OrderDetail,Long> {
}
