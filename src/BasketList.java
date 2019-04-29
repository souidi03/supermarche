import java.util.ArrayList;
import java.util.List;

public class BasketList extends Article {

	private double totaleprice = 0.0;

	private List<Article> articlelist = new ArrayList<Article>();

	private Article article;

	public BasketList() {
		this.totaleprice = 0.0;
		this.articlelist = null;

	}

	public BasketList(Article article) {
		this.article = article;
		this.articlelist = this.addArticleToBasket(article);
	}

	public BasketList(List<Article> articlelist) {

		this.articlelist = articlelist;
	}

	public ArrayList<Article> addArticleToBasket(Article a) {

		this.articlelist.add(a);
		return (ArrayList<Article>) this.articlelist;

	}

	public void removeArticleToBasket(Article a) {
		this.articlelist.remove(a);
	}



	public void displayBasket(List<Article> articlelist) {

		for (Article article : articlelist) {

			System.out.println("Busket= " + article.getName() + "quantity ");
		}

	}

	public void payer(PaiementStrategy methode) {

		for (Article article : articlelist) {

			methode.payer(this.totale);
			displayBasket(this.articlelist);
		}

	}

}
