package ge.edu.sangu.drive.cluster

import java.util.*

/**
 * @author irakli on 4/19/2015.
 */
public class Node (var uuid : String = UUID.randomUUID().toString()) : Comparable<Node> {

    public var id: String = uuid
        get() = $id
        set(value) {$id = value}

    override fun compareTo(other: Node): Int {
        return this.id.compareTo(other.id)
    }
}
