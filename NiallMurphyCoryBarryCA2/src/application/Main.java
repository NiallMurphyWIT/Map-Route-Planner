package application;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ScrollEvent;
import javafx.stage.Stage;

public class Main extends Application {
	
	static Image image;

	static BufferedImage bufferedImage, markedImage;

	File file;

	WritableImage writeImage;

	static int node1;

	static int node2;

	private static Graph testGraph;
	private static List<Node> mapNodes;

	
	private static String[] locations = { "00: Castle Black", "01: The Dread Fort", "02: Winterfell",
			"03: White harbor", "04: Moat Cailin", "05: The Twins", "06: The Eyrie", "07: Riverrun",
			"10: Casterly Rock", "11: King's Landing", "12: Storm's End", "13: High Garden", "14: Oldtown",
			"15: Sunspear", "16: Tyrosh", "17: Volantis", "18: Lotus Port", "19: Asshai", "20: Vaes Dothrak",
			"21: Pentos", "22: Qohor", "23: Norvos", "24: Braavos", "25: Myr", "26: Lys", "27: Pyke", "28: LannisPort",
			"29: Valyria", "30: Dragonstone", "31: Harrenhal", "32: Stygai", "33: Turrani", "34: Vahar", "35: Zabhad",
			"36: Port Moraq", "37: Selhorys", "38: Vaes Khewo", "39: Kosrak", "40: Gulltown", "41: Kayakayanaya"};

	@SuppressWarnings("rawtypes")
	private JComboBox cb;
	@SuppressWarnings("rawtypes")
	private JComboBox cb1;
	private JComboBox<String> cb2;

	private static ImageView imageView = new ImageView();
	private ScrollPane scrollPane = new ScrollPane();
	final DoubleProperty zoomProperty = new SimpleDoubleProperty(200);

