package com.flywheel.choo1.data;

import com.flywheel.choo1.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * @author yekw
 * @date 2022/6/23/17:13
 * @description:
 */
public interface OrderRepository extends CrudRepository<Order, Long> {
}
