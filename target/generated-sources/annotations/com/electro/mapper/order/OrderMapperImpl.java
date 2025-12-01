package com.electro.mapper.order;

import com.electro.dto.order.OrderRequest;
import com.electro.dto.order.OrderResponse;
import com.electro.dto.order.OrderVariantRequest;
import com.electro.dto.order.OrderVariantResponse;
import com.electro.entity.order.Order;
import com.electro.entity.order.OrderVariant;
import com.electro.mapper.authentication.UserMapper;
import com.electro.utils.MapperUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-02T04:44:15+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Autowired
    private MapperUtils mapperUtils;
    @Autowired
    private OrderResourceMapper orderResourceMapper;
    @Autowired
    private OrderCancellationReasonMapper orderCancellationReasonMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrderVariantMapper orderVariantMapper;

    @Override
    public OrderResponse entityToResponse(Order entity) {
        if ( entity == null ) {
            return null;
        }

        OrderResponse orderResponse = new OrderResponse();

        orderResponse.setId( entity.getId() );
        orderResponse.setCreatedAt( entity.getCreatedAt() );
        orderResponse.setUpdatedAt( entity.getUpdatedAt() );
        orderResponse.setCode( entity.getCode() );
        orderResponse.setStatus( entity.getStatus() );
        orderResponse.setToName( entity.getToName() );
        orderResponse.setToPhone( entity.getToPhone() );
        orderResponse.setToAddress( entity.getToAddress() );
        orderResponse.setToWardName( entity.getToWardName() );
        orderResponse.setToDistrictName( entity.getToDistrictName() );
        orderResponse.setToProvinceName( entity.getToProvinceName() );
        orderResponse.setOrderResource( orderResourceMapper.entityToResponse( entity.getOrderResource() ) );
        orderResponse.setOrderCancellationReason( orderCancellationReasonMapper.entityToResponse( entity.getOrderCancellationReason() ) );
        orderResponse.setNote( entity.getNote() );
        orderResponse.setUser( userMapper.entityToResponse( entity.getUser() ) );
        orderResponse.setOrderVariants( orderVariantSetToOrderVariantResponseSet( entity.getOrderVariants() ) );
        orderResponse.setTotalAmount( entity.getTotalAmount() );
        orderResponse.setTax( entity.getTax() );
        orderResponse.setShippingCost( entity.getShippingCost() );
        orderResponse.setTotalPay( entity.getTotalPay() );
        orderResponse.setPaymentMethodType( entity.getPaymentMethodType() );
        orderResponse.setPaymentStatus( entity.getPaymentStatus() );

        return orderResponse;
    }

    @Override
    public List<Order> requestToEntity(List<OrderRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Order> list = new ArrayList<Order>( requests.size() );
        for ( OrderRequest orderRequest : requests ) {
            list.add( requestToEntity( orderRequest ) );
        }

        return list;
    }

    @Override
    public List<OrderResponse> entityToResponse(List<Order> entities) {
        if ( entities == null ) {
            return null;
        }

        List<OrderResponse> list = new ArrayList<OrderResponse>( entities.size() );
        for ( Order order : entities ) {
            list.add( entityToResponse( order ) );
        }

        return list;
    }

    @Override
    public Order requestToEntity(OrderRequest request) {
        if ( request == null ) {
            return null;
        }

        Order order = new Order();

        order.setOrderResource( mapperUtils.mapToOrderResource( request.getOrderResourceId() ) );
        order.setOrderCancellationReason( mapperUtils.mapToOrderCancellationReason( request.getOrderCancellationReasonId() ) );
        order.setUser( mapperUtils.mapToUser( request.getUserId() ) );
        order.setCode( request.getCode() );
        order.setStatus( request.getStatus() );
        order.setToName( request.getToName() );
        order.setToPhone( request.getToPhone() );
        order.setToAddress( request.getToAddress() );
        order.setToWardName( request.getToWardName() );
        order.setToDistrictName( request.getToDistrictName() );
        order.setToProvinceName( request.getToProvinceName() );
        order.setNote( request.getNote() );
        order.setOrderVariants( orderVariantRequestSetToOrderVariantSet( request.getOrderVariants() ) );
        order.setTotalAmount( request.getTotalAmount() );
        order.setTax( request.getTax() );
        order.setShippingCost( request.getShippingCost() );
        order.setTotalPay( request.getTotalPay() );
        order.setPaymentMethodType( request.getPaymentMethodType() );
        order.setPaymentStatus( request.getPaymentStatus() );

        Order target = mapperUtils.attachOrder( order );
        if ( target != null ) {
            return target;
        }

        return order;
    }

    @Override
    public Order partialUpdate(Order entity, OrderRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setOrderResource( mapperUtils.mapToOrderResource( request.getOrderResourceId() ) );
        entity.setOrderCancellationReason( mapperUtils.mapToOrderCancellationReason( request.getOrderCancellationReasonId() ) );
        entity.setUser( mapperUtils.mapToUser( request.getUserId() ) );
        entity.setCode( request.getCode() );
        entity.setStatus( request.getStatus() );
        entity.setToName( request.getToName() );
        entity.setToPhone( request.getToPhone() );
        entity.setToAddress( request.getToAddress() );
        entity.setToWardName( request.getToWardName() );
        entity.setToDistrictName( request.getToDistrictName() );
        entity.setToProvinceName( request.getToProvinceName() );
        entity.setNote( request.getNote() );
        if ( entity.getOrderVariants() != null ) {
            Set<OrderVariant> set = orderVariantRequestSetToOrderVariantSet( request.getOrderVariants() );
            if ( set != null ) {
                entity.getOrderVariants().clear();
                entity.getOrderVariants().addAll( set );
            }
            else {
                entity.setOrderVariants( null );
            }
        }
        else {
            Set<OrderVariant> set = orderVariantRequestSetToOrderVariantSet( request.getOrderVariants() );
            if ( set != null ) {
                entity.setOrderVariants( set );
            }
        }
        entity.setTotalAmount( request.getTotalAmount() );
        entity.setTax( request.getTax() );
        entity.setShippingCost( request.getShippingCost() );
        entity.setTotalPay( request.getTotalPay() );
        entity.setPaymentMethodType( request.getPaymentMethodType() );
        entity.setPaymentStatus( request.getPaymentStatus() );

        Order target = mapperUtils.attachOrder( entity );
        if ( target != null ) {
            return target;
        }

        return entity;
    }

    protected Set<OrderVariantResponse> orderVariantSetToOrderVariantResponseSet(Set<OrderVariant> set) {
        if ( set == null ) {
            return null;
        }

        Set<OrderVariantResponse> set1 = new HashSet<OrderVariantResponse>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OrderVariant orderVariant : set ) {
            set1.add( orderVariantMapper.entityToResponse( orderVariant ) );
        }

        return set1;
    }

    protected Set<OrderVariant> orderVariantRequestSetToOrderVariantSet(Set<OrderVariantRequest> set) {
        if ( set == null ) {
            return null;
        }

        Set<OrderVariant> set1 = new HashSet<OrderVariant>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OrderVariantRequest orderVariantRequest : set ) {
            set1.add( orderVariantMapper.requestToEntity( orderVariantRequest ) );
        }

        return set1;
    }
}
