package com.electro.mapper.chat;

import com.electro.dto.chat.MessageResponse;
import com.electro.dto.chat.RoomRequest;
import com.electro.dto.chat.RoomResponse;
import com.electro.dto.chat.RoomResponse.UserResponse;
import com.electro.entity.authentication.User;
import com.electro.entity.chat.Message;
import com.electro.entity.chat.Room;
import com.electro.utils.MapperUtils;
import java.time.Instant;
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
public class RoomMapperImpl implements RoomMapper {

    @Autowired
    private MapperUtils mapperUtils;

    @Override
    public RoomResponse entityToResponse(Room entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        Instant createdAt = null;
        Instant updatedAt = null;
        String name = null;
        UserResponse user = null;
        MessageResponse lastMessage = null;

        id = entity.getId();
        createdAt = entity.getCreatedAt();
        updatedAt = entity.getUpdatedAt();
        name = entity.getName();
        user = userToUserResponse( entity.getUser() );
        lastMessage = messageToMessageResponse( entity.getLastMessage() );

        RoomResponse roomResponse = new RoomResponse( id, createdAt, updatedAt, name, user, lastMessage );

        return roomResponse;
    }

    @Override
    public List<Room> requestToEntity(List<RoomRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Room> list = new ArrayList<Room>( requests.size() );
        for ( RoomRequest roomRequest : requests ) {
            list.add( requestToEntity( roomRequest ) );
        }

        return list;
    }

    @Override
    public List<RoomResponse> entityToResponse(List<Room> entities) {
        if ( entities == null ) {
            return null;
        }

        List<RoomResponse> list = new ArrayList<RoomResponse>( entities.size() );
        for ( Room room : entities ) {
            list.add( entityToResponse( room ) );
        }

        return list;
    }

    @Override
    public Room partialUpdate(Room entity, RoomRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setName( request.getName() );

        return entity;
    }

    @Override
    public Room requestToEntity(RoomRequest request) {
        if ( request == null ) {
            return null;
        }

        Room room = new Room();

        room.setUser( mapperUtils.mapToUser( request.getUserId() ) );
        room.setName( request.getName() );

        return room;
    }

    protected UserResponse userToUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        String username = null;
        String fullname = null;
        String email = null;

        id = user.getId();
        username = user.getUsername();
        fullname = user.getFullname();
        email = user.getEmail();

        UserResponse userResponse = new UserResponse( id, username, fullname, email );

        return userResponse;
    }

    protected com.electro.dto.chat.MessageResponse.UserResponse userToUserResponse1(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        String username = null;
        String fullname = null;
        String email = null;

        id = user.getId();
        username = user.getUsername();
        fullname = user.getFullname();
        email = user.getEmail();

        com.electro.dto.chat.MessageResponse.UserResponse userResponse = new com.electro.dto.chat.MessageResponse.UserResponse( id, username, fullname, email );

        return userResponse;
    }

    protected MessageResponse messageToMessageResponse(Message message) {
        if ( message == null ) {
            return null;
        }

        Long id = null;
        Instant createdAt = null;
        Instant updatedAt = null;
        String content = null;
        Integer status = null;
        com.electro.dto.chat.MessageResponse.UserResponse user = null;

        id = message.getId();
        createdAt = message.getCreatedAt();
        updatedAt = message.getUpdatedAt();
        content = message.getContent();
        status = message.getStatus();
        user = userToUserResponse1( message.getUser() );

        MessageResponse messageResponse = new MessageResponse( id, createdAt, updatedAt, content, status, user );

        return messageResponse;
    }
}
