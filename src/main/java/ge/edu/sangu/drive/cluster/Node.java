package ge.edu.sangu.drive.cluster;

import org.jetbrains.annotations.NotNull;

/**
 * @author irakli on 4/19/2015.
 */
public class Node implements Comparable<Node> {

	public String id;

	@Override
	public int compareTo(@NotNull Node other) {
		return this.id.compareTo(other.id);
	}
}
