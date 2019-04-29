package strategypaiement;
import article.Article;

public interface MarketRules {

	public int getStockArticle(Article a);

	public boolean checkStockNoEmpty(Article a, int quantity);

	public double BuyOneGetOneFree(Article a);

	public double ThreeForPriceOfTwo(Article a);

	public void setStock(Article a, int quantity);

	// public void displayBucket(Article a, double montant);

	public boolean isEmptyStock(Article a);
}