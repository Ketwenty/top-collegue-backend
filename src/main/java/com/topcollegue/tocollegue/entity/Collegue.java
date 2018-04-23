package com.topcollegue.tocollegue.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.topcollegue.tocollegue.service.model.LightCollegue;

/**
 * @author Kevin M.
 */
@Entity
@Table(name = "COLLEGUE")
public class Collegue {

	/** id : Integer */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	/** name : String */
	@Column(name = "NAME")
	private String name;

	/** prenom : String */
	@Column(name = "PRENOM")
	private String prenom;

	/** email : String */
	@Column(name = "EMAIL")
	private String email;

	/** Adresse : String */
	@Column(name = "ADRESSE")
	private String adresse;

	/** lightCollegue : LightCollegue */
	@Embedded
	private LightCollegue lightCollegue;

	/**
	 * Constructor
	 */
	public Collegue() {
	}

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param name
	 * @param prenom
	 * @param email
	 * @param adresse
	 */
	public Collegue(Integer id, String name, String urlImage, Integer score, String prenom, String pseudo, String email,
			String adresse) {
		super();
		this.id = id;
		this.name = name;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.lightCollegue = new LightCollegue(pseudo, score, urlImage);
	}

	/** Getter @return the id */
	public Integer getId() {
		return id;
	}

	/** Setter @param id the id to set */
	public void setId(Integer id) {
		this.id = id;
	}

	/** Getter @return the name */
	public String getName() {
		return name;
	}

	/** Setter @param name the name to set */
	public void setName(String name) {
		this.name = name;
	}

	/** Getter @return the prenom */
	public String getPrenom() {
		return prenom;
	}

	/** Setter @param prenom the prenom to set */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/** Getter @return the email */
	public String getEmail() {
		return email;
	}

	/** Setter @param email the email to set */
	public void setEmail(String email) {
		this.email = email;
	}

	/** Getter @return the adresse */
	public String getAdresse() {
		return adresse;
	}

	/** Setter @param adresse the adresse to set */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/** Getter @return the lightCollegue */
	public LightCollegue getLightCollegue() {
		return lightCollegue;
	}

	/** Setter @param lightCollegue the lightCollegue to set */
	public void setLightCollegue(LightCollegue lightCollegue) {
		this.lightCollegue = lightCollegue;
	}
}
