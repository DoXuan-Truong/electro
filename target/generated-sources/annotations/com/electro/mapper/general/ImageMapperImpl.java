package com.electro.mapper.general;

import com.electro.dto.general.ImageRequest;
import com.electro.dto.general.ImageResponse;
import com.electro.entity.general.Image;
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
public class ImageMapperImpl implements ImageMapper {

    @Override
    public Image requestToEntity(ImageRequest request) {
        if ( request == null ) {
            return null;
        }

        Image image = new Image();

        image.setId( request.getId() );
        image.setName( request.getName() );
        image.setPath( request.getPath() );
        image.setContentType( request.getContentType() );
        image.setSize( request.getSize() );
        image.setGroup( request.getGroup() );
        image.setIsThumbnail( request.getIsThumbnail() );
        image.setIsEliminated( request.getIsEliminated() );

        return image;
    }

    @Override
    public ImageResponse entityToResponse(Image entity) {
        if ( entity == null ) {
            return null;
        }

        ImageResponse imageResponse = new ImageResponse();

        imageResponse.setId( entity.getId() );
        imageResponse.setName( entity.getName() );
        imageResponse.setPath( entity.getPath() );
        imageResponse.setContentType( entity.getContentType() );
        imageResponse.setSize( entity.getSize() );
        imageResponse.setGroup( entity.getGroup() );
        imageResponse.setIsThumbnail( entity.getIsThumbnail() );
        imageResponse.setIsEliminated( entity.getIsEliminated() );

        return imageResponse;
    }

    @Override
    public List<Image> requestToEntity(List<ImageRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Image> list = new ArrayList<Image>( requests.size() );
        for ( ImageRequest imageRequest : requests ) {
            list.add( requestToEntity( imageRequest ) );
        }

        return list;
    }

    @Override
    public List<ImageResponse> entityToResponse(List<Image> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ImageResponse> list = new ArrayList<ImageResponse>( entities.size() );
        for ( Image image : entities ) {
            list.add( entityToResponse( image ) );
        }

        return list;
    }

    @Override
    public Image partialUpdate(Image entity, ImageRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setId( request.getId() );
        entity.setName( request.getName() );
        entity.setPath( request.getPath() );
        entity.setContentType( request.getContentType() );
        entity.setSize( request.getSize() );
        entity.setGroup( request.getGroup() );
        entity.setIsThumbnail( request.getIsThumbnail() );
        entity.setIsEliminated( request.getIsEliminated() );

        return entity;
    }
}
