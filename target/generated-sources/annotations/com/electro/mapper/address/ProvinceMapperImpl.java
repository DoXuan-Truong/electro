package com.electro.mapper.address;

import com.electro.dto.address.ProvinceRequest;
import com.electro.dto.address.ProvinceResponse;
import com.electro.entity.address.Province;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-02T03:17:49+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class ProvinceMapperImpl implements ProvinceMapper {

    @Override
    public Province requestToEntity(ProvinceRequest request) {
        if ( request == null ) {
            return null;
        }

        Province province = new Province();

        province.setName( request.getName() );
        province.setCode( request.getCode() );

        return province;
    }

    @Override
    public ProvinceResponse entityToResponse(Province entity) {
        if ( entity == null ) {
            return null;
        }

        ProvinceResponse provinceResponse = new ProvinceResponse();

        provinceResponse.setId( entity.getId() );
        provinceResponse.setCreatedAt( entity.getCreatedAt() );
        provinceResponse.setUpdatedAt( entity.getUpdatedAt() );
        provinceResponse.setName( entity.getName() );
        provinceResponse.setCode( entity.getCode() );

        return provinceResponse;
    }

    @Override
    public List<Province> requestToEntity(List<ProvinceRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Province> list = new ArrayList<Province>( requests.size() );
        for ( ProvinceRequest provinceRequest : requests ) {
            list.add( requestToEntity( provinceRequest ) );
        }

        return list;
    }

    @Override
    public List<ProvinceResponse> entityToResponse(List<Province> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ProvinceResponse> list = new ArrayList<ProvinceResponse>( entities.size() );
        for ( Province province : entities ) {
            list.add( entityToResponse( province ) );
        }

        return list;
    }

    @Override
    public Province partialUpdate(Province entity, ProvinceRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setName( request.getName() );
        entity.setCode( request.getCode() );

        return entity;
    }
}
