package com.electro.mapper.chat;

import com.electro.dto.chat.MessageRequest;
import com.electro.dto.chat.MessageResponse;
import com.electro.dto.chat.MessageResponse.UserResponse;
import com.electro.entity.authentication.User;
import com.electro.entity.chat.Message;
import com.electro.utils.MapperUtils;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-02T03:17:49+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class MessageMapperImpl implements MessageMapper {

    @Autowired
    private MapperUtils mapperUtils;

    @Override
    public MessageResponse entityToResponse(Message entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        Instant createdAt = null;
        Instant updatedAt = null;
        String content = null;
        Integer status = null;
        UserResponse user = null;

        id = entity.getId();
        createdAt = entity.getCreatedAt();
        updatedAt = entity.getUpdatedAt();
        content = entity.getContent();
        status = entity.getStatus();
        user = userToUserResponse( entity.getUser() );

        MessageResponse messageResponse = new MessageResponse( id, createdAt, updatedAt, content, status, user );

        return messageResponse;
    }

    @Override
    public List<Message> requestToEntity(List<MessageRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Message> list = new ArrayList<Message>( requests.size() );
        for ( MessageRequest messageRequest : requests ) {
            list.add( requestToEntity( messageRequest ) );
        }

        return list;
    }

    @Override
    public List<MessageResponse> entityToResponse(List<Message> entities) {
        if ( entities == null ) {
            return null;
        }

        List<MessageResponse> list = new ArrayList<MessageResponse>( entities.size() );
        for ( Message message : entities ) {
            list.add( entityToResponse( message ) );
        }

        return list;
    }

    @Override
    public Message partialUpdate(Message entity, MessageRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setContent( request.getContent() );
        entity.setStatus( request.getStatus() );

        return entity;
    }

    @Override
    public Message requestToEntity(MessageRequest request) {
        if ( request == null ) {
            return null;
        }

        Message message = new Message();

        message.setUser( mapperUtils.mapToUser( request.getUserId() ) );
        message.setRoom( mapperUtils.mapToRoom( request.getRoomId() ) );
        message.setContent( request.getContent() );
        message.setStatus( request.getStatus() );

        return message;
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
}
