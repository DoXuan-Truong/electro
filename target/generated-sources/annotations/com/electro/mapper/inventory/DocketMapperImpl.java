package com.electro.mapper.inventory;

import com.electro.dto.inventory.DocketRequest;
import com.electro.dto.inventory.DocketResponse;
import com.electro.dto.inventory.DocketResponse.OrderResponse;
import com.electro.dto.inventory.DocketResponse.PurchaseOrderResponse;
import com.electro.dto.inventory.DocketVariantRequest;
import com.electro.dto.inventory.DocketVariantResponse;
import com.electro.entity.inventory.Docket;
import com.electro.entity.inventory.DocketVariant;
import com.electro.entity.inventory.PurchaseOrder;
import com.electro.entity.order.Order;
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
    date = "2025-12-02T03:17:50+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class DocketMapperImpl implements DocketMapper {

    @Autowired
    private MapperUtils mapperUtils;
    @Autowired
    private DocketReasonMapper docketReasonMapper;
    @Autowired
    private WarehouseMapper warehouseMapper;
    @Autowired
    private DocketVariantMapper docketVariantMapper;

    @Override
    public DocketResponse entityToResponse(Docket entity) {
        if ( entity == null ) {
            return null;
        }

        DocketResponse docketResponse = new DocketResponse();

        docketResponse.setId( entity.getId() );
        docketResponse.setCreatedAt( entity.getCreatedAt() );
        docketResponse.setUpdatedAt( entity.getUpdatedAt() );
        docketResponse.setType( entity.getType() );
        docketResponse.setCode( entity.getCode() );
        docketResponse.setReason( docketReasonMapper.entityToResponse( entity.getReason() ) );
        docketResponse.setWarehouse( warehouseMapper.entityToResponse( entity.getWarehouse() ) );
        docketResponse.setDocketVariants( docketVariantSetToDocketVariantResponseSet( entity.getDocketVariants() ) );
        docketResponse.setPurchaseOrder( purchaseOrderToPurchaseOrderResponse( entity.getPurchaseOrder() ) );
        docketResponse.setOrder( orderToOrderResponse( entity.getOrder() ) );
        docketResponse.setNote( entity.getNote() );
        docketResponse.setStatus( entity.getStatus() );

        return docketResponse;
    }

    @Override
    public List<Docket> requestToEntity(List<DocketRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Docket> list = new ArrayList<Docket>( requests.size() );
        for ( DocketRequest docketRequest : requests ) {
            list.add( requestToEntity( docketRequest ) );
        }

        return list;
    }

    @Override
    public List<DocketResponse> entityToResponse(List<Docket> entities) {
        if ( entities == null ) {
            return null;
        }

        List<DocketResponse> list = new ArrayList<DocketResponse>( entities.size() );
        for ( Docket docket : entities ) {
            list.add( entityToResponse( docket ) );
        }

        return list;
    }

    @Override
    public Docket requestToEntity(DocketRequest request) {
        if ( request == null ) {
            return null;
        }

        Docket docket = new Docket();

        docket.setReason( mapperUtils.mapToDocketReason( request.getReasonId() ) );
        docket.setWarehouse( mapperUtils.mapToWarehouse( request.getWarehouseId() ) );
        docket.setPurchaseOrder( mapperUtils.mapToPurchaseOrder( request.getPurchaseOrderId() ) );
        docket.setOrder( mapperUtils.mapToOrder( request.getOrderId() ) );
        docket.setType( request.getType() );
        docket.setCode( request.getCode() );
        docket.setDocketVariants( docketVariantRequestSetToDocketVariantSet( request.getDocketVariants() ) );
        docket.setNote( request.getNote() );
        docket.setStatus( request.getStatus() );

        Docket target = mapperUtils.attachDocket( docket );
        if ( target != null ) {
            return target;
        }

        return docket;
    }

    @Override
    public Docket partialUpdate(Docket entity, DocketRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setReason( mapperUtils.mapToDocketReason( request.getReasonId() ) );
        entity.setWarehouse( mapperUtils.mapToWarehouse( request.getWarehouseId() ) );
        entity.setPurchaseOrder( mapperUtils.mapToPurchaseOrder( request.getPurchaseOrderId() ) );
        entity.setOrder( mapperUtils.mapToOrder( request.getOrderId() ) );
        entity.setType( request.getType() );
        entity.setCode( request.getCode() );
        if ( entity.getDocketVariants() != null ) {
            Set<DocketVariant> set = docketVariantRequestSetToDocketVariantSet( request.getDocketVariants() );
            if ( set != null ) {
                entity.getDocketVariants().clear();
                entity.getDocketVariants().addAll( set );
            }
            else {
                entity.setDocketVariants( null );
            }
        }
        else {
            Set<DocketVariant> set = docketVariantRequestSetToDocketVariantSet( request.getDocketVariants() );
            if ( set != null ) {
                entity.setDocketVariants( set );
            }
        }
        entity.setNote( request.getNote() );
        entity.setStatus( request.getStatus() );

        Docket target = mapperUtils.attachDocket( entity );
        if ( target != null ) {
            return target;
        }

        return entity;
    }

    protected Set<DocketVariantResponse> docketVariantSetToDocketVariantResponseSet(Set<DocketVariant> set) {
        if ( set == null ) {
            return null;
        }

        Set<DocketVariantResponse> set1 = new HashSet<DocketVariantResponse>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( DocketVariant docketVariant : set ) {
            set1.add( docketVariantMapper.entityToResponse( docketVariant ) );
        }

        return set1;
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

    protected Set<DocketVariant> docketVariantRequestSetToDocketVariantSet(Set<DocketVariantRequest> set) {
        if ( set == null ) {
            return null;
        }

        Set<DocketVariant> set1 = new HashSet<DocketVariant>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( DocketVariantRequest docketVariantRequest : set ) {
            set1.add( docketVariantMapper.requestToEntity( docketVariantRequest ) );
        }

        return set1;
    }
}
