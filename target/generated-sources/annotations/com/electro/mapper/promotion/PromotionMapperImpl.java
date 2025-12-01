package com.electro.mapper.promotion;

import com.electro.dto.client.ClientPromotionResponse;
import com.electro.dto.product.ProductResponse;
import com.electro.dto.promotion.PromotionRequest;
import com.electro.dto.promotion.PromotionResponse;
import com.electro.entity.product.Product;
import com.electro.entity.promotion.Promotion;
import com.electro.mapper.product.ProductMapper;
import com.electro.utils.MapperUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-02T04:44:14+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class PromotionMapperImpl extends PromotionMapper {

    @Autowired
    private MapperUtils mapperUtils;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public PromotionResponse entityToResponse(Promotion entity) {
        if ( entity == null ) {
            return null;
        }

        PromotionResponse promotionResponse = new PromotionResponse();

        promotionResponse.setId( entity.getId() );
        promotionResponse.setCreatedAt( entity.getCreatedAt() );
        promotionResponse.setUpdatedAt( entity.getUpdatedAt() );
        promotionResponse.setName( entity.getName() );
        promotionResponse.setStartDate( entity.getStartDate() );
        promotionResponse.setEndDate( entity.getEndDate() );
        promotionResponse.setPercent( entity.getPercent() );
        promotionResponse.setStatus( entity.getStatus() );
        promotionResponse.setProducts( productSetToProductResponseSet( entity.getProducts() ) );

        return promotionResponse;
    }

    @Override
    public List<Promotion> requestToEntity(List<PromotionRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Promotion> list = new ArrayList<Promotion>( requests.size() );
        for ( PromotionRequest promotionRequest : requests ) {
            list.add( requestToEntity( promotionRequest ) );
        }

        return list;
    }

    @Override
    public List<PromotionResponse> entityToResponse(List<Promotion> entities) {
        if ( entities == null ) {
            return null;
        }

        List<PromotionResponse> list = new ArrayList<PromotionResponse>( entities.size() );
        for ( Promotion promotion : entities ) {
            list.add( entityToResponse( promotion ) );
        }

        return list;
    }

    @Override
    public Promotion requestToEntity(PromotionRequest request) {
        if ( request == null ) {
            return null;
        }

        Promotion promotion = new Promotion();

        promotion.setProducts( longSetToProductSet( request.getProductIds() ) );
        promotion.setName( request.getName() );
        promotion.setStartDate( request.getStartDate() );
        promotion.setEndDate( request.getEndDate() );
        promotion.setPercent( request.getPercent() );
        promotion.setStatus( request.getStatus() );

        addProductsFromCategories( promotion, request );

        return promotion;
    }

    @Override
    public Promotion partialUpdate(Promotion entity, PromotionRequest request) {
        if ( request == null ) {
            return null;
        }

        if ( entity.getProducts() != null ) {
            Set<Product> set = longSetToProductSet( request.getProductIds() );
            if ( set != null ) {
                entity.getProducts().clear();
                entity.getProducts().addAll( set );
            }
        }
        else {
            Set<Product> set = longSetToProductSet( request.getProductIds() );
            if ( set != null ) {
                entity.setProducts( set );
            }
        }
        if ( request.getName() != null ) {
            entity.setName( request.getName() );
        }
        if ( request.getStartDate() != null ) {
            entity.setStartDate( request.getStartDate() );
        }
        if ( request.getEndDate() != null ) {
            entity.setEndDate( request.getEndDate() );
        }
        if ( request.getPercent() != null ) {
            entity.setPercent( request.getPercent() );
        }
        if ( request.getStatus() != null ) {
            entity.setStatus( request.getStatus() );
        }

        return entity;
    }

    @Override
    public ClientPromotionResponse entityToClientResponse(Promotion promotion) {
        if ( promotion == null ) {
            return null;
        }

        ClientPromotionResponse clientPromotionResponse = new ClientPromotionResponse();

        clientPromotionResponse.setPromotionId( promotion.getId() );
        clientPromotionResponse.setPromotionPercent( promotion.getPercent() );

        return clientPromotionResponse;
    }

    protected Set<ProductResponse> productSetToProductResponseSet(Set<Product> set) {
        if ( set == null ) {
            return null;
        }

        Set<ProductResponse> set1 = new HashSet<ProductResponse>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Product product : set ) {
            set1.add( productMapper.entityToResponse( product ) );
        }

        return set1;
    }

    protected Set<Product> longSetToProductSet(Set<Long> set) {
        if ( set == null ) {
            return null;
        }

        Set<Product> set1 = new HashSet<Product>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Long long1 : set ) {
            set1.add( mapperUtils.mapToProduct( long1 ) );
        }

        return set1;
    }
}
