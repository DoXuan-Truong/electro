package com.electro.mapper.employee;

import com.electro.dto.address.AddressResponse;
import com.electro.dto.address.AddressResponse.DistrictResponse;
import com.electro.dto.address.AddressResponse.WardResponse;
import com.electro.dto.address.ProvinceResponse;
import com.electro.dto.employee.DepartmentResponse;
import com.electro.dto.employee.EmployeeRequest;
import com.electro.dto.employee.EmployeeResponse;
import com.electro.dto.employee.JobLevelResponse;
import com.electro.dto.employee.JobTitleResponse;
import com.electro.dto.employee.JobTypeResponse;
import com.electro.dto.employee.OfficeResponse;
import com.electro.entity.address.Address;
import com.electro.entity.address.District;
import com.electro.entity.address.Province;
import com.electro.entity.address.Ward;
import com.electro.entity.authentication.User;
import com.electro.entity.employee.Department;
import com.electro.entity.employee.Employee;
import com.electro.entity.employee.JobLevel;
import com.electro.entity.employee.JobTitle;
import com.electro.entity.employee.JobType;
import com.electro.entity.employee.Office;
import com.electro.mapper.authentication.UserMapper;
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
public class EmployeeMapperImpl implements EmployeeMapper {

    @Autowired
    private MapperUtils mapperUtils;
    @Autowired
    private UserMapper userMapper;

    @Override
    public EmployeeResponse entityToResponse(Employee entity) {
        if ( entity == null ) {
            return null;
        }

        EmployeeResponse employeeResponse = new EmployeeResponse();

        employeeResponse.setId( entity.getId() );
        employeeResponse.setCreatedAt( entity.getCreatedAt() );
        employeeResponse.setUpdatedAt( entity.getUpdatedAt() );
        employeeResponse.setUser( userMapper.entityToResponse( entity.getUser() ) );
        employeeResponse.setOffice( officeToOfficeResponse( entity.getOffice() ) );
        employeeResponse.setDepartment( departmentToDepartmentResponse( entity.getDepartment() ) );
        employeeResponse.setJobType( jobTypeToJobTypeResponse( entity.getJobType() ) );
        employeeResponse.setJobLevel( jobLevelToJobLevelResponse( entity.getJobLevel() ) );
        employeeResponse.setJobTitle( jobTitleToJobTitleResponse( entity.getJobTitle() ) );

        return employeeResponse;
    }

    @Override
    public List<Employee> requestToEntity(List<EmployeeRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Employee> list = new ArrayList<Employee>( requests.size() );
        for ( EmployeeRequest employeeRequest : requests ) {
            list.add( requestToEntity( employeeRequest ) );
        }

        return list;
    }

    @Override
    public List<EmployeeResponse> entityToResponse(List<Employee> entities) {
        if ( entities == null ) {
            return null;
        }

        List<EmployeeResponse> list = new ArrayList<EmployeeResponse>( entities.size() );
        for ( Employee employee : entities ) {
            list.add( entityToResponse( employee ) );
        }

        return list;
    }

