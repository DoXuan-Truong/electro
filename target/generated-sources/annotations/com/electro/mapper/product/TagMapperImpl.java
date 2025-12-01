package com.electro.mapper.product;

import com.electro.dto.product.TagRequest;
import com.electro.dto.product.TagResponse;
import com.electro.entity.product.Tag;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-02T04:44:13+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class TagMapperImpl implements TagMapper {

    @Override
    public Tag requestToEntity(TagRequest request) {
        if ( request == null ) {
            return null;
        }

        Tag tag = new Tag();

        tag.setName( request.getName() );
        tag.setSlug( request.getSlug() );
        tag.setStatus( request.getStatus() );

        return tag;
    }

    @Override
    public TagResponse entityToResponse(Tag entity) {
        if ( entity == null ) {
            return null;
        }

        TagResponse tagResponse = new TagResponse();

        tagResponse.setId( entity.getId() );
        tagResponse.setCreatedAt( entity.getCreatedAt() );
        tagResponse.setUpdatedAt( entity.getUpdatedAt() );
        tagResponse.setName( entity.getName() );
        tagResponse.setSlug( entity.getSlug() );
        tagResponse.setStatus( entity.getStatus() );

        return tagResponse;
    }

    @Override
    public List<Tag> requestToEntity(List<TagRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Tag> list = new ArrayList<Tag>( requests.size() );
        for ( TagRequest tagRequest : requests ) {
            list.add( requestToEntity( tagRequest ) );
        }

        return list;
    }

    @Override
    public List<TagResponse> entityToResponse(List<Tag> entities) {
        if ( entities == null ) {
            return null;
        }

        List<TagResponse> list = new ArrayList<TagResponse>( entities.size() );
        for ( Tag tag : entities ) {
            list.add( entityToResponse( tag ) );
        }

        return list;
    }

    @Override
    public Tag partialUpdate(Tag entity, TagRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setName( request.getName() );
        entity.setSlug( request.getSlug() );
        entity.setStatus( request.getStatus() );

        return entity;
    }
}
