package kalkulatorKredytowy;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;

public class CalcBB {
	private String credit;
	private String mouth;
	private String rrso;
	
	private double result;
	
	@Inject
	FacesContext ctx;
	
	public String getCredit() { return credit; }
	public void setCredit(String credit) { this.credit = credit; }
	
	public String getMouth() { return mouth; }
	public void setMouth(String mouth) { this.mouth = mouth; }
	
	public String getRrso() { return rrso; }
	public void setRrso(String rrso) { this.rrso = rrso; }
	
	public void setResult(double result) { this.result = result; }
	
	public boolean doTheMath() {
		try {
			double credit = Double.parseDouble(this.credit);
			double mouth = Double.parseDouble(this.mouth);

			this.result = credit + mouth;

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
			return false;
		}
	}

	// Go to "showresult" if ok
	public String calc() {
		if (doTheMath()) {
			return "showresult";
		}
		return null;
	}
}
