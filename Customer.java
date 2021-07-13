package in.Coder.bookstore.pojo;

public class Customer {
	
	private int custId;
	private String custName,address,emailId,UserName,phoneNumber,password;
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	
	public String getUserName() {
		return UserName;
	}
	public  void setUserName(String UserName) {
		this.UserName = UserName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", address=" + address + ", emailId=" + emailId
				+ ", UserName=" + UserName + ", phoneNumber=" + phoneNumber + ", password=" + password + "]";
	}
}
