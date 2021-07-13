package in.Coder.bookstore.pojo;

import java.sql.Date;
import java.time.LocalDate;

public class Order {
private int orderId;
private double totalBill;
private String custUserName;
private LocalDate date;

public double getTotalBill() {
	return totalBill;
}
public void setTotalBill(double totalBill) {
	this.totalBill = totalBill;
}
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}


public String getCustUserName() {
	return custUserName;
}
public void setCustUserName(String custUserName) {
	this.custUserName = custUserName;
}
@Override
public String toString() {
	return "Order [orderId=" + orderId + ", totalBill=" + totalBill + ", custUserName=" + custUserName + ", date="
			+ date + "]";
}

}
