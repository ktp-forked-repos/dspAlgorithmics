package gui;

import algorithms.metaProcessors.FileManager;
import app.Main;
import data.FileCache;
import data.WaveFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.*;

import java.io.File;

import static algorithms.metaProcessors.FileManager.saveFile;

public class MainMenuController {

	@FXML
		public static MainMenuController
		mainMenuController;

	static Stage
		stage;

	public static void setStage(Stage s){
		stage = s;
	}
/*
	Menu
		menuFile = MENU_FILE.getMenu(OPEN_FILE, CLOSE_FILE, SEPARATOR, SAVE, SEPARATOR, QUIT),
		menuEdit = MENU_EDIT.getMenu(),
		menuAnalyze = MENU_ANALYZE.getMenu(),
		menuView = MENU_VIEW.getMenu(FILE_WAVEFORM, FILE_AMPLITUDE_DISTRIBUTION, SEPARATOR,  FILE_PROPERTIES),
		menuHelp = MENU_HELP.getMenu(AUTO_SAVE);*/

//	--------------------------------------------------------------------------------------------------------------------

/*
	public MainMenuController(Stage stage){


//		setHeight(25);
//		this.getMenus().addAll(menuFile, menuEdit, menuAnalyze, menuView, menuHelp);
//		setActionsToMenuFile();
	}
*/

//	---------------------------------------------------------------------------------------------------

	public void openFile(ActionEvent event){
		FileChooser
			browser = new FileChooser();

		browser.setTitle("Open File");

		browser.setInitialDirectory(new File(System.getProperty("user.home")));
		File file = browser.showOpenDialog(stage);
		WaveFile waveFile = new WaveFile(file);
	}

	public void autoSave(ActionEvent event){

		if (FileManager.FileManagerSettings.getAutoSave()) {

			WaveFile
				file = FileCache.loadCurrent();

			file.getFileAddress().setNameToDefault();

			FileManager.saveFile(file);
		}

		FileCache.purgeCache();
	}

	public void save(ActionEvent event){

		FileChooser
			browser = new FileChooser();

		browser.setTitle("Save As");

		File
			file = browser.showSaveDialog(stage);

		saveFile(file);
	}

	public void quit(ActionEvent event){

		stage.close();
	}

	public void setAutoSaveStatus(ActionEvent event ){

		FileManager.FileManagerSettings.setAutoSave(/*((CheckMenuItem)helpItems.get(0)).isSelected()*/ false);

		System.out.println("autosave enable : " + FileManager.FileManagerSettings.getAutoSave());
	}

	private void setActionsToMenuFile(){

//		List<MenuItem> fileItems = menuFile.getItems();

/*
		fileItems.get(0).setOnAction((ActionEvent e) -> {

			FileChooser
				browser = new FileChooser();

			browser.setTitle("Open File");

			browser.setInitialDirectory(new File(System.getProperty("user.home")));
			File file = browser.showOpenDialog(stage);
			WaveFile waveFile = new WaveFile(file);
		});
*/	// ? open file disposable ?

/*
		fileItems.get(1).setOnAction((ActionEvent e) ->{

			if (FileManager.FileManagerSettings.getAutoSave()) {

				WaveFile
					file = FileCache.loadCurrent();

				file.getFileAddress().setNameToDefault();

				FileManager.saveFile(file);
			}

			FileCache.purgeCache();
		});
*/	// ? autosave disposable ?

/*
		fileItems.get(3).setOnAction((ActionEvent e) -> {

			FileChooser
				browser = new FileChooser();

			browser.setTitle("Save As");

			File
				file = browser.showSaveDialog(stage);

			saveFile(file);
		});
*/	// ? save disposable?

/*
		fileItems.get(5).setOnAction(close -> stage.close());
*/	// ? quit disposable ?

//		List<MenuItem> helpItems = menuHelp.getItems();

/*

		helpItems.get(0).setOnAction((ActionEvent e) -> {

			FileManager.FileManagerSettings.setAutoSave(((CheckMenuItem)helpItems.get(0)).isSelected());

			System.out.println("autosave enable : " + FileManager.FileManagerSettings.getAutoSave());
		});
*/	// ? autosave setting disposable ?

	}
}