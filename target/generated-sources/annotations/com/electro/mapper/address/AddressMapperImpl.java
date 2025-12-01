package com.electro.mapper.address;

import com.electro.dto.address.AddressRequest;
import com.electro.dto.address.AddressResponse;
import com.electro.dto.address.AddressResponse.DistrictResponse;
import com.electro.dto.address.AddressResponse.WardResponse;
import com.electro.dto.address.ProvinceResponse;
import com.electro.entity.address.Address;
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
    date = "2025-12-02T04:44:15+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Autowired
    private MapperUtils mapperUtils;

    @Override
    public AddressResponse entityToResponse(Address entity) {
        if ( entity == null ) {
            return null;
        }

        AddressResponse addressResponse = new AddressResponse();

        addressResponse.setId( entity.getId() );
        addressResponse.setCreatedAt( entity.getCreatedAt() );
        addressResponse.setUpdatedAt( entity.getUpdatedAt() );
        addressResponse.setLine( entity.getLine() );
        addressResponse.setProvince( provinceToProvinceResponse( entity.getProvince() ) );
        addressResponse.setDistrict( districtToDistrictResponse( entity.getDistrict() ) );
        addressResponse.setWard( wardToWardResponse( entity.getWard() ) );

        return addressResponse;
    }

    @Override
    public List<Address> requestToEntity(List<AddressRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Address> list = new ArrayList<Address>( requests.size() );
        for ( AddressRequest addressRequest : requests ) {
            list.add( requestToEntity( addressRequest ) );
        }

        return list;
    }

    @Override
    public List<AddressResponse> entityToResponse(List<Address> entities) {
        if ( entities == null ) {
            return null;
        }

        List<AddressResponse> list = new ArrayList<AddressResponse>( entities.size() );
        for ( Address address : entities ) {
            list.add( entityToResponse( address ) );
        }

        return list;
    }

    @Override
    public Address requestToEntity(AddressRequest request) {
        if ( request == null ) {
            return null;
        }

        Address address = new Address();

        address.setProvince( mapperUtils.mapToProvince( request.getProvinceId() ) );
        address.setDistrict( mapperUtils.mapToDistrict( request.getDistrictId() ) );
        address.setWard( mapperUtils.mapToWard( request.getWardId() ) );
        address.setLine( request.getLine() );

        return address;
    }

    @Override
    public Address partialUpdate(Address entity, AddressRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setProvince( mapperUtils.mapToProvince( request.getProvinceId() ) );
        entity.setDistrict( mapperUtils.mapToDistrict( request.getDistrictId() ) );
        entity.setWard( mapperUtils.mapToWard( request.getWardId() ) );
        entity.setLine( request.getLine() );

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

        return districtResponse;
    }

    protected WardResponse wardToWardResponse(Ward ward) {
        if ( ward == null ) {
            return null;
        }

        WardResponse wardResponse = new WardResponse();

        wardResponse.setId( ward.getId() );
        wardResponse.setCreatedAt( ward.getCreatedAt() );
        wardResponse.setUpdatedAt( ward.getUpdatedAt() );
        wardResponse.setName( ward.getName() );
        wardResponse.setCode( ward.getCode() );

        return wardResponse;
    }
}
