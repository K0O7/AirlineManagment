package airline;
import java.util.Date;

public class SeasonalDiscount extends Discount {
	private Date discountStart;
	private Date discountEnd;
	

	public SeasonalDiscount(int discountPercent, Date discountStart, Date discountEnd) {
		super(discountPercent);
		this.discountStart = discountStart;
		this.discountEnd = discountEnd;
	}

	public Date getDiscountStart() {
		return discountStart;
	}
	
	public void setDiscountStart(Date discountStart) {
		this.discountStart = discountStart;
	}
	
	public Date getDiscountEnd() {
		return discountEnd;
	}
	
	public void setDiscountEnd(Date discountEnd) {
		this.discountEnd = discountEnd;
	}

	@Override
	public boolean checkEligibility(Reservation reservation) {
		if (reservation.getFlight().getDepartureTime().after(discountStart) && reservation.getFlight().getDepartureTime().before(discountEnd)) {
			return true;
		}
		return false;
	}
}
