package com.electro.mapper.inventory;

import com.electro.dto.inventory.DocketVariantEliminatedResponse;
import com.electro.dto.inventory.DocketVariantExtendedResponse;
import com.electro.dto.inventory.DocketVariantExtendedResponse.DocketResponse;
import com.electro.dto.inventory.DocketVariantExtendedResponse.DocketResponse.OrderResponse;
import com.electro.dto.inventory.DocketVariantExtendedResponse.DocketResponse.PurchaseOrderResponse;
import com.electro.dto.inventory.DocketVariantRequest;
import com.electro.dto.inventory.DocketVariantResponse;
import com.electro.dto.inventory.DocketVariantResponse.VariantResponse;
import com.electro.dto.inventory.DocketVariantResponse.VariantResponse.ProductResponse;
import com.electro.entity.inventory.Docket;
import com.electro.entity.inventory.DocketVariant;
import com.electro.entity.inventory.PurchaseOrder;
import com.electro.entity.order.Order;
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
    date = "2025-12-02T04:44:14+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class DocketVariantMapperImpl implements DocketVariantMapper {

    @Autowired
    private DocketReasonMapper docketReasonMapper;
    @Autowired
    private WarehouseMapper warehouseMapper;
    @Autowired
    private MapperUtils mapperUtils;

    @Override
    public DocketVariantResponse entityToResponse(DocketVariant entity) {
        if ( entity == null ) {
            return null;
        }

        DocketVariantResponse docketVariantResponse = new DocketVariantResponse();

        docketVariantResponse.setVariant( variantToVariantResponse( entity.getVariant() ) );
        docketVariantResponse.setQuantity( entity.getQuantity() );

        return docketVariantResponse;
    }

    @Override
    public List<DocketVariant> requestToEntity(List<DocketVariantRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<DocketVariant> list = new ArrayList<DocketVariant>( requests.size() );
        for ( DocketVariantRequest docketVariantRequest : requests ) {
            list.add( requestToEntity( docketVariantRequest ) );
        }

        return list;
    }

    @Override
    public List<DocketVariantResponse> entityToResponse(List<DocketVariant> entities) {
        if ( entities == null ) {
            return null;
        }

        List<DocketVariantResponse> list = new ArrayList<DocketVariantResponse>( entities.size() );
        for ( DocketVariant docketVariant : entities ) {
            list.add( entityToResponse( docketVariant ) );
        }

        return list;
    }

    @Override
    public DocketVariant requestToEntity(DocketVariantRequest request) {
        if ( request == null ) {
            return null;
        }

        DocketVariant docketVariant = new DocketVariant();

        docketVariant.setVariant( mapperUtils.mapToVariant( request.getVariantId() ) );
        docketVariant.setQuantity( request.getQuantity() );

        return docketVariant;
    }

    @Override
    public DocketVariant partialUpdate(DocketVariant entity, DocketVariantRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setVariant( mapperUtils.mapToVariant( request.getVariantId() ) );
        entity.setQuantity( request.getQuantity() );

        return entity;
    }

    @Override
    public DocketVariantExtendedResponse docketVariantToDocketVariantExtendedResponse(DocketVariant docketVariant) {
        if ( docketVariant == null ) {
            return null;
        }

        DocketVariantExtendedResponse docketVariantExtendedResponse = new DocketVariantExtendedResponse();

        docketVariantExtendedResponse.setDocket( docketToDocketResponse( docketVariant.getDocket() ) );
        docketVariantExtendedResponse.setVariant( variantToVariantResponse1( docketVariant.getVariant() ) );
        docketVariantExtendedResponse.setQuantity( docketVariant.getQuantity() );

        return docketVariantExtendedResponse;
    }

    @Override
    public DocketVariantEliminatedResponse docketVariantToDocketVariantEliminatedResponse(DocketVariant docketVariant) {
        if ( docketVariant == null ) {
            return null;
        }

        DocketVariantEliminatedResponse docketVariantEliminatedResponse = new DocketVariantEliminatedResponse();

        docketVariantEliminatedResponse.setDocket( docketToDocketResponse1( docketVariant.getDocket() ) );
        docketVariantEliminatedResponse.setQuantity( docketVariant.getQuantity() );

        return docketVariantEliminatedResponse;
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

    protected PurchaseOrderResponse purchaseOrderToPurchaseOrderResponse(PurchaseOrder purchaseOrder) {
        if ( purchaseOrder == null ) {
            return null;
        }

        PurchaseOrderResponse purchaseOrderResponse = new PurchaseOrderResponse();

        purchaseOrderResponse.setId( purchaseOrder.getId() );
        purchaseOrderResponse.setCreatedAt( purchaseOrder.getCreatedAt() );
        purchaseOrderResponse.setUpdatedAt( purchaseOrder.getUpdatedAt() );
        purchaseOrderResponse.setCode( purchaseOrder.getCode() );
        purchaseOrderResponse.setStatus( purchaseOrder.getStatus() );

        return purchaseOrderResponse;
    }

    protected OrderResponse orderToOrderResponse(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderResponse orderResponse = new OrderResponse();

        orderResponse.setId( order.getId() );
        orderResponse.setCreatedAt( order.getCreatedAt() );
        orderResponse.setUpdatedAt( order.getUpdatedAt() );
        orderResponse.setCode( order.getCode() );
        orderResponse.setStatus( order.getStatus() );

        return orderResponse;
    }

    protected DocketResponse docketToDocketResponse(Docket docket) {
        if ( docket == null ) {
            return null;
        }

        DocketResponse docketResponse = new DocketResponse();

        docketResponse.setId( docket.getId() );
        docketResponse.setCreatedAt( docket.getCreatedAt() );
        docketResponse.setUpdatedAt( docket.getUpdatedAt() );
        docketResponse.setType( docket.getType() );
        docketResponse.setCode( docket.getCode() );
        docketResponse.setReason( docketReasonMapper.entityToResponse( docket.getReason() ) );
        docketResponse.setWarehouse( warehouseMapper.entityToResponse( docket.getWarehouse() ) );
        docketResponse.setPurchaseOrder( purchaseOrderToPurchaseOrderResponse( docket.getPurchaseOrder() ) );
        docketResponse.setOrder( orderToOrderResponse( docket.getOrder() ) );
        docketResponse.setStatus( docket.getStatus() );

        return docketResponse;
    }

    protected com.electro.dto.inventory.DocketVariantExtendedResponse.VariantResponse variantToVariantResponse1(Variant variant) {
        if ( variant == null ) {
            return null;
        }

        com.electro.dto.inventory.DocketVariantExtendedResponse.VariantResponse variantResponse = new com.electro.dto.inventory.DocketVariantExtendedResponse.VariantResponse();

        variantResponse.setId( variant.getId() );
        variantResponse.setCreatedAt( variant.getCreatedAt() );
        variantResponse.setUpdatedAt( variant.getUpdatedAt() );
        variantResponse.setSku( variant.getSku() );
        variantResponse.setProperties( variant.getProperties() );
        variantResponse.setStatus( variant.getStatus() );

        return variantResponse;
    }

    protected com.electro.dto.inventory.DocketVariantEliminatedResponse.DocketResponse.PurchaseOrderResponse purchaseOrderToPurchaseOrderResponse1(PurchaseOrder purchaseOrder) {
        if ( purchaseOrder == null ) {
            return null;
        }

        com.electro.dto.inventory.DocketVariantEliminatedResponse.DocketResponse.PurchaseOrderResponse purchaseOrderResponse = new com.electro.dto.inventory.DocketVariantEliminatedResponse.DocketResponse.PurchaseOrderResponse();

        purchaseOrderResponse.setId( purchaseOrder.getId() );
        purchaseOrderResponse.setCreatedAt( purchaseOrder.getCreatedAt() );
        purchaseOrderResponse.setUpdatedAt( purchaseOrder.getUpdatedAt() );
        purchaseOrderResponse.setCode( purchaseOrder.getCode() );
        purchaseOrderResponse.setStatus( purchaseOrder.getStatus() );

        return purchaseOrderResponse;
    }

    protected com.electro.dto.inventory.DocketVariantEliminatedResponse.DocketResponse.OrderResponse orderToOrderResponse1(Order order) {
        if ( order == null ) {
            return null;
        }

        com.electro.dto.inventory.DocketVariantEliminatedResponse.DocketResponse.OrderResponse orderResponse = new com.electro.dto.inventory.DocketVariantEliminatedResponse.DocketResponse.OrderResponse();

        orderResponse.setId( order.getId() );
        orderResponse.setCreatedAt( order.getCreatedAt() );
        orderResponse.setUpdatedAt( order.getUpdatedAt() );
        orderResponse.setCode( order.getCode() );
        orderResponse.setStatus( order.getStatus() );

        return orderResponse;
    }

    protected com.electro.dto.inventory.DocketVariantEliminatedResponse.DocketResponse docketToDocketResponse1(Docket docket) {
        if ( docket == null ) {
            return null;
        }

        com.electro.dto.inventory.DocketVariantEliminatedResponse.DocketResponse docketResponse = new com.electro.dto.inventory.DocketVariantEliminatedResponse.DocketResponse();

        docketResponse.setId( docket.getId() );
        docketResponse.setCreatedAt( docket.getCreatedAt() );
        docketResponse.setUpdatedAt( docket.getUpdatedAt() );
        docketResponse.setType( docket.getType() );
        docketResponse.setCode( docket.getCode() );
        docketResponse.setReason( docketReasonMapper.entityToResponse( docket.getReason() ) );
        docketResponse.setWarehouse( warehouseMapper.entityToResponse( docket.getWarehouse() ) );
        docketResponse.setPurchaseOrder( purchaseOrderToPurchaseOrderResponse1( docket.getPurchaseOrder() ) );
        docketResponse.setOrder( orderToOrderResponse1( docket.getOrder() ) );
        docketResponse.setStatus( docket.getStatus() );

        return docketResponse;
    }
}
