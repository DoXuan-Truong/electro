package com.electro.mapper.product;

import com.electro.dto.product.UnitRequest;
import com.electro.dto.product.UnitResponse;
import com.electro.entity.product.Unit;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-02T04:44:14+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class UnitMapperImpl implements UnitMapper {

    @Override
    public Unit requestToEntity(UnitRequest request) {
        if ( request == null ) {
            return null;
        }

        Unit unit = new Unit();

        unit.setName( request.getName() );
        unit.setStatus( request.getStatus() );

        return unit;
    }

    @Override
    public UnitResponse entityToResponse(Unit entity) {
        if ( entity == null ) {
            return null;
        }

        UnitResponse unitResponse = new UnitResponse();

        unitResponse.setId( entity.getId() );
        unitResponse.setCreatedAt( entity.getCreatedAt() );
        unitResponse.setUpdatedAt( entity.getUpdatedAt() );
        unitResponse.setName( entity.getName() );
        unitResponse.setStatus( entity.getStatus() );

        return unitResponse;
    }

    @Override
    public List<Unit> requestToEntity(List<UnitRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Unit> list = new ArrayList<Unit>( requests.size() );
        for ( UnitRequest unitRequest : requests ) {
            list.add( requestToEntity( unitRequest ) );
        }

        return list;
    }

    @Override
    public List<UnitResponse> entityToResponse(List<Unit> entities) {
        if ( entities == null ) {
            return null;
        }

        List<UnitResponse> list = new ArrayList<UnitResponse>( entities.size() );
        for ( Unit unit : entities ) {
            list.add( entityToResponse( unit ) );
        }

        return list;
    }

    @Override
    public Unit partialUpdate(Unit entity, UnitRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setName( request.getName() );
        entity.setStatus( request.getStatus() );

        return entity;
    }
}
