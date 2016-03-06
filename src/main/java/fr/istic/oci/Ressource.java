package fr.istic.oci;

import java.util.ArrayList;
import java.util.List;

public class Ressource {

	public static List<Technologie> technos() {

		DataAccess data = new DataAccess();
		ArrayList<Technologie> listOfTechnologies = new ArrayList<>();
		
		String zk = data.getData("files/zk.txt");
		listOfTechnologies.add(new Technologie("ZK", zk));

		String FXML = data.getData("files/fxml.txt");
		listOfTechnologies.add(new Technologie("FXML", FXML));

		String mxml = data.getData("files/mxml.txt");
		listOfTechnologies.add(new Technologie("MXML", mxml));

		String xaml = data.getData("files/xaml.txt");
		listOfTechnologies.add(new Technologie("XAML", xaml));

		return listOfTechnologies;
	}
}