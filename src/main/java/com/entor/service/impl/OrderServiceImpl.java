package com.entor.service.impl;

import com.entor.entity.Order;
import com.entor.mapper.OrderMapper;
import com.entor.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 展成
 * @since 2020-01-07
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
