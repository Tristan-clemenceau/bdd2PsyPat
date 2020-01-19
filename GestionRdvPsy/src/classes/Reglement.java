package classes;

public class Reglement {
	private String reglement;
	private int id_reglement;

	public Reglement(String reglement, int id_reglement) {
		super();
		this.reglement = reglement;
		this.id_reglement = id_reglement;
	}

	public Reglement(String reglement) {
		this.reglement = reglement;
	}

	public String getReglement() {
		return reglement;
	}

	public void setReglement(String reglement) {
		this.reglement = reglement;
	}

	public int getId_reglement() {
		return id_reglement;
	}

	public void setId_reglement(int id_reglement) {
		this.id_reglement = id_reglement;
	}

	@Override
	public String toString() {
		return "Reglement [reglement=" + reglement + "]";
	}

}
