package com.topcollegue.tocollegue.service.model;

public class NewCollegue {

	/** matricule : String */
	private String matricule;
	/** pseudo : Integer */
	private String pseudo;
	/** urlImage : String */
	private String urlImage;

	/**
	 * Constructor
	 */
	public NewCollegue() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param matricule
	 * @param pseudo
	 * @param urlImage
	 */
	public NewCollegue(String matricule, String pseudo, String urlImage) {
		super();
		this.matricule = matricule;
		this.pseudo = pseudo;
		this.urlImage = urlImage;
	}

	/** Getter @return the matricule */
	public String getMatricule() {
		return matricule;
	}

	/** Setter @param matricule the matricule to set */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/** Getter @return the pseudo */
	public String getPseudo() {
		return pseudo;
	}

	/** Setter @param pseudo the pseudo to set */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/** Getter @return the urlImage */
	public String getUrlImage() {
		return urlImage;
	}

	/** Setter @param urlImage the urlImage to set */
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

}
