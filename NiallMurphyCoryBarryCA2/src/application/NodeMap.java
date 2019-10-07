package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NodeMap {

	private static List<Node> mapNodes;

	public static List<Node> nodeMapDeclared() throws IOException {

		mapNodes = new ArrayList<Node>();

		mapNodes.add(new Node(00, "Castle Black", 963, 529)); // node index 00
		mapNodes.add(new Node(01, "The Dread Fort", 1027, 808)); // node index 01
		mapNodes.add(new Node(02, "Winterfell", 821, 846)); // node index 02
		mapNodes.add(new Node(03, "White Harbor", 927, 1048)); // node index 03
		mapNodes.add(new Node(04, "Moat Cailin", 823, 1094)); // node index 04
		mapNodes.add(new Node(05, "The Twins", 791, 1316)); // node index 05

		mapNodes.add(new Node(06, "TheEyrie", 1038, 1391)); // node index 06
		mapNodes.add(new Node(07, "Riverrun", 750, 1487)); // node index 07
		// does not work if node numbers 08 and 09 are used
		mapNodes.add(new Node(88, "Error", 0, 0)); // node index 08 (doesn't work because it's being taken as an octal, not an int?)
		mapNodes.add(new Node(99, "Error2", 1, 1)); // node index 09
		mapNodes.add(new Node(10, "Casterly Rock", 517, 1630)); // node index 10
		mapNodes.add(new Node(11, "Kings Landing", 979, 1709)); // node index 11

		mapNodes.add(new Node(12, "Storms End", 1126, 1874)); // node index 12
		mapNodes.add(new Node(13, "High Garden", 633, 1942)); // node index 13
		mapNodes.add(new Node(14, "OldTown", 516, 2078)); // node index 14
		mapNodes.add(new Node(15, "Sunspear", 1207, 2196)); // node index 15
		mapNodes.add(new Node(16, "Tyrosh", 1350, 1994)); // node index 16
		mapNodes.add(new Node(17, "Volantis", 1913, 2210)); // node index 17

		mapNodes.add(new Node(18, "Lotus Port", 1333, 2765)); // node index 18
		mapNodes.add(new Node(19, "Asshai", 4452, 3121)); // node index 19
		mapNodes.add(new Node(20, "Vaes Dothrak", 3198, 1574)); // node index 20
		mapNodes.add(new Node(21, "Pentos", 1462, 1692)); // node index 21
		mapNodes.add(new Node(22, "Qohor", 1969, 1693)); // node index 22
		mapNodes.add(new Node(23, "Norvos", 1724, 1543)); // node index 23

		mapNodes.add(new Node(24, "Braavos", 1450, 1259)); // node index 24
		mapNodes.add(new Node(25, "Myr", 1552, 1958)); // node index 25
		mapNodes.add(new Node(26, "Lys", 1473, 2202)); // node index 26
		mapNodes.add(new Node(27, "Pyke", 525, 1417)); // node index 27
		mapNodes.add(new Node(28, "Lannisport", 517, 1649)); // node index 28
		mapNodes.add(new Node(29, "Valyria", 2162, 2599)); // node index 29
		mapNodes.add(new Node(30, "Dragonstone", 1173, 1603)); // node index 30
		mapNodes.add(new Node(31, "Harrenhal", 910, 1536)); // node index 31
		
		mapNodes.add(new Node(32, "Stygai", 4556, 3004)); // node index 32
		mapNodes.add(new Node(33, "Turrani", 4216, 2879)); // node index 33
		mapNodes.add(new Node(34, "Vahar", 3357, 2789)); // node index 34
		mapNodes.add(new Node(35, "Zabhad", 3660, 3065)); // node index 35
		mapNodes.add(new Node(36, "Port Moraq", 3590, 2976)); // node index 36
		mapNodes.add(new Node(37, "Selhorys", 1827, 2068)); // node index 37
		mapNodes.add(new Node(38, "Vaes Khewo", 2462, 1732)); // node index 38
		mapNodes.add(new Node(39, "Kosrak", 3065, 2089)); // node index 39
		mapNodes.add(new Node(40, "Gulltown", 1209, 1431)); // node index 40
		mapNodes.add(new Node(41, "Kayakayanaya", 3649, 1677)); // node index 32


		// Routes
		// Castle Black to The Dread Fort
		mapNodes.get(00).addTwoWayNeighbor(mapNodes.get(01), GetLength(00, 01));
		// Castle Black to Winterfell
		mapNodes.get(00).addTwoWayNeighbor(mapNodes.get(02), GetLength(00, 02));
		// The Dread Fort to White Harbor
		mapNodes.get(01).addTwoWayNeighbor(mapNodes.get(03), GetLength(01, 03));
		// The Dread Fort to White Harbor
		mapNodes.get(01).addTwoWayNeighbor(mapNodes.get(03), GetLength(01, 03));
		// Winterfell to Castle Black
		mapNodes.get(02).addTwoWayNeighbor(mapNodes.get(00), GetLength(02, 00));
		// Winterfell to Dread Fort
		mapNodes.get(02).addTwoWayNeighbor(mapNodes.get(01), GetLength(02, 01));
		// Winterfell to White Harbor
		mapNodes.get(02).addTwoWayNeighbor(mapNodes.get(03), GetLength(02, 03));
		// White Harbor to Moat Cailin
		mapNodes.get(03).addTwoWayNeighbor(mapNodes.get(04), GetLength(03, 04));
		// Moat Calin to The Twins
		mapNodes.get(04).addTwoWayNeighbor(mapNodes.get(05), GetLength(04, 05));
		// Moat Cailin to Winterfell
		mapNodes.get(04).addTwoWayNeighbor(mapNodes.get(02), GetLength(04, 02));
		// The Twins to Pyke
		mapNodes.get(05).addTwoWayNeighbor(mapNodes.get(27), GetLength(05, 27));
		// The Twins to Riverrun
		mapNodes.get(05).addTwoWayNeighbor(mapNodes.get(07), GetLength(05, 07));
		// The Twins to Harrenhal
		// mapNodes.get(05).addTwoWayNeighbor(mapNodes.get(99),GetLength(05,99));
		// The Twins to The Eyrie
		mapNodes.get(05).addTwoWayNeighbor(mapNodes.get(06), GetLength(05, 06));
		// Riverrun to Casterly Rock
		mapNodes.get(07).addTwoWayNeighbor(mapNodes.get(10), GetLength(07, 10));
		// Riverrun to The Eyrie
		mapNodes.get(07).addTwoWayNeighbor(mapNodes.get(06), GetLength(07, 06));
		// Riverrun to King's Landing
		mapNodes.get(07).addTwoWayNeighbor(mapNodes.get(11), GetLength(07, 11));
		// Casterly Rock to Lannisport
		mapNodes.get(10).addTwoWayNeighbor(mapNodes.get(28), GetLength(10, 28));
		// Casterly Rock to High Garden
		mapNodes.get(10).addTwoWayNeighbor(mapNodes.get(13), GetLength(10, 13));
		// Casterly Rock to King's Landing
		mapNodes.get(10).addTwoWayNeighbor(mapNodes.get(11), GetLength(10, 11));
		// King's Landing to Storm's End
		mapNodes.get(11).addTwoWayNeighbor(mapNodes.get(12), GetLength(11, 12));
		// King's Landing to High Garden
		mapNodes.get(11).addTwoWayNeighbor(mapNodes.get(13), GetLength(11, 13));
		// King's Landing to LannisPort
		mapNodes.get(11).addTwoWayNeighbor(mapNodes.get(28), GetLength(11, 28));
		// Storm's End to Tyrosh
		mapNodes.get(12).addTwoWayNeighbor(mapNodes.get(16), GetLength(12, 16));
		// Storm's End to Braavos
		mapNodes.get(12).addTwoWayNeighbor(mapNodes.get(24), GetLength(12, 24));
		// Storm's End to Pentos
		mapNodes.get(12).addTwoWayNeighbor(mapNodes.get(21), GetLength(12, 21));
		// High Garden to Oldtown
		mapNodes.get(13).addTwoWayNeighbor(mapNodes.get(14), GetLength(13, 14));
		// High Garden to LannisPort
		mapNodes.get(13).addTwoWayNeighbor(mapNodes.get(28), GetLength(13, 28));
		// Oldtown to Sunspear
		mapNodes.get(14).addTwoWayNeighbor(mapNodes.get(15), GetLength(14, 15));
		// Sunspear to Tyrosh
		mapNodes.get(15).addTwoWayNeighbor(mapNodes.get(16), GetLength(15, 16));
		// Sunspear to Lys
		mapNodes.get(15).addTwoWayNeighbor(mapNodes.get(26), GetLength(15, 26));
		// Sunspear to Lotus Port
		mapNodes.get(15).addTwoWayNeighbor(mapNodes.get(18), GetLength(15, 18));
		// Tyrosh to Myr
		mapNodes.get(16).addTwoWayNeighbor(mapNodes.get(25), GetLength(16, 25));
		// Tyrosh to Pentos
		mapNodes.get(16).addTwoWayNeighbor(mapNodes.get(21), GetLength(16, 21));
		// Volantis to Myr
		mapNodes.get(17).addTwoWayNeighbor(mapNodes.get(25), GetLength(17, 25));
		// Volantis to Qohor
		mapNodes.get(17).addTwoWayNeighbor(mapNodes.get(22), GetLength(17, 22));
		// Volantis to Norvos
		mapNodes.get(17).addTwoWayNeighbor(mapNodes.get(23), GetLength(17, 23));
		// Volantis to Pentos
		mapNodes.get(17).addTwoWayNeighbor(mapNodes.get(21), GetLength(17, 21));
		// Volantis to Vaes Dothrak
		mapNodes.get(17).addTwoWayNeighbor(mapNodes.get(20), GetLength(17, 20));
		// Lotus Port to Valyria
		mapNodes.get(18).addTwoWayNeighbor(mapNodes.get(29), GetLength(18, 29));
		// Lotus Port to Lys
		mapNodes.get(18).addTwoWayNeighbor(mapNodes.get(26), GetLength(18, 26));
		// Asshai to Valyria
		mapNodes.get(19).addTwoWayNeighbor(mapNodes.get(29), GetLength(19, 29));
		// Vaes Dothrak to Valyria
		mapNodes.get(20).addTwoWayNeighbor(mapNodes.get(29), GetLength(20, 29));
		// Vaes Dothrak to Qohor
		mapNodes.get(20).addTwoWayNeighbor(mapNodes.get(22), GetLength(20, 22));
		// Pentos to Myr
		mapNodes.get(21).addTwoWayNeighbor(mapNodes.get(25), GetLength(21, 25));
		// Pentos to Braavos
		mapNodes.get(21).addTwoWayNeighbor(mapNodes.get(24), GetLength(21, 24));
		// Pentos to Norvos
		mapNodes.get(21).addTwoWayNeighbor(mapNodes.get(23), GetLength(21, 23));
		// Qohor to Norvos
		mapNodes.get(22).addTwoWayNeighbor(mapNodes.get(23), GetLength(22, 23));
		// Qohor to Myr
		mapNodes.get(22).addTwoWayNeighbor(mapNodes.get(25), GetLength(22, 25));
		// Myr to Lys
		mapNodes.get(25).addTwoWayNeighbor(mapNodes.get(25), GetLength(25, 26));
		// Lys to Valyria
		mapNodes.get(16).addTwoWayNeighbor(mapNodes.get(29), GetLength(26, 29));
		// Pyke to Lannisport
		mapNodes.get(27).addTwoWayNeighbor(mapNodes.get(28), GetLength(27, 28));
		// Pyke to Riverrun
		mapNodes.get(27).addTwoWayNeighbor(mapNodes.get(07), GetLength(27, 07));
		// LannisPort to Riverrun
		mapNodes.get(28).addTwoWayNeighbor(mapNodes.get(07), GetLength(28, 07));
		// Valyria to Volantis
		mapNodes.get(29).addTwoWayNeighbor(mapNodes.get(17), GetLength(29, 17));
		// Dragonstone to Braavos
		mapNodes.get(30).addTwoWayNeighbor(mapNodes.get(24), GetLength(30, 24));
		// Dragonstone to Pentos
		mapNodes.get(30).addTwoWayNeighbor(mapNodes.get(21), GetLength(30, 21));
		// Dragonstone to Tyrosh
		mapNodes.get(30).addTwoWayNeighbor(mapNodes.get(16), GetLength(30, 16));
		// Harrenhal to Dragonstone
		mapNodes.get(31).addTwoWayNeighbor(mapNodes.get(30), GetLength(31, 30));
		// Harrenhal to Riverrun
		mapNodes.get(31).addTwoWayNeighbor(mapNodes.get(07), GetLength(31, 07));
		// Harrenhal to The Twins
		mapNodes.get(31).addTwoWayNeighbor(mapNodes.get(05), GetLength(31, 05));
		// Harrenhal to King's Landing
		mapNodes.get(31).addTwoWayNeighbor(mapNodes.get(10), GetLength(31, 10));
		// Harrenhal to LannisPort
		mapNodes.get(31).addTwoWayNeighbor(mapNodes.get(28), GetLength(31, 28));
		// Harrenhal to The Eyrie
		mapNodes.get(31).addTwoWayNeighbor(mapNodes.get(06), GetLength(31, 06));
		// Harrenhal to High Garden
		mapNodes.get(31).addTwoWayNeighbor(mapNodes.get(13), GetLength(31, 13));
		// Stygai to Asshai
		mapNodes.get(32).addTwoWayNeighbor(mapNodes.get(19), GetLength(32, 19));
		// Turrani to Asshai
	    mapNodes.get(33).addTwoWayNeighbor(mapNodes.get(19), GetLength(33, 19));
	    // Turrani to Port Moraq
	    mapNodes.get(33).addTwoWayNeighbor(mapNodes.get(36), GetLength(33, 36));
	    // Vahar to Zabhad
	    mapNodes.get(34).addTwoWayNeighbor(mapNodes.get(35), GetLength(34, 35));
	    // Zabhad to Port Moraq
	    mapNodes.get(35).addTwoWayNeighbor(mapNodes.get(36), GetLength(35, 36));
	    // Vahar to lotus Port
	    mapNodes.get(34).addTwoWayNeighbor(mapNodes.get(18), GetLength(34, 18));
	    // Vahar to Valyria
	    mapNodes.get(34).addTwoWayNeighbor(mapNodes.get(29), GetLength(34, 29));
	    // Selhorys to Volantis
	    mapNodes.get(37).addTwoWayNeighbor(mapNodes.get(17), GetLength(37, 17));
	    // Selhorys to Qohor
	    mapNodes.get(37).addTwoWayNeighbor(mapNodes.get(22), GetLength(37, 22));
	    // Vaes Khewo to Vaes Dothrak
	    mapNodes.get(38).addTwoWayNeighbor(mapNodes.get(20), GetLength(38, 20));
	   // Vaes Khewo to Valyria
	   mapNodes.get(38).addTwoWayNeighbor(mapNodes.get(20), GetLength(38, 29));
	   // Vaes Khewo to Qohor
	   mapNodes.get(38).addTwoWayNeighbor(mapNodes.get(22), GetLength(38, 22));
	   // Kosrak to Vaes Dothrak
	   mapNodes.get(39).addTwoWayNeighbor(mapNodes.get(20), GetLength(39, 20));
	   // Kosrak to Vaes Khewo
	   mapNodes.get(39).addTwoWayNeighbor(mapNodes.get(38), GetLength(39, 38));
	   // Kosrak to Kayakayanaya
	   mapNodes.get(39).addTwoWayNeighbor(mapNodes.get(41), GetLength(39, 41));
	   // Kayakayanaya to Vaes Dothrak
	   mapNodes.get(41).addTwoWayNeighbor(mapNodes.get(20), GetLength(41, 20));
	   // Gulltown to Braavos
	   mapNodes.get(40).addTwoWayNeighbor(mapNodes.get(24), GetLength(40, 24));
	   // Gulltown to Eyrie
	   mapNodes.get(40).addTwoWayNeighbor(mapNodes.get(06), GetLength(40, 06));
	   // Gulltowh to Pentos
	   mapNodes.get(40).addTwoWayNeighbor(mapNodes.get(21), GetLength(40, 21));
	    

		return mapNodes;

	}

	// gets length between two points
	public static int GetLength(int val1, int val2) {

		int x1 = mapNodes.get(val1).getX();
		int y1 = mapNodes.get(val1).getY();
		int x2 = mapNodes.get(val2).getX();
		int y2 = mapNodes.get(val1).getY();

		double dis;
		dis = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

		int length = (int) dis;
		return length;

	}
}
