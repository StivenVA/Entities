package org.clubhive.repositories.implement;

import FindUser.FindUser;
import exceptions.NoBugsException;
import lombok.RequiredArgsConstructor;
import org.clubhive.entities.UserEntity;
import org.clubhive.model.Customer;
import org.clubhive.repositories.UserRepositoryImplementation;
import org.clubhive.repositories.jpa.CustomerRepository;
import org.clubhive.utils.GenericMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CustomerRepoImpl implements UserRepositoryImplementation<Customer> {
    private final CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        UserEntity userEntity = GenericMapper.map(customer, UserEntity.class);

        return GenericMapper.map(customerRepository.save(userEntity), Customer.class);

    }

    @Override
    public Customer update(Customer customer){

        FindUser<UserEntity,String> findByUserId = (userId)-> customerRepository.findAll().stream().filter(userEntity -> userEntity.getUserId().equals(userId)).findFirst().orElseThrow(()->new NoBugsException("User not found", HttpStatus.NOT_FOUND));

        UserEntity userEntity = findByUserId.findBy(customer.getUserId());


        userEntity.setName((customer.getName() != null) ? customer.getName(): userEntity.getName());
        userEntity.setPhone((customer.getPhone() != null) ? customer.getPhone() : userEntity.getPhone());

        return save(GenericMapper.map(userEntity, Customer.class));
    }

    @Override
    public List<Customer> findAll(){
        return GenericMapper.mapList(customerRepository.findAll(), Customer.class);
    }

}
