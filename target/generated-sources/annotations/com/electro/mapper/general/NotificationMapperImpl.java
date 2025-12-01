package com.electro.mapper.general;

import com.electro.dto.general.NotificationRequest;
import com.electro.dto.general.NotificationResponse;
import com.electro.entity.general.Notification;
import com.electro.utils.MapperUtils;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-02T03:17:52+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class NotificationMapperImpl implements NotificationMapper {

    @Autowired
    private MapperUtils mapperUtils;

    @Override
    public NotificationResponse entityToResponse(Notification entity) {
        if ( entity == null ) {
            return null;
        }

        NotificationResponse notificationResponse = new NotificationResponse();

        notificationResponse.setId( entity.getId() );
        notificationResponse.setCreatedAt( entity.getCreatedAt() );
        notificationResponse.setType( entity.getType() );
        notificationResponse.setMessage( entity.getMessage() );
        notificationResponse.setAnchor( entity.getAnchor() );
        notificationResponse.setStatus( entity.getStatus() );

        return notificationResponse;
    }

    @Override
    public List<Notification> requestToEntity(List<NotificationRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Notification> list = new ArrayList<Notification>( requests.size() );
        for ( NotificationRequest notificationRequest : requests ) {
            list.add( requestToEntity( notificationRequest ) );
        }

        return list;
    }

    @Override
    public List<NotificationResponse> entityToResponse(List<Notification> entities) {
        if ( entities == null ) {
            return null;
        }

        List<NotificationResponse> list = new ArrayList<NotificationResponse>( entities.size() );
        for ( Notification notification : entities ) {
            list.add( entityToResponse( notification ) );
        }

        return list;
    }

    @Override
    public Notification requestToEntity(NotificationRequest request) {
        if ( request == null ) {
            return null;
        }

        Notification notification = new Notification();

        notification.setUser( mapperUtils.mapToUser( request.getUserId() ) );
        notification.setType( request.getType() );
        notification.setMessage( request.getMessage() );
        notification.setAnchor( request.getAnchor() );
        notification.setStatus( request.getStatus() );

        return notification;
    }

    @Override
    public Notification partialUpdate(Notification entity, NotificationRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setUser( mapperUtils.mapToUser( request.getUserId() ) );
        entity.setType( request.getType() );
        entity.setMessage( request.getMessage() );
        entity.setAnchor( request.getAnchor() );
        entity.setStatus( request.getStatus() );

        return entity;
    }
}
