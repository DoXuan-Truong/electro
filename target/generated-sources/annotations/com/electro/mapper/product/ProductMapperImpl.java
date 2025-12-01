package com.electro.mapper.product;

import com.electro.dto.product.ProductRequest;
import com.electro.dto.product.ProductRequest.TagRequest;
import com.electro.dto.product.ProductResponse;
import com.electro.dto.product.ProductResponse.CategoryResponse;
import com.electro.dto.product.ProductResponse.VariantResponse;
import com.electro.dto.product.TagResponse;
import com.electro.dto.product.VariantRequest;
import com.electro.entity.general.Image;
import com.electro.entity.product.Category;
import com.electro.entity.product.Product;
import com.electro.entity.product.Tag;
import com.electro.entity.product.Variant;
import com.electro.mapper.general.ImageMapper;
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
    date = "2025-12-02T04:44:14+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private MapperUtils mapperUtils;
    @Autowired
    private ImageMapper imageMapper;
    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private SupplierMapper supplierMapper;
    @Autowired
    private UnitMapper unitMapper;
    @Autowired
    private GuaranteeMapper guaranteeMapper;

    @Override
    public ProductResponse entityToResponse(Product entity) {
        if ( entity == null ) {
            return null;
        }

        ProductResponse productResponse = new ProductResponse();

        productResponse.setId( entity.getId() );
        productResponse.setCreatedAt( entity.getCreatedAt() );
        productResponse.setUpdatedAt( entity.getUpdatedAt() );
        productResponse.setName( entity.getName() );
        productResponse.setCode( entity.getCode() );
        productResponse.setSlug( entity.getSlug() );
        productResponse.setShortDescription( entity.getShortDescription() );
        productResponse.setDescription( entity.getDescription() );
        productResponse.setImages( imageMapper.entityToResponse( entity.getImages() ) );
        productResponse.setStatus( entity.getStatus() );
        productResponse.setCategory( categoryToCategoryResponse( entity.getCategory() ) );
        productResponse.setBrand( brandMapper.entityToResponse( entity.getBrand() ) );
        productResponse.setSupplier( supplierMapper.entityToResponse( entity.getSupplier() ) );
        productResponse.setUnit( unitMapper.entityToResponse( entity.getUnit() ) );
        productResponse.setTags( tagSetToTagResponseSet( entity.getTags() ) );
        productResponse.setSpecifications( entity.getSpecifications() );
        productResponse.setProperties( entity.getProperties() );
        productResponse.setVariants( variantListToVariantResponseList( entity.getVariants() ) );
        productResponse.setWeight( entity.getWeight() );
        productResponse.setGuarantee( guaranteeMapper.entityToResponse( entity.getGuarantee() ) );

        return productResponse;
    }

    @Override
    public List<Product> requestToEntity(List<ProductRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( requests.size() );
        for ( ProductRequest productRequest : requests ) {
            list.add( requestToEntity( productRequest ) );
        }

        return list;
    }

    @Override
    public List<ProductResponse> entityToResponse(List<Product> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ProductResponse> list = new ArrayList<ProductResponse>( entities.size() );
        for ( Product product : entities ) {
            list.add( entityToResponse( product ) );
        }

        return list;
    }

    @Override
    public Product requestToEntity(ProductRequest request) {
        if ( request == null ) {
            return null;
        }

        Product product = new Product();

        product.setCategory( mapperUtils.mapToCategory( request.getCategoryId() ) );
        product.setBrand( mapperUtils.mapToBrand( request.getBrandId() ) );
        product.setSupplier( mapperUtils.mapToSupplier( request.getSupplierId() ) );
        product.setUnit( mapperUtils.mapToUnit( request.getUnitId() ) );
        product.setGuarantee( mapperUtils.mapToGuarantee( request.getGuaranteeId() ) );
        product.setName( request.getName() );
        product.setCode( request.getCode() );
        product.setSlug( request.getSlug() );
        product.setShortDescription( request.getShortDescription() );
        product.setDescription( request.getDescription() );
        product.setImages( imageMapper.requestToEntity( request.getImages() ) );
        product.setStatus( request.getStatus() );
        product.setTags( tagRequestSetToTagSet( request.getTags() ) );
        product.setSpecifications( request.getSpecifications() );
        product.setProperties( request.getProperties() );
        product.setVariants( variantRequestListToVariantList( request.getVariants() ) );
        product.setWeight( request.getWeight() );

        Product target = mapperUtils.attachProduct( product );
        if ( target != null ) {
            return target;
        }

        return product;
    }

    @Override
    public Product partialUpdate(Product entity, ProductRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setCategory( mapperUtils.mapToCategory( request.getCategoryId() ) );
        entity.setBrand( mapperUtils.mapToBrand( request.getBrandId() ) );
        entity.setSupplier( mapperUtils.mapToSupplier( request.getSupplierId() ) );
        entity.setUnit( mapperUtils.mapToUnit( request.getUnitId() ) );
        entity.setGuarantee( mapperUtils.mapToGuarantee( request.getGuaranteeId() ) );
        entity.setName( request.getName() );
        entity.setCode( request.getCode() );
        entity.setSlug( request.getSlug() );
        entity.setShortDescription( request.getShortDescription() );
        entity.setDescription( request.getDescription() );
        if ( entity.getImages() != null ) {
            List<Image> list = imageMapper.requestToEntity( request.getImages() );
            if ( list != null ) {
                entity.getImages().clear();
                entity.getImages().addAll( list );
            }
            else {
                entity.setImages( null );
            }
        }
        else {
            List<Image> list = imageMapper.requestToEntity( request.getImages() );
            if ( list != null ) {
                entity.setImages( list );
            }
        }
        entity.setStatus( request.getStatus() );
        if ( entity.getTags() != null ) {
            Set<Tag> set = tagRequestSetToTagSet( request.getTags() );
            if ( set != null ) {
                entity.getTags().clear();
                entity.getTags().addAll( set );
            }
            else {
                entity.setTags( null );
            }
        }
        else {
            Set<Tag> set = tagRequestSetToTagSet( request.getTags() );
            if ( set != null ) {
                entity.setTags( set );
            }
        }
        entity.setSpecifications( request.getSpecifications() );
        entity.setProperties( request.getProperties() );
        if ( entity.getVariants() != null ) {
            List<Variant> list1 = variantRequestListToVariantList( request.getVariants() );
            if ( list1 != null ) {
                entity.getVariants().clear();
                entity.getVariants().addAll( list1 );
            }
            else {
                entity.setVariants( null );
            }
        }
        else {
            List<Variant> list1 = variantRequestListToVariantList( request.getVariants() );
            if ( list1 != null ) {
                entity.setVariants( list1 );
            }
        }
        entity.setWeight( request.getWeight() );

        Product target = mapperUtils.attachProduct( entity );
        if ( target != null ) {
            return target;
        }

        return entity;
    }

    protected CategoryResponse categoryToCategoryResponse(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryResponse categoryResponse = new CategoryResponse();

        categoryResponse.setId( category.getId() );
        categoryResponse.setCreatedAt( category.getCreatedAt() );
        categoryResponse.setUpdatedAt( category.getUpdatedAt() );
        categoryResponse.setName( category.getName() );
        categoryResponse.setSlug( category.getSlug() );
        categoryResponse.setDescription( category.getDescription() );
        categoryResponse.setThumbnail( category.getThumbnail() );
        categoryResponse.setStatus( category.getStatus() );

        return categoryResponse;
    }

    protected TagResponse tagToTagResponse(Tag tag) {
        if ( tag == null ) {
            return null;
        }

        TagResponse tagResponse = new TagResponse();

        tagResponse.setId( tag.getId() );
        tagResponse.setCreatedAt( tag.getCreatedAt() );
        tagResponse.setUpdatedAt( tag.getUpdatedAt() );
        tagResponse.setName( tag.getName() );
        tagResponse.setSlug( tag.getSlug() );
        tagResponse.setStatus( tag.getStatus() );

        return tagResponse;
    }

    protected Set<TagResponse> tagSetToTagResponseSet(Set<Tag> set) {
        if ( set == null ) {
            return null;
        }

        Set<TagResponse> set1 = new HashSet<TagResponse>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Tag tag : set ) {
            set1.add( tagToTagResponse( tag ) );
        }

        return set1;
    }

    protected VariantResponse variantToVariantResponse(Variant variant) {
        if ( variant == null ) {
            return null;
        }

        VariantResponse variantResponse = new VariantResponse();

        variantResponse.setId( variant.getId() );
        variantResponse.setCreatedAt( variant.getCreatedAt() );
        variantResponse.setUpdatedAt( variant.getUpdatedAt() );
        variantResponse.setSku( variant.getSku() );
        variantResponse.setCost( variant.getCost() );
        variantResponse.setPrice( variant.getPrice() );
        variantResponse.setProperties( variant.getProperties() );
        variantResponse.setStatus( variant.getStatus() );

        return variantResponse;
    }

    protected List<VariantResponse> variantListToVariantResponseList(List<Variant> list) {
        if ( list == null ) {
            return null;
        }

        List<VariantResponse> list1 = new ArrayList<VariantResponse>( list.size() );
        for ( Variant variant : list ) {
            list1.add( variantToVariantResponse( variant ) );
        }

        return list1;
    }

    protected Tag tagRequestToTag(TagRequest tagRequest) {
        if ( tagRequest == null ) {
            return null;
        }

        Tag tag = new Tag();

        tag.setId( tagRequest.getId() );
        tag.setName( tagRequest.getName() );
        tag.setSlug( tagRequest.getSlug() );
        tag.setStatus( tagRequest.getStatus() );

        return tag;
    }

    protected Set<Tag> tagRequestSetToTagSet(Set<TagRequest> set) {
        if ( set == null ) {
            return null;
        }

        Set<Tag> set1 = new HashSet<Tag>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( TagRequest tagRequest : set ) {
            set1.add( tagRequestToTag( tagRequest ) );
        }

        return set1;
    }

    protected Variant variantRequestToVariant(VariantRequest variantRequest) {
        if ( variantRequest == null ) {
            return null;
        }

        Variant variant = new Variant();

        variant.setId( variantRequest.getId() );
        variant.setSku( variantRequest.getSku() );
        variant.setCost( variantRequest.getCost() );
        variant.setPrice( variantRequest.getPrice() );
        variant.setProperties( variantRequest.getProperties() );
        variant.setStatus( variantRequest.getStatus() );

        return variant;
    }

    protected List<Variant> variantRequestListToVariantList(List<VariantRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<Variant> list1 = new ArrayList<Variant>( list.size() );
        for ( VariantRequest variantRequest : list ) {
            list1.add( variantRequestToVariant( variantRequest ) );
        }

        return list1;
    }
}
