package airline;

import java.time.LocalDate;

public class SeasonalDiscount {
	private LocalDate discountStart;
	private LocalDate discountEnd;
	
	public SeasonalDiscount(LocalDate discountStart, LocalDate discountEnd) {
		super();
		this.discountStart = discountStart;
		this.discountEnd = discountEnd;
	}

	public LocalDate getDiscountStart() {
		return discountStart;
	}
	
	public void setDiscountStart(LocalDate discountStart) {
		this.discountStart = discountStart;
	}
	
	public LocalDate getDiscountEnd() {
		return discountEnd;
	}
	
	public void setDiscountEnd(LocalDate discountEnd) {
		this.discountEnd = discountEnd;
	}
}
