package com.electro.mapper.inventory;

import com.electro.dto.inventory.PurchaseOrderVariantRequest;
import com.electro.dto.inventory.PurchaseOrderVariantResponse;
import com.electro.dto.inventory.PurchaseOrderVariantResponse.VariantResponse;
import com.electro.dto.inventory.PurchaseOrderVariantResponse.VariantResponse.ProductResponse;
import com.electro.entity.inventory.PurchaseOrderVariant;
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
    date = "2025-12-02T03:17:52+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class PurchaseOrderVariantMapperImpl implements PurchaseOrderVariantMapper {

    @Autowired
    private MapperUtils mapperUtils;

    @Override
    public PurchaseOrderVariantResponse entityToResponse(PurchaseOrderVariant entity) {
        if ( entity == null ) {
            return null;
        }

        PurchaseOrderVariantResponse purchaseOrderVariantResponse = new PurchaseOrderVariantResponse();

        purchaseOrderVariantResponse.setVariant( variantToVariantResponse( entity.getVariant() ) );
        purchaseOrderVariantResponse.setCost( entity.getCost() );
        purchaseOrderVariantResponse.setQuantity( entity.getQuantity() );
        purchaseOrderVariantResponse.setAmount( entity.getAmount() );

        return purchaseOrderVariantResponse;
    }

    @Override
    public List<PurchaseOrderVariant> requestToEntity(List<PurchaseOrderVariantRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<PurchaseOrderVariant> list = new ArrayList<PurchaseOrderVariant>( requests.size() );
        for ( PurchaseOrderVariantRequest purchaseOrderVariantRequest : requests ) {
            list.add( requestToEntity( purchaseOrderVariantRequest ) );
        }

        return list;
    }

    @Override
    public List<PurchaseOrderVariantResponse> entityToResponse(List<PurchaseOrderVariant> entities) {
        if ( entities == null ) {
            return null;
        }

        List<PurchaseOrderVariantResponse> list = new ArrayList<PurchaseOrderVariantResponse>( entities.size() );
        for ( PurchaseOrderVariant purchaseOrderVariant : entities ) {
            list.add( entityToResponse( purchaseOrderVariant ) );
        }

        return list;
    }

    @Override
    public PurchaseOrderVariant requestToEntity(PurchaseOrderVariantRequest request) {
        if ( request == null ) {
            return null;
        }

        PurchaseOrderVariant purchaseOrderVariant = new PurchaseOrderVariant();

        purchaseOrderVariant.setVariant( mapperUtils.mapToVariant( request.getVariantId() ) );
        purchaseOrderVariant.setCost( request.getCost() );
        purchaseOrderVariant.setQuantity( request.getQuantity() );
        purchaseOrderVariant.setAmount( request.getAmount() );

        return purchaseOrderVariant;
    }

    @Override
    public PurchaseOrderVariant partialUpdate(PurchaseOrderVariant entity, PurchaseOrderVariantRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setVariant( mapperUtils.mapToVariant( request.getVariantId() ) );
        entity.setCost( request.getCost() );
        entity.setQuantity( request.getQuantity() );
        entity.setAmount( request.getAmount() );

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
