package ge.edu.sangu.drive.cluster.connect

public fun createClusterFinder(): ClusterFinder {
    return NetworkScanningClusterFinder()
}