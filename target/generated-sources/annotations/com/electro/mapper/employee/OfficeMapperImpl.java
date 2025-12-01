package com.electro.mapper.employee;

import com.electro.dto.employee.OfficeRequest;
import com.electro.dto.employee.OfficeResponse;
import com.electro.entity.address.Address;
import com.electro.entity.employee.Office;
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
public class OfficeMapperImpl implements OfficeMapper {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Office requestToEntity(OfficeRequest request) {
        if ( request == null ) {
            return null;
        }

        Office office = new Office();

        office.setName( request.getName() );
        office.setAddress( addressMapper.requestToEntity( request.getAddress() ) );
        office.setStatus( request.getStatus() );

        return office;
    }

    @Override
    public OfficeResponse entityToResponse(Office entity) {
        if ( entity == null ) {
            return null;
        }

        OfficeResponse officeResponse = new OfficeResponse();

        officeResponse.setId( entity.getId() );
        officeResponse.setCreatedAt( entity.getCreatedAt() );
        officeResponse.setUpdatedAt( entity.getUpdatedAt() );
        officeResponse.setName( entity.getName() );
        officeResponse.setAddress( addressMapper.entityToResponse( entity.getAddress() ) );
        officeResponse.setStatus( entity.getStatus() );

        return officeResponse;
    }

    @Override
    public List<Office> requestToEntity(List<OfficeRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Office> list = new ArrayList<Office>( requests.size() );
        for ( OfficeRequest officeRequest : requests ) {
            list.add( requestToEntity( officeRequest ) );
        }

        return list;
    }

    @Override
    public List<OfficeResponse> entityToResponse(List<Office> entities) {
        if ( entities == null ) {
            return null;
        }

        List<OfficeResponse> list = new ArrayList<OfficeResponse>( entities.size() );
        for ( Office office : entities ) {
            list.add( entityToResponse( office ) );
        }

        return list;
    }

    @Override
    public Office partialUpdate(Office entity, OfficeRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setName( request.getName() );
        if ( request.getAddress() != null ) {
            if ( entity.getAddress() == null ) {
                entity.setAddress( new Address() );
            }
            addressMapper.partialUpdate( entity.getAddress(), request.getAddress() );
        }
        else {
            entity.setAddress( null );
        }
        entity.setStatus( request.getStatus() );

        return entity;
    }
}
