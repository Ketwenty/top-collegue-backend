package com.topcollegue.tocollegue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	/** urlImage : String */
	@Column(name = "URL_IMAGE")
	private String urlImage;

	/** score : Integer */
	@Column(name = "SCORE")
	private Integer score;
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
	 * @param urlImage
	 * @param score
	 */
	public Collegue(Integer id, String name, String urlImage, Integer score) {
		super();
		this.id = id;
		this.name = name;
		this.urlImage = urlImage;
		this.score = score;
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

	/** Getter @return the urlImage */
	public String getUrlImage() {
		return urlImage;
	}

	/** Setter @param urlImage the urlImage to set */
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	/** Getter @return the score */
	public Integer getScore() {
		return score;
	}

	/** Setter @param score the score to set */
	public void setScore(Integer score) {
		this.score = score;
	}
}
