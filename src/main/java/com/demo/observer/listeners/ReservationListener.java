package com.demo.observer.listeners;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.observer.enumeration.ETypeOperation;
import com.demo.observer.eventListener.EventListener;

/**
 * Listener de la reservation permettant 
 * de notifier l'utilisateur de la reservation
 * @author fidal
 *
 */
public class ReservationListener implements EventListener {
	
	private ETypeOperation typeOperation;
	private Date dateReservation;
	
	private Logger logger = LoggerFactory.getLogger(ReservationListener.class);

	
	public ReservationListener(ETypeOperation typeOperation, Date dateReservation) {
		super();
		this.typeOperation = typeOperation;
		this.dateReservation = dateReservation;
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		logger.info("Votre reservation a bien été prise en compte. "
				+ "Vous serez notifiez d'un autre message lorsque votre commande "
				+ "sera receptionner en magasin");
	}


	public ETypeOperation getTypeOperation() {
		return typeOperation;
	}


	public void setTypeOperation(ETypeOperation typeOperation) {
		this.typeOperation = typeOperation;
	}


	public Date getDateReservation() {
		return dateReservation;
	}


	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}
	
	
	
	

}
