package com.electro.mapper.inventory;

import com.electro.dto.inventory.PurchaseOrderRequest;
import com.electro.dto.inventory.PurchaseOrderResponse;
import com.electro.dto.inventory.PurchaseOrderResponse.DocketResponse;
import com.electro.dto.inventory.PurchaseOrderResponse.DocketResponse.WarehouseResponse;
import com.electro.dto.inventory.PurchaseOrderVariantRequest;
import com.electro.dto.inventory.PurchaseOrderVariantResponse;
import com.electro.entity.inventory.Docket;
import com.electro.entity.inventory.PurchaseOrder;
import com.electro.entity.inventory.PurchaseOrderVariant;
import com.electro.entity.inventory.Warehouse;
import com.electro.mapper.product.SupplierMapper;
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
public class PurchaseOrderMapperImpl implements PurchaseOrderMapper {

    @Autowired
    private MapperUtils mapperUtils;
    @Autowired
    private SupplierMapper supplierMapper;
    @Autowired
    private DestinationMapper destinationMapper;
    @Autowired
    private PurchaseOrderVariantMapper purchaseOrderVariantMapper;

    @Override
    public PurchaseOrderResponse entityToResponse(PurchaseOrder entity) {
        if ( entity == null ) {
            return null;
        }

        PurchaseOrderResponse purchaseOrderResponse = new PurchaseOrderResponse();

        purchaseOrderResponse.setId( entity.getId() );
        purchaseOrderResponse.setCreatedAt( entity.getCreatedAt() );
        purchaseOrderResponse.setUpdatedAt( entity.getUpdatedAt() );
        purchaseOrderResponse.setCode( entity.getCode() );
        purchaseOrderResponse.setSupplier( supplierMapper.entityToResponse( entity.getSupplier() ) );
        purchaseOrderResponse.setPurchaseOrderVariants( purchaseOrderVariantSetToPurchaseOrderVariantResponseSet( entity.getPurchaseOrderVariants() ) );
        purchaseOrderResponse.setDestination( destinationMapper.entityToResponse( entity.getDestination() ) );
        purchaseOrderResponse.setTotalAmount( entity.getTotalAmount() );
        purchaseOrderResponse.setNote( entity.getNote() );
        purchaseOrderResponse.setStatus( entity.getStatus() );
        purchaseOrderResponse.setDockets( docketListToDocketResponseList( entity.getDockets() ) );

        return purchaseOrderResponse;
    }

    @Override
    public List<PurchaseOrder> requestToEntity(List<PurchaseOrderRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<PurchaseOrder> list = new ArrayList<PurchaseOrder>( requests.size() );
        for ( PurchaseOrderRequest purchaseOrderRequest : requests ) {
            list.add( requestToEntity( purchaseOrderRequest ) );
        }

        return list;
    }

    @Override
    public List<PurchaseOrderResponse> entityToResponse(List<PurchaseOrder> entities) {
        if ( entities == null ) {
            return null;
        }

        List<PurchaseOrderResponse> list = new ArrayList<PurchaseOrderResponse>( entities.size() );
        for ( PurchaseOrder purchaseOrder : entities ) {
            list.add( entityToResponse( purchaseOrder ) );
        }

        return list;
    }

    @Override
    public PurchaseOrder requestToEntity(PurchaseOrderRequest request) {
        if ( request == null ) {
            return null;
        }

        PurchaseOrder purchaseOrder = new PurchaseOrder();

        purchaseOrder.setSupplier( mapperUtils.mapToSupplier( request.getSupplierId() ) );
        purchaseOrder.setDestination( mapperUtils.mapToDestination( request.getDestinationId() ) );
        purchaseOrder.setCode( request.getCode() );
        purchaseOrder.setPurchaseOrderVariants( purchaseOrderVariantRequestSetToPurchaseOrderVariantSet( request.getPurchaseOrderVariants() ) );
        purchaseOrder.setTotalAmount( request.getTotalAmount() );
        purchaseOrder.setNote( request.getNote() );
        purchaseOrder.setStatus( request.getStatus() );

        PurchaseOrder target = mapperUtils.attachPurchaseOrder( purchaseOrder );
        if ( target != null ) {
            return target;
        }

        return purchaseOrder;
    }

