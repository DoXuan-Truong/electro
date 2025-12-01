package com.electro.mapper.inventory;

import com.electro.dto.inventory.TransferRequest;
import com.electro.dto.inventory.TransferResponse;
import com.electro.entity.inventory.Docket;
import com.electro.entity.inventory.Transfer;
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
public class TransferMapperImpl implements TransferMapper {

    @Autowired
    private DocketMapper docketMapper;

    @Override
    public Transfer requestToEntity(TransferRequest request) {
        if ( request == null ) {
            return null;
        }

        Transfer transfer = new Transfer();

        transfer.setCode( request.getCode() );
        transfer.setExportDocket( docketMapper.requestToEntity( request.getExportDocket() ) );
        transfer.setImportDocket( docketMapper.requestToEntity( request.getImportDocket() ) );
        transfer.setNote( request.getNote() );

        return transfer;
    }

    @Override
    public TransferResponse entityToResponse(Transfer entity) {
        if ( entity == null ) {
            return null;
        }

        TransferResponse transferResponse = new TransferResponse();

        transferResponse.setId( entity.getId() );
        transferResponse.setCreatedAt( entity.getCreatedAt() );
        transferResponse.setUpdatedAt( entity.getUpdatedAt() );
        transferResponse.setCode( entity.getCode() );
        transferResponse.setExportDocket( docketMapper.entityToResponse( entity.getExportDocket() ) );
        transferResponse.setImportDocket( docketMapper.entityToResponse( entity.getImportDocket() ) );
        transferResponse.setNote( entity.getNote() );

        return transferResponse;
    }

    @Override
    public List<Transfer> requestToEntity(List<TransferRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Transfer> list = new ArrayList<Transfer>( requests.size() );
        for ( TransferRequest transferRequest : requests ) {
            list.add( requestToEntity( transferRequest ) );
        }

        return list;
    }

    @Override
    public List<TransferResponse> entityToResponse(List<Transfer> entities) {
        if ( entities == null ) {
            return null;
        }

        List<TransferResponse> list = new ArrayList<TransferResponse>( entities.size() );
        for ( Transfer transfer : entities ) {
            list.add( entityToResponse( transfer ) );
        }

        return list;
    }

    @Override
    public Transfer partialUpdate(Transfer entity, TransferRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setCode( request.getCode() );
        if ( request.getExportDocket() != null ) {
            if ( entity.getExportDocket() == null ) {
                entity.setExportDocket( new Docket() );
            }
            docketMapper.partialUpdate( entity.getExportDocket(), request.getExportDocket() );
        }
        else {
            entity.setExportDocket( null );
        }
        if ( request.getImportDocket() != null ) {
            if ( entity.getImportDocket() == null ) {
                entity.setImportDocket( new Docket() );
            }
            docketMapper.partialUpdate( entity.getImportDocket(), request.getImportDocket() );
        }
        else {
            entity.setImportDocket( null );
        }
        entity.setNote( request.getNote() );

        return entity;
    }
}
