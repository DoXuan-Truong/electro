package com.electro.mapper.customer;

import com.electro.dto.customer.CustomerGroupResponse;
import com.electro.dto.customer.CustomerRequest;
import com.electro.dto.customer.CustomerResourceResponse;
import com.electro.dto.customer.CustomerResponse;
import com.electro.dto.customer.CustomerStatusResponse;
import com.electro.entity.authentication.User;
import com.electro.entity.customer.Customer;
import com.electro.entity.customer.CustomerGroup;
import com.electro.entity.customer.CustomerResource;
import com.electro.entity.customer.CustomerStatus;
import com.electro.mapper.authentication.UserMapper;
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
public class CustomerMapperImpl implements CustomerMapper {

    @Autowired
    private MapperUtils mapperUtils;
    @Autowired
    private UserMapper userMapper;

    @Override
    public CustomerResponse entityToResponse(Customer entity) {
        if ( entity == null ) {
            return null;
        }

        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.setId( entity.getId() );
        customerResponse.setCreatedAt( entity.getCreatedAt() );
        customerResponse.setUpdatedAt( entity.getUpdatedAt() );
        customerResponse.setUser( userMapper.entityToResponse( entity.getUser() ) );
        customerResponse.setCustomerGroup( customerGroupToCustomerGroupResponse( entity.getCustomerGroup() ) );
        customerResponse.setCustomerStatus( customerStatusToCustomerStatusResponse( entity.getCustomerStatus() ) );
        customerResponse.setCustomerResource( customerResourceToCustomerResourceResponse( entity.getCustomerResource() ) );

        return customerResponse;
    }

    @Override
    public List<Customer> requestToEntity(List<CustomerRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Customer> list = new ArrayList<Customer>( requests.size() );
        for ( CustomerRequest customerRequest : requests ) {
            list.add( requestToEntity( customerRequest ) );
        }

        return list;
    }

    @Override
    public List<CustomerResponse> entityToResponse(List<Customer> entities) {
        if ( entities == null ) {
            return null;
        }

        List<CustomerResponse> list = new ArrayList<CustomerResponse>( entities.size() );
        for ( Customer customer : entities ) {
            list.add( entityToResponse( customer ) );
        }

        return list;
    }

    @Override
    public Customer requestToEntity(CustomerRequest request) {
        if ( request == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setCustomerGroup( mapperUtils.mapToCustomerGroup( request.getCustomerGroupId() ) );
        customer.setCustomerResource( mapperUtils.mapToCustomerResource( request.getCustomerResourceId() ) );
        customer.setCustomerStatus( mapperUtils.mapToCustomerStatus( request.getCustomerStatusId() ) );
        customer.setUser( userMapper.requestToEntity( request.getUser() ) );

        return customer;
    }

    @Override
    public Customer partialUpdate(Customer entity, CustomerRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setCustomerGroup( mapperUtils.mapToCustomerGroup( request.getCustomerGroupId() ) );
        entity.setCustomerResource( mapperUtils.mapToCustomerResource( request.getCustomerResourceId() ) );
        entity.setCustomerStatus( mapperUtils.mapToCustomerStatus( request.getCustomerStatusId() ) );
        if ( request.getUser() != null ) {
            if ( entity.getUser() == null ) {
                entity.setUser( new User() );
            }
            userMapper.partialUpdate( entity.getUser(), request.getUser() );
        }
        else {
            entity.setUser( null );
        }

        return entity;
    }

    protected CustomerGroupResponse customerGroupToCustomerGroupResponse(CustomerGroup customerGroup) {
        if ( customerGroup == null ) {
            return null;
        }

        CustomerGroupResponse customerGroupResponse = new CustomerGroupResponse();

        customerGroupResponse.setId( customerGroup.getId() );
        customerGroupResponse.setCreatedAt( customerGroup.getCreatedAt() );
        customerGroupResponse.setUpdatedAt( customerGroup.getUpdatedAt() );
        customerGroupResponse.setCode( customerGroup.getCode() );
        customerGroupResponse.setName( customerGroup.getName() );
        customerGroupResponse.setDescription( customerGroup.getDescription() );
        customerGroupResponse.setColor( customerGroup.getColor() );
        customerGroupResponse.setStatus( customerGroup.getStatus() );

        return customerGroupResponse;
    }

    protected CustomerStatusResponse customerStatusToCustomerStatusResponse(CustomerStatus customerStatus) {
        if ( customerStatus == null ) {
            return null;
        }

        CustomerStatusResponse customerStatusResponse = new CustomerStatusResponse();

        customerStatusResponse.setId( customerStatus.getId() );
        customerStatusResponse.setCreatedAt( customerStatus.getCreatedAt() );
        customerStatusResponse.setUpdatedAt( customerStatus.getUpdatedAt() );
        customerStatusResponse.setCode( customerStatus.getCode() );
        customerStatusResponse.setName( customerStatus.getName() );
        customerStatusResponse.setDescription( customerStatus.getDescription() );
        customerStatusResponse.setColor( customerStatus.getColor() );
        customerStatusResponse.setStatus( customerStatus.getStatus() );

        return customerStatusResponse;
    }

    protected CustomerResourceResponse customerResourceToCustomerResourceResponse(CustomerResource customerResource) {
        if ( customerResource == null ) {
            return null;
        }

        CustomerResourceResponse customerResourceResponse = new CustomerResourceResponse();

        customerResourceResponse.setId( customerResource.getId() );
        customerResourceResponse.setCreatedAt( customerResource.getCreatedAt() );
        customerResourceResponse.setUpdatedAt( customerResource.getUpdatedAt() );
        customerResourceResponse.setCode( customerResource.getCode() );
        customerResourceResponse.setName( customerResource.getName() );
        customerResourceResponse.setDescription( customerResource.getDescription() );
        customerResourceResponse.setColor( customerResource.getColor() );
        customerResourceResponse.setStatus( customerResource.getStatus() );

        return customerResourceResponse;
    }
}
