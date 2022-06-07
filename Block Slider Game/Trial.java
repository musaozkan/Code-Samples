import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Cell;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Ellipse;

public class Trial extends Application {
	private Cell[][] cell = new Cell[4][4];
	int clickSum = 0;
	Cell cell1;
	Cell cell2;

	public void changer() {
		if ((cell2 != null) && (!((cell1).isIsstatic())) && (cell2)) {
			Cell cellTemp = cell1;
			cell1 = cell2;
			cell2 = cellTemp;
		}
	}

	public void start(Stage primaryStage) {
		GridPane pane = new GridPane();

		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				System.out.println(e.getPickResult());
				System.out.println(e.getPickResult().getIntersectedNode());
				clickSum += e.getClickCount();
				if (clickSum % 2 == 1) {
					cell1 = (Cell) (e.getPickResult().getIntersectedNode());
				} else if (clickSum % 2 == 0) {
					cell2 = (Cell) (e.getPickResult().getIntersectedNode());
				}

				/*
				 * for (int x = 0; x < 4; x++) { for (int y = 0; y < 4; y++) { if
				 * ((e.getSceneY() < 100 * (x + 1)) && (e.getSceneY() > 100 * x) &&
				 * (e.getSceneX() < 100 * (y + 1)) && (e.getSceneX() > 100 * y)) { Image img =
				 * new Image("flagofTurkey.png"); BackgroundImage bImg = new
				 * BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				 * BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT); Background bGround = new
				 * Background(bImg); cell[x][y].setBackground(bGround); } } }
				 * 
				 */
			}
		};

		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				pane.add(cell[x][y] = new Cell(Math.round(Math.random()) == 1), y, x);
				cell[x][y].addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
			}
		}

		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		Scene scene = new Scene(borderPane, 400, 400);
		primaryStage.setTitle("Trial");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	public static class Cell extends Pane {
		private boolean isstatic;

		public Cell(boolean isstatic) {
			setIsstatic(isstatic);
			setStyle("-fx-border-color: black; -fx-border-width: 2");
			this.setPrefSize(800, 800);
		}

		public static void main(String[] args) {
			launch(args);
		}

		public boolean isIsstatic() {
			return isstatic;
		}

		public void setIsstatic(boolean isstatic) {
			this.isstatic = isstatic;
		}
	}
}