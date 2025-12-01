package com.electro.mapper.authentication;

import com.electro.dto.authentication.RoleResponse;
import com.electro.dto.authentication.Role_UserRequest;
import com.electro.dto.authentication.UserRequest;
import com.electro.dto.authentication.UserResponse;
import com.electro.dto.client.ClientEmailSettingUserRequest;
import com.electro.dto.client.ClientPersonalSettingUserRequest;
import com.electro.dto.client.ClientPhoneSettingUserRequest;
import com.electro.entity.address.Address;
import com.electro.entity.authentication.Role;
import com.electro.entity.authentication.User;
import com.electro.mapper.address.AddressMapper;
import com.electro.utils.MapperUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-02T03:17:51+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private MapperUtils mapperUtils;
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public UserResponse entityToResponse(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        userResponse.setId( entity.getId() );
        userResponse.setCreatedAt( entity.getCreatedAt() );
        userResponse.setUpdatedAt( entity.getUpdatedAt() );
        userResponse.setUsername( entity.getUsername() );
        userResponse.setFullname( entity.getFullname() );
        userResponse.setEmail( entity.getEmail() );
        userResponse.setPhone( entity.getPhone() );
        userResponse.setGender( entity.getGender() );
        userResponse.setAddress( addressMapper.entityToResponse( entity.getAddress() ) );
        userResponse.setAvatar( entity.getAvatar() );
        userResponse.setStatus( entity.getStatus() );
        userResponse.setRoles( roleSetToRoleResponseSet( entity.getRoles() ) );

        return userResponse;
    }

    @Override
    public List<User> requestToEntity(List<UserRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( requests.size() );
        for ( UserRequest userRequest : requests ) {
            list.add( requestToEntity( userRequest ) );
        }

        return list;
    }

    @Override
    public List<UserResponse> entityToResponse(List<User> entities) {
        if ( entities == null ) {
            return null;
        }

        List<UserResponse> list = new ArrayList<UserResponse>( entities.size() );
        for ( User user : entities ) {
            list.add( entityToResponse( user ) );
        }

        return list;
    }

    @Override
    public User requestToEntity(UserRequest request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

        user.setPassword( mapperUtils.hashPassword( request.getPassword() ) );
        user.setUsername( request.getUsername() );
        user.setFullname( request.getFullname() );
        user.setEmail( request.getEmail() );
        user.setPhone( request.getPhone() );
        user.setGender( request.getGender() );
        user.setAddress( addressMapper.requestToEntity( request.getAddress() ) );
        user.setAvatar( request.getAvatar() );
        user.setStatus( request.getStatus() );
        user.setRoles( role_UserRequestSetToRoleSet( request.getRoles() ) );

        User target = mapperUtils.attachUser( user );
        if ( target != null ) {
            return target;
        }

        return user;
    }

    @Override
    public User partialUpdate(User entity, UserRequest request) {
        if ( request == null ) {
            return null;
        }

        if ( request.getPassword() != null ) {
            entity.setPassword( mapperUtils.hashPassword( request.getPassword() ) );
        }
        entity.setUsername( request.getUsername() );
        entity.setFullname( request.getFullname() );
        entity.setEmail( request.getEmail() );
        entity.setPhone( request.getPhone() );
        entity.setGender( request.getGender() );
        if ( request.getAddress() != null ) {
            if ( entity.getAddress() == null ) {
                entity.setAddress( new Address() );
            }
            addressMapper.partialUpdate( entity.getAddress(), request.getAddress() );
        }
        else {
            entity.setAddress( null );
        }
        entity.setAvatar( request.getAvatar() );
        entity.setStatus( request.getStatus() );
        if ( entity.getRoles() != null ) {
            Set<Role> set = role_UserRequestSetToRoleSet( request.getRoles() );
            if ( set != null ) {
                entity.getRoles().clear();
                entity.getRoles().addAll( set );
            }
            else {
                entity.setRoles( null );
            }
        }
        else {
            Set<Role> set = role_UserRequestSetToRoleSet( request.getRoles() );
            if ( set != null ) {
                entity.setRoles( set );
            }
        }

        User target = mapperUtils.attachUser( entity );
        if ( target != null ) {
            return target;
        }

        return entity;
    }

    @Override
    public User partialUpdate(User entity, ClientPersonalSettingUserRequest request) {
        if ( request == null ) {
            return null;
        }

        if ( request.getUsername() != null ) {
            entity.setUsername( request.getUsername() );
        }
        if ( request.getFullname() != null ) {
            entity.setFullname( request.getFullname() );
        }
        if ( request.getGender() != null ) {
            entity.setGender( request.getGender() );
        }
        if ( request.getAddress() != null ) {
            if ( entity.getAddress() == null ) {
                entity.setAddress( new Address() );
            }
            addressMapper.partialUpdate( entity.getAddress(), request.getAddress() );
        }

        return entity;
    }

    @Override
    public User partialUpdate(User entity, ClientPhoneSettingUserRequest request) {
        if ( request == null ) {
            return null;
        }

        if ( request.getPhone() != null ) {
            entity.setPhone( request.getPhone() );
        }

        return entity;
    }

    @Override
    public User partialUpdate(User entity, ClientEmailSettingUserRequest request) {
        if ( request == null ) {
            return null;
        }

        if ( request.getEmail() != null ) {
            entity.setEmail( request.getEmail() );
        }

        return entity;
    }

    protected RoleResponse roleToRoleResponse(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleResponse roleResponse = new RoleResponse();

        roleResponse.setId( role.getId() );
        roleResponse.setCreatedAt( role.getCreatedAt() );
        roleResponse.setUpdatedAt( role.getUpdatedAt() );
        roleResponse.setCode( role.getCode() );
        roleResponse.setName( role.getName() );
        roleResponse.setStatus( role.getStatus() );

        return roleResponse;
    }

    protected Set<RoleResponse> roleSetToRoleResponseSet(Set<Role> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoleResponse> set1 = new HashSet<RoleResponse>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Role role : set ) {
            set1.add( roleToRoleResponse( role ) );
        }

        return set1;
    }

    protected Role role_UserRequestToRole(Role_UserRequest role_UserRequest) {
        if ( role_UserRequest == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( role_UserRequest.getId() );
        role.setCode( role_UserRequest.getCode() );
        role.setName( role_UserRequest.getName() );
        role.setStatus( role_UserRequest.getStatus() );

        return role;
    }

    protected Set<Role> role_UserRequestSetToRoleSet(Set<Role_UserRequest> set) {
        if ( set == null ) {
            return null;
        }

        Set<Role> set1 = new HashSet<Role>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Role_UserRequest role_UserRequest : set ) {
            set1.add( role_UserRequestToRole( role_UserRequest ) );
        }

        return set1;
    }
}
