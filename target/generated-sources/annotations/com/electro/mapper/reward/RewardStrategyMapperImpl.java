package com.electro.mapper.reward;

import com.electro.dto.reward.RewardStrategyRequest;
import com.electro.dto.reward.RewardStrategyResponse;
import com.electro.entity.reward.RewardStrategy;
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
public class RewardStrategyMapperImpl implements RewardStrategyMapper {

    @Override
    public RewardStrategy requestToEntity(RewardStrategyRequest request) {
        if ( request == null ) {
            return null;
        }

        RewardStrategy rewardStrategy = new RewardStrategy();

        rewardStrategy.setFormula( request.getFormula() );
        rewardStrategy.setStatus( request.getStatus() );

        return rewardStrategy;
    }

    @Override
    public RewardStrategyResponse entityToResponse(RewardStrategy entity) {
        if ( entity == null ) {
            return null;
        }

        RewardStrategyResponse rewardStrategyResponse = new RewardStrategyResponse();

        rewardStrategyResponse.setId( entity.getId() );
        rewardStrategyResponse.setCreatedAt( entity.getCreatedAt() );
        rewardStrategyResponse.setUpdatedAt( entity.getUpdatedAt() );
        rewardStrategyResponse.setName( entity.getName() );
        rewardStrategyResponse.setCode( entity.getCode() );
        rewardStrategyResponse.setFormula( entity.getFormula() );
        rewardStrategyResponse.setStatus( entity.getStatus() );

        return rewardStrategyResponse;
    }

    @Override
    public List<RewardStrategy> requestToEntity(List<RewardStrategyRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<RewardStrategy> list = new ArrayList<RewardStrategy>( requests.size() );
        for ( RewardStrategyRequest rewardStrategyRequest : requests ) {
            list.add( requestToEntity( rewardStrategyRequest ) );
        }

        return list;
    }

    @Override
    public List<RewardStrategyResponse> entityToResponse(List<RewardStrategy> entities) {
        if ( entities == null ) {
            return null;
        }

        List<RewardStrategyResponse> list = new ArrayList<RewardStrategyResponse>( entities.size() );
        for ( RewardStrategy rewardStrategy : entities ) {
            list.add( entityToResponse( rewardStrategy ) );
        }

        return list;
    }

    @Override
    public RewardStrategy partialUpdate(RewardStrategy entity, RewardStrategyRequest request) {
        if ( request == null ) {
            return null;
        }

        if ( request.getFormula() != null ) {
            entity.setFormula( request.getFormula() );
        }
        if ( request.getStatus() != null ) {
            entity.setStatus( request.getStatus() );
        }

        return entity;
    }
}
