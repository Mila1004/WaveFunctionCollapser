package de.ibci.rottmann.WFC.View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class MenuBarView {
    private final VBox menuBarVbox = new VBox();
    private final Menu menuBarFile = new Menu("File");
    private final Menu menuBarEdit = new Menu("Edit");
    private final Menu menuBarView = new Menu("View");
    private final Menu menuBarHelp = new Menu("Help");
    private String gridSizeString = null;
    public MenuBarView() {
        MenuBar tmpMenuBar = new MenuBar();
        List<MenuItem> tmpMenuItemList = this.menuBarFileItems();
        for (MenuItem tmpMenuItem :
                tmpMenuItemList) {
            this.menuBarFile.getItems().add(tmpMenuItem);
            this.menuBarFile.getItems().add(new SeparatorMenuItem());
        }
        tmpMenuItemList = this.menuBarEditItems();
        for (MenuItem tmpMenuItem :
                tmpMenuItemList) {
            this.menuBarEdit.getItems().add(tmpMenuItem);
            this.menuBarEdit.getItems().add(new SeparatorMenuItem());
        }
        tmpMenuItemList = this.menuBarViewItems();
        for (MenuItem tmpMenuItem :
                tmpMenuItemList) {
            this.menuBarView.getItems().add(tmpMenuItem);
            this.menuBarView.getItems().add(new SeparatorMenuItem());
        }
        tmpMenuItemList = this.menuBarHelpItems();
        for (MenuItem tmpMenuItem :
                tmpMenuItemList) {
            this.menuBarHelp.getItems().add(tmpMenuItem);
            this.menuBarHelp.getItems().add(new SeparatorMenuItem());
        }
        tmpMenuBar.getMenus().addAll(this.menuBarFile, this.menuBarEdit,
                this.menuBarView, this.menuBarHelp);
        menuBarVbox.getChildren().addAll(tmpMenuBar);
    }
    public VBox getMenuBarVBox() {
        return this.menuBarVbox;
    }
    private List<MenuItem> menuBarFileItems() {
        MenuItem tmpNewFileItem = new MenuItem("New File");
        MenuItem tmpOpenFileItem = new MenuItem("Open File");
        MenuItem tmpSaveFileItem = new MenuItem("Save File");
        List<MenuItem> tmpMenuItemList = new ArrayList<>();
        tmpMenuItemList.add(tmpNewFileItem);
        tmpMenuItemList.add(tmpOpenFileItem);
        tmpMenuItemList.add(tmpSaveFileItem);
        return tmpMenuItemList;
    }
    private List<MenuItem> menuBarEditItems() {
        //MenuItem tmpEditItem = new MenuItem("Edit");
        Menu tmpEditMenu = new Menu("Edit");
        Menu tmpGridSize = new Menu("Grid Size");
        CustomMenuItem tmpGridSizeItem = new CustomMenuItem();
        TextField tmpGridSizeTextFieldHorizontal = new TextField("*grid size as NxM*");
        EventHandler<ActionEvent> tmpHorizontalTextFieldHandler = new EventHandler<ActionEvent>(
        ) {
            /**
             * Invoked when a specific event of the type for which this handler is
             * registered happens.
             *
             * @param event the event which occurred
             */
            @Override
            public void handle(ActionEvent event) {
                getGridSizeStringFromField(tmpGridSizeTextFieldHorizontal.getText());
            }
        };
        tmpGridSizeTextFieldHorizontal.setOnAction(tmpHorizontalTextFieldHandler);
        tmpGridSizeItem.setContent(tmpGridSizeTextFieldHorizontal);
        TextField tmpGridSizeTextFieldVertical = new TextField("*grid size as NxM*");
        EventHandler<ActionEvent> tmpVerticalTextFieldHandler = new EventHandler<ActionEvent>(
        ) {
            /**
             * Invoked when a specific event of the type for which this handler is
             * registered happens.
             *
             * @param event the event which occurred
             */
            @Override
            public void handle(ActionEvent event) {
                getGridSizeStringFromField(tmpGridSizeTextFieldHorizontal.getText());
            }
        };
        tmpGridSizeTextFieldHorizontal.setOnAction(tmpVerticalTextFieldHandler);
        tmpGridSizeItem.setContent(tmpGridSizeTextFieldHorizontal);
        tmpGridSize.getItems().add(tmpGridSizeItem);

        tmpEditMenu.getItems().add(tmpGridSize);
        MenuItem tmpSettingsItem = new MenuItem("Settings");
        List<MenuItem> tmpMenuItemList = new ArrayList<>();
        tmpMenuItemList.add(tmpEditMenu);
        tmpMenuItemList.add(tmpSettingsItem);
        return tmpMenuItemList;
    }
    private List<MenuItem> menuBarViewItems() {
        List<MenuItem> tmpMenuItemList = new ArrayList<>();
        return tmpMenuItemList;
    }
    private List<MenuItem> menuBarHelpItems() {
        MenuItem tmpAboutItem = new MenuItem("About");
        MenuItem tmpTutorialItem = new MenuItem("Tutorial");
        List<MenuItem> tmpMenuItemList = new ArrayList<>();
        tmpMenuItemList.add(tmpAboutItem);
        tmpMenuItemList.add(tmpTutorialItem);
        return tmpMenuItemList;
    }
    public String getGridSizeStringFromField(String aString) {
        return this.gridSizeString = aString;
    }
    public String getGridSizeStringFromView() {
        return this.gridSizeString;
    }
}
