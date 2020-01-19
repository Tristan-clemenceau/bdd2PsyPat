package classes;

public class Classification {
	private String nom;
	private int id;
	
	public Classification(String nom,int id) {
		this.nom = nom;
		this.id= id;
	}
	public Classification(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Classification [nom=" + nom + "]";
	}
	
}
