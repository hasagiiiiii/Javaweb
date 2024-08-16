package Entity;

public class CartEntity {
	private int idCart;
	private int idAcount;
	private int idProduct;
	private int quantity;
	private String name;
	private float price;
	private int sale;
	private String imgProduct;
	public CartEntity(int idCart, int idAcount, int idProduct, int quantity, String name, float price, int sale,
			String imgProduct) {
		super();
		this.idCart = idCart;
		this.idAcount = idAcount;
		this.idProduct = idProduct;
		this.quantity = quantity;
		this.name = name;
		this.price = price;
		this.sale = sale;
		this.imgProduct = imgProduct;
	}
	public CartEntity() {
		super();
	}
	public int getIdCart() {
		return idCart;
	}
	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}
	public int getIdAcount() {
		return idAcount;
	}
	public void setIdAcount(int idAcount) {
		this.idAcount = idAcount;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	public String getImgProduct() {
		return imgProduct;
	}
	public void setImgProduct(String imgProduct) {
		this.imgProduct = imgProduct;
	}
	
	
}
