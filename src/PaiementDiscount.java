
public class PaiementDiscount extends PaiementStrategy implements MarketRules {

	private Article article;
	private int quantity;
	private int totaleproduct;

	public PaiementDiscount() {
		// TODO Auto-generated constructor stub
	}

	public PaiementDiscount(Article article, int quantity) {
		super();
		this.article = article;
		this.quantity = quantity;
		this.totaleproduct = quantity;

	}

	@Override

	public void payer(double montant) {

		if (isApple(this.article)) {

			montant = BuyOneGetOneFree(this.article);
			displayBucket(this.article, montant);

		} else if (isWaterMelon(this.article)) {
			montant = ThreeForPriceOfTwo(this.article);
			displayBucket(this.article, montant);
		} else {
			System.out.println("There is no offer for this article");
		}

	}

	@Override
	public boolean checkStockNoEmpty(Article a, int quantity) {

		return a.getStock() >= quantity;
	}

	@Override
	public boolean isApple(Article a) {
		return a.getName().equals("Apple");
	}

	@Override
	public boolean isWaterMelon(Article a) {
		return a.getName().equals("Watermelon");
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

		System.out.println("Stock is empty");
		return a.getStock() == 0;
	}

}
