package ge.edu.sangu.drive.data.management

import com.mongodb.MongoClient
import org.bson.Document

/**
 * @author Davit Abulashvili
 */

class DBManager : DataManager {

    val mongoClient = MongoClient("localhost")

    override fun saveFile(file: ByteArray, meta: Map<String, String>) {
        val db = mongoClient.getDatabase("drive")
        val collection = db.getCollection("files")
        val dbObj = Document()
        meta.forEach { key -> print(key) }
        for ((key, value) in meta) {
            dbObj.append(key, value)
        }
        dbObj.append("data", file)
        dbObj.append("size", file.size())
        collection.insertOne(dbObj)
    }

    fun save() {
        val db = mongoClient.getDatabase("drive")
        val collection = db.getCollection("nodes")
        collection.find()
    }
}