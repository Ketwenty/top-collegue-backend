package com.topcollegue.tocollegue.service.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LightCollegue {

	/** pseudo : String */
	@Column(name = "PSEUDO")
	private String pseudo;
	/** score : Integer */
	@Column(name = "SCORE")
	private Integer score;
	/** urlImage : String */
	@Column(name = "URL_IMAGE", length = 5000)
	private String urlImage;

	/**
	 * Constructor
	 */
	public LightCollegue() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param pseudo
	 * @param score
	 * @param urlImage
	 */
	public LightCollegue(String pseudo, Integer score, String urlImage) {
		super();
		this.pseudo = pseudo;
		this.score = score;
		this.urlImage = urlImage;
	}

	/** Getter @return the pseudo */
	public String getPseudo() {
		return pseudo;
	}

	/** Setter @param pseudo the pseudo to set */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/** Getter @return the score */
	public Integer getScore() {
		return score;
	}

	/** Setter @param score the score to set */
	public void setScore(Integer score) {
		this.score = score;
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
