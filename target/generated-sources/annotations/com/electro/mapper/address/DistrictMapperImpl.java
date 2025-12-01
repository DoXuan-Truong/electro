package com.electro.mapper.address;

import com.electro.dto.address.DistrictRequest;
import com.electro.dto.address.DistrictResponse;
import com.electro.dto.address.ProvinceResponse;
import com.electro.entity.address.District;
import com.electro.entity.address.Province;
import com.electro.utils.MapperUtils;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-02T03:17:50+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class DistrictMapperImpl implements DistrictMapper {

    @Autowired
    private MapperUtils mapperUtils;

    @Override
    public DistrictResponse entityToResponse(District entity) {
        if ( entity == null ) {
            return null;
        }

        DistrictResponse districtResponse = new DistrictResponse();

        districtResponse.setId( entity.getId() );
        districtResponse.setCreatedAt( entity.getCreatedAt() );
        districtResponse.setUpdatedAt( entity.getUpdatedAt() );
        districtResponse.setName( entity.getName() );
        districtResponse.setCode( entity.getCode() );
        districtResponse.setProvince( provinceToProvinceResponse( entity.getProvince() ) );

        return districtResponse;
    }

    @Override
    public List<District> requestToEntity(List<DistrictRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<District> list = new ArrayList<District>( requests.size() );
        for ( DistrictRequest districtRequest : requests ) {
            list.add( requestToEntity( districtRequest ) );
        }

        return list;
    }

    @Override
    public List<DistrictResponse> entityToResponse(List<District> entities) {
        if ( entities == null ) {
            return null;
        }

        List<DistrictResponse> list = new ArrayList<DistrictResponse>( entities.size() );
        for ( District district : entities ) {
            list.add( entityToResponse( district ) );
        }

        return list;
    }

    @Override
    public District requestToEntity(DistrictRequest request) {
        if ( request == null ) {
            return null;
        }

        District district = new District();

        district.setProvince( mapperUtils.mapToProvince( request.getProvinceId() ) );
        district.setName( request.getName() );
        district.setCode( request.getCode() );

        return district;
    }

    @Override
    public District partialUpdate(District entity, DistrictRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setProvince( mapperUtils.mapToProvince( request.getProvinceId() ) );
        entity.setName( request.getName() );
        entity.setCode( request.getCode() );

        return entity;
    }

    protected ProvinceResponse provinceToProvinceResponse(Province province) {
        if ( province == null ) {
            return null;
        }

        ProvinceResponse provinceResponse = new ProvinceResponse();

        provinceResponse.setId( province.getId() );
        provinceResponse.setCreatedAt( province.getCreatedAt() );
        provinceResponse.setUpdatedAt( province.getUpdatedAt() );
        provinceResponse.setName( province.getName() );
        provinceResponse.setCode( province.getCode() );

        return provinceResponse;
    }
}
