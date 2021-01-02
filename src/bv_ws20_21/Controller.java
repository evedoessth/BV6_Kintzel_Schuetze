package bv_ws20_21;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;

import java.io.File;

public class Controller {
    private static final String initialFileName = "test1.png";
    private static File fileOpenPath = new File(".");

    public enum PredictorType {
        A("A (horizontal)"),
        B("B (vertikal)"),
        C("C (diagonal)"),
        D("A + B − C"),
        AD("adaptiv");

        private final String name;
        PredictorType(String s) { name = s; }
        public String toString() { return this.name; }
    }

    @FXML
    private ComboBox<PredictorType> predictorSelection;

    @FXML
    private ImageView originalImageView;

    @FXML
    private Label messageLabel;

    @FXML
    void openImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(fileOpenPath);
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Images (*.jpg, *.png, *.gif)", "*.jpeg", "*.jpg", "*.png", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if(selectedFile != null) {
            fileOpenPath = selectedFile.getParentFile();
            RasterImage img = new RasterImage(selectedFile);
            img.convertToGray();
            img.setToView(originalImageView);
            processImages();
            messageLabel.getScene().getWindow().sizeToScene();;
        }
    }

    @FXML
    void quantizationChanged() {
        processImages();
    }

    @FXML
    void predictorChanged() {
        processImages();
    }

    @FXML
    public void initialize() {
        // set combo boxes items
        predictorSelection.getItems().addAll(PredictorType.values());
        predictorSelection.setValue(PredictorType.A);

        // initialize parameters

        /* load and process default image
        RasterImage img = new RasterImage(new File(initialFileName));
        img.convertToGray();
        img.setToView(originalImageView);
        processImages();*/
    }

    private void processImages() {

        switch(predictorSelection.getValue()) {
            case A:
                //filter = new MinFilter();
                break;
            case B:
                //filter = new MinFilter();
                break;
            case C:
                //filter = new MinFilter();
                break;
            case D:
                //filter = new MinFilter();
                break;
            case AD:
                //filter = new MinFilter();
                break;
        }
    }
}
