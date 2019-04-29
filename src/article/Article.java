package article;
import strategypaiement.PaiementStrategy;

public class Article {

	private String name;
	private double price;
	private int stock;

	double totale = 0.0;

	public Article() {
	}

	public Article(String name, double price, int stock) {
		super();
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.totale = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void payer(PaiementStrategy methode) {

		methode.payer(this.totale);

	}

}
