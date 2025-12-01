package com.electro.mapper.inventory;

import com.electro.dto.inventory.VariantInventoryLimitRequest;
import com.electro.dto.inventory.VariantInventoryLimitResponse;
import com.electro.entity.inventory.VariantInventoryLimit;
import com.electro.utils.MapperUtils;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-02T04:44:15+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class VariantInventoryLimitMapperImpl implements VariantInventoryLimitMapper {

    @Autowired
    private MapperUtils mapperUtils;

    @Override
    public VariantInventoryLimitResponse entityToResponse(VariantInventoryLimit entity) {
        if ( entity == null ) {
            return null;
        }

        VariantInventoryLimitResponse variantInventoryLimitResponse = new VariantInventoryLimitResponse();

        variantInventoryLimitResponse.setId( entity.getId() );
        variantInventoryLimitResponse.setCreatedAt( entity.getCreatedAt() );
        variantInventoryLimitResponse.setUpdatedAt( entity.getUpdatedAt() );
        variantInventoryLimitResponse.setMinimumLimit( entity.getMinimumLimit() );
        variantInventoryLimitResponse.setMaximumLimit( entity.getMaximumLimit() );

        return variantInventoryLimitResponse;
    }

    @Override
    public List<VariantInventoryLimit> requestToEntity(List<VariantInventoryLimitRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<VariantInventoryLimit> list = new ArrayList<VariantInventoryLimit>( requests.size() );
        for ( VariantInventoryLimitRequest variantInventoryLimitRequest : requests ) {
            list.add( requestToEntity( variantInventoryLimitRequest ) );
        }

        return list;
    }

    @Override
    public List<VariantInventoryLimitResponse> entityToResponse(List<VariantInventoryLimit> entities) {
        if ( entities == null ) {
            return null;
        }

        List<VariantInventoryLimitResponse> list = new ArrayList<VariantInventoryLimitResponse>( entities.size() );
        for ( VariantInventoryLimit variantInventoryLimit : entities ) {
            list.add( entityToResponse( variantInventoryLimit ) );
        }

        return list;
    }

    @Override
    public VariantInventoryLimit requestToEntity(VariantInventoryLimitRequest request) {
        if ( request == null ) {
            return null;
        }

        VariantInventoryLimit variantInventoryLimit = new VariantInventoryLimit();

        variantInventoryLimit.setVariant( mapperUtils.mapToVariant( request.getVariantId() ) );
        variantInventoryLimit.setMinimumLimit( request.getMinimumLimit() );
        variantInventoryLimit.setMaximumLimit( request.getMaximumLimit() );

        return variantInventoryLimit;
    }

    @Override
    public VariantInventoryLimit partialUpdate(VariantInventoryLimit entity, VariantInventoryLimitRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setVariant( mapperUtils.mapToVariant( request.getVariantId() ) );
        entity.setMinimumLimit( request.getMinimumLimit() );
        entity.setMaximumLimit( request.getMaximumLimit() );

        return entity;
    }
}
