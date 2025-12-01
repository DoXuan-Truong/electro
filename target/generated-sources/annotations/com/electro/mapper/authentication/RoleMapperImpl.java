package com.electro.mapper.authentication;

import com.electro.dto.authentication.RoleRequest;
import com.electro.dto.authentication.RoleResponse;
import com.electro.entity.authentication.Role;
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
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role requestToEntity(RoleRequest request) {
        if ( request == null ) {
            return null;
        }

        Role role = new Role();

        role.setCode( request.getCode() );
        role.setName( request.getName() );
        role.setStatus( request.getStatus() );

        return role;
    }

    @Override
    public RoleResponse entityToResponse(Role entity) {
        if ( entity == null ) {
            return null;
        }

        RoleResponse roleResponse = new RoleResponse();

        roleResponse.setId( entity.getId() );
        roleResponse.setCreatedAt( entity.getCreatedAt() );
        roleResponse.setUpdatedAt( entity.getUpdatedAt() );
        roleResponse.setCode( entity.getCode() );
        roleResponse.setName( entity.getName() );
        roleResponse.setStatus( entity.getStatus() );

        return roleResponse;
    }

    @Override
    public List<Role> requestToEntity(List<RoleRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Role> list = new ArrayList<Role>( requests.size() );
        for ( RoleRequest roleRequest : requests ) {
            list.add( requestToEntity( roleRequest ) );
        }

        return list;
    }

    @Override
    public List<RoleResponse> entityToResponse(List<Role> entities) {
        if ( entities == null ) {
            return null;
        }

        List<RoleResponse> list = new ArrayList<RoleResponse>( entities.size() );
        for ( Role role : entities ) {
            list.add( entityToResponse( role ) );
        }

        return list;
    }

    @Override
    public Role partialUpdate(Role entity, RoleRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setCode( request.getCode() );
        entity.setName( request.getName() );
        entity.setStatus( request.getStatus() );

        return entity;
    }
}
