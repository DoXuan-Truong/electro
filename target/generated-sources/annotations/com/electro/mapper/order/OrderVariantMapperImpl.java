package com.electro.mapper.order;

import com.electro.dto.order.OrderVariantRequest;
import com.electro.dto.order.OrderVariantResponse;
import com.electro.dto.order.OrderVariantResponse.VariantResponse;
import com.electro.dto.order.OrderVariantResponse.VariantResponse.ProductResponse;
import com.electro.entity.order.OrderVariant;
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
public class OrderVariantMapperImpl implements OrderVariantMapper {

    @Autowired
    private MapperUtils mapperUtils;

    @Override
    public OrderVariantResponse entityToResponse(OrderVariant entity) {
        if ( entity == null ) {
            return null;
        }

        OrderVariantResponse orderVariantResponse = new OrderVariantResponse();

        orderVariantResponse.setVariant( variantToVariantResponse( entity.getVariant() ) );
        orderVariantResponse.setPrice( entity.getPrice() );
        orderVariantResponse.setQuantity( entity.getQuantity() );
        orderVariantResponse.setAmount( entity.getAmount() );

        return orderVariantResponse;
    }

    @Override
    public List<OrderVariant> requestToEntity(List<OrderVariantRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<OrderVariant> list = new ArrayList<OrderVariant>( requests.size() );
        for ( OrderVariantRequest orderVariantRequest : requests ) {
            list.add( requestToEntity( orderVariantRequest ) );
        }

        return list;
    }

    @Override
    public List<OrderVariantResponse> entityToResponse(List<OrderVariant> entities) {
        if ( entities == null ) {
            return null;
        }

        List<OrderVariantResponse> list = new ArrayList<OrderVariantResponse>( entities.size() );
        for ( OrderVariant orderVariant : entities ) {
            list.add( entityToResponse( orderVariant ) );
        }

        return list;
    }

    @Override
    public OrderVariant requestToEntity(OrderVariantRequest request) {
        if ( request == null ) {
            return null;
        }

        OrderVariant orderVariant = new OrderVariant();

        orderVariant.setVariant( mapperUtils.mapToVariant( request.getVariantId() ) );
        orderVariant.setPrice( request.getPrice() );
        orderVariant.setQuantity( request.getQuantity() );
        orderVariant.setAmount( request.getAmount() );

        return orderVariant;
    }

    @Override
    public OrderVariant partialUpdate(OrderVariant entity, OrderVariantRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setVariant( mapperUtils.mapToVariant( request.getVariantId() ) );
        entity.setPrice( request.getPrice() );
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
