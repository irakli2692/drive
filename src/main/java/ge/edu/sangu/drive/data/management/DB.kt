package ge.edu.sangu.drive.data.management

import com.mongodb.MongoClient
import java.io.File

/**
 * @author Davit Abulashvili
 */

class DBManager {
    val mongoClient = MongoClient("localhost")

    fun save() {
        val db = mongoClient.getDB("drive")
        val collection = db.getCollection("nodes")
        collection.find()
    }
}