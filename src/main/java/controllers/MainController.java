package controllers;


import javafx.scene.control.Button;
import model.App;
import model.util.Constants;
import view.MainView;
import view.ViewBase;

import java.io.IOException;
import java.net.UnknownHostException;

/**
 * Contrôleur pour la vue principale de l'application TamagotchiClient.
 * Ce contrôleur gère la lecture du port, la connexion au serveur et la transition vers la vue Tamagotchi.
 */
public class MainController extends ControllerBase {

	/**
	 * Vue spécifique utilisée pour la saisie du port.
	 */
	private MainView mainView;



	/**
	 * Constructeur pour le contrôleur principal.
	 *
	 * @param view La vue associée à ce contrôleur.
	 */
	public MainController(ViewBase view) {
		super(view);
	}

	/**
	 * Méthode d'initialisation du contrôleur principal.
	 * Configure l'action du bouton de connexion.
	 */
	@Override
	protected void initialize() {
		this.mainView = (MainView) super.view;

		Button connectButton = mainView.getConnectButton();
		connectButton.setOnAction(event -> onConnectButtonClick());
	}

	/**
	 * Lit le numéro de port saisi par l'utilisateur et tente de se connecter au serveur Tamagotchi.
	 * Si le champ est vide, le port par défaut est utilisé.
	 * En cas de connexion réussie, la vue Tamagotchi est affichée.
	 */
	private void onConnectButtonClick() {
		int port = -1; // not sure
		// TODO Tâche 5 : Implémenter le changement de la vue lors d'une connexion et gèrer la validation du numéro de port 
		// Votre code doit utiliser la ligne ci-dessous:
		//						super.setUpSocket(port);
		//						App.showView("Tamagotchi");

		String portText = mainView.getPortField().getText().trim();
		
		System.out.println(portText);
		
	    if (portText.isEmpty()) {
	        port = Constants.DEFAULT_PORT;
	    } else {
	        try {
	            port = Integer.parseInt(portText);
	            if (port <= 0 || port > 66666) {
	                throw new NumberFormatException();
	            }
	        } catch (NumberFormatException e) {
	            showError("Invalid port number. Please enter a valid port number between 1 and 66666.");
	            return;
	        }
	    }

	    try {
	        super.setUpSocket(port);

	        App.showView("Tamagotchi");
	        
	    } catch (IOException e) {
	    	e.printStackTrace();
	        showError("Failed to connect to the server. Please try again.");
	    }
	}



	/**
	 * Méthode utilitaire pour afficher une alerte d'erreur.
	 *
	 * @param title   Le titre de l'alerte.
	 * @param message Le message à afficher.
	 */
	private void showError(String message) {
		mainView.getErrorLabel().setText(message);
		mainView.getErrorLabel().setVisible(true);
	}
}
