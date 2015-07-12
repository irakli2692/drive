package ge.edu.sangu.drive.cluster.connect

public object ClusterFinderFactory {

    public fun createClusterFinder(): ClusterFinder {
        return NetworkScanningClusterFinder()
    }

}
