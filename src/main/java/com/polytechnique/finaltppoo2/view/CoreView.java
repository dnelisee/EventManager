package com.polytechnique.finaltppoo2.view;

import com.polytechnique.finaltppoo2.util.UsefulGraphicInterface;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public abstract class CoreView extends HBox implements UsefulGraphicInterface {
    protected static final int LEFT_SIDE_SPACING = 5;
    protected static final int LEFT_SIDE_WIDTH = 300;
    protected static final int RIGHT_SIDE_WIDTH = 300;
    protected static final int DEFAULT_SIDES_SPACING = 40;
    protected static final int TEXTFIELD_HEIGHT = 25;

    protected String elementName;

    protected VBox leftSide;
    protected VBox rightSide;
    protected Button threePoints;
    protected TextField searchBar;
    protected ListView<GraphicPersisObject> elementsListView;

    protected CoreView(int sidesSpacing, String elementName) {
        super(sidesSpacing);
        this.elementName = elementName;
        createLeftSide();
        createRightSide();

        this.getChildren().addAll(leftSide, rightSide);
    }

    protected CoreView(String elementName) {
        this(DEFAULT_SIDES_SPACING, elementName);
    }

    /**
     * create the left side of the home view
     */
    protected void createLeftSide() {
        leftSide = new VBox();

        leftSide.setPrefWidth(LEFT_SIDE_WIDTH);
        leftSide.setSpacing(LEFT_SIDE_SPACING);
        leftSide.setPadding(new Insets(5, 2, 0, 2));

        /* create the line of the app name and three points */
        createAppNameAndThreePoints();

        /* create the search bar */
        createSearchBar();

        /* create the list of graphic element view */
        elementsListView = new ListView<>();
        leftSide.getChildren().add(elementsListView);

    }

    protected void createAppNameAndThreePoints() {
        HBox line = new HBox();

        /* create the app name label and set a good style */
        Label appName = new Label("Events Manager");

        // set the style here ...
        appName.getStyleClass().add("title");

        /* create the three points */
        threePoints = createIconButton("menu-burger.png", 20);

        /* region to force appName and threePoints to be at the ens of line */
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        line.getChildren().addAll(appName, spacer, threePoints);

        /* setting padding */
        line.setPadding(new Insets(1));

        leftSide.getChildren().add(line);

    }

    protected void createSearchBar() {
        HBox searchBarBox = new HBox();
        searchBarBox.getStyleClass().add("search_bar");
        searchBarBox.setPrefWidth(TEXTFIELD_HEIGHT);
        searchBarBox.setSpacing(2);

        /* search icon */
        ImageView searchIcon = loadIcon("search.png");
        searchIcon.setFitWidth(TEXTFIELD_HEIGHT);
        searchIcon.setFitHeight(TEXTFIELD_HEIGHT);

        /* search bar text field */
        searchBar = new TextField();
        searchBar.setPrefWidth(RIGHT_SIDE_WIDTH - TEXTFIELD_HEIGHT);
        searchBar.setPromptText("Research " + elementName + "...");
        searchBar.getStyleClass().add("search_text_field");

        searchBarBox.getChildren().addAll(searchIcon, searchBar);

        leftSide.getChildren().add(searchBarBox);
    }

    /**
     * create the right side of the home view
     */
    protected void createRightSide() {
        rightSide = new VBox();
        rightSide.setPrefWidth(RIGHT_SIDE_WIDTH);
        Text message = new Text(
                String.format("Click on one %s to display its informations", elementName));

        rightSide.setAlignment(Pos.CENTER);

        rightSide.getChildren().add(message);
    }

    /* getters */
    public Button getThreePoints() {
        return threePoints;
    }

    public TextField getSearchBar() {
        return searchBar;
    }

    public ListView<GraphicPersisObject> getElementsListView() {
        return elementsListView;
    }

    public VBox getRightSide() {
        return rightSide;
    }

}
