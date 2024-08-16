package Entity;

public class OrderProductEntity {
 private int id_Order;
 private int id_Account;
 private int id_Product;
 private int quantity;
 private String Address;
 private String Zip;
public OrderProductEntity(int id_Order, int id_Account, int id_Product, int quantity, String address, String zip) {
	super();
	this.id_Order = id_Order;
	this.id_Account = id_Account;
	this.id_Product = id_Product;
	this.quantity = quantity;
	Address = address;
	Zip = zip;
}
public OrderProductEntity() {
	super();
}
public int getId_Order() {
	return id_Order;
}
public void setId_Order(int id_Order) {
	this.id_Order = id_Order;
}
public int getId_Account() {
	return id_Account;
}
public void setId_Account(int id_Account) {
	this.id_Account = id_Account;
}
public int getId_Product() {
	return id_Product;
}
public void setId_Product(int id_Product) {
	this.id_Product = id_Product;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getZip() {
	return Zip;
}
public void setZip(String zip) {
	Zip = zip;
}
 
 
 
}
