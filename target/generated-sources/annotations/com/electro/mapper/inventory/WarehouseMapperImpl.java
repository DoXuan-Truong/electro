package com.electro.mapper.inventory;

import com.electro.dto.inventory.WarehouseRequest;
import com.electro.dto.inventory.WarehouseResponse;
import com.electro.entity.address.Address;
import com.electro.entity.inventory.Warehouse;
import com.electro.mapper.address.AddressMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-02T03:17:51+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class WarehouseMapperImpl implements WarehouseMapper {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Warehouse requestToEntity(WarehouseRequest request) {
        if ( request == null ) {
            return null;
        }

        Warehouse warehouse = new Warehouse();

        warehouse.setCode( request.getCode() );
        warehouse.setName( request.getName() );
        warehouse.setAddress( addressMapper.requestToEntity( request.getAddress() ) );
        warehouse.setStatus( request.getStatus() );

        return warehouse;
    }

    @Override
    public WarehouseResponse entityToResponse(Warehouse entity) {
        if ( entity == null ) {
            return null;
        }

        WarehouseResponse warehouseResponse = new WarehouseResponse();

        warehouseResponse.setId( entity.getId() );
        warehouseResponse.setCreatedAt( entity.getCreatedAt() );
        warehouseResponse.setUpdatedAt( entity.getUpdatedAt() );
        warehouseResponse.setCode( entity.getCode() );
        warehouseResponse.setName( entity.getName() );
        warehouseResponse.setAddress( addressMapper.entityToResponse( entity.getAddress() ) );
        warehouseResponse.setStatus( entity.getStatus() );

        return warehouseResponse;
    }

    @Override
    public List<Warehouse> requestToEntity(List<WarehouseRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Warehouse> list = new ArrayList<Warehouse>( requests.size() );
        for ( WarehouseRequest warehouseRequest : requests ) {
            list.add( requestToEntity( warehouseRequest ) );
        }

        return list;
    }

    @Override
    public List<WarehouseResponse> entityToResponse(List<Warehouse> entities) {
        if ( entities == null ) {
            return null;
        }

        List<WarehouseResponse> list = new ArrayList<WarehouseResponse>( entities.size() );
        for ( Warehouse warehouse : entities ) {
            list.add( entityToResponse( warehouse ) );
        }

        return list;
    }

    @Override
    public Warehouse partialUpdate(Warehouse entity, WarehouseRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setCode( request.getCode() );
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
