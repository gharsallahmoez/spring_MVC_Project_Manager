package tp1.model;

import java.util.List;

public class Departement {
	private int numero; 
	private String nom ;
	private List<Projet> listProjet;
	public Departement(int numero, String nom) {
		super();
		this.numero = numero;
		this.nom = nom;
	}
	public int getNumero() {
		return numero;
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
	public List<Projet> getListProjet() {
		return listProjet;
	}
	public void setListProjet(List<Projet> listProjet) {
		this.listProjet = listProjet;
	}
	public Departement() {
		super();
	} 
	
}
