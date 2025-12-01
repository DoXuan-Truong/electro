package com.electro.mapper.inventory;

import com.electro.dto.inventory.CountRequest;
import com.electro.dto.inventory.CountResponse;
import com.electro.dto.inventory.CountVariantRequest;
import com.electro.dto.inventory.CountVariantResponse;
import com.electro.entity.inventory.Count;
import com.electro.entity.inventory.CountVariant;
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
    date = "2025-12-02T03:17:49+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class CountMapperImpl implements CountMapper {

    @Autowired
    private MapperUtils mapperUtils;
    @Autowired
    private WarehouseMapper warehouseMapper;
    @Autowired
    private CountVariantMapper countVariantMapper;

    @Override
    public CountResponse entityToResponse(Count entity) {
        if ( entity == null ) {
            return null;
        }

        CountResponse countResponse = new CountResponse();

        countResponse.setId( entity.getId() );
        countResponse.setCreatedAt( entity.getCreatedAt() );
        countResponse.setUpdatedAt( entity.getUpdatedAt() );
        countResponse.setCode( entity.getCode() );
        countResponse.setWarehouse( warehouseMapper.entityToResponse( entity.getWarehouse() ) );
        countResponse.setCountVariants( countVariantSetToCountVariantResponseSet( entity.getCountVariants() ) );
        countResponse.setNote( entity.getNote() );
        countResponse.setStatus( entity.getStatus() );

        return countResponse;
    }

    @Override
    public List<Count> requestToEntity(List<CountRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Count> list = new ArrayList<Count>( requests.size() );
        for ( CountRequest countRequest : requests ) {
            list.add( requestToEntity( countRequest ) );
        }

        return list;
    }

    @Override
    public List<CountResponse> entityToResponse(List<Count> entities) {
        if ( entities == null ) {
            return null;
        }

        List<CountResponse> list = new ArrayList<CountResponse>( entities.size() );
        for ( Count count : entities ) {
            list.add( entityToResponse( count ) );
        }

        return list;
    }

    @Override
    public Count requestToEntity(CountRequest request) {
        if ( request == null ) {
            return null;
        }

        Count count = new Count();

        count.setWarehouse( mapperUtils.mapToWarehouse( request.getWarehouseId() ) );
        count.setCode( request.getCode() );
        count.setCountVariants( countVariantRequestSetToCountVariantSet( request.getCountVariants() ) );
        count.setNote( request.getNote() );
        count.setStatus( request.getStatus() );

        Count target = mapperUtils.attachCount( count );
        if ( target != null ) {
            return target;
        }

        return count;
    }

    @Override
    public Count partialUpdate(Count entity, CountRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setWarehouse( mapperUtils.mapToWarehouse( request.getWarehouseId() ) );
        entity.setCode( request.getCode() );
        if ( entity.getCountVariants() != null ) {
            Set<CountVariant> set = countVariantRequestSetToCountVariantSet( request.getCountVariants() );
            if ( set != null ) {
                entity.getCountVariants().clear();
                entity.getCountVariants().addAll( set );
            }
            else {
                entity.setCountVariants( null );
            }
        }
        else {
            Set<CountVariant> set = countVariantRequestSetToCountVariantSet( request.getCountVariants() );
            if ( set != null ) {
                entity.setCountVariants( set );
            }
        }
        entity.setNote( request.getNote() );
        entity.setStatus( request.getStatus() );

        Count target = mapperUtils.attachCount( entity );
        if ( target != null ) {
            return target;
        }

        return entity;
    }

    protected Set<CountVariantResponse> countVariantSetToCountVariantResponseSet(Set<CountVariant> set) {
        if ( set == null ) {
            return null;
        }

        Set<CountVariantResponse> set1 = new HashSet<CountVariantResponse>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( CountVariant countVariant : set ) {
            set1.add( countVariantMapper.entityToResponse( countVariant ) );
        }

        return set1;
    }

    protected Set<CountVariant> countVariantRequestSetToCountVariantSet(Set<CountVariantRequest> set) {
        if ( set == null ) {
            return null;
        }

        Set<CountVariant> set1 = new HashSet<CountVariant>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( CountVariantRequest countVariantRequest : set ) {
            set1.add( countVariantMapper.requestToEntity( countVariantRequest ) );
        }

        return set1;
    }
}
