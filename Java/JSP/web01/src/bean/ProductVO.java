package bean;

public class ProductVO {
	// db table의 컬럼명과 동일하게 저장할 공간 만들어주세요.
	String id;
	String name;
	String content;
	int price;
	String company;
	String img;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	// 가방안에 어떤 데이터들이 들어가있는지 String으로 프린트하고 싶다.

	@Override
	public String toString() {
		return "ProductVO [id=" + id + ", name=" + name + ", content=" + content + ", price=" + price + ", company="
				+ company + ", img=" + img + "]";
	}

}
