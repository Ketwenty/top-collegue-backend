package com.topcollegue.tocollegue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Kevin M.
 */
@Entity
@Table(name = "VOTE")
public class Vote {

	/** id : Integer */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	/** name : String */
	@Column(name = "AVIS")
	@Enumerated(EnumType.STRING)
	private Avis avis;

	@OneToOne
	private Collegue collegue;

	/**
	 * Constructor
	 */
	public Vote() {

	}

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param avis
	 * @param collegue
	 */
	public Vote(Integer id, Avis avis, Collegue collegue) {
		super();
		this.id = id;
		this.avis = avis;
		this.collegue = collegue;
	}

	/** Getter @return the id */
	public Integer getId() {
		return id;
	}

	/** Setter @param id the id to set */
	public void setId(Integer id) {
		this.id = id;
	}

	/** Getter @return the avis */
	public Avis getAvis() {
		return avis;
	}

	/** Setter @param avis the avis to set */
	public void setAvis(Avis avis) {
		this.avis = avis;
	}

	/** Getter @return the collegue */
	public Collegue getCollegue() {
		return collegue;
	}

	/** Setter @param collegue the collegue to set */
	public void setCollegue(Collegue collegue) {
		this.collegue = collegue;
	}

}
