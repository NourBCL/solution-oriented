/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Restaurant;
import Services.RestaurantService;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author louay
 */
public class StatistiquesController implements Initializable {

    @FXML
    private BarChart barChart;
    @FXML
    private PieChart pieChart;

    RestaurantService res = new RestaurantService();
    @FXML
    private NumberAxis yBarChart;
    @FXML
    private CategoryAxis xBarChart;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        //pie chart
        List<Restaurant> list = res.getNumberOfRestaurantsByCat();
        list.stream().map((rest) -> {
            int number = rest.getCount();
            String name = rest.getNom() + " (" + number + ") ";
            PieChart.Data slice = new PieChart.Data(name, number);
            return slice;
        }).forEachOrdered((slice) -> {
            pieChart.getData().add(slice);
        });

        //bar chart
        HashMap<String, Integer> ratingStat = res.getRatingStats();
        int less = ratingStat.get(">3");
        int equals = ratingStat.get("=3");
        int more = ratingStat.get("<3");

        xBarChart.setLabel("Ratings");
        yBarChart.setLabel("Nombre des restaurents");

        XYChart.Series dataSeries1 = new XYChart.Series();

        dataSeries1.getData().add(new XYChart.Data(">3", less));
        dataSeries1.getData().add(new XYChart.Data("=3", equals));
        dataSeries1.getData().add(new XYChart.Data("<3", more));
        barChart.getData().add(dataSeries1);
        Node n = barChart.lookup(".data0.chart-bar");
        n.setStyle("-fx-bar-fill: #4421af");
        n = barChart.lookup(".data1.chart-bar");
        n.setStyle("-fx-bar-fill: #1a53ff");
        n = barChart.lookup(".data2.chart-bar");
        n.setStyle("-fx-bar-fill: #0d88e6");
    }

    private static void loadPage(String page) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(BackRestaurantController.class.getResource(page + ".fxml"));

        HomePageController.hpc.getBp().setCenter(root);
    }

    public static void reload() {
        try {
            loadPage("Statistiques");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
