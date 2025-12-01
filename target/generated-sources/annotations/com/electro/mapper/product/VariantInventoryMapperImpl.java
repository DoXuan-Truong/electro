package com.electro.mapper.product;

import com.electro.dto.inventory.DocketVariantEliminatedResponse;
import com.electro.dto.inventory.VariantInventoryResponse;
import com.electro.dto.inventory.VariantInventoryResponse.VariantResponse;
import com.electro.dto.inventory.VariantInventoryResponse.VariantResponse.ProductResponse;
import com.electro.entity.inventory.DocketVariant;
import com.electro.entity.product.Product;
import com.electro.entity.product.Variant;
import com.electro.mapper.inventory.DocketVariantMapper;
import com.electro.projection.inventory.VariantInventory;
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
public class VariantInventoryMapperImpl implements VariantInventoryMapper {

    @Autowired
    private DocketVariantMapper docketVariantMapper;

    @Override
    public VariantInventoryResponse toResponse(VariantInventory variantInventory) {
        if ( variantInventory == null ) {
            return null;
        }

        VariantInventoryResponse variantInventoryResponse = new VariantInventoryResponse();

        variantInventoryResponse.setVariant( variantToVariantResponse( variantInventory.getVariant() ) );
        variantInventoryResponse.setTransactions( docketVariantListToDocketVariantEliminatedResponseList( variantInventory.getTransactions() ) );
        variantInventoryResponse.setInventory( variantInventory.getInventory() );
        variantInventoryResponse.setWaitingForDelivery( variantInventory.getWaitingForDelivery() );
        variantInventoryResponse.setCanBeSold( variantInventory.getCanBeSold() );
        variantInventoryResponse.setAreComing( variantInventory.getAreComing() );

        return variantInventoryResponse;
    }

    @Override
    public List<VariantInventoryResponse> toResponse(List<VariantInventory> variantInventory) {
        if ( variantInventory == null ) {
            return null;
        }

        List<VariantInventoryResponse> list = new ArrayList<VariantInventoryResponse>( variantInventory.size() );
        for ( VariantInventory variantInventory1 : variantInventory ) {
            list.add( toResponse( variantInventory1 ) );
        }

        return list;
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

    protected List<DocketVariantEliminatedResponse> docketVariantListToDocketVariantEliminatedResponseList(List<DocketVariant> list) {
        if ( list == null ) {
            return null;
        }

        List<DocketVariantEliminatedResponse> list1 = new ArrayList<DocketVariantEliminatedResponse>( list.size() );
        for ( DocketVariant docketVariant : list ) {
            list1.add( docketVariantMapper.docketVariantToDocketVariantEliminatedResponse( docketVariant ) );
        }

        return list1;
    }
}
