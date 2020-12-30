package bv_ws20_21;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;

import java.io.File;

public class Controller {
    private static final String initialFileName = "test1.png";
    private static File fileOpenPath = new File(".");

    @FXML
    void openImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(fileOpenPath);
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Images (*.jpg, *.png, *.gif)", "*.jpeg", "*.jpg", "*.png", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(null);
        /*if(selectedFile != null) {
            fileOpenPath = selectedFile.getParentFile();
            originalImage = new RasterImage(selectedFile);
            initImage();
            resetToneCurve();
            messageLabel.getScene().getWindow().sizeToScene();;
        }*/
    }

    public void quantizationChanged(KeyEvent keyEvent) {
    }
}
