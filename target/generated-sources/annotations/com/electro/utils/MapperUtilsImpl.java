package com.electro.utils;

import com.electro.entity.chat.Room;
import com.electro.entity.customer.Customer;
import com.electro.entity.customer.CustomerGroup;
import com.electro.entity.customer.CustomerResource;
import com.electro.entity.customer.CustomerStatus;
import com.electro.entity.employee.Department;
import com.electro.entity.employee.JobLevel;
import com.electro.entity.employee.JobTitle;
import com.electro.entity.employee.JobType;
import com.electro.entity.employee.Office;
import com.electro.entity.inventory.Destination;
import com.electro.entity.inventory.DocketReason;
import com.electro.entity.inventory.PurchaseOrder;
import com.electro.entity.inventory.Warehouse;
import com.electro.entity.order.Order;
import com.electro.entity.order.OrderCancellationReason;
import com.electro.entity.order.OrderResource;
import com.electro.entity.product.Brand;
import com.electro.entity.product.Category;
import com.electro.entity.product.Guarantee;
import com.electro.entity.product.Supplier;
import com.electro.entity.product.Unit;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-02T04:44:15+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Oracle Corporation)"
)
@Component
public class MapperUtilsImpl extends MapperUtils {

    @Override
    public Office mapToOffice(Long id) {
        if ( id == null ) {
            return null;
        }

        Office office = new Office();

        office.setId( id );

        return office;
    }

    @Override
    public Department mapToDepartment(Long id) {
        if ( id == null ) {
            return null;
        }

        Department department = new Department();

        department.setId( id );

        return department;
    }

    @Override
    public JobType mapToJobType(Long id) {
        if ( id == null ) {
            return null;
        }

        JobType jobType = new JobType();

        jobType.setId( id );

        return jobType;
    }

    @Override
    public JobLevel mapToJobLevel(Long id) {
        if ( id == null ) {
            return null;
        }

        JobLevel jobLevel = new JobLevel();

        jobLevel.setId( id );

        return jobLevel;
    }

    @Override
    public JobTitle mapToJobTitle(Long id) {
        if ( id == null ) {
            return null;
        }

        JobTitle jobTitle = new JobTitle();

        jobTitle.setId( id );

        return jobTitle;
    }

    @Override
    public CustomerGroup mapToCustomerGroup(Long id) {
        if ( id == null ) {
            return null;
        }

        CustomerGroup customerGroup = new CustomerGroup();

        customerGroup.setId( id );

        return customerGroup;
    }

    @Override
    public CustomerResource mapToCustomerResource(Long id) {
        if ( id == null ) {
            return null;
        }

        CustomerResource customerResource = new CustomerResource();

        customerResource.setId( id );

        return customerResource;
    }

    @Override
    public CustomerStatus mapToCustomerStatus(Long id) {
        if ( id == null ) {
            return null;
        }

        CustomerStatus customerStatus = new CustomerStatus();

        customerStatus.setId( id );

        return customerStatus;
    }

    @Override
    public Category mapToCategory(Long id) {
        if ( id == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( id );

        return category;
    }

    @Override
    public Brand mapToBrand(Long id) {
        if ( id == null ) {
            return null;
        }

        Brand brand = new Brand();

        brand.setId( id );

        return brand;
    }

    @Override
    public Supplier mapToSupplier(Long id) {
        if ( id == null ) {
            return null;
        }

        Supplier supplier = new Supplier();

        supplier.setId( id );

        return supplier;
    }

    @Override
    public Unit mapToUnit(Long id) {
        if ( id == null ) {
            return null;
        }

        Unit unit = new Unit();

        unit.setId( id );

        return unit;
    }

    @Override
    public Guarantee mapToGuarantee(Long id) {
        if ( id == null ) {
            return null;
        }

        Guarantee guarantee = new Guarantee();

        guarantee.setId( id );

        return guarantee;
    }

    @Override
    public Warehouse mapToWarehouse(Long id) {
        if ( id == null ) {
            return null;
        }

        Warehouse warehouse = new Warehouse();

        warehouse.setId( id );

        return warehouse;
    }

    @Override
    public DocketReason mapToDocketReason(Long id) {
        if ( id == null ) {
            return null;
        }

        DocketReason docketReason = new DocketReason();

        docketReason.setId( id );

        return docketReason;
    }

    @Override
    public Destination mapToDestination(Long id) {
        if ( id == null ) {
            return null;
        }

        Destination destination = new Destination();

        destination.setId( id );

        return destination;
    }

    @Override
    public PurchaseOrder mapToPurchaseOrder(Long id) {
        if ( id == null ) {
            return null;
        }

        PurchaseOrder purchaseOrder = new PurchaseOrder();

        purchaseOrder.setId( id );

        return purchaseOrder;
    }

    @Override
    public OrderResource mapToOrderResource(Long id) {
        if ( id == null ) {
            return null;
        }

        OrderResource orderResource = new OrderResource();

        orderResource.setId( id );

        return orderResource;
    }

    @Override
    public OrderCancellationReason mapToOrderCancellationReason(Long id) {
        if ( id == null ) {
            return null;
        }

        OrderCancellationReason orderCancellationReason = new OrderCancellationReason();

        orderCancellationReason.setId( id );

        return orderCancellationReason;
    }

    @Override
    public Customer mapToCustomer(Long id) {
        if ( id == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( id );

        return customer;
    }

    @Override
    public Order mapToOrder(Long id) {
        if ( id == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( id );

        return order;
    }

    @Override
    public Room mapToRoom(Long id) {
        if ( id == null ) {
            return null;
        }

        Room room = new Room();

        room.setId( id );

        return room;
    }
}
