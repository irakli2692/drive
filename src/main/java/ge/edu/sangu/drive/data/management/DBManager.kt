package ge.edu.sangu.drive.data.management

import com.mongodb.MongoClient
import com.mongodb.client.FindIterable
import org.bson.Document
import java.util.*

/**
 * @author Davit Abulashvili
 */

class DBManager : DataManager {

    val mongoClient = MongoClient("localhost")

    override fun saveFile(info: Map<String, Any>, meta: Map<String, String>): String {
        val db = mongoClient.getDatabase("drive")
        val collection = db.getCollection("files")
        val dbObj = Document()
        val metadata = Document()
        for ((key, value) in meta) {
            metadata.append(key, value)
        }
        for ((key, value) in info) {
            dbObj.append(key, value)
        }
        dbObj.append("_metadata", metadata)
        collection.insertOne(dbObj)
        return dbObj.get("_id").toString()
    }

    override fun getFiles(): List<Document> {
        val db = mongoClient.getDatabase("drive")
        val collection = db.getCollection("files")
        val docs = collection.find().projection(Document("_data", false)).toList()
        docs.forEach { it!!.set("_id", it.get("_id").toString()) }
        return docs
    }
}