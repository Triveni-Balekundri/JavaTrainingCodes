package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class MainSample extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root =FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
