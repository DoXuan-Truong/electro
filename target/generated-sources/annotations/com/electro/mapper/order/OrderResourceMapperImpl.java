package com.electro.mapper.order;

import com.electro.dto.order.OrderResourceRequest;
import com.electro.dto.order.OrderResourceResponse;
import com.electro.entity.order.OrderResource;
import com.electro.mapper.customer.CustomerResourceMapper;
import com.electro.utils.MapperUtils;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-02T03:17:50+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class OrderResourceMapperImpl implements OrderResourceMapper {

    @Autowired
    private MapperUtils mapperUtils;
    @Autowired
    private CustomerResourceMapper customerResourceMapper;

    @Override
    public OrderResourceResponse entityToResponse(OrderResource entity) {
        if ( entity == null ) {
            return null;
        }

        OrderResourceResponse orderResourceResponse = new OrderResourceResponse();

        orderResourceResponse.setId( entity.getId() );
        orderResourceResponse.setCreatedAt( entity.getCreatedAt() );
        orderResourceResponse.setUpdatedAt( entity.getUpdatedAt() );
        orderResourceResponse.setCode( entity.getCode() );
        orderResourceResponse.setName( entity.getName() );
        orderResourceResponse.setColor( entity.getColor() );
        orderResourceResponse.setCustomerResource( customerResourceMapper.entityToResponse( entity.getCustomerResource() ) );
        orderResourceResponse.setStatus( entity.getStatus() );

        return orderResourceResponse;
    }

    @Override
    public List<OrderResource> requestToEntity(List<OrderResourceRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<OrderResource> list = new ArrayList<OrderResource>( requests.size() );
        for ( OrderResourceRequest orderResourceRequest : requests ) {
            list.add( requestToEntity( orderResourceRequest ) );
        }

        return list;
    }

    @Override
    public List<OrderResourceResponse> entityToResponse(List<OrderResource> entities) {
        if ( entities == null ) {
            return null;
        }

        List<OrderResourceResponse> list = new ArrayList<OrderResourceResponse>( entities.size() );
        for ( OrderResource orderResource : entities ) {
            list.add( entityToResponse( orderResource ) );
        }

        return list;
    }

    @Override
    public OrderResource requestToEntity(OrderResourceRequest request) {
        if ( request == null ) {
            return null;
        }

        OrderResource orderResource = new OrderResource();

        orderResource.setCustomerResource( mapperUtils.mapToCustomerResource( request.getCustomerResourceId() ) );
        orderResource.setCode( request.getCode() );
        orderResource.setName( request.getName() );
        orderResource.setColor( request.getColor() );
        orderResource.setStatus( request.getStatus() );

        return orderResource;
    }

    @Override
    public OrderResource partialUpdate(OrderResource entity, OrderResourceRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setCustomerResource( mapperUtils.mapToCustomerResource( request.getCustomerResourceId() ) );
        entity.setCode( request.getCode() );
        entity.setName( request.getName() );
        entity.setColor( request.getColor() );
        entity.setStatus( request.getStatus() );

        return entity;
    }
}
