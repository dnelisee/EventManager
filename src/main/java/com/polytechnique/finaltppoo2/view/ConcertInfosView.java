package com.polytechnique.finaltppoo2.view;

import com.polytechnique.finaltppoo2.model.Concert;
import com.polytechnique.finaltppoo2.model.Event;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ConcertInfosView extends EventInfosView {

    private TextField artistField; 
    private TextField musicalGenreField;

    public ConcertInfosView(Concert concert) {
        super(concert);
    }

    @Override
    protected int addOtherFields(Event event, int startRow) {
        // artist
        Label themeLabel = new Label("Artist");
        this.add(themeLabel, 0, startRow);

        artistField = new TextField(((Concert)event).getArtist());
        artistField.setEditable(false);
        artistField.setPrefWidth(TEXT_FIELD_HEIGHT);
        this.add(artistField, 1, startRow);

        // musical genre 
        Label musiclalGenreLabel = new Label("Musical genre");
        this.add(musiclalGenreLabel, 0, startRow + 1);

        musicalGenreField = new TextField(((Concert)event).getMusicalGenre());
        musicalGenreField.setEditable(false);
        musicalGenreField.setPrefWidth(TEXT_FIELD_HEIGHT);
        this.add(musicalGenreField, 1, startRow + 1);

        return startRow + 2;
    }

    public TextField getArtistField() {
        return artistField;
    }

    public TextField getMusicalGenreField() {
        return musicalGenreField;
    }
}
