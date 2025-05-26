package com.polytechnique.finaltppoo2.view;

import com.polytechnique.finaltppoo2.model.Concert;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ConcertInfosView extends EventInfosView {

    private TextField artistField;
    private TextField musicalGenreField;

    public ConcertInfosView(Concert concert) {
        super(concert);
    }

    @Override
    protected int addOtherFields() {
        startRow = super.addOtherFields();

        startRow = addArtistField();
        startRow = addMusicalGenreField();

        return startRow;
    }

    private int addArtistField() {
        Label themeLabel = new Label("Artist");
        this.add(themeLabel, 0, startRow);

        artistField = new TextField(((Concert) obj).getArtist());
        artistField.setEditable(false);
        artistField.setPrefWidth(TEXT_FIELD_HEIGHT);
        this.add(artistField, 1, startRow);

        return startRow + 1;
    }

    private int addMusicalGenreField() {
        Label musiclalGenreLabel = new Label("Musical genre");
        this.add(musiclalGenreLabel, 0, startRow);

        musicalGenreField = new TextField(((Concert) obj).getMusicalGenre());
        musicalGenreField.setEditable(false);
        musicalGenreField.setPrefWidth(TEXT_FIELD_HEIGHT);
        this.add(musicalGenreField, 1, startRow);

        return startRow + 1;
    }

    public TextField getArtistField() {
        return artistField;
    }

    public TextField getMusicalGenreField() {
        return musicalGenreField;
    }
}
