package com.electro.mapper.product;

import com.electro.dto.product.VariantRequest;
import com.electro.dto.product.VariantResponse;
import com.electro.dto.product.VariantResponse.ProductResponse;
import com.electro.entity.product.Product;
import com.electro.entity.product.Variant;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-02T03:17:51+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class VariantMapperImpl implements VariantMapper {

    @Override
    public Variant requestToEntity(VariantRequest request) {
        if ( request == null ) {
            return null;
        }

        Variant variant = new Variant();

        variant.setId( request.getId() );
        variant.setSku( request.getSku() );
        variant.setCost( request.getCost() );
        variant.setPrice( request.getPrice() );
        variant.setProperties( request.getProperties() );
        variant.setStatus( request.getStatus() );

        return variant;
    }

    @Override
    public VariantResponse entityToResponse(Variant entity) {
        if ( entity == null ) {
            return null;
        }

        VariantResponse variantResponse = new VariantResponse();

        variantResponse.setId( entity.getId() );
        variantResponse.setCreatedAt( entity.getCreatedAt() );
        variantResponse.setUpdatedAt( entity.getUpdatedAt() );
        variantResponse.setProduct( productToProductResponse( entity.getProduct() ) );
        variantResponse.setSku( entity.getSku() );
        variantResponse.setCost( entity.getCost() );
        variantResponse.setPrice( entity.getPrice() );
        variantResponse.setProperties( entity.getProperties() );
        variantResponse.setStatus( entity.getStatus() );

        return variantResponse;
    }

    @Override
    public List<Variant> requestToEntity(List<VariantRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Variant> list = new ArrayList<Variant>( requests.size() );
        for ( VariantRequest variantRequest : requests ) {
            list.add( requestToEntity( variantRequest ) );
        }

        return list;
    }

    @Override
    public List<VariantResponse> entityToResponse(List<Variant> entities) {
        if ( entities == null ) {
            return null;
        }

        List<VariantResponse> list = new ArrayList<VariantResponse>( entities.size() );
        for ( Variant variant : entities ) {
            list.add( entityToResponse( variant ) );
        }

        return list;
    }

    @Override
    public Variant partialUpdate(Variant entity, VariantRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setId( request.getId() );
        entity.setSku( request.getSku() );
        entity.setCost( request.getCost() );
        entity.setPrice( request.getPrice() );
        entity.setProperties( request.getProperties() );
        entity.setStatus( request.getStatus() );

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
}
