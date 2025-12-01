package com.electro.mapper.inventory;

import com.electro.dto.inventory.CountVariantRequest;
import com.electro.dto.inventory.CountVariantResponse;
import com.electro.dto.inventory.CountVariantResponse.VariantResponse;
import com.electro.dto.inventory.CountVariantResponse.VariantResponse.ProductResponse;
import com.electro.entity.inventory.CountVariant;
import com.electro.entity.product.Product;
import com.electro.entity.product.Variant;
import com.electro.utils.MapperUtils;
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
public class CountVariantMapperImpl implements CountVariantMapper {

    @Autowired
    private MapperUtils mapperUtils;

    @Override
    public CountVariantResponse entityToResponse(CountVariant entity) {
        if ( entity == null ) {
            return null;
        }

        CountVariantResponse countVariantResponse = new CountVariantResponse();

        countVariantResponse.setVariant( variantToVariantResponse( entity.getVariant() ) );
        countVariantResponse.setInventory( entity.getInventory() );
        countVariantResponse.setActualInventory( entity.getActualInventory() );

        return countVariantResponse;
    }

    @Override
    public List<CountVariant> requestToEntity(List<CountVariantRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<CountVariant> list = new ArrayList<CountVariant>( requests.size() );
        for ( CountVariantRequest countVariantRequest : requests ) {
            list.add( requestToEntity( countVariantRequest ) );
        }

        return list;
    }

    @Override
    public List<CountVariantResponse> entityToResponse(List<CountVariant> entities) {
        if ( entities == null ) {
            return null;
        }

        List<CountVariantResponse> list = new ArrayList<CountVariantResponse>( entities.size() );
        for ( CountVariant countVariant : entities ) {
            list.add( entityToResponse( countVariant ) );
        }

        return list;
    }

    @Override
    public CountVariant requestToEntity(CountVariantRequest request) {
        if ( request == null ) {
            return null;
        }

        CountVariant countVariant = new CountVariant();

        countVariant.setVariant( mapperUtils.mapToVariant( request.getVariantId() ) );
        countVariant.setInventory( request.getInventory() );
        countVariant.setActualInventory( request.getActualInventory() );

        return countVariant;
    }

    @Override
    public CountVariant partialUpdate(CountVariant entity, CountVariantRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setVariant( mapperUtils.mapToVariant( request.getVariantId() ) );
        entity.setInventory( request.getInventory() );
        entity.setActualInventory( request.getActualInventory() );

        return entity;
    }

    protected ProductResponse productToProductResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductResponse productResponse = new ProductResponse();

        productResponse.setId( product.getId() );
        productResponse.setCreatedAt( product.getCreatedAt() );
        productResponse.setUpdatedAt( product.getUpdatedAt() );
        productResponse.setName( product.getName() );
        productResponse.setCode( product.getCode() );
        productResponse.setSlug( product.getSlug() );

        return productResponse;
    }

    protected VariantResponse variantToVariantResponse(Variant variant) {
        if ( variant == null ) {
            return null;
        }

        VariantResponse variantResponse = new VariantResponse();

        variantResponse.setId( variant.getId() );
        variantResponse.setCreatedAt( variant.getCreatedAt() );
        variantResponse.setUpdatedAt( variant.getUpdatedAt() );
        variantResponse.setProduct( productToProductResponse( variant.getProduct() ) );
        variantResponse.setSku( variant.getSku() );
        variantResponse.setCost( variant.getCost() );
        variantResponse.setPrice( variant.getPrice() );
        variantResponse.setProperties( variant.getProperties() );
        variantResponse.setStatus( variant.getStatus() );

        return variantResponse;
    }
}
