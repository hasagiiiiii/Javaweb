package dovantrung_2110900043.beans;

public class Category {
 private int CategoryId;
 private String CategoryName;
public Category(int categoryId, String categoryName) {
	super();
	CategoryId = categoryId;
	CategoryName = categoryName;
}
public Category() {
	super();
}
public int getCategoryId() {
	return CategoryId;
}
public void setCategoryId(int categoryId) {
	CategoryId = categoryId;
}
public String getCategoryName() {
	return CategoryName;
}
public void setCategoryName(String categoryName) {
	CategoryName = categoryName;
}
 
 
 
}