    @Override
    public PurchaseOrder partialUpdate(PurchaseOrder entity, PurchaseOrderRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setSupplier( mapperUtils.mapToSupplier( request.getSupplierId() ) );
        entity.setDestination( mapperUtils.mapToDestination( request.getDestinationId() ) );
        entity.setCode( request.getCode() );
        if ( entity.getPurchaseOrderVariants() != null ) {
            Set<PurchaseOrderVariant> set = purchaseOrderVariantRequestSetToPurchaseOrderVariantSet( request.getPurchaseOrderVariants() );
            if ( set != null ) {
                entity.getPurchaseOrderVariants().clear();
                entity.getPurchaseOrderVariants().addAll( set );
            }
            else {
                entity.setPurchaseOrderVariants( null );
            }
        }
        else {
            Set<PurchaseOrderVariant> set = purchaseOrderVariantRequestSetToPurchaseOrderVariantSet( request.getPurchaseOrderVariants() );
            if ( set != null ) {
                entity.setPurchaseOrderVariants( set );
            }
        }
        entity.setTotalAmount( request.getTotalAmount() );
        entity.setNote( request.getNote() );
        entity.setStatus( request.getStatus() );

        PurchaseOrder target = mapperUtils.attachPurchaseOrder( entity );
        if ( target != null ) {
            return target;
        }

        return entity;
    }

    protected Set<PurchaseOrderVariantResponse> purchaseOrderVariantSetToPurchaseOrderVariantResponseSet(Set<PurchaseOrderVariant> set) {
        if ( set == null ) {
            return null;
        }

        Set<PurchaseOrderVariantResponse> set1 = new HashSet<PurchaseOrderVariantResponse>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( PurchaseOrderVariant purchaseOrderVariant : set ) {
            set1.add( purchaseOrderVariantMapper.entityToResponse( purchaseOrderVariant ) );
        }

        return set1;
    }

    protected WarehouseResponse warehouseToWarehouseResponse(Warehouse warehouse) {
        if ( warehouse == null ) {
            return null;
        }

        WarehouseResponse warehouseResponse = new WarehouseResponse();

        warehouseResponse.setId( warehouse.getId() );
        warehouseResponse.setCreatedAt( warehouse.getCreatedAt() );
        warehouseResponse.setUpdatedAt( warehouse.getUpdatedAt() );
        warehouseResponse.setCode( warehouse.getCode() );
        warehouseResponse.setName( warehouse.getName() );
        warehouseResponse.setStatus( warehouse.getStatus() );

        return warehouseResponse;
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
        docketResponse.setWarehouse( warehouseToWarehouseResponse( docket.getWarehouse() ) );
        docketResponse.setStatus( docket.getStatus() );

        return docketResponse;
    }

    protected List<DocketResponse> docketListToDocketResponseList(List<Docket> list) {
        if ( list == null ) {
            return null;
        }

        List<DocketResponse> list1 = new ArrayList<DocketResponse>( list.size() );
        for ( Docket docket : list ) {
            list1.add( docketToDocketResponse( docket ) );
        }

        return list1;
    }

    protected Set<PurchaseOrderVariant> purchaseOrderVariantRequestSetToPurchaseOrderVariantSet(Set<PurchaseOrderVariantRequest> set) {
        if ( set == null ) {
            return null;
        }

        Set<PurchaseOrderVariant> set1 = new HashSet<PurchaseOrderVariant>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( PurchaseOrderVariantRequest purchaseOrderVariantRequest : set ) {
            set1.add( purchaseOrderVariantMapper.requestToEntity( purchaseOrderVariantRequest ) );
        }

        return set1;
    }
}
