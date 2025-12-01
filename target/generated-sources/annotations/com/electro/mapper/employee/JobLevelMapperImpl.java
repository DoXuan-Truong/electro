package com.electro.mapper.employee;

import com.electro.dto.employee.JobLevelRequest;
import com.electro.dto.employee.JobLevelResponse;
import com.electro.entity.employee.JobLevel;
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
public class JobLevelMapperImpl implements JobLevelMapper {

    @Override
    public JobLevel requestToEntity(JobLevelRequest request) {
        if ( request == null ) {
            return null;
        }

        JobLevel jobLevel = new JobLevel();

        jobLevel.setName( request.getName() );
        jobLevel.setStatus( request.getStatus() );

        return jobLevel;
    }

    @Override
    public JobLevelResponse entityToResponse(JobLevel entity) {
        if ( entity == null ) {
            return null;
        }

        JobLevelResponse jobLevelResponse = new JobLevelResponse();

        jobLevelResponse.setId( entity.getId() );
        jobLevelResponse.setCreatedAt( entity.getCreatedAt() );
        jobLevelResponse.setUpdatedAt( entity.getUpdatedAt() );
        jobLevelResponse.setName( entity.getName() );
        jobLevelResponse.setStatus( entity.getStatus() );

        return jobLevelResponse;
    }

    @Override
    public List<JobLevel> requestToEntity(List<JobLevelRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<JobLevel> list = new ArrayList<JobLevel>( requests.size() );
        for ( JobLevelRequest jobLevelRequest : requests ) {
            list.add( requestToEntity( jobLevelRequest ) );
        }

        return list;
    }

    @Override
    public List<JobLevelResponse> entityToResponse(List<JobLevel> entities) {
        if ( entities == null ) {
            return null;
        }

        List<JobLevelResponse> list = new ArrayList<JobLevelResponse>( entities.size() );
        for ( JobLevel jobLevel : entities ) {
            list.add( entityToResponse( jobLevel ) );
        }

        return list;
    }

    @Override
    public JobLevel partialUpdate(JobLevel entity, JobLevelRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setName( request.getName() );
        entity.setStatus( request.getStatus() );

        return entity;
    }
}
