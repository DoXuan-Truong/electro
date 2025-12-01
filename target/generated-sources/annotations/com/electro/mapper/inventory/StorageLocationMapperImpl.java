package com.electro.mapper.inventory;

import com.electro.dto.inventory.StorageLocationRequest;
import com.electro.dto.inventory.StorageLocationResponse;
import com.electro.entity.inventory.StorageLocation;
import com.electro.mapper.product.VariantMapper;
import com.electro.utils.MapperUtils;
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
public class StorageLocationMapperImpl implements StorageLocationMapper {

    @Autowired
    private MapperUtils mapperUtils;
    @Autowired
    private WarehouseMapper warehouseMapper;
    @Autowired
    private VariantMapper variantMapper;

    @Override
    public StorageLocationResponse entityToResponse(StorageLocation entity) {
        if ( entity == null ) {
            return null;
        }

        StorageLocationResponse storageLocationResponse = new StorageLocationResponse();

        storageLocationResponse.setId( entity.getId() );
        storageLocationResponse.setCreatedAt( entity.getCreatedAt() );
        storageLocationResponse.setUpdatedAt( entity.getUpdatedAt() );
        storageLocationResponse.setWarehouse( warehouseMapper.entityToResponse( entity.getWarehouse() ) );
        storageLocationResponse.setVariant( variantMapper.entityToResponse( entity.getVariant() ) );
        storageLocationResponse.setName( entity.getName() );

        return storageLocationResponse;
    }

    @Override
    public List<StorageLocation> requestToEntity(List<StorageLocationRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<StorageLocation> list = new ArrayList<StorageLocation>( requests.size() );
        for ( StorageLocationRequest storageLocationRequest : requests ) {
            list.add( requestToEntity( storageLocationRequest ) );
        }

        return list;
    }

    @Override
    public List<StorageLocationResponse> entityToResponse(List<StorageLocation> entities) {
        if ( entities == null ) {
            return null;
        }

        List<StorageLocationResponse> list = new ArrayList<StorageLocationResponse>( entities.size() );
        for ( StorageLocation storageLocation : entities ) {
            list.add( entityToResponse( storageLocation ) );
        }

        return list;
    }

    @Override
    public StorageLocation requestToEntity(StorageLocationRequest request) {
        if ( request == null ) {
            return null;
        }

        StorageLocation storageLocation = new StorageLocation();

        storageLocation.setWarehouse( mapperUtils.mapToWarehouse( request.getWarehouseId() ) );
        storageLocation.setVariant( mapperUtils.mapToVariant( request.getVariantId() ) );
        storageLocation.setName( request.getName() );

        return storageLocation;
    }

    @Override
    public StorageLocation partialUpdate(StorageLocation entity, StorageLocationRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setWarehouse( mapperUtils.mapToWarehouse( request.getWarehouseId() ) );
        entity.setVariant( mapperUtils.mapToVariant( request.getVariantId() ) );
        entity.setName( request.getName() );

        return entity;
    }
}
