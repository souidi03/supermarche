package strategypaiement;
import article.Article;

public class PaiementNoDiscount extends PaiementStrategy {

	private Article article;
	private int quantity;

	public PaiementNoDiscount() {

	}

	public PaiementNoDiscount(Article article, int quantity) {
		super();
		this.article = article;
		this.quantity = quantity;

	}

	@Override

	public void payer(double montant) {

		montant = this.article.getPrice() * this.quantity;
		
		displayBucket(this.article, montant);
		
		this.article.setStock(this.article.getStock() - this.quantity);

	}

	@Override
	public void displayBucket(Article a, double montant) {
		
		System.out.println(
				" montant payer= " + montant +
				" Busket= " + this.article.getName() +
				" quantity=" + this.quantity);

	}

}
