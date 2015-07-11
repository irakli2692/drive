package ge.edu.sangu.drive.cluster.connect

import ge.edu.sangu.drive.cluster.Cluster

class NetworkScanningClusterFinder : ClusterFinder {

    override fun find(): Cluster {
        return Cluster()
    }
}
