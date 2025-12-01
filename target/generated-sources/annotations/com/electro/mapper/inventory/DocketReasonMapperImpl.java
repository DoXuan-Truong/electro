package com.electro.mapper.inventory;

import com.electro.dto.inventory.DocketReasonRequest;
import com.electro.dto.inventory.DocketReasonResponse;
import com.electro.entity.inventory.DocketReason;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-02T03:17:52+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class DocketReasonMapperImpl implements DocketReasonMapper {

    @Override
    public DocketReason requestToEntity(DocketReasonRequest request) {
        if ( request == null ) {
            return null;
        }

        DocketReason docketReason = new DocketReason();

        docketReason.setName( request.getName() );
        docketReason.setStatus( request.getStatus() );

        return docketReason;
    }

    @Override
    public DocketReasonResponse entityToResponse(DocketReason entity) {
        if ( entity == null ) {
            return null;
        }

        DocketReasonResponse docketReasonResponse = new DocketReasonResponse();

        docketReasonResponse.setId( entity.getId() );
        docketReasonResponse.setCreatedAt( entity.getCreatedAt() );
        docketReasonResponse.setUpdatedAt( entity.getUpdatedAt() );
        docketReasonResponse.setName( entity.getName() );
        docketReasonResponse.setStatus( entity.getStatus() );

        return docketReasonResponse;
    }

    @Override
    public List<DocketReason> requestToEntity(List<DocketReasonRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<DocketReason> list = new ArrayList<DocketReason>( requests.size() );
        for ( DocketReasonRequest docketReasonRequest : requests ) {
            list.add( requestToEntity( docketReasonRequest ) );
        }

        return list;
    }

    @Override
    public List<DocketReasonResponse> entityToResponse(List<DocketReason> entities) {
        if ( entities == null ) {
            return null;
        }

        List<DocketReasonResponse> list = new ArrayList<DocketReasonResponse>( entities.size() );
        for ( DocketReason docketReason : entities ) {
            list.add( entityToResponse( docketReason ) );
        }

        return list;
    }

    @Override
    public DocketReason partialUpdate(DocketReason entity, DocketReasonRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setName( request.getName() );
        entity.setStatus( request.getStatus() );

        return entity;
    }
}
