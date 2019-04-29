
public class Main {

	public static void main(String[] args) {
		
		/*article price quatity stock*/
		Article article1 = new Article("Apple", 4.0, 10);
		Article article2 = new Article("Watermelon", 2.0, 8);
		Article article3 = new Article("Orange", 2.0, 6);


		// Check articales with offer
		article1.payer(new PaiementDiscount(article1, 2,new Offers(1)));
		// All articles without offer
		article1.payer(new PaiementNoDiscount(article1, 2));

		// with offer
		article2.payer(new PaiementDiscount(article2, 3,new Offers(0)));
		// without offer
		article2.payer(new PaiementNoDiscount(article2, 4));

		// offer doesn't exist
		article3.payer(new PaiementDiscount(article3, 3,new Offers(3)));
		// offer exist
		article3.payer(new PaiementDiscount(article3, 3,new Offers(1)));
		// without offer
		article3.payer(new PaiementNoDiscount(article3, 4));

	}

}
