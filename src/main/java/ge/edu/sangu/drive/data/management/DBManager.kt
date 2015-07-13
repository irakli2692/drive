package ge.edu.sangu.drive.data.management

import com.mongodb.MongoClient
import com.mongodb.client.FindIterable
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.Filters
import org.bson.Document
import org.bson.types.ObjectId
import java.util.*

/**
 * @author Davit Abulashvili
 */

class DBManager : DataManager {

    val mongoClient = MongoClient("localhost")
    val db = mongoClient.getDatabase("drive")
    val filesCollection = db.getCollection("files")

    override fun saveFile(info: Map<String, Any>, meta: Map<String, String>): String {

        val dbObj = Document()
        val metadata = Document()
        for ((key, value) in meta) {
            metadata.append(key, value)
        }
        for ((key, value) in info) {
            dbObj.append(key, value)
        }
        dbObj.append("_metadata", metadata)
        filesCollection.insertOne(dbObj)
        return dbObj.get("_id").toString()
    }

    override fun getFiles(): List<Document> {
        val docs = filesCollection.find().projection(Document("_data", false)).toList()
        docs.forEach { it!!.set("_id", it.get("_id").toString()) }
        return docs
    }

    override fun getFileById(val id: String): Document {
        val doc = filesCollection.find(Filters.eq("_id", ObjectId(id))).first()

        return doc
    }
}
