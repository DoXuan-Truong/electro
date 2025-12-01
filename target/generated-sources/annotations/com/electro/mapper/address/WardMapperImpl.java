package com.electro.mapper.address;

import com.electro.dto.address.DistrictResponse;
import com.electro.dto.address.ProvinceResponse;
import com.electro.dto.address.WardRequest;
import com.electro.dto.address.WardResponse;
import com.electro.entity.address.District;
import com.electro.entity.address.Province;
import com.electro.entity.address.Ward;
import com.electro.utils.MapperUtils;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-02T04:44:14+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class WardMapperImpl implements WardMapper {

    @Autowired
    private MapperUtils mapperUtils;

    @Override
    public WardResponse entityToResponse(Ward entity) {
        if ( entity == null ) {
            return null;
        }

        WardResponse wardResponse = new WardResponse();

        wardResponse.setId( entity.getId() );
        wardResponse.setCreatedAt( entity.getCreatedAt() );
        wardResponse.setUpdatedAt( entity.getUpdatedAt() );
        wardResponse.setName( entity.getName() );
        wardResponse.setCode( entity.getCode() );
        wardResponse.setDistrict( districtToDistrictResponse( entity.getDistrict() ) );

        return wardResponse;
    }

    @Override
    public List<Ward> requestToEntity(List<WardRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Ward> list = new ArrayList<Ward>( requests.size() );
        for ( WardRequest wardRequest : requests ) {
            list.add( requestToEntity( wardRequest ) );
        }

        return list;
    }

    @Override
    public List<WardResponse> entityToResponse(List<Ward> entities) {
        if ( entities == null ) {
            return null;
        }

        List<WardResponse> list = new ArrayList<WardResponse>( entities.size() );
        for ( Ward ward : entities ) {
            list.add( entityToResponse( ward ) );
        }

        return list;
    }

    @Override
    public Ward requestToEntity(WardRequest request) {
        if ( request == null ) {
            return null;
        }

        Ward ward = new Ward();

        ward.setDistrict( mapperUtils.mapToDistrict( request.getDistrictId() ) );
        ward.setName( request.getName() );
        ward.setCode( request.getCode() );

        return ward;
    }

    @Override
    public Ward partialUpdate(Ward entity, WardRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setDistrict( mapperUtils.mapToDistrict( request.getDistrictId() ) );
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

    protected DistrictResponse districtToDistrictResponse(District district) {
        if ( district == null ) {
            return null;
        }

        DistrictResponse districtResponse = new DistrictResponse();

        districtResponse.setId( district.getId() );
        districtResponse.setCreatedAt( district.getCreatedAt() );
        districtResponse.setUpdatedAt( district.getUpdatedAt() );
        districtResponse.setName( district.getName() );
        districtResponse.setCode( district.getCode() );
        districtResponse.setProvince( provinceToProvinceResponse( district.getProvince() ) );

        return districtResponse;
    }
}
