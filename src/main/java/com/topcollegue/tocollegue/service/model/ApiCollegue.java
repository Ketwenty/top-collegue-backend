package com.topcollegue.tocollegue.service.model;

import java.util.List;

import com.topcollegue.tocollegue.entity.Collegue;

/**
 * @author Kevin M.
 */
public class ApiCollegue extends Collegue {

	/** matricule : String */
	private String matricule;
	/** dateNaissance : LocalDate */
	private String dateNaissance;
	/** sexe : String */
	private String sexe;
	/** password : String */
	private String password;
	/** photo : String */
	private String photo;
	/** subalternes : String */
	private List<String> subalternes;
	/** departement : String */
	private String departement;
	/** pseudo : String */
	private String pseudo;


	/**
	 * Constructor
	 */
	public ApiCollegue() {
		super();

	}

	/**
	 * Constructor
	 * 
	 * @param matricule
	 * @param dateNaissance
	 * @param sexe
	 * @param password
	 * @param photo
	 * @param subalternes
	 * @param departement
	 * @param pseudo
	 * @param score
	 */
	public ApiCollegue(String matricule, String dateNaissance, String sexe, String password, String photo,
			List<String> subalternes, String departement, String pseudo, String score) {
		super();
		this.matricule = matricule;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
		this.password = password;
		this.photo = photo;
		this.subalternes = subalternes;
		this.departement = departement;
		this.pseudo = pseudo;

	}

	/** Getter @return the matricule */
	public String getMatricule() {
		return matricule;
	}

	/** Setter @param matricule the matricule to set */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/** Getter @return the dateNaissance */
	public String getDateNaissance() {
		return dateNaissance;
	}

	/** Setter @param dateNaissance the dateNaissance to set */
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/** Getter @return the sexe */
	public String getSexe() {
		return sexe;
	}

	/** Setter @param sexe the sexe to set */
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	/** Getter @return the password */
	public String getPassword() {
		return password;
	}

	/** Setter @param password the password to set */
	public void setPassword(String password) {
		this.password = password;
	}

	/** Getter @return the photo */
	public String getPhoto() {
		return photo;
	}

	/** Setter @param photo the photo to set */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/** Getter @return the subalternes */
	public List<String> getSubalternes() {
		return subalternes;
	}

	/** Setter @param subalternes the subalternes to set */
	public void setSubalternes(List<String> subalternes) {
		this.subalternes = subalternes;
	}

	/** Getter @return the departement */
	public String getDepartement() {
		return departement;
	}

	/** Setter @param departement the departement to set */
	public void setDepartement(String departement) {
		this.departement = departement;
	}

	/** Getter @return the pseudo */
	public String getPseudo() {
		return pseudo;
	}

	/** Setter @param pseudo the pseudo to set */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

}
