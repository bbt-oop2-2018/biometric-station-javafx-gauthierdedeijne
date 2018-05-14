package projectwerk;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
/**
 *
 * @author Gauthier De Deijne
 */
public class projectwerkFXMLController implements Initializable {
    
    @FXML
    final NumberAxis xAxis = new NumberAxis();
    final NumberAxis yAxis = new NumberAxis();
    private int xValue = 0;
    private Random dataGenerator = new Random();
    
   
    private LineChart BPMChart;
    private XYChart.Series BPMValues;
    private LineChart temperatureChart;
    private XYChart.Series temperatureValues;
    private LineChart accelerometerChart;
    private XYChart.Series accelerometerValues;
    
    @FXML
    private void generateRandomDataHandler(ActionEvent event) {
        int randomBPM = dataGenerator.nextInt();
        BPMValues.getData().add(new XYChart.Data(xValue++, randomBPM));
        int randomTemperature = dataGenerator.nextInt();
        temperatureValues.getData().add(new XYChart.Data(xValue++, randomTemperature));
        int randomAccelerometer = dataGenerator.nextInt();
        accelerometerValues.getData().add(new XYChart.Data(xValue++, randomAccelerometer));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BPMValues = new XYChart.Series();
        BPMValues.setName("Heartpulse (in BPM)");
        BPMChart.getData().add(BPMValues);
        temperatureValues = new XYChart.Series();
        temperatureValues.setName("Temperature (in Celcius)");
        temperatureChart.getData().add(temperatureValues);
        accelerometerValues = new XYChart.Series();
        accelerometerValues.setName("Accelerometer (in x, y, z)");
        accelerometerChart.getData().add(accelerometerValues);        
    }    
    
}
