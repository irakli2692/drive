package ge.edu.sangu.drive.cluster

import java.util.ArrayList

/**
 * @author irakli on 4/19/2015.
 */
public class Cluster {

    private val nodes = ArrayList<Node>()

    public fun addNode(node: Node) {
        this.nodes.add(node)
    }

    public fun removeNode(node: Node) {
        this.nodes.remove(node)
    }

    public fun addNodes(nodes: List<Node>) {
        this.nodes.addAll(nodes)
    }

    public fun Connect() {
    }
}
