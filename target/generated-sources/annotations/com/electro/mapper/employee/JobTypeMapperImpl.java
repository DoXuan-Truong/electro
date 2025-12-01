package com.electro.mapper.employee;

import com.electro.dto.employee.JobTypeRequest;
import com.electro.dto.employee.JobTypeResponse;
import com.electro.entity.employee.JobType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-02T04:44:14+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class JobTypeMapperImpl implements JobTypeMapper {

    @Override
    public JobType requestToEntity(JobTypeRequest request) {
        if ( request == null ) {
            return null;
        }

        JobType jobType = new JobType();

        jobType.setName( request.getName() );
        jobType.setStatus( request.getStatus() );

        return jobType;
    }

    @Override
    public JobTypeResponse entityToResponse(JobType entity) {
        if ( entity == null ) {
            return null;
        }

        JobTypeResponse jobTypeResponse = new JobTypeResponse();

        jobTypeResponse.setId( entity.getId() );
        jobTypeResponse.setCreatedAt( entity.getCreatedAt() );
        jobTypeResponse.setUpdatedAt( entity.getUpdatedAt() );
        jobTypeResponse.setName( entity.getName() );
        jobTypeResponse.setStatus( entity.getStatus() );

        return jobTypeResponse;
    }

    @Override
    public List<JobType> requestToEntity(List<JobTypeRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<JobType> list = new ArrayList<JobType>( requests.size() );
        for ( JobTypeRequest jobTypeRequest : requests ) {
            list.add( requestToEntity( jobTypeRequest ) );
        }

        return list;
    }

    @Override
    public List<JobTypeResponse> entityToResponse(List<JobType> entities) {
        if ( entities == null ) {
            return null;
        }

        List<JobTypeResponse> list = new ArrayList<JobTypeResponse>( entities.size() );
        for ( JobType jobType : entities ) {
            list.add( entityToResponse( jobType ) );
        }

        return list;
    }

    @Override
    public JobType partialUpdate(JobType entity, JobTypeRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setName( request.getName() );
        entity.setStatus( request.getStatus() );

        return entity;
    }
}
