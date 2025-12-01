package com.electro.mapper.product;

import com.electro.dto.product.BrandRequest;
import com.electro.dto.product.BrandResponse;
import com.electro.entity.product.Brand;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-02T03:17:51+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class BrandMapperImpl implements BrandMapper {

    @Override
    public Brand requestToEntity(BrandRequest request) {
        if ( request == null ) {
            return null;
        }

        Brand brand = new Brand();

        brand.setName( request.getName() );
        brand.setCode( request.getCode() );
        brand.setDescription( request.getDescription() );
        brand.setStatus( request.getStatus() );

        return brand;
    }

    @Override
    public BrandResponse entityToResponse(Brand entity) {
        if ( entity == null ) {
            return null;
        }

        BrandResponse brandResponse = new BrandResponse();

        brandResponse.setId( entity.getId() );
        brandResponse.setCreatedAt( entity.getCreatedAt() );
        brandResponse.setUpdatedAt( entity.getUpdatedAt() );
        brandResponse.setName( entity.getName() );
        brandResponse.setCode( entity.getCode() );
        brandResponse.setDescription( entity.getDescription() );
        brandResponse.setStatus( entity.getStatus() );

        return brandResponse;
    }

    @Override
    public List<Brand> requestToEntity(List<BrandRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Brand> list = new ArrayList<Brand>( requests.size() );
        for ( BrandRequest brandRequest : requests ) {
            list.add( requestToEntity( brandRequest ) );
        }

        return list;
    }

    @Override
    public List<BrandResponse> entityToResponse(List<Brand> entities) {
        if ( entities == null ) {
            return null;
        }

        List<BrandResponse> list = new ArrayList<BrandResponse>( entities.size() );
        for ( Brand brand : entities ) {
            list.add( entityToResponse( brand ) );
        }

        return list;
    }

    @Override
    public Brand partialUpdate(Brand entity, BrandRequest request) {
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
