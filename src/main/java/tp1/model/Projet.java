package tp1.model;

public class Projet {
	private int numero; 
	private String titre; 
	private int etat;
	private Departement departement;
	
	
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	public Projet(int numero, String titre, int etat, Departement departement) {
		super();
		this.numero = numero;
		this.titre = titre;
		this.etat = etat;
		this.departement = departement;
	}
	public Projet() {
		super();
	} 
	

}
