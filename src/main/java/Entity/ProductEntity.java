package Entity;

public class ProductEntity {
	private int id_product;
	private String nameProduct;
	private int startProduct;
	private float price;
	private int sale;
	private String description;
	private String trademark;
	private int quantityPro;
	private String imgPro;
	private String colorPro;
	public ProductEntity() {
		super();
	}
	public ProductEntity(int id_product, String nameProduct, int startProduct, float price, int sale,
			String description, String trademark, int quantityPro, String imgPro, String colorPro) {
		super();
		this.id_product = id_product;
		this.nameProduct = nameProduct;
		this.startProduct = startProduct;
		this.price = price;
		this.sale = sale;
		this.description = description;
		this.trademark = trademark;
		this.quantityPro = quantityPro;
		this.imgPro = imgPro;
		this.colorPro = colorPro;
	}
	public int getId_product() {
		return id_product;
	}
	public void setId_product(int id_product) {
		this.id_product = id_product;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public int getStartProduct() {
		return startProduct;
	}
	public void setStartProduct(int startProduct) {
		this.startProduct = startProduct;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTrademark() {
		return trademark;
	}
	public void setTrademark(String trademark) {
		this.trademark = trademark;
	}
	public int getQuantityPro() {
		return quantityPro;
	}
	public void setQuantityPro(int quantityPro) {
		this.quantityPro = quantityPro;
	}
	public String getImgPro() {
		return imgPro;
	}
	public void setImgPro(String imgPro) {
		this.imgPro = imgPro;
	}
	public String getColorPro() {
		return colorPro;
	}
	public void setColorPro(String colorPro) {
		this.colorPro = colorPro;
	}
	
	
}
