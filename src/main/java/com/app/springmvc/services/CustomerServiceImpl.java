package com.app.springmvc.services;

import com.app.springmvc.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: in708bhugad
 * Date: 05-01-2020
 * Time: 16:49
 * inside the package - com.app.springmvc.services
 * To change this template use File | Settings | File and Code Templates.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<Integer, Customer> customers;

    public CustomerServiceImpl() {
        loadCustomers();
    }

    @Override
    public List<Customer> listAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customers.get(id);
    }

    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {
        if (customer != null){
            if (customer.getId() == null){
                customer.setId(getNextKey());
            }
            customers.put(customer.getId(), customer);
            return customer;
        } else {
            throw new RuntimeException("Customer Can't be nill");
        }
    }

    private Integer getNextKey(){
        return Collections.max(customers.keySet()) + 1;
    }

    @Override
    public void deleteCustomer(Integer id) {
        customers.remove(id);
    }


    private void loadCustomers() {
        customers = new HashMap<>();
        Customer c1 = new Customer();
        c1.setId(1);
        c1.setFirstName("Bhushan");
        c1.setLastName("Gadekar");
        c1.setEmail("b.gadekar@crif.com");
        c1.setPhone("9886631264");
        c1.setAddress("Nashik");
        c1.setCity("Nashik");
        c1.setState("Maharashtra");
        c1.setZipCode("422302");
        customers.put(1, c1);

        Customer c2 = new Customer();
        c2.setId(2);
        c2.setFirstName("Ganesh");
        c2.setLastName("Karki");
        c2.setEmail("g.karki@crif.com");
        c2.setPhone("9886631264");
        c2.setAddress("Japan");
        c2.setCity("Tokyo");
        c2.setState("Tokyo");
        c2.setZipCode("000000");
        customers.put(2, c2);

        Customer c3 = new Customer();
        c3.setId(3);
        c3.setFirstName("Akash");
        c3.setLastName("Bhandawalkar");
        c3.setEmail("a.bhandwalkar@crif.com");
        c3.setPhone("9886631264");
        c3.setAddress("Paranda");
        c3.setCity("Paranda");
        c3.setState("Maharashtra");
        c3.setZipCode("422211");
        customers.put(3, c3);

        Customer c4 = new Customer();
        c4.setId(4);
        c4.setFirstName("Hiren");
        c4.setLastName("Patel");
        c4.setEmail("h.patel@crif.com");
        c4.setPhone("9886631264");
        c4.setAddress("Pune");
        c4.setCity("Pune");
        c4.setState("Maharashtra");
        c4.setZipCode("411018");
        customers.put(4, c4);
    }


}
