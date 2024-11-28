package main.java.com.solvd.airline;
import java.util.Date;

public class SeasonalDiscount extends Discount {
	private Date discountStart;
	private Date discountEnd;
	

	public SeasonalDiscount(int discountPercent, Date discountStart, Date discountEnd) throws InvalidPercentageException {
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
	public final boolean checkEligibility(Reservation reservation) {
		if (reservation.getFlight().getDepartureTime().after(discountStart) && reservation.getFlight().getDepartureTime().before(discountEnd)) {
			return true;
		}
		return false;
	}

	@Override
	public double apply(double amount) {
		return amount - (amount * this.discountPercent / 100);
	}
	
	@Override
	public double getDiscountPercent() {
		return this.discountPercent;
	}

	@Override
	public void setDiscountPercent(double discountPercent) throws InvalidPercentageException {
		if (discountPercent < 0 || discountPercent > 100) {
			throw new InvalidPercentageException("Percentage must be between 0 and 100.");
		}
		this.discountPercent = discountPercent;
	}
}
