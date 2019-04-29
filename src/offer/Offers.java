package offer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Offers {

	private int codeoffer ;

	private String nameOffer;

	public Offers() {

	}

	public Offers(String nameOffer, int codeoffer) {
		this.codeoffer = codeoffer;

		this.nameOffer = this.nameOffer;

	}

	public Offers(int codeoffer) {
		this.codeoffer = codeoffer;

	}

	public int getCodeoffer() {
		return codeoffer;
	}

	public void setCodeoffer(int codeoffer) {
		this.codeoffer = codeoffer;
	}

	public String getNameOffer() {
		return nameOffer;
	}

	public void setNameOffer(String nameOffer) {
		this.nameOffer = nameOffer;
	}

}
