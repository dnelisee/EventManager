package com.polytechnique.finaltppoo2.controller;

import com.polytechnique.finaltppoo2.view.CoreView;
import com.polytechnique.finaltppoo2.view.GraphicPersisObject;

import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Duration;

public abstract class CoreViewController {
    private static final int RESEARCH_REFRESH_DELAY = 300; // milliseconds
    protected static final int HEADER_IMG_SIZE = 100;

    protected CoreView view;

    protected CoreViewController(CoreView coreView) {
        this.view = coreView;

        handleListView();

        handleSearchBar();

        setThreePtsCtxMenu();

        handleEventsMenu(); 
        handleOrganizersMenu(); 
        handleParticipantsMenu(); 
    }

    protected abstract void loadElementsList();
    protected abstract void handleListView(); 

    protected void handleSearchBar() {
        /* get the current list */
        ObservableList<GraphicPersisObject> currentList = this.view.getElementsListView().getItems();

        /* define a delay before each research */
        PauseTransition pause = new PauseTransition(Duration.millis(RESEARCH_REFRESH_DELAY));

        /* a listener to searchBar content changes */
        this.view.getSearchBar().textProperty().addListener((_, _, newValue) -> {
            /* stop the current pause */
            pause.stop();

            /* the efficient value to search */
            String filter = newValue.toLowerCase().trim();

            if (filter.isBlank()) {
                /* no word to search */
                this.view.getElementsListView().setItems(currentList);
            } else {
                /* the future result list */
                ObservableList<GraphicPersisObject> newList = FXCollections.observableArrayList();

                /* get good elements */
                for (GraphicPersisObject obj : currentList) {
                    if (obj.getPersisObj().getName().toLowerCase().contains(filter)) {
                        newList.add(obj);
                    }
                }

                if (newList.isEmpty()) {
                    /* set a no result message */
                    this.view.getElementsListView().getItems().clear();
                    this.view.getElementsListView().getItems()
                            .add(new GraphicPersisObject(null, "Result", "no result"));
                } else {
                    /* display the result */
                    this.view.getElementsListView().setItems(newList);
                }
            }

        });
    }

    protected void setThreePtsCtxMenu() {
        this.view.getThreePoints().setOnAction(_ -> 
            this.view.getThreePtsCtxMenu().show(
                    this.view.getThreePoints(),
                    this.view.getThreePoints().localToScreen(this.view.getThreePoints().getBoundsInLocal()).getMinX(),
                    this.view.getThreePoints().localToScreen(this.view.getThreePoints().getBoundsInLocal()).getMaxY())
        );
    }

    private void handleEventsMenu() {
        this.view.getEventsMenu().setOnAction(_-> this.view.getApp().gotoEventsView());
    }

    private void handleOrganizersMenu() {
        this.view.getOrganizersMenu().setOnAction(_-> this.view.getApp().gotoOrganizersView());
    }

    private void handleParticipantsMenu() {
        this.view.getParticipantsMenu().setOnAction(_-> this.view.getApp().gotoParticipantsView());
    }
}
