package com.electro.mapper.order;

import com.electro.dto.order.OrderCancellationReasonRequest;
import com.electro.dto.order.OrderCancellationReasonResponse;
import com.electro.entity.order.OrderCancellationReason;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-02T04:44:14+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class OrderCancellationReasonMapperImpl implements OrderCancellationReasonMapper {

    @Override
    public OrderCancellationReason requestToEntity(OrderCancellationReasonRequest request) {
        if ( request == null ) {
            return null;
        }

        OrderCancellationReason orderCancellationReason = new OrderCancellationReason();

        orderCancellationReason.setName( request.getName() );
        orderCancellationReason.setNote( request.getNote() );
        orderCancellationReason.setStatus( request.getStatus() );

        return orderCancellationReason;
    }

    @Override
    public OrderCancellationReasonResponse entityToResponse(OrderCancellationReason entity) {
        if ( entity == null ) {
            return null;
        }

        OrderCancellationReasonResponse orderCancellationReasonResponse = new OrderCancellationReasonResponse();

        orderCancellationReasonResponse.setId( entity.getId() );
        orderCancellationReasonResponse.setCreatedAt( entity.getCreatedAt() );
        orderCancellationReasonResponse.setUpdatedAt( entity.getUpdatedAt() );
        orderCancellationReasonResponse.setName( entity.getName() );
        orderCancellationReasonResponse.setNote( entity.getNote() );
        orderCancellationReasonResponse.setStatus( entity.getStatus() );

        return orderCancellationReasonResponse;
    }

    @Override
    public List<OrderCancellationReason> requestToEntity(List<OrderCancellationReasonRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<OrderCancellationReason> list = new ArrayList<OrderCancellationReason>( requests.size() );
        for ( OrderCancellationReasonRequest orderCancellationReasonRequest : requests ) {
            list.add( requestToEntity( orderCancellationReasonRequest ) );
        }

        return list;
    }

    @Override
    public List<OrderCancellationReasonResponse> entityToResponse(List<OrderCancellationReason> entities) {
        if ( entities == null ) {
            return null;
        }

        List<OrderCancellationReasonResponse> list = new ArrayList<OrderCancellationReasonResponse>( entities.size() );
        for ( OrderCancellationReason orderCancellationReason : entities ) {
            list.add( entityToResponse( orderCancellationReason ) );
        }

        return list;
    }

    @Override
    public OrderCancellationReason partialUpdate(OrderCancellationReason entity, OrderCancellationReasonRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setName( request.getName() );
        entity.setNote( request.getNote() );
        entity.setStatus( request.getStatus() );

        return entity;
    }
}