	@Override
	public void start(Stage stage) throws Exception {

		// zoom for map
		zoomProperty.addListener(new InvalidationListener() {
			@Override
			public void invalidated(Observable arg0) {
				imageView.setFitWidth(zoomProperty.get() * 4);
				imageView.setFitHeight(zoomProperty.get() * 3);
			}
		});

		// scroll for map
		scrollPane.addEventFilter(ScrollEvent.ANY, new EventHandler<ScrollEvent>() {
			@Override
			public void handle(ScrollEvent event) {
				if (event.getDeltaY() > 0) {
					zoomProperty.set(zoomProperty.get() * 1.1);
				} else if (event.getDeltaY() < 0) {
					zoomProperty.set(zoomProperty.get() / 1.1);
				}
			}
		});

		imageView.setImage(SwingFXUtils.toFXImage(markedImage, null));
		imageView.preserveRatioProperty().set(true);
		scrollPane.setContent(imageView);

		stage.setScene(new Scene(scrollPane, 1000, 600));
		stage.show();

		// Route Selection Box
		JFrame frame = new JFrame("Select a Route");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setLocation(300, 400);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(Color.WHITE);

		frame.add(panel);

		JLabel lbl = new JLabel("Select two locations and click 'Find Route'");
		JLabel lb2 = new JLabel("Select a waypoint if required ");
		lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		lb2.setAlignmentX(Component.CENTER_ALIGNMENT);

		panel.add(lbl);
		panel.add(lb2);

		cb = new JComboBox<String>(locations);

		cb1 = new JComboBox<String>(locations);

		cb2 = new JComboBox<String>(locations);

		panel.add(Box.createVerticalStrut(10));
		cb.setMaximumSize(cb.getPreferredSize());
		cb.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(cb);
		cb.setBackground(Color.WHITE);

		panel.add(Box.createVerticalStrut(10));
		cb1.setMaximumSize(cb1.getPreferredSize());
		cb1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(cb1);
		cb1.setBackground(Color.WHITE);

		panel.add(Box.createVerticalStrut(10));
		cb2.addItem("No Waypoint Selected");
		cb2.setSelectedItem("No Waypoint Selected");
		cb2.setMaximumSize(cb2.getPreferredSize());
		cb2.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(cb2);
		cb2.setBackground(Color.WHITE);

		panel.add(Box.createVerticalStrut(10));
		JButton btn = new JButton("Find Shortest Route");
		btn.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(btn);
		btn.setBackground(Color.MAGENTA);

		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Gets first 2 numbers from selection box
				
				String box1 = (String) cb.getSelectedItem();

				String box1stChar = box1.substring(0, 2);
				int box1Int = Integer.parseInt(box1stChar);

				String box2 = (String) cb1.getSelectedItem();

				String box2ndChar = box2.substring(0, 2);
				int box2Int = Integer.parseInt(box2ndChar);

				
				// prints out diret distance betweeen points in command line
				System.out.println("Distance between " + cb.getSelectedItem() + " and " + cb1.getSelectedItem()
						+ " equals " + NodeMap.GetLength(box1Int, box2Int) + " miles");

				if (cb2.getSelectedItem() != "No Waypoint Selected") {

					String box3 = (String) cb2.getSelectedItem();

					String box3rdChar = box3.substring(0, 2);
					int box3Int = Integer.parseInt(box3rdChar);

					try {
						
						// for waypoint 
						
						pathFinder(box1Int, box3Int);
						pathFinder(box3Int, box2Int);

						
						// resets image
						bufferedImage = SwingFXUtils.fromFXImage(image, null);

					} catch (IOException e1) {
						e1.printStackTrace();
					}

				} else {
					try {

						// if no waypoint selected
						
						pathFinder(box1Int, box2Int);

						// resets image
						bufferedImage = SwingFXUtils.fromFXImage(image, null);
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				}

				if (cb.getSelectedItem() == cb1.getSelectedItem()) {
					JOptionPane.showMessageDialog(null, "Invalid Route!!");
					System.out.println("Try another route!");
				}
				
				if (cb2.getSelectedItem() == cb.getSelectedItem()) {
					JOptionPane.showMessageDialog(null, "Waypoint cannot be the same as choicebox 1!!");
					System.out.println("Try another Waypoint!");
				}
				
				if (cb2.getSelectedItem() == cb1.getSelectedItem()) {
					JOptionPane.showMessageDialog(null, "Waypoint cannot be the same as choicebox 2!!");
					System.out.println("Try another Waypoint!");
				}
			}
		});

		panel.add(Box.createVerticalStrut(10));
		JButton btn2 = new JButton("Close Program");
		btn2.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(btn2);
		btn2.setBackground(Color.CYAN);

		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Platform.exit();
				System.exit(0); 
			}
		});

		frame.setVisible(true);
	}


	
	// draws routes lines on map
	public static BufferedImage drawLine(BufferedImage bufferedImage2, int node1, int node2) throws IOException {

		Graphics imageGraphics = bufferedImage.getGraphics();
		Graphics2D g2 = (Graphics2D) imageGraphics;

		
		g2.setColor(Color.MAGENTA);
		g2.setStroke(new BasicStroke(6));
		// setes coordinates as 2 points
		int x1 = mapNodes.get(node1).getX();
		int y1 = mapNodes.get(node1).getY();
		int x2 = mapNodes.get(node2).getX();
		int y2 = mapNodes.get(node2).getY();
		g2.drawLine(x1, y1, x2, y2);
		imageGraphics.dispose();
		g2.dispose();

		return bufferedImage;
	}

	public static void pathFinder(int node1, int node2) throws IOException {
		testGraph = new Graph(mapNodes);

		DijkstraGraph dGraph = new DijkstraGraph(testGraph);

		// shortest path of node1 to node2
		List<Node> pathTest = dGraph.getShortestPath(mapNodes.get(node1), mapNodes.get(node2));

		// draws line for each path on route
		for (int i = 1; i < pathTest.size(); i++) {
			markedImage = drawLine(markedImage, pathTest.get(i).getIndex(), pathTest.get(i - 1).getIndex());
		}

		imageView.setImage(SwingFXUtils.toFXImage(markedImage, null));

	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		mapNodes = NodeMap.nodeMapDeclared();

		image = new Image("mapDS2CA2.jpg");

		bufferedImage = SwingFXUtils.fromFXImage(image, null);

		markedImage = bufferedImage;

		launch(args);

	}
}
