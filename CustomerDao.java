package in.Coder.bookstore.dao;

import java.util.List;

import in.Coder.bookstore.pojo.Customer;

public interface CustomerDao {

	boolean addCustomer(Customer cust);
	boolean updateCustomer(Customer cust);
	boolean deleteCustomer(String UserName);
	 List<Customer> getAllCustomer();
	 public Customer getCustByUsername(String UserName);
	 public  Customer getCustById(int custId);
	 List<Customer> getByUsername(String UserName);
}
