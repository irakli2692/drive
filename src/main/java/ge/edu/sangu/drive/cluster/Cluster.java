package ge.edu.sangu.drive.cluster;

import java.util.ArrayList;
import java.util.List;

/**
 * @author irakli on 4/19/2015.
 */
public class Cluster {

	private List<Node> nodes = new ArrayList<>();

	public void addNode(Node node) {
		this.nodes.add(node);
	}

	public void removeNode(Node node) {
		this.nodes.remove(node);
	}

	public void addNodes(List<Node> nodes) {
		this.nodes.addAll(nodes);
	}

	public void Connect() {

	}
}
