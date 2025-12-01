package com.electro.mapper.inventory;

import com.electro.dto.inventory.ProductInventoryLimitRequest;
import com.electro.dto.inventory.ProductInventoryLimitResponse;
import com.electro.entity.inventory.ProductInventoryLimit;
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
public class ProductInventoryLimitMapperImpl implements ProductInventoryLimitMapper {

    @Autowired
    private MapperUtils mapperUtils;

    @Override
    public ProductInventoryLimitResponse entityToResponse(ProductInventoryLimit entity) {
        if ( entity == null ) {
            return null;
        }

        ProductInventoryLimitResponse productInventoryLimitResponse = new ProductInventoryLimitResponse();

        productInventoryLimitResponse.setId( entity.getId() );
        productInventoryLimitResponse.setCreatedAt( entity.getCreatedAt() );
        productInventoryLimitResponse.setUpdatedAt( entity.getUpdatedAt() );
        productInventoryLimitResponse.setMinimumLimit( entity.getMinimumLimit() );
        productInventoryLimitResponse.setMaximumLimit( entity.getMaximumLimit() );

        return productInventoryLimitResponse;
    }

    @Override
    public List<ProductInventoryLimit> requestToEntity(List<ProductInventoryLimitRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<ProductInventoryLimit> list = new ArrayList<ProductInventoryLimit>( requests.size() );
        for ( ProductInventoryLimitRequest productInventoryLimitRequest : requests ) {
            list.add( requestToEntity( productInventoryLimitRequest ) );
        }

        return list;
    }

    @Override
    public List<ProductInventoryLimitResponse> entityToResponse(List<ProductInventoryLimit> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ProductInventoryLimitResponse> list = new ArrayList<ProductInventoryLimitResponse>( entities.size() );
        for ( ProductInventoryLimit productInventoryLimit : entities ) {
            list.add( entityToResponse( productInventoryLimit ) );
        }

        return list;
    }

    @Override
    public ProductInventoryLimit requestToEntity(ProductInventoryLimitRequest request) {
        if ( request == null ) {
            return null;
        }

        ProductInventoryLimit productInventoryLimit = new ProductInventoryLimit();

        productInventoryLimit.setProduct( mapperUtils.mapToProduct( request.getProductId() ) );
        productInventoryLimit.setMinimumLimit( request.getMinimumLimit() );
        productInventoryLimit.setMaximumLimit( request.getMaximumLimit() );

        return productInventoryLimit;
    }

    @Override
    public ProductInventoryLimit partialUpdate(ProductInventoryLimit entity, ProductInventoryLimitRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setProduct( mapperUtils.mapToProduct( request.getProductId() ) );
        entity.setMinimumLimit( request.getMinimumLimit() );
        entity.setMaximumLimit( request.getMaximumLimit() );

        return entity;
    }
}
