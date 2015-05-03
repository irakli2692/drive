package ge.edu.sangu.drive.cluster.connect;

public class ClusterFinderFactory {

	public static ClusterFinder createClusterFinder() {
		return new NetworkScanningClusterFinder();
	}
}
