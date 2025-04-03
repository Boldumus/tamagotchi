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
		int port = -1;
		// TODO Tâche 5 : Implémenter le changement de la vue lors d'une connexion et gèrer la validation du numéro de port 
		// Votre code doit utiliser la ligne ci-dessous:
		//						super.setUpSocket(port);
		//						App.showView("Tamagotchi");


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
