package pkgCore;


import java.text.DecimalFormat;

import org.apache.poi.ss.formula.functions.FinanceLib;


public class Retirement {

	private int iYearsToWork;
	private double dAnnualReturnWorking;
	private int iYearsRetired;
	private double dAnnualReturnRetired;
	private double dRequiredIncome;
	private double dMonthlySSI;
	
	
	public Retirement (int iYearsToWork, double dAnnualReturnWorking, int iYearsRetired, double dAnnualReturnRetired, 
			double dRequiredIncome, double dMonthlySSI) {
		
		super();
		this.iYearsToWork = iYearsToWork;
		this.dAnnualReturnWorking = dAnnualReturnWorking;
		this.iYearsRetired = iYearsRetired;
		this.dAnnualReturnRetired = dAnnualReturnRetired;
		this.dRequiredIncome = dRequiredIncome;
		this.dMonthlySSI = dMonthlySSI;			
		
	}
	
	public int getiYearsToWork() {
		return iYearsToWork;
	}

	public void setiYearsToWork(int iYearsToWork) {
		this.iYearsToWork = iYearsToWork;
	}

	public double getdAnnualReturnWorking() {
		return dAnnualReturnWorking;
	}

	public void setdAnnualReturnWorking(double dAnnualReturnWorking) {
		this.dAnnualReturnWorking = dAnnualReturnWorking;
	}

	public int getiYearsRetired() {
		return iYearsRetired;
	}

	public void setiYearsRetired(int iYearsRetired) {
		this.iYearsRetired = iYearsRetired;
	}

	public double getdAnnualReturnRetired() {
		return dAnnualReturnRetired;
	}

	public void setdAnnualReturnRetired(double dAnnualReturnRetired) {
		this.dAnnualReturnRetired = dAnnualReturnRetired;
	}

	public double getdRequiredIncome() {
		return dRequiredIncome;
	}

	public void setdRequiredIncome(double dRequiredIncome) {
		this.dRequiredIncome = dRequiredIncome;
	}

	public double getdMonthlySSI() {
		return dMonthlySSI;
	}

	public void setdMonthlySSI(double dMonthlySSI) {
		this.dMonthlySSI = dMonthlySSI;
	}
	
	
	public double AmountToSave()
	{
		
		DecimalFormat dec = new DecimalFormat("0.00");
		double pmt = Double.parseDouble(dec.format(FinanceLib.pmt(dAnnualReturnWorking / 12, iYearsToWork * 12, 0, this.TotalAmountSaved(), false)));
		
		return pmt;
	}
	
	public double TotalAmountSaved()
	{
		
		DecimalFormat dec = new DecimalFormat("0.00");
		 double pv = Double.parseDouble(dec.format(FinanceLib.pv(dAnnualReturnRetired/12, iYearsRetired*12.0, dRequiredIncome - dMonthlySSI, 0.0, false)));
	        return pv;
	}
}
