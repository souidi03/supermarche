package strategypaiement;
import article.Article;
import offer.Offers;

public class PaiementDiscount extends PaiementStrategy implements MarketRules {

	private Article article;
	private int quantity;
	private int totaleproduct;
	private int codeOffer;
	private Offers offer;

	public PaiementDiscount() {
		// TODO Auto-generated constructor stub
	}

	public PaiementDiscount(Article article, int quantity) {
		super();
		this.article = article;
		this.quantity = quantity;
		this.totaleproduct = quantity;

	}

	public PaiementDiscount(Article article, int quantity, Offers offer) {
		super();
		this.article = article;
		this.quantity = quantity;
		this.totaleproduct = quantity;

		this.offer = offer;

	}

	@Override

	public void payer(double montant) {

		switch (this.offer.getCodeoffer()) {
		case 0:

			montant = BuyOneGetOneFree(this.article);
			displayBucket(this.article, montant);

			break;
		case 1:
			montant = ThreeForPriceOfTwo(this.article);
			displayBucket(this.article, montant);
			break;

		default:
			System.out.println("There is no offer for this article code" + this.article.getName());
		}

	}

	@Override
	public boolean checkStockNoEmpty(Article a, int quantity) {

		return a.getStock() >= quantity;
	}

	@Override
	public double BuyOneGetOneFree(Article a) {

		double totale = 0.0;

		if (isEmptyStock(a)) {
			System.out.println("Stock empty");
			return 0;
		} else {
			int rest = a.getStock() - this.quantity;

			if (rest < 0) {

				int quotion = a.getStock() / 2;

				totale = totale + (a.getStock() % 2) * a.getPrice() + quotion * a.getPrice();
				setTotaleproduct(this.quantity);
				setStock(a, 0);
				return totale;
			} else {

				if (rest > this.quantity * 2) {

					totale = totale + a.getPrice() * this.quantity;
					setTotaleproduct(this.quantity * 2);
					a.setStock(a.getStock() - this.quantity * 2);
					return totale;

				} else {

					totale = totale + a.getPrice() * this.quantity;
					setTotaleproduct(this.quantity);
					setStock(a, a.getStock() - this.quantity + a.getStock() % this.quantity);
					return totale;

				}
			}
		}

	}

	@Override
	public double ThreeForPriceOfTwo(Article a) {

		double totale = 0.0;
		if (isEmptyStock(a)) {
			return 0;
		}

		if (a.getStock() >= 3) {
			if (this.quantity >= 3 && this.quantity <= a.getStock()) {

				int quotion = this.quantity / 3;

				totale = totale + (quotion * a.getPrice() * 2) + (this.quantity % 3) * a.getPrice();
				setStock(a, a.getStock() - this.quantity);
				return totale;

			} else {

				totale = totale + this.quantity * a.getPrice();
				a.setStock(a.getStock() - this.quantity);
				return totale;

			}

		} else {

			if (this.quantity >= 3) {

				totale = totale + a.getStock() * a.getPrice();
				setStock(a, 0);

				return totale;
			} else {
				if (a.getStock() > this.quantity) {

					totale = totale + this.quantity * a.getPrice();
					setStock(a, a.getStock() - this.quantity);
					return totale;
				} else {

					totale = totale + a.getStock() * a.getPrice();
					setStock(a, this.quantity);
					return totale;
				}

			}

		}

	}

	@Override
	public void setStock(Article a, int quantity) {

		a.setStock(a.getStock() - quantity);
	}

	@Override
	public int getStockArticle(Article a) {
		return a.getStock();
	}

	public void setTotaleproduct(int totaleproduct) {
		this.totaleproduct = totaleproduct;
	}

	@Override
	public void displayBucket(Article a, double montant) {
		System.out.println("montant payer" + montant + "Busket= " + this.article.getName() + "quantity "
				+ this.getTotaleproduct());

	}

	public int getTotaleproduct() {
		return totaleproduct;
	}

	@Override
	public boolean isEmptyStock(Article a) {

		return a.getStock() == 0;
	}

}
