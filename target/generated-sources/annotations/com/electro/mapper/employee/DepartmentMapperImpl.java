package com.electro.mapper.employee;

import com.electro.dto.employee.DepartmentRequest;
import com.electro.dto.employee.DepartmentResponse;
import com.electro.entity.employee.Department;
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
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public Department requestToEntity(DepartmentRequest request) {
        if ( request == null ) {
            return null;
        }

        Department department = new Department();

        department.setName( request.getName() );
        department.setStatus( request.getStatus() );

        return department;
    }

    @Override
    public DepartmentResponse entityToResponse(Department entity) {
        if ( entity == null ) {
            return null;
        }

        DepartmentResponse departmentResponse = new DepartmentResponse();

        departmentResponse.setId( entity.getId() );
        departmentResponse.setCreatedAt( entity.getCreatedAt() );
        departmentResponse.setUpdatedAt( entity.getUpdatedAt() );
        departmentResponse.setName( entity.getName() );
        departmentResponse.setStatus( entity.getStatus() );

        return departmentResponse;
    }

    @Override
    public List<Department> requestToEntity(List<DepartmentRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Department> list = new ArrayList<Department>( requests.size() );
        for ( DepartmentRequest departmentRequest : requests ) {
            list.add( requestToEntity( departmentRequest ) );
        }

        return list;
    }

    @Override
    public List<DepartmentResponse> entityToResponse(List<Department> entities) {
        if ( entities == null ) {
            return null;
        }

        List<DepartmentResponse> list = new ArrayList<DepartmentResponse>( entities.size() );
        for ( Department department : entities ) {
            list.add( entityToResponse( department ) );
        }

        return list;
    }

    @Override
    public Department partialUpdate(Department entity, DepartmentRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setName( request.getName() );
        entity.setStatus( request.getStatus() );

        return entity;
    }
}
