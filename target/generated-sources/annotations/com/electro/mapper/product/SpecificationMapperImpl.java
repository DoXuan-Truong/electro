package com.electro.mapper.product;

import com.electro.dto.product.SpecificationRequest;
import com.electro.dto.product.SpecificationResponse;
import com.electro.entity.product.Specification;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-02T04:44:15+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class SpecificationMapperImpl implements SpecificationMapper {

    @Override
    public Specification requestToEntity(SpecificationRequest request) {
        if ( request == null ) {
            return null;
        }

        Specification specification = new Specification();

        specification.setName( request.getName() );
        specification.setCode( request.getCode() );
        specification.setDescription( request.getDescription() );
        specification.setStatus( request.getStatus() );

        return specification;
    }

    @Override
    public SpecificationResponse entityToResponse(Specification entity) {
        if ( entity == null ) {
            return null;
        }

        SpecificationResponse specificationResponse = new SpecificationResponse();

        specificationResponse.setId( entity.getId() );
        specificationResponse.setCreatedAt( entity.getCreatedAt() );
        specificationResponse.setUpdatedAt( entity.getUpdatedAt() );
        specificationResponse.setName( entity.getName() );
        specificationResponse.setCode( entity.getCode() );
        specificationResponse.setDescription( entity.getDescription() );
        specificationResponse.setStatus( entity.getStatus() );

        return specificationResponse;
    }

    @Override
    public List<Specification> requestToEntity(List<SpecificationRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Specification> list = new ArrayList<Specification>( requests.size() );
        for ( SpecificationRequest specificationRequest : requests ) {
            list.add( requestToEntity( specificationRequest ) );
        }

        return list;
    }

    @Override
    public List<SpecificationResponse> entityToResponse(List<Specification> entities) {
        if ( entities == null ) {
            return null;
        }

        List<SpecificationResponse> list = new ArrayList<SpecificationResponse>( entities.size() );
        for ( Specification specification : entities ) {
            list.add( entityToResponse( specification ) );
        }

        return list;
    }

    @Override
    public Specification partialUpdate(Specification entity, SpecificationRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setName( request.getName() );
        entity.setCode( request.getCode() );
        entity.setDescription( request.getDescription() );
        entity.setStatus( request.getStatus() );

        return entity;
    }
}
