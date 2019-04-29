package offer;

import java.util.*;

public class ManageOffers {

	private Offers offer = new Offers();
	private ArrayList<Offers> listoffers = new ArrayList<Offers>();

	public ManageOffers() {

	}

	public ManageOffers(ArrayList<Offers> listoffers, Offers offer) {

		this.listoffers = listoffers;
		this.offer = offer;

	}

	public ManageOffers(ArrayList<Offers> listoffers) {

		this.listoffers = listoffers;

	}

	public void addNewOffer(int codeOffer, String nameOffer) {

		if (isOfferExist(codeOffer) == false) {

			listoffers.add(new Offers(nameOffer, codeOffer));
			System.out.println("Offer add succes");
		} else {

			System.out.println("Offer exist");
		}

	}

	public void removeOffer(int codeOffer) {

		if (isOfferExist(codeOffer) == true) {

			listoffers.remove(codeOffer);
			System.out.println("Offer delete succes");
		} else {

			System.out.println("Offer doesn't exist");
		}

	}

	public boolean isOfferExist(int codeOffer) {

		for (int i = 0; i < listoffers.size(); i++) {
			if (listoffers.get(i).getCodeoffer() == codeOffer)
				return true;
		}
		return false;

	}

}
