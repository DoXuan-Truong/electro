package com.electro.mapper.review;

import com.electro.dto.review.ReviewRequest;
import com.electro.dto.review.ReviewResponse;
import com.electro.dto.review.ReviewResponse.ProductResponse;
import com.electro.dto.review.ReviewResponse.UserResponse;
import com.electro.entity.authentication.User;
import com.electro.entity.product.Product;
import com.electro.entity.review.Review;
import com.electro.utils.MapperUtils;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-02T04:44:14+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class ReviewMapperImpl implements ReviewMapper {

    @Autowired
    private MapperUtils mapperUtils;

    @Override
    public ReviewResponse entityToResponse(Review entity) {
        if ( entity == null ) {
            return null;
        }

        ReviewResponse reviewResponse = new ReviewResponse();

        reviewResponse.setId( entity.getId() );
        reviewResponse.setCreatedAt( entity.getCreatedAt() );
        reviewResponse.setUpdatedAt( entity.getUpdatedAt() );
        reviewResponse.setUser( userToUserResponse( entity.getUser() ) );
        reviewResponse.setProduct( productToProductResponse( entity.getProduct() ) );
        reviewResponse.setRatingScore( entity.getRatingScore() );
        reviewResponse.setContent( entity.getContent() );
        reviewResponse.setReply( entity.getReply() );
        reviewResponse.setStatus( entity.getStatus() );

        return reviewResponse;
    }

    @Override
    public List<Review> requestToEntity(List<ReviewRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Review> list = new ArrayList<Review>( requests.size() );
        for ( ReviewRequest reviewRequest : requests ) {
            list.add( requestToEntity( reviewRequest ) );
        }

        return list;
    }

    @Override
    public List<ReviewResponse> entityToResponse(List<Review> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ReviewResponse> list = new ArrayList<ReviewResponse>( entities.size() );
        for ( Review review : entities ) {
            list.add( entityToResponse( review ) );
        }

        return list;
    }

    @Override
    public Review requestToEntity(ReviewRequest request) {
        if ( request == null ) {
            return null;
        }

        Review review = new Review();

        review.setUser( mapperUtils.mapToUser( request.getUserId() ) );
        review.setProduct( mapperUtils.mapToProduct( request.getProductId() ) );
        review.setRatingScore( request.getRatingScore() );
        review.setContent( request.getContent() );
        review.setReply( request.getReply() );
        review.setStatus( request.getStatus() );

        return review;
    }

    @Override
    public Review partialUpdate(Review entity, ReviewRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setUser( mapperUtils.mapToUser( request.getUserId() ) );
        entity.setProduct( mapperUtils.mapToProduct( request.getProductId() ) );
        entity.setRatingScore( request.getRatingScore() );
        entity.setContent( request.getContent() );
        entity.setReply( request.getReply() );
        entity.setStatus( request.getStatus() );

        return entity;
    }

    protected UserResponse userToUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        userResponse.setId( user.getId() );
        userResponse.setCreatedAt( user.getCreatedAt() );
        userResponse.setUpdatedAt( user.getUpdatedAt() );
        userResponse.setUsername( user.getUsername() );
        userResponse.setFullname( user.getFullname() );

        return userResponse;
    }

    protected ProductResponse productToProductResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductResponse productResponse = new ProductResponse();

        productResponse.setId( product.getId() );
        productResponse.setCreatedAt( product.getCreatedAt() );
        productResponse.setUpdatedAt( product.getUpdatedAt() );
        productResponse.setName( product.getName() );
        productResponse.setCode( product.getCode() );
        productResponse.setSlug( product.getSlug() );

        return productResponse;
    }
}
