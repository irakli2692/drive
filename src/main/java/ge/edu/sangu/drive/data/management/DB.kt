package ge.edu.sangu.drive.data.management

import com.mongodb.MongoClient
import java.io.File

/**
 * @author Davit Abulashvili
 */

class DBManager : DataManager {

    val mongoClient = MongoClient("localhost")

    override fun saveFile(file: File?) {
        throw UnsupportedOperationException()
    }

    fun save() {
        val db = mongoClient.getDB("drive")
        val collection = db.getCollection("nodes")
        collection.find()
    }
}