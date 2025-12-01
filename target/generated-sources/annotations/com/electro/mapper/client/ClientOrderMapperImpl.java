package com.electro.mapper.client;

import com.electro.dto.client.ClientOrderDetailResponse;
import com.electro.dto.client.ClientOrderRequest;
import com.electro.dto.client.ClientOrderVariantResponse;
import com.electro.dto.client.ClientOrderVariantResponse.ClientVariantResponse;
import com.electro.dto.client.ClientOrderVariantResponse.ClientVariantResponse.ClientProductResponse;
import com.electro.dto.client.ClientSimpleOrderResponse;
import com.electro.dto.client.ClientWaybillResponse;
import com.electro.dto.client.ClientWaybillResponse.ClientWaybillLogResponse;
import com.electro.dto.order.OrderVariantRequest;
import com.electro.entity.order.Order;
import com.electro.entity.order.OrderVariant;
import com.electro.entity.product.Product;
import com.electro.entity.product.Variant;
import com.electro.entity.waybill.Waybill;
import com.electro.entity.waybill.WaybillLog;
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
public class ClientOrderMapperImpl extends ClientOrderMapper {

    @Autowired
    private MapperUtils mapperUtils;

    @Override
    public ClientSimpleOrderResponse entityToResponse(Order order) {
        if ( order == null ) {
            return null;
        }

        ClientSimpleOrderResponse clientSimpleOrderResponse = new ClientSimpleOrderResponse();

        clientSimpleOrderResponse.setOrderId( order.getId() );
        clientSimpleOrderResponse.setOrderCreatedAt( order.getCreatedAt() );
        clientSimpleOrderResponse.setOrderCode( order.getCode() );
        clientSimpleOrderResponse.setOrderStatus( order.getStatus() );
        clientSimpleOrderResponse.setOrderTotalPay( order.getTotalPay() );
        clientSimpleOrderResponse.setOrderItems( orderVariantSetToClientOrderVariantResponseSet( order.getOrderVariants() ) );
        clientSimpleOrderResponse.setOrderPaymentStatus( order.getPaymentStatus() );

        return clientSimpleOrderResponse;
    }

    @Override
    public ClientOrderDetailResponse entityToDetailResponse(Order order) {
        if ( order == null ) {
            return null;
        }

        ClientOrderDetailResponse clientOrderDetailResponse = new ClientOrderDetailResponse();

        clientOrderDetailResponse.setOrderWaybill( waybillToClientWaybillResponse( order.getWaybill() ) );
        clientOrderDetailResponse.setOrderId( order.getId() );
        clientOrderDetailResponse.setOrderCreatedAt( order.getCreatedAt() );
        clientOrderDetailResponse.setOrderCode( order.getCode() );
        clientOrderDetailResponse.setOrderStatus( order.getStatus() );
        clientOrderDetailResponse.setOrderToName( order.getToName() );
        clientOrderDetailResponse.setOrderToPhone( order.getToPhone() );
        clientOrderDetailResponse.setOrderToAddress( order.getToAddress() );
        clientOrderDetailResponse.setOrderToWardName( order.getToWardName() );
        clientOrderDetailResponse.setOrderToDistrictName( order.getToDistrictName() );
        clientOrderDetailResponse.setOrderToProvinceName( order.getToProvinceName() );
        clientOrderDetailResponse.setOrderTotalAmount( order.getTotalAmount() );
        clientOrderDetailResponse.setOrderTax( order.getTax() );
        clientOrderDetailResponse.setOrderShippingCost( order.getShippingCost() );
        clientOrderDetailResponse.setOrderTotalPay( order.getTotalPay() );
        clientOrderDetailResponse.setOrderPaymentMethodType( order.getPaymentMethodType() );
        clientOrderDetailResponse.setOrderPaymentStatus( order.getPaymentStatus() );
        clientOrderDetailResponse.setOrderItems( orderVariantSetToClientOrderVariantResponseSet( order.getOrderVariants() ) );

        ClientOrderDetailResponse target = entityToDetailResponseCallback( clientOrderDetailResponse );
        if ( target != null ) {
            return target;
        }

        return clientOrderDetailResponse;
    }

    @Override
    public ClientOrderVariantResponse entityToResponse(OrderVariant orderVariant) {
        if ( orderVariant == null ) {
            return null;
        }

        ClientOrderVariantResponse clientOrderVariantResponse = new ClientOrderVariantResponse();

        clientOrderVariantResponse.setOrderItemVariant( variantToClientVariantResponse( orderVariant.getVariant() ) );
        clientOrderVariantResponse.setOrderItemPrice( orderVariant.getPrice() );
        clientOrderVariantResponse.setOrderItemQuantity( orderVariant.getQuantity() );
        clientOrderVariantResponse.setOrderItemAmount( orderVariant.getAmount() );

        return clientOrderVariantResponse;
    }

