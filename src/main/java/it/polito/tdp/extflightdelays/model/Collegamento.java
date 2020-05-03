package it.polito.tdp.extflightdelays.model;

public class Collegamento {
	private Airport A1;
	private Airport A2;
	private long media;
	private int numerovoli;
	
	
	
	/**
	 * @param a1
	 * @param a2
	 * @param media
	 */
	public Collegamento(Airport a1, Airport a2, long media,int numerovoli) {
		super();
		A1 = a1;
		A2 = a2;
		this.media = media;
		this.numerovoli=numerovoli;
	}
	
	public Airport getA1() {
		return A1;
	}
	public void setA1(Airport a1) {
		A1 = a1;
	}
	public Airport getA2() {
		return A2;
	}
	public void setA2(Airport a2) {
		A2 = a2;
	}
	public long getMedia() {
		return media;
	}
	public void setMedia(long media) {
		this.media = media;
	}
	
	public int getNumerovoli() {
		return numerovoli;
	}
	public void setNumerovoli(int numerovoli) {
		this.numerovoli = numerovoli;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((A1 == null) ? 0 : A1.hashCode());
		result = prime * result + ((A2 == null) ? 0 : A2.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Collegamento other = (Collegamento) obj;
		if (A1 == null) {
			if (other.A1 != null)
				return false;
		} else if (!A1.equals(other.A1))
			return false;
		if (A2 == null) {
			if (other.A2 != null)
				return false;
		} else if (!A2.equals(other.A2))
			return false;
		return true;
	}
	
	
	
	

}
