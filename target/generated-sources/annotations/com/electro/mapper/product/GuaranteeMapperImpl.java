package com.electro.mapper.product;

import com.electro.dto.product.GuaranteeRequest;
import com.electro.dto.product.GuaranteeResponse;
import com.electro.entity.product.Guarantee;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-02T03:17:50+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class GuaranteeMapperImpl implements GuaranteeMapper {

    @Override
    public Guarantee requestToEntity(GuaranteeRequest request) {
        if ( request == null ) {
            return null;
        }

        Guarantee guarantee = new Guarantee();

        guarantee.setName( request.getName() );
        guarantee.setDescription( request.getDescription() );
        guarantee.setStatus( request.getStatus() );

        return guarantee;
    }

    @Override
    public GuaranteeResponse entityToResponse(Guarantee entity) {
        if ( entity == null ) {
            return null;
        }

        GuaranteeResponse guaranteeResponse = new GuaranteeResponse();

        guaranteeResponse.setId( entity.getId() );
        guaranteeResponse.setCreatedAt( entity.getCreatedAt() );
        guaranteeResponse.setUpdatedAt( entity.getUpdatedAt() );
        guaranteeResponse.setName( entity.getName() );
        guaranteeResponse.setDescription( entity.getDescription() );
        guaranteeResponse.setStatus( entity.getStatus() );

        return guaranteeResponse;
    }

    @Override
    public List<Guarantee> requestToEntity(List<GuaranteeRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Guarantee> list = new ArrayList<Guarantee>( requests.size() );
        for ( GuaranteeRequest guaranteeRequest : requests ) {
            list.add( requestToEntity( guaranteeRequest ) );
        }

        return list;
    }

    @Override
    public List<GuaranteeResponse> entityToResponse(List<Guarantee> entities) {
        if ( entities == null ) {
            return null;
        }

        List<GuaranteeResponse> list = new ArrayList<GuaranteeResponse>( entities.size() );
        for ( Guarantee guarantee : entities ) {
            list.add( entityToResponse( guarantee ) );
        }

        return list;
    }

    @Override
    public Guarantee partialUpdate(Guarantee entity, GuaranteeRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setName( request.getName() );
        entity.setDescription( request.getDescription() );
        entity.setStatus( request.getStatus() );

        return entity;
    }
}
