package tp1.model;

public class Employee {
	private int numero; 
	private String nom ; 
	private Projet projet;
	private String fonction ; 
	private Departement departement;
	public int getNumero() {
		return numero;
	}
	
	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	public Employee() {
		super();
	}
	public Employee(int numero, String nom, Projet projet, Departement departement, String fonction) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.projet = projet;
		this.departement = departement;
		this.fonction=fonction;
	} 
	
}