    @Override
    public Employee requestToEntity(EmployeeRequest request) {
        if ( request == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setOffice( mapperUtils.mapToOffice( request.getOfficeId() ) );
        employee.setDepartment( mapperUtils.mapToDepartment( request.getDepartmentId() ) );
        employee.setJobType( mapperUtils.mapToJobType( request.getJobTypeId() ) );
        employee.setJobLevel( mapperUtils.mapToJobLevel( request.getJobLevelId() ) );
        employee.setJobTitle( mapperUtils.mapToJobTitle( request.getJobTitleId() ) );
        employee.setUser( userMapper.requestToEntity( request.getUser() ) );

        return employee;
    }

    @Override
    public Employee partialUpdate(Employee entity, EmployeeRequest request) {
        if ( request == null ) {
            return null;
        }

        entity.setOffice( mapperUtils.mapToOffice( request.getOfficeId() ) );
        entity.setDepartment( mapperUtils.mapToDepartment( request.getDepartmentId() ) );
        entity.setJobType( mapperUtils.mapToJobType( request.getJobTypeId() ) );
        entity.setJobLevel( mapperUtils.mapToJobLevel( request.getJobLevelId() ) );
        entity.setJobTitle( mapperUtils.mapToJobTitle( request.getJobTitleId() ) );
        if ( request.getUser() != null ) {
            if ( entity.getUser() == null ) {
                entity.setUser( new User() );
            }
            userMapper.partialUpdate( entity.getUser(), request.getUser() );
        }
        else {
            entity.setUser( null );
        }

        return entity;
    }

    protected ProvinceResponse provinceToProvinceResponse(Province province) {
        if ( province == null ) {
            return null;
        }

        ProvinceResponse provinceResponse = new ProvinceResponse();

        provinceResponse.setId( province.getId() );
        provinceResponse.setCreatedAt( province.getCreatedAt() );
        provinceResponse.setUpdatedAt( province.getUpdatedAt() );
        provinceResponse.setName( province.getName() );
        provinceResponse.setCode( province.getCode() );

        return provinceResponse;
    }

    protected DistrictResponse districtToDistrictResponse(District district) {
        if ( district == null ) {
            return null;
        }

        DistrictResponse districtResponse = new DistrictResponse();

        districtResponse.setId( district.getId() );
        districtResponse.setCreatedAt( district.getCreatedAt() );
        districtResponse.setUpdatedAt( district.getUpdatedAt() );
        districtResponse.setName( district.getName() );
        districtResponse.setCode( district.getCode() );

        return districtResponse;
    }

    protected WardResponse wardToWardResponse(Ward ward) {
        if ( ward == null ) {
            return null;
        }

        WardResponse wardResponse = new WardResponse();

        wardResponse.setId( ward.getId() );
        wardResponse.setCreatedAt( ward.getCreatedAt() );
        wardResponse.setUpdatedAt( ward.getUpdatedAt() );
        wardResponse.setName( ward.getName() );
        wardResponse.setCode( ward.getCode() );

        return wardResponse;
    }

    protected AddressResponse addressToAddressResponse(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressResponse addressResponse = new AddressResponse();

        addressResponse.setId( address.getId() );
        addressResponse.setCreatedAt( address.getCreatedAt() );
        addressResponse.setUpdatedAt( address.getUpdatedAt() );
        addressResponse.setLine( address.getLine() );
        addressResponse.setProvince( provinceToProvinceResponse( address.getProvince() ) );
        addressResponse.setDistrict( districtToDistrictResponse( address.getDistrict() ) );
        addressResponse.setWard( wardToWardResponse( address.getWard() ) );

        return addressResponse;
    }

    protected OfficeResponse officeToOfficeResponse(Office office) {
        if ( office == null ) {
            return null;
        }

        OfficeResponse officeResponse = new OfficeResponse();

        officeResponse.setId( office.getId() );
        officeResponse.setCreatedAt( office.getCreatedAt() );
        officeResponse.setUpdatedAt( office.getUpdatedAt() );
        officeResponse.setName( office.getName() );
        officeResponse.setAddress( addressToAddressResponse( office.getAddress() ) );
        officeResponse.setStatus( office.getStatus() );

        return officeResponse;
    }

    protected DepartmentResponse departmentToDepartmentResponse(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentResponse departmentResponse = new DepartmentResponse();

        departmentResponse.setId( department.getId() );
        departmentResponse.setCreatedAt( department.getCreatedAt() );
        departmentResponse.setUpdatedAt( department.getUpdatedAt() );
        departmentResponse.setName( department.getName() );
        departmentResponse.setStatus( department.getStatus() );

        return departmentResponse;
    }

    protected JobTypeResponse jobTypeToJobTypeResponse(JobType jobType) {
        if ( jobType == null ) {
            return null;
        }

        JobTypeResponse jobTypeResponse = new JobTypeResponse();

        jobTypeResponse.setId( jobType.getId() );
        jobTypeResponse.setCreatedAt( jobType.getCreatedAt() );
        jobTypeResponse.setUpdatedAt( jobType.getUpdatedAt() );
        jobTypeResponse.setName( jobType.getName() );
        jobTypeResponse.setStatus( jobType.getStatus() );

        return jobTypeResponse;
    }

    protected JobLevelResponse jobLevelToJobLevelResponse(JobLevel jobLevel) {
        if ( jobLevel == null ) {
            return null;
        }

        JobLevelResponse jobLevelResponse = new JobLevelResponse();

        jobLevelResponse.setId( jobLevel.getId() );
        jobLevelResponse.setCreatedAt( jobLevel.getCreatedAt() );
        jobLevelResponse.setUpdatedAt( jobLevel.getUpdatedAt() );
        jobLevelResponse.setName( jobLevel.getName() );
        jobLevelResponse.setStatus( jobLevel.getStatus() );

        return jobLevelResponse;
    }

    protected JobTitleResponse jobTitleToJobTitleResponse(JobTitle jobTitle) {
        if ( jobTitle == null ) {
            return null;
        }

        JobTitleResponse jobTitleResponse = new JobTitleResponse();

        jobTitleResponse.setId( jobTitle.getId() );
        jobTitleResponse.setCreatedAt( jobTitle.getCreatedAt() );
        jobTitleResponse.setUpdatedAt( jobTitle.getUpdatedAt() );
        jobTitleResponse.setName( jobTitle.getName() );
        jobTitleResponse.setStatus( jobTitle.getStatus() );

        return jobTitleResponse;
    }
}
