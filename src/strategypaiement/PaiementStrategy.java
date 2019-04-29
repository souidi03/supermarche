package strategypaiement;
import article.Article;

public abstract class PaiementStrategy {

	public abstract void payer(double montant);

	public abstract void displayBucket(Article a, double montant);

}
