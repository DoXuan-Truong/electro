package com.electro.mapper.customer;

import com.electro.dto.customer.CustomerGroupRequest;
import com.electro.dto.customer.CustomerGroupResponse;
import com.electro.entity.customer.CustomerGroup;
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
public class CustomerGroupMapperImpl implements CustomerGroupMapper {

    @Override
    public CustomerGroup requestToEntity(CustomerGroupRequest request) {
        if ( request == null ) {
            return null;
        }

        CustomerGroup customerGroup = new CustomerGroup();

        customerGroup.setCode( request.getCode() );
        customerGroup.setName( request.getName() );
        customerGroup.setDescription( request.getDescription() );
        customerGroup.setColor( request.getColor() );
        customerGroup.setStatus( request.getStatus() );

        return customerGroup;
    }

    @Override
    public CustomerGroupResponse entityToResponse(CustomerGroup entity) {
        if ( entity == null ) {
            return null;
        }

        CustomerGroupResponse customerGroupResponse = new CustomerGroupResponse();

        customerGroupResponse.setId( entity.getId() );
        customerGroupResponse.setCreatedAt( entity.getCreatedAt() );
        customerGroupResponse.setUpdatedAt( entity.getUpdatedAt() );
        customerGroupResponse.setCode( entity.getCode() );
        customerGroupResponse.setName( entity.getName() );
        customerGroupResponse.setDescription( entity.getDescription() );
        customerGroupResponse.setColor( entity.getColor() );
        customerGroupResponse.setStatus( entity.getStatus() );

        return customerGroupResponse;
    }

    @Override
    public List<CustomerGroup> requestToEntity(List<CustomerGroupRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<CustomerGroup> list = new ArrayList<CustomerGroup>( requests.size() );
        for ( CustomerGroupRequest customerGroupRequest : requests ) {
            list.add( requestToEntity( customerGroupRequest ) );
        }

        return list;
    }

    @Override
    public List<CustomerGroupResponse> entityToResponse(List<CustomerGroup> entities) {
        if ( entities == null ) {
            return null;
        }

        List<CustomerGroupResponse> list = new ArrayList<CustomerGroupResponse>( entities.size() );
        for ( CustomerGroup customerGroup : entities ) {
            list.add( entityToResponse( customerGroup ) );
        }

        return list;
    }

    @Override
    public CustomerGroup partialUpdate(CustomerGroup entity, CustomerGroupRequest request) {
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
