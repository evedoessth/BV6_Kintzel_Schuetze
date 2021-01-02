package bv_ws20_21;

import bv_ws20_21.Predication.PredictorType;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;

public class Controller {
    private static final String initialFileName = "test1.png";
    private static File fileOpenPath = new File(".");


    private final Predication predication = new Predication();
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

        // load and process default image
        RasterImage img = new RasterImage(new File(initialFileName));
        img.convertToGray();
        img.setToView(originalImageView);
        processImages();
    }

    private void processImages() {
        if(originalImageView.getImage() == null)
            return; // no image: nothing to do

        long startTime = System.currentTimeMillis();

        RasterImage origImg = new RasterImage(originalImageView);
        RasterImage binaryImg = new RasterImage(origImg.width, origImg.height);
        RasterImage filteredImg = new RasterImage(origImg.width, origImg.height);


        predication.copy(origImg, binaryImg);
        binaryImg.convertToGray();

        switch(predictorSelection.getValue()) {
            case A:
                predication.horizontal(origImg,binaryImg);
                break;
            case B:
                predication.vertical(origImg,binaryImg);
                break;
            case C:
                predication.diagonal(origImg,binaryImg);
                break;
            case D:
                predication.additive(origImg,binaryImg);
                break;
            case AD:
                predication.adaptive(origImg,binaryImg);
                break;
            default:
                break;
        }

        binaryImg.setToView(originalImageView);

        messageLabel.setText("Processing time: " + (System.currentTimeMillis() - startTime) + " ms");
        switch(predictorSelection.getValue()) {

        }
    }
}
