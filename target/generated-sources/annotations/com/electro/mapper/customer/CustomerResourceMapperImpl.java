package com.electro.mapper.customer;

import com.electro.dto.customer.CustomerResourceRequest;
import com.electro.dto.customer.CustomerResourceResponse;
import com.electro.entity.customer.CustomerResource;
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
public class CustomerResourceMapperImpl implements CustomerResourceMapper {

    @Override
    public CustomerResource requestToEntity(CustomerResourceRequest request) {
        if ( request == null ) {
            return null;
        }

        CustomerResource customerResource = new CustomerResource();

        customerResource.setCode( request.getCode() );
        customerResource.setName( request.getName() );
        customerResource.setDescription( request.getDescription() );
        customerResource.setColor( request.getColor() );
        customerResource.setStatus( request.getStatus() );

        return customerResource;
    }

    @Override
    public CustomerResourceResponse entityToResponse(CustomerResource entity) {
        if ( entity == null ) {
            return null;
        }

        CustomerResourceResponse customerResourceResponse = new CustomerResourceResponse();

        customerResourceResponse.setId( entity.getId() );
        customerResourceResponse.setCreatedAt( entity.getCreatedAt() );
        customerResourceResponse.setUpdatedAt( entity.getUpdatedAt() );
        customerResourceResponse.setCode( entity.getCode() );
        customerResourceResponse.setName( entity.getName() );
        customerResourceResponse.setDescription( entity.getDescription() );
        customerResourceResponse.setColor( entity.getColor() );
        customerResourceResponse.setStatus( entity.getStatus() );

        return customerResourceResponse;
    }

    @Override
    public List<CustomerResource> requestToEntity(List<CustomerResourceRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<CustomerResource> list = new ArrayList<CustomerResource>( requests.size() );
        for ( CustomerResourceRequest customerResourceRequest : requests ) {
            list.add( requestToEntity( customerResourceRequest ) );
        }

        return list;
    }

    @Override
    public List<CustomerResourceResponse> entityToResponse(List<CustomerResource> entities) {
        if ( entities == null ) {
            return null;
        }

        List<CustomerResourceResponse> list = new ArrayList<CustomerResourceResponse>( entities.size() );
        for ( CustomerResource customerResource : entities ) {
            list.add( entityToResponse( customerResource ) );
        }

        return list;
    }

    @Override
    public CustomerResource partialUpdate(CustomerResource entity, CustomerResourceRequest request) {
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
