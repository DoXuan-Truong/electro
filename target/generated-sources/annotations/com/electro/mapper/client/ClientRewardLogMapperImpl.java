package com.electro.mapper.client;

import com.electro.dto.client.ClientRewardLogResponse;
import com.electro.entity.reward.RewardLog;
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
public class ClientRewardLogMapperImpl implements ClientRewardLogMapper {

    @Override
    public ClientRewardLogResponse entityToResponse(RewardLog rewardLog) {
        if ( rewardLog == null ) {
            return null;
        }

        ClientRewardLogResponse clientRewardLogResponse = new ClientRewardLogResponse();

        clientRewardLogResponse.setRewardLogId( rewardLog.getId() );
        clientRewardLogResponse.setRewardLogCreatedAt( rewardLog.getCreatedAt() );
        clientRewardLogResponse.setRewardLogScore( rewardLog.getScore() );
        clientRewardLogResponse.setRewardLogType( rewardLog.getType() );
        clientRewardLogResponse.setRewardLogNote( rewardLog.getNote() );

        return clientRewardLogResponse;
    }

    @Override
    public List<ClientRewardLogResponse> entityToResponse(List<RewardLog> rewardLogs) {
        if ( rewardLogs == null ) {
            return null;
        }

        List<ClientRewardLogResponse> list = new ArrayList<ClientRewardLogResponse>( rewardLogs.size() );
        for ( RewardLog rewardLog : rewardLogs ) {
            list.add( entityToResponse( rewardLog ) );
        }

        return list;
    }
}
