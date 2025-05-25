package com.polytechnique.finaltppoo2.util;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public interface UsefulGraphicInterface {
    public default ImageView loadResourceAsImage(String imagePath) {
		return new ImageView(new Image(getClass().getResourceAsStream(imagePath)));
	}

	public default ImageView loadImage(String imageName) {
		return loadResourceAsImage("/com/polytechnique/finaltppoo2/images/" + imageName);
	}

	public default ImageView loadIcon(String iconName) {
		return loadResourceAsImage("/com/polytechnique/finaltppoo2/icons/" + iconName);
	}

    public default Button createIconButton(String iconName, double size) {
		Button button = new Button();
		ImageView icon = loadIcon(iconName);
		icon.setFitWidth(size);
		icon.setFitHeight(size);
		button.setGraphic(icon);
		button.setStyle("-fx-background-color: transparent;");

		button.setOnMouseEntered(_ -> button.setCursor(Cursor.HAND));
		button.setOnMouseExited(_ -> button.setCursor(Cursor.DEFAULT));
		
		return button;
	}
}
