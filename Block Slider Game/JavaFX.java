
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.util.*;

public class JavaFX extends Application {
	public static String fileName = "CSE1242_spring2022_project_level";
	public static int levelNumber = 7;
	public static String str = "";
	private Cell[][] cell = new Cell[4][4];
	int clickSum = 0;
	Cell cell1;
	Cell cell2;
	private int X1;
	private int Y1;
	private int X2;
	private int Y2;
	private double X;
	private double Y;
	static ArrayList<Block> listOfBlocks = new ArrayList<Block>();
	static ArrayList<String> listOfWords = new ArrayList<String>();
	static ArrayList<String> listOfNames = new ArrayList<String>();
	static ArrayList<Integer> listOfIds = new ArrayList<Integer>();
	static ArrayList<String> listOfAspectInfos = new ArrayList<String>();

	public boolean changer() {
		boolean a1 = (X2 < X1 + 1);
		boolean a2 = (X1 - 1 < X2);
		boolean b1 = (Y2 < Y1 + 1);
		boolean b2 = (Y1 - 1 < Y2);
		if ((cell2 != null) && (!((cell1).isIsstatic())) && (cell2.getName().equals("Empty"))
				&& (cell2.getAspectInfo().equals("Free"))
				&& (((!(a1 && a2)) && (b1 && b2)) || (((a1 && a2)) && !(b1 && b2))) 
				&& (Math.abs(X1 - X2) <= 1) && (Math.abs(Y1 - Y2) <= 1)
				&& (X1 != X2) && (Y1 != Y2) ) {
			cell[X1][Y1] = cell2;
			cell[X2][Y2] = cell1;
			cell1 = null;
			cell2 = null;
			System.out.println(cell[X1][Y1]);
			System.out.println(cell[X2][Y2]);
			return true;
		} else if ((cell1 != null) && (cell2 != null)) {
			cell1 = null;
			cell2 = null;
		}
		return false;
	}

	public static class Cell extends Pane {
		private boolean isstatic;
		private String name;
		private String aspectInfo;

		public Cell() {

		}

		public Cell(Image img, boolean isstatic, String name, String aspectInfo) {
			setName(name);
			setAspectInfo(aspectInfo);
			setIsstatic(isstatic);
			setStyle("-fx-border-color: black; -fx-border-width: 4");
			this.setPrefSize(800, 800);
			BackgroundImage bImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
					BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
			Background bGround = new Background(bImg);
			setBackground(bGround);
		}

		public boolean isIsstatic() {
			return isstatic;
		}

		public void setIsstatic(boolean isstatic) {
			this.isstatic = isstatic;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAspectInfo() {
			return aspectInfo;
		}

		public void setAspectInfo(String aspectInfo) {
			this.aspectInfo = aspectInfo;
		}
	}

	@Override
	public void start(Stage primaryStage) {
		GridPane pane = new GridPane();

		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				System.out.println(e.getPickResult());
				System.out.println(e.getPickResult().getIntersectedNode());

				clickSum += e.getClickCount();
				System.out.println(clickSum);
				if (clickSum % 2 == 1) {
					cell1 = (Cell) (e.getPickResult().getIntersectedNode());
					setX(e.getSceneX());
					setY(e.getSceneY());
					for (int x = 0; x < 4; x++) {
						for (int y = 0; y < 4; y++) {
							if ((e.getSceneY() < 100 * (x + 1)) && (e.getSceneY() > 100 * x)
									&& (e.getSceneX() < 100 * (y + 1)) && (e.getSceneX() > 100 * y)) {
								setX1(x);
								setY1(y);
							}
						}
					}
				} else if (clickSum % 2 == 0) {
					cell2 = (Cell) (e.getPickResult().getIntersectedNode());
					for (int x = 0; x < 4; x++) {
						for (int y = 0; y < 4; y++) {
							if ((e.getSceneY() < 100 * (x + 1)) && (e.getSceneY() > 100 * x)
									&& (e.getSceneX() < 100 * (y + 1)) && (e.getSceneX() > 100 * y)) {
								setX2(x);
								setY2(y);
							}
						}
					}
				}
				if (changer()) {
					pane.getChildren().remove(cell[X1][Y1]);
					pane.getChildren().remove(cell[X2][Y2]);
					pane.add(cell[X1][Y1], Y1, X1);
					pane.add(cell[X2][Y2], Y2, X2);

				}

			}
		};

		int i = 0;
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				pane.add(cell[x][y] = new Cell(listOfBlocks.get(i).getImg(), listOfBlocks.get(i).isIsstatic(),
						listOfBlocks.get(i).getName(), listOfBlocks.get(i).getAspectInfo()), y, x);
				cell[x][y].addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
				i++;
			}
		}

		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		Scene scene = new Scene(borderPane, 400, 400);
		primaryStage.setTitle("JavaFX");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		try {
			File txt = new File("levels\\" + fileName + levelNumber + ".txt");
			Scanner input = new Scanner(txt);
			while (input.hasNext()) {
				str += input.next();
				str += " ";
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		str = str.replace(",", " ");
		str = str.replace("  ", " ");
		Scanner input = new Scanner(str);
		while (input.hasNext()) {
			listOfWords.add(input.next());
		}
		input.close();
		for (int i = 0; i < 48; i++) {
			if (i % 3 == 0) {
				listOfIds.add(Integer.parseInt(listOfWords.get(i)));
			} else if (i % 3 == 1) {
				listOfNames.add(listOfWords.get(i));
			} else {
				listOfAspectInfos.add(listOfWords.get(i));
			}
		}
		for (int i = 0; i < 16; i++) {
			if ((listOfNames.get(i).equals("Starter")) || listOfNames.get(i).equals("Pipe")
					|| (listOfNames.get(i).equals("PipeStatic")) || (listOfNames.get(i).equals("End"))) {
				Pipe pipe = new Pipe(listOfIds.get(i), listOfNames.get(i), listOfAspectInfos.get(i));
				listOfBlocks.add(pipe);
			} else if (listOfNames.get(i).equals("Empty")) {
				Empty empty = new Empty(listOfIds.get(i), listOfNames.get(i), listOfAspectInfos.get(i));
				listOfBlocks.add(empty);
			}
		}
		launch(args);
	}

	public int getX1() {
		return X1;
	}

	public void setX1(int x) {
		X1 = x;
	}

	public int getY1() {
		return Y1;
	}

	public void setY1(int y) {
		Y1 = y;
	}

	public int getX2() {
		return X2;
	}

	public void setX2(int x2) {
		X2 = x2;
	}

	public int getY2() {
		return Y2;
	}

	public void setY2(int y2) {
		Y2 = y2;
	}

	public double getX() {
		return X;
	}

	public void setX(double x) {
		X = x;
	}

	public double getY() {
		return Y;
	}

	public void setY(double d) {
		Y = d;
	}

}
