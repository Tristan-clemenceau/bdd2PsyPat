package classes;

public class Classification {
	private String nom;
	
	public Classification(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Classification [nom=" + nom + "]";
	}
	
}
