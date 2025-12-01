package com.electro.mapper.waybill;

import com.electro.dto.waybill.WaybillRequest;
import com.electro.dto.waybill.WaybillResponse;
import com.electro.entity.waybill.Waybill;
import com.electro.mapper.order.OrderMapper;
import com.electro.utils.MapperUtils;
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
public class WaybillMapperImpl implements WaybillMapper {

    @Autowired
    private MapperUtils mapperUtils;
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public WaybillResponse entityToResponse(Waybill entity) {
        if ( entity == null ) {
            return null;
        }

        WaybillResponse waybillResponse = new WaybillResponse();

        waybillResponse.setId( entity.getId() );
        waybillResponse.setCreatedAt( entity.getCreatedAt() );
        waybillResponse.setUpdatedAt( entity.getUpdatedAt() );
        waybillResponse.setCode( entity.getCode() );
        waybillResponse.setOrder( orderMapper.entityToResponse( entity.getOrder() ) );
        waybillResponse.setShippingDate( entity.getShippingDate() );
        waybillResponse.setExpectedDeliveryTime( entity.getExpectedDeliveryTime() );
        waybillResponse.setStatus( entity.getStatus() );
        waybillResponse.setCodAmount( entity.getCodAmount() );
        waybillResponse.setShippingFee( entity.getShippingFee() );
        waybillResponse.setWeight( entity.getWeight() );
        waybillResponse.setLength( entity.getLength() );
        waybillResponse.setWidth( entity.getWidth() );
        waybillResponse.setHeight( entity.getHeight() );
        waybillResponse.setNote( entity.getNote() );
        waybillResponse.setGhnPaymentTypeId( entity.getGhnPaymentTypeId() );
        waybillResponse.setGhnRequiredNote( entity.getGhnRequiredNote() );

        return waybillResponse;
    }

    @Override
    public List<Waybill> requestToEntity(List<WaybillRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Waybill> list = new ArrayList<Waybill>( requests.size() );
        for ( WaybillRequest waybillRequest : requests ) {
            list.add( requestToEntity( waybillRequest ) );
        }

        return list;
    }

    @Override
    public List<WaybillResponse> entityToResponse(List<Waybill> entities) {
        if ( entities == null ) {
            return null;
        }

        List<WaybillResponse> list = new ArrayList<WaybillResponse>( entities.size() );
        for ( Waybill waybill : entities ) {
            list.add( entityToResponse( waybill ) );
        }

        return list;
    }

    @Override
    public Waybill requestToEntity(WaybillRequest request) {
        if ( request == null ) {
            return null;
        }

        Waybill waybill = new Waybill();

        waybill.setOrder( mapperUtils.mapToOrder( request.getOrderId() ) );
        waybill.setShippingDate( request.getShippingDate() );
        waybill.setWeight( request.getWeight() );
        waybill.setLength( request.getLength() );
        waybill.setWidth( request.getWidth() );
        waybill.setHeight( request.getHeight() );
        waybill.setNote( request.getNote() );
        waybill.setGhnRequiredNote( request.getGhnRequiredNote() );

        return waybill;
    }

    @Override
    public Waybill partialUpdate(Waybill entity, WaybillRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setOrder( mapperUtils.mapToOrder( request.getOrderId() ) );
        entity.setShippingDate( request.getShippingDate() );
        entity.setWeight( request.getWeight() );
        entity.setLength( request.getLength() );
        entity.setWidth( request.getWidth() );
        entity.setHeight( request.getHeight() );
        entity.setNote( request.getNote() );
        entity.setGhnRequiredNote( request.getGhnRequiredNote() );

        return entity;
    }
}
