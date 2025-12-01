package com.electro.mapper.product;

import com.electro.dto.product.SupplierRequest;
import com.electro.dto.product.SupplierResponse;
import com.electro.entity.address.Address;
import com.electro.entity.product.Supplier;
import com.electro.mapper.address.AddressMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-02T04:44:14+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class SupplierMapperImpl implements SupplierMapper {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Supplier requestToEntity(SupplierRequest request) {
        if ( request == null ) {
            return null;
        }

        Supplier supplier = new Supplier();

        supplier.setDisplayName( request.getDisplayName() );
        supplier.setCode( request.getCode() );
        supplier.setContactFullname( request.getContactFullname() );
        supplier.setContactEmail( request.getContactEmail() );
        supplier.setContactPhone( request.getContactPhone() );
        supplier.setCompanyName( request.getCompanyName() );
        supplier.setTaxCode( request.getTaxCode() );
        supplier.setEmail( request.getEmail() );
        supplier.setPhone( request.getPhone() );
        supplier.setFax( request.getFax() );
        supplier.setWebsite( request.getWebsite() );
        supplier.setAddress( addressMapper.requestToEntity( request.getAddress() ) );
        supplier.setDescription( request.getDescription() );
        supplier.setNote( request.getNote() );
        supplier.setStatus( request.getStatus() );

        return supplier;
    }

    @Override
    public SupplierResponse entityToResponse(Supplier entity) {
        if ( entity == null ) {
            return null;
        }

        SupplierResponse supplierResponse = new SupplierResponse();

        supplierResponse.setId( entity.getId() );
        supplierResponse.setCreatedAt( entity.getCreatedAt() );
        supplierResponse.setUpdatedAt( entity.getUpdatedAt() );
        supplierResponse.setDisplayName( entity.getDisplayName() );
        supplierResponse.setCode( entity.getCode() );
        supplierResponse.setContactFullname( entity.getContactFullname() );
        supplierResponse.setContactEmail( entity.getContactEmail() );
        supplierResponse.setContactPhone( entity.getContactPhone() );
        supplierResponse.setCompanyName( entity.getCompanyName() );
        supplierResponse.setTaxCode( entity.getTaxCode() );
        supplierResponse.setEmail( entity.getEmail() );
        supplierResponse.setPhone( entity.getPhone() );
        supplierResponse.setFax( entity.getFax() );
        supplierResponse.setWebsite( entity.getWebsite() );
        supplierResponse.setAddress( addressMapper.entityToResponse( entity.getAddress() ) );
        supplierResponse.setDescription( entity.getDescription() );
        supplierResponse.setNote( entity.getNote() );
        supplierResponse.setStatus( entity.getStatus() );

        return supplierResponse;
    }

    @Override
    public List<Supplier> requestToEntity(List<SupplierRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Supplier> list = new ArrayList<Supplier>( requests.size() );
        for ( SupplierRequest supplierRequest : requests ) {
            list.add( requestToEntity( supplierRequest ) );
        }

        return list;
    }

    @Override
    public List<SupplierResponse> entityToResponse(List<Supplier> entities) {
        if ( entities == null ) {
            return null;
        }

        List<SupplierResponse> list = new ArrayList<SupplierResponse>( entities.size() );
        for ( Supplier supplier : entities ) {
            list.add( entityToResponse( supplier ) );
        }

        return list;
    }

    @Override
    public Supplier partialUpdate(Supplier entity, SupplierRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setDisplayName( request.getDisplayName() );
        entity.setCode( request.getCode() );
        entity.setContactFullname( request.getContactFullname() );
        entity.setContactEmail( request.getContactEmail() );
        entity.setContactPhone( request.getContactPhone() );
        entity.setCompanyName( request.getCompanyName() );
        entity.setTaxCode( request.getTaxCode() );
        entity.setEmail( request.getEmail() );
        entity.setPhone( request.getPhone() );
        entity.setFax( request.getFax() );
        entity.setWebsite( request.getWebsite() );
        if ( request.getAddress() != null ) {
            if ( entity.getAddress() == null ) {
                entity.setAddress( new Address() );
            }
            addressMapper.partialUpdate( entity.getAddress(), request.getAddress() );
        }
        else {
            entity.setAddress( null );
        }
        entity.setDescription( request.getDescription() );
        entity.setNote( request.getNote() );
        entity.setStatus( request.getStatus() );

        return entity;
    }
}
