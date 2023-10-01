package de.ibci.rottmann.WFC.View;

import javafx.scene.control.Button;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.awt.geom.Dimension2D;
import java.util.ArrayList;
import java.util.List;

public class MenuBarView {
    private final VBox menuBarVbox = new VBox();
    private final Menu menuBarFile = new Menu("File");
    private final Menu menuBarEdit = new Menu("Edit");
    private final Menu menuBarView = new Menu("View");
    private final Menu menuBarHelp = new Menu("Help");
    private Dimension2D gridDimension;
    private TextField gridSizeTextField = new TextField("Enter Grid Size");
    private SingletonAllView singletonAllViewInstance;

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
        CustomMenuItem tmpGridSizeItem = getGridSizeItem();
        tmpGridSize.getItems().add(tmpGridSizeItem);
        tmpEditMenu.getItems().add(tmpGridSize);
        MenuItem tmpSettingsItem = new MenuItem("Settings");
        List<MenuItem> tmpMenuItemList = new ArrayList<>();
        tmpMenuItemList.add(tmpEditMenu);
        tmpMenuItemList.add(tmpSettingsItem);
        return tmpMenuItemList;
    }

    private CustomMenuItem getGridSizeItem() {
        CustomMenuItem tmpGridSizeItem = new CustomMenuItem();
        Button tmpResizeButton = new Button("Resize Grid");
        tmpResizeButton.setOnAction(value -> {
            this.handleGridSizing();
        });
        VBox tmpGridSizeVBox = new VBox(this.gridSizeTextField, tmpResizeButton);
        tmpGridSizeItem.setContent(tmpGridSizeVBox);
        return tmpGridSizeItem;
    }

    private void handleGridSizing() {
        String tmpString = this.gridSizeTextField.getText();
        this.gridDimension = this.parseGridSize(tmpString);
        singletonAllViewInstance = SingletonAllView.getInstance();
        singletonAllViewInstance.setUpdatedGridSize(this.gridDimension);
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

    private Dimension2D parseGridSize(String aString) {
        int tmpIntCharPosition = 0;
        if (aString.contains(",")) {
            tmpIntCharPosition = aString.indexOf(",");
            System.out.println(",: " + tmpIntCharPosition);
        } else {
            System.out.println("contains no \",\" ");
        }

        int tmpIntGridWidth = Integer.parseInt(aString, 0, tmpIntCharPosition, 36);
        int tmpGridHeight = Integer.parseInt(aString, tmpIntCharPosition + 1, aString.length(), 36);
        Dimension2D tmpDimension = new Dimension2D() {
            @Override
            public double getWidth() {
                return 0;
            }

            @Override
            public double getHeight() {
                return 0;
            }

            @Override
            public void setSize(double width, double height) {

            }
        };
        tmpDimension.setSize(tmpIntGridWidth, tmpGridHeight);
        return tmpDimension;
    }

    public Dimension2D getGridSizeStringFromView() {
        return this.gridDimension;
    }

}
