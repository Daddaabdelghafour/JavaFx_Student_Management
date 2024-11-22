package Models;

public class Etudiant {

	String nom;
	String prenom;
	String Cne;
	String email;
	
	public String getNom() {
		return this.nom;
	}

	public String getPrenom() {
		return this.prenom;
	}
	
	public String getCne() {
		return this.Cne;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	
	public Etudiant(String n , String p , String c , String e) {
			this.nom=n;
			this.prenom=p;
			this.Cne=c;
			this.email=e;
	}
}
