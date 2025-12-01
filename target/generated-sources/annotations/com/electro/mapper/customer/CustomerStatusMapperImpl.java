package com.electro.mapper.customer;

import com.electro.dto.customer.CustomerStatusRequest;
import com.electro.dto.customer.CustomerStatusResponse;
import com.electro.entity.customer.CustomerStatus;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-02T03:17:51+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class CustomerStatusMapperImpl implements CustomerStatusMapper {

    @Override
    public CustomerStatus requestToEntity(CustomerStatusRequest request) {
        if ( request == null ) {
            return null;
        }

        CustomerStatus customerStatus = new CustomerStatus();

        customerStatus.setCode( request.getCode() );
        customerStatus.setName( request.getName() );
        customerStatus.setDescription( request.getDescription() );
        customerStatus.setColor( request.getColor() );
        customerStatus.setStatus( request.getStatus() );

        return customerStatus;
    }

    @Override
    public CustomerStatusResponse entityToResponse(CustomerStatus entity) {
        if ( entity == null ) {
            return null;
        }

        CustomerStatusResponse customerStatusResponse = new CustomerStatusResponse();

        customerStatusResponse.setId( entity.getId() );
        customerStatusResponse.setCreatedAt( entity.getCreatedAt() );
        customerStatusResponse.setUpdatedAt( entity.getUpdatedAt() );
        customerStatusResponse.setCode( entity.getCode() );
        customerStatusResponse.setName( entity.getName() );
        customerStatusResponse.setDescription( entity.getDescription() );
        customerStatusResponse.setColor( entity.getColor() );
        customerStatusResponse.setStatus( entity.getStatus() );

        return customerStatusResponse;
    }

    @Override
    public List<CustomerStatus> requestToEntity(List<CustomerStatusRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<CustomerStatus> list = new ArrayList<CustomerStatus>( requests.size() );
        for ( CustomerStatusRequest customerStatusRequest : requests ) {
            list.add( requestToEntity( customerStatusRequest ) );
        }

        return list;
    }

    @Override
    public List<CustomerStatusResponse> entityToResponse(List<CustomerStatus> entities) {
        if ( entities == null ) {
            return null;
        }

        List<CustomerStatusResponse> list = new ArrayList<CustomerStatusResponse>( entities.size() );
        for ( CustomerStatus customerStatus : entities ) {
            list.add( entityToResponse( customerStatus ) );
        }

        return list;
    }

    @Override
    public CustomerStatus partialUpdate(CustomerStatus entity, CustomerStatusRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setCode( request.getCode() );
        entity.setName( request.getName() );
        entity.setDescription( request.getDescription() );
        entity.setColor( request.getColor() );
        entity.setStatus( request.getStatus() );

        return entity;
    }
}
