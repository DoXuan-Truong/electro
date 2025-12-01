package com.electro.mapper.inventory;

import com.electro.dto.inventory.DestinationRequest;
import com.electro.dto.inventory.DestinationResponse;
import com.electro.entity.address.Address;
import com.electro.entity.inventory.Destination;
import com.electro.mapper.address.AddressMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-02T03:17:49+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class DestinationMapperImpl implements DestinationMapper {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Destination requestToEntity(DestinationRequest request) {
        if ( request == null ) {
            return null;
        }

        Destination destination = new Destination();

        destination.setContactFullname( request.getContactFullname() );
        destination.setContactEmail( request.getContactEmail() );
        destination.setContactPhone( request.getContactPhone() );
        destination.setAddress( addressMapper.requestToEntity( request.getAddress() ) );
        destination.setStatus( request.getStatus() );

        return destination;
    }

    @Override
    public DestinationResponse entityToResponse(Destination entity) {
        if ( entity == null ) {
            return null;
        }

        DestinationResponse destinationResponse = new DestinationResponse();

        destinationResponse.setId( entity.getId() );
        destinationResponse.setCreatedAt( entity.getCreatedAt() );
        destinationResponse.setUpdatedAt( entity.getUpdatedAt() );
        destinationResponse.setContactFullname( entity.getContactFullname() );
        destinationResponse.setContactEmail( entity.getContactEmail() );
        destinationResponse.setContactPhone( entity.getContactPhone() );
        destinationResponse.setAddress( addressMapper.entityToResponse( entity.getAddress() ) );
        destinationResponse.setStatus( entity.getStatus() );

        return destinationResponse;
    }

    @Override
    public List<Destination> requestToEntity(List<DestinationRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Destination> list = new ArrayList<Destination>( requests.size() );
        for ( DestinationRequest destinationRequest : requests ) {
            list.add( requestToEntity( destinationRequest ) );
        }

        return list;
    }

    @Override
    public List<DestinationResponse> entityToResponse(List<Destination> entities) {
        if ( entities == null ) {
            return null;
        }

        List<DestinationResponse> list = new ArrayList<DestinationResponse>( entities.size() );
        for ( Destination destination : entities ) {
            list.add( entityToResponse( destination ) );
        }

        return list;
    }

    @Override
    public Destination partialUpdate(Destination entity, DestinationRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setContactFullname( request.getContactFullname() );
        entity.setContactEmail( request.getContactEmail() );
        entity.setContactPhone( request.getContactPhone() );
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
