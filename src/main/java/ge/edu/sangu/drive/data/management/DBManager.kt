package ge.edu.sangu.drive.data.management

import com.mongodb.MongoClient
import org.bson.Document
import java.util.*

/**
 * @author Davit Abulashvili
 */

class DBManager : DataManager {

    val mongoClient = MongoClient("localhost")

    override fun saveFile(file: ByteArray, meta: Map<String, String>): String {
        val db = mongoClient.getDatabase("drive")
        val collection = db.getCollection("files")
        val dbObj = Document()
        for ((key, value) in meta) {
            dbObj.append(key, value)
        }
        dbObj.append("_data", file)
        dbObj.append("_size", file.size())
        dbObj.append("_date", Date().getTime())
        collection.insertOne(dbObj)
        return dbObj.get("_id").toString()
    }
}