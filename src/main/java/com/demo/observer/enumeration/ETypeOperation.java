package com.demo.observer.enumeration;

/**
 * Enumération représentant les différentes actions possible par l'utilisateur
 * @author fidal
 *
 */
public enum ETypeOperation {
	
	ACHETER("acheter"),
	RESERVER("reserver"),
	ENVOIE_COMMANDE("Envoie commande"),
	DISPO_MAGASIN("Dispo en magasin");

	
	private String operation;
	
	ETypeOperation(String operation) {
		this.operation = operation;
	}

	public String getOperation() {
		return operation;
	}
	
}