    @Override
    public Order requestToEntity(ClientOrderRequest request) {
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
        order.setPaypalOrderId( request.getPaypalOrderId() );
        order.setPaypalOrderStatus( request.getPaypalOrderStatus() );

        Order target = mapperUtils.attachOrder( order );
        if ( target != null ) {
            return target;
        }

        return order;
    }

    @Override
    public Order partialUpdate(Order entity, ClientOrderRequest request) {
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
        entity.setPaypalOrderId( request.getPaypalOrderId() );
        entity.setPaypalOrderStatus( request.getPaypalOrderStatus() );

        Order target = mapperUtils.attachOrder( entity );
        if ( target != null ) {
            return target;
        }

        return entity;
    }

    @Override
    public ClientWaybillLogResponse entityToResponse(WaybillLog waybillLog) {
        if ( waybillLog == null ) {
            return null;
        }

        ClientWaybillLogResponse clientWaybillLogResponse = new ClientWaybillLogResponse();

        clientWaybillLogResponse.setWaybillLogId( waybillLog.getId() );
        clientWaybillLogResponse.setWaybillLogCreatedAt( waybillLog.getCreatedAt() );
        clientWaybillLogResponse.setWaybillLogPreviousStatus( waybillLog.getPreviousStatus() );
        clientWaybillLogResponse.setWaybillLogCurrentStatus( waybillLog.getCurrentStatus() );

        return clientWaybillLogResponse;
    }

    protected Set<ClientOrderVariantResponse> orderVariantSetToClientOrderVariantResponseSet(Set<OrderVariant> set) {
        if ( set == null ) {
            return null;
        }

        Set<ClientOrderVariantResponse> set1 = new HashSet<ClientOrderVariantResponse>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OrderVariant orderVariant : set ) {
            set1.add( entityToResponse( orderVariant ) );
        }

        return set1;
    }

    protected List<ClientWaybillLogResponse> waybillLogListToClientWaybillLogResponseList(List<WaybillLog> list) {
        if ( list == null ) {
            return null;
        }

        List<ClientWaybillLogResponse> list1 = new ArrayList<ClientWaybillLogResponse>( list.size() );
        for ( WaybillLog waybillLog : list ) {
            list1.add( entityToResponse( waybillLog ) );
        }

        return list1;
    }

    protected ClientWaybillResponse waybillToClientWaybillResponse(Waybill waybill) {
        if ( waybill == null ) {
            return null;
        }

        ClientWaybillResponse clientWaybillResponse = new ClientWaybillResponse();

        clientWaybillResponse.setWaybillCode( waybill.getCode() );
        clientWaybillResponse.setWaybillExpectedDeliveryTime( waybill.getExpectedDeliveryTime() );
        clientWaybillResponse.setWaybillLogs( waybillLogListToClientWaybillLogResponseList( waybill.getWaybillLogs() ) );

        return clientWaybillResponse;
    }

    protected ClientProductResponse productToClientProductResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        ClientProductResponse clientProductResponse = new ClientProductResponse();

        clientProductResponse.setProductId( product.getId() );
        clientProductResponse.setProductName( product.getName() );
        clientProductResponse.setProductSlug( product.getSlug() );
        clientProductResponse.setProductThumbnail( mapToProductThumbnail( product.getImages() ) );

        return clientProductResponse;
    }

    protected ClientVariantResponse variantToClientVariantResponse(Variant variant) {
        if ( variant == null ) {
            return null;
        }

        ClientVariantResponse clientVariantResponse = new ClientVariantResponse();

        clientVariantResponse.setVariantProduct( productToClientProductResponse( variant.getProduct() ) );
        clientVariantResponse.setVariantId( variant.getId() );
        clientVariantResponse.setVariantProperties( variant.getProperties() );

        return clientVariantResponse;
    }

    protected OrderVariant orderVariantRequestToOrderVariant(OrderVariantRequest orderVariantRequest) {
        if ( orderVariantRequest == null ) {
            return null;
        }

        OrderVariant orderVariant = new OrderVariant();

        orderVariant.setPrice( orderVariantRequest.getPrice() );
        orderVariant.setQuantity( orderVariantRequest.getQuantity() );
        orderVariant.setAmount( orderVariantRequest.getAmount() );

        return orderVariant;
    }

    protected Set<OrderVariant> orderVariantRequestSetToOrderVariantSet(Set<OrderVariantRequest> set) {
        if ( set == null ) {
            return null;
        }

        Set<OrderVariant> set1 = new HashSet<OrderVariant>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OrderVariantRequest orderVariantRequest : set ) {
            set1.add( orderVariantRequestToOrderVariant( orderVariantRequest ) );
        }

        return set1;
    }
}
