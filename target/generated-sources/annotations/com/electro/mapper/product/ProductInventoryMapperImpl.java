package com.electro.mapper.product;

import com.electro.dto.inventory.DocketVariantExtendedResponse;
import com.electro.dto.inventory.ProductInventoryResponse;
import com.electro.dto.inventory.ProductInventoryResponse.ProductResponse;
import com.electro.entity.inventory.DocketVariant;
import com.electro.entity.product.Product;
import com.electro.mapper.inventory.DocketVariantMapper;
import com.electro.projection.inventory.ProductInventory;
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
public class ProductInventoryMapperImpl implements ProductInventoryMapper {

    @Autowired
    private DocketVariantMapper docketVariantMapper;
    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public ProductInventoryResponse toResponse(ProductInventory productInventory) {
        if ( productInventory == null ) {
            return null;
        }

        ProductInventoryResponse productInventoryResponse = new ProductInventoryResponse();

        productInventoryResponse.setProduct( productToProductResponse( productInventory.getProduct() ) );
        productInventoryResponse.setTransactions( docketVariantListToDocketVariantExtendedResponseList( productInventory.getTransactions() ) );
        productInventoryResponse.setInventory( productInventory.getInventory() );
        productInventoryResponse.setWaitingForDelivery( productInventory.getWaitingForDelivery() );
        productInventoryResponse.setCanBeSold( productInventory.getCanBeSold() );
        productInventoryResponse.setAreComing( productInventory.getAreComing() );

        return productInventoryResponse;
    }

    @Override
    public List<ProductInventoryResponse> toResponse(List<ProductInventory> productInventory) {
        if ( productInventory == null ) {
            return null;
        }

        List<ProductInventoryResponse> list = new ArrayList<ProductInventoryResponse>( productInventory.size() );
        for ( ProductInventory productInventory1 : productInventory ) {
            list.add( toResponse( productInventory1 ) );
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
        productResponse.setBrand( brandMapper.entityToResponse( product.getBrand() ) );
        productResponse.setSupplier( supplierMapper.entityToResponse( product.getSupplier() ) );

        return productResponse;
    }

    protected List<DocketVariantExtendedResponse> docketVariantListToDocketVariantExtendedResponseList(List<DocketVariant> list) {
        if ( list == null ) {
            return null;
        }

        List<DocketVariantExtendedResponse> list1 = new ArrayList<DocketVariantExtendedResponse>( list.size() );
        for ( DocketVariant docketVariant : list ) {
            list1.add( docketVariantMapper.docketVariantToDocketVariantExtendedResponse( docketVariant ) );
        }

        return list1;
    }
}
