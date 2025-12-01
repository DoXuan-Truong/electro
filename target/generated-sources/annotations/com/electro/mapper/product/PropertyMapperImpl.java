package com.electro.mapper.product;

import com.electro.dto.product.PropertyRequest;
import com.electro.dto.product.PropertyResponse;
import com.electro.entity.product.Property;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-02T03:17:47+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class PropertyMapperImpl implements PropertyMapper {

    @Override
    public Property requestToEntity(PropertyRequest request) {
        if ( request == null ) {
            return null;
        }

        Property property = new Property();

        property.setName( request.getName() );
        property.setCode( request.getCode() );
        property.setDescription( request.getDescription() );
        property.setStatus( request.getStatus() );

        return property;
    }

    @Override
    public PropertyResponse entityToResponse(Property entity) {
        if ( entity == null ) {
            return null;
        }

        PropertyResponse propertyResponse = new PropertyResponse();

        propertyResponse.setId( entity.getId() );
        propertyResponse.setCreatedAt( entity.getCreatedAt() );
        propertyResponse.setUpdatedAt( entity.getUpdatedAt() );
        propertyResponse.setName( entity.getName() );
        propertyResponse.setCode( entity.getCode() );
        propertyResponse.setDescription( entity.getDescription() );
        propertyResponse.setStatus( entity.getStatus() );

        return propertyResponse;
    }

    @Override
    public List<Property> requestToEntity(List<PropertyRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Property> list = new ArrayList<Property>( requests.size() );
        for ( PropertyRequest propertyRequest : requests ) {
            list.add( requestToEntity( propertyRequest ) );
        }

        return list;
    }

    @Override
    public List<PropertyResponse> entityToResponse(List<Property> entities) {
        if ( entities == null ) {
            return null;
        }

        List<PropertyResponse> list = new ArrayList<PropertyResponse>( entities.size() );
        for ( Property property : entities ) {
            list.add( entityToResponse( property ) );
        }

        return list;
    }

    @Override
    public Property partialUpdate(Property entity, PropertyRequest request) {
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
