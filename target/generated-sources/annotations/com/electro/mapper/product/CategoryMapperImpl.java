package com.electro.mapper.product;

import com.electro.dto.product.CategoryRequest;
import com.electro.dto.product.CategoryResponse;
import com.electro.dto.product.ParentCategoryResponse;
import com.electro.entity.product.Category;
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
public class CategoryMapperImpl implements CategoryMapper {

    @Autowired
    private MapperUtils mapperUtils;

    @Override
    public CategoryResponse entityToResponse(Category entity) {
        if ( entity == null ) {
            return null;
        }

        CategoryResponse categoryResponse = new CategoryResponse();

        categoryResponse.setId( entity.getId() );
        categoryResponse.setCreatedAt( entity.getCreatedAt() );
        categoryResponse.setUpdatedAt( entity.getUpdatedAt() );
        categoryResponse.setName( entity.getName() );
        categoryResponse.setSlug( entity.getSlug() );
        categoryResponse.setDescription( entity.getDescription() );
        categoryResponse.setThumbnail( entity.getThumbnail() );
        categoryResponse.setParentCategory( categoryToParentCategoryResponse( entity.getParentCategory() ) );
        categoryResponse.setStatus( entity.getStatus() );
        categoryResponse.setCategories( entityToResponse( entity.getCategories() ) );

        return categoryResponse;
    }

    @Override
    public List<Category> requestToEntity(List<CategoryRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( requests.size() );
        for ( CategoryRequest categoryRequest : requests ) {
            list.add( requestToEntity( categoryRequest ) );
        }

        return list;
    }

    @Override
    public List<CategoryResponse> entityToResponse(List<Category> entities) {
        if ( entities == null ) {
            return null;
        }

        List<CategoryResponse> list = new ArrayList<CategoryResponse>( entities.size() );
        for ( Category category : entities ) {
            list.add( entityToResponse( category ) );
        }

        return list;
    }

    @Override
    public Category requestToEntity(CategoryRequest request) {
        if ( request == null ) {
            return null;
        }

        Category category = new Category();

        category.setParentCategory( mapperUtils.mapToCategory( request.getParentCategoryId() ) );
        category.setName( request.getName() );
        category.setSlug( request.getSlug() );
        category.setDescription( request.getDescription() );
        category.setThumbnail( request.getThumbnail() );
        category.setStatus( request.getStatus() );

        return category;
    }

    @Override
    public Category partialUpdate(Category entity, CategoryRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setParentCategory( mapperUtils.mapToCategory( request.getParentCategoryId() ) );
        entity.setName( request.getName() );
        entity.setSlug( request.getSlug() );
        entity.setDescription( request.getDescription() );
        entity.setThumbnail( request.getThumbnail() );
        entity.setStatus( request.getStatus() );

        return entity;
    }

    protected ParentCategoryResponse categoryToParentCategoryResponse(Category category) {
        if ( category == null ) {
            return null;
        }

        ParentCategoryResponse parentCategoryResponse = new ParentCategoryResponse();

        parentCategoryResponse.setId( category.getId() );
        parentCategoryResponse.setCreatedAt( category.getCreatedAt() );
        parentCategoryResponse.setUpdatedAt( category.getUpdatedAt() );
        parentCategoryResponse.setName( category.getName() );
        parentCategoryResponse.setSlug( category.getSlug() );
        parentCategoryResponse.setDescription( category.getDescription() );
        parentCategoryResponse.setThumbnail( category.getThumbnail() );
        parentCategoryResponse.setStatus( category.getStatus() );

        return parentCategoryResponse;
    }
}
