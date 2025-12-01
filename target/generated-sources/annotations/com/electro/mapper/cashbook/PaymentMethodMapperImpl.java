package com.electro.mapper.cashbook;

import com.electro.dto.cashbook.ClientPaymentMethodResponse;
import com.electro.dto.cashbook.PaymentMethodRequest;
import com.electro.dto.cashbook.PaymentMethodResponse;
import com.electro.entity.cashbook.PaymentMethod;
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
public class PaymentMethodMapperImpl implements PaymentMethodMapper {

    @Override
    public PaymentMethod requestToEntity(PaymentMethodRequest request) {
        if ( request == null ) {
            return null;
        }

        PaymentMethod paymentMethod = new PaymentMethod();

        paymentMethod.setStatus( request.getStatus() );

        return paymentMethod;
    }

    @Override
    public PaymentMethodResponse entityToResponse(PaymentMethod entity) {
        if ( entity == null ) {
            return null;
        }

        PaymentMethodResponse paymentMethodResponse = new PaymentMethodResponse();

        paymentMethodResponse.setId( entity.getId() );
        paymentMethodResponse.setCreatedAt( entity.getCreatedAt() );
        paymentMethodResponse.setUpdatedAt( entity.getUpdatedAt() );
        paymentMethodResponse.setName( entity.getName() );
        paymentMethodResponse.setCode( entity.getCode() );
        paymentMethodResponse.setStatus( entity.getStatus() );

        return paymentMethodResponse;
    }

    @Override
    public List<PaymentMethod> requestToEntity(List<PaymentMethodRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<PaymentMethod> list = new ArrayList<PaymentMethod>( requests.size() );
        for ( PaymentMethodRequest paymentMethodRequest : requests ) {
            list.add( requestToEntity( paymentMethodRequest ) );
        }

        return list;
    }

    @Override
    public List<PaymentMethodResponse> entityToResponse(List<PaymentMethod> entities) {
        if ( entities == null ) {
            return null;
        }

        List<PaymentMethodResponse> list = new ArrayList<PaymentMethodResponse>( entities.size() );
        for ( PaymentMethod paymentMethod : entities ) {
            list.add( entityToResponse( paymentMethod ) );
        }

        return list;
    }

    @Override
    public PaymentMethod partialUpdate(PaymentMethod entity, PaymentMethodRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setStatus( request.getStatus() );

        return entity;
    }

    @Override
    public ClientPaymentMethodResponse entityToClientResponse(PaymentMethod entity) {
        if ( entity == null ) {
            return null;
        }

        ClientPaymentMethodResponse clientPaymentMethodResponse = new ClientPaymentMethodResponse();

        clientPaymentMethodResponse.setPaymentMethodId( entity.getId() );
        clientPaymentMethodResponse.setPaymentMethodName( entity.getName() );
        clientPaymentMethodResponse.setPaymentMethodCode( entity.getCode() );

        return clientPaymentMethodResponse;
    }

    @Override
    public List<ClientPaymentMethodResponse> entityToClientResponse(List<PaymentMethod> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ClientPaymentMethodResponse> list = new ArrayList<ClientPaymentMethodResponse>( entities.size() );
        for ( PaymentMethod paymentMethod : entities ) {
            list.add( entityToClientResponse( paymentMethod ) );
        }

        return list;
    }
}
