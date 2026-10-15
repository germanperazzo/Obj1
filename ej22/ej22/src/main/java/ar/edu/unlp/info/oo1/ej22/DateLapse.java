package ar.edu.unlp.info.oo1.ej22;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;



public class DateLapse {
	private LocalDate from;
	private LocalDate to;
	
	public DateLapse(LocalDate from, LocalDate to) {
		this.from = from;
		this.to = to;
	}
	
	public LocalDate getFrom() {
		return this.from;
	}
	

	public LocalDate getTo(){
		return this.to;
	}
	

	public int sizeInDays() {
	    return (int) ChronoUnit.DAYS.between(this.from, this.to);
	}
	
	public boolean includesDate(LocalDate other) {
		return !other.isBefore(this.from) && !other.isAfter(this.to) ;
	}
	
	
	public boolean overlapse(DateLapse periodo) { 
		return !((this.from.isAfter(periodo.to)) || (this.to.isBefore(periodo.from))); 
	}
}
