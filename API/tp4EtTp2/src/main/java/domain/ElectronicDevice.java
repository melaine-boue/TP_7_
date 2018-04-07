package domain;

import javax.persistence.Entity;

@Entity
public class ElectronicDevice extends Device{
	long consMoyenne;
	public ElectronicDevice() {

	}
	public ElectronicDevice( long consMoyenne) {
		this.consMoyenne = consMoyenne;
	}
	public long getConsMoyenne() {
		return consMoyenne;
	}
	public void setConsMoyenne(long consMoyenne) {
		this.consMoyenne = consMoyenne;
	}
}
