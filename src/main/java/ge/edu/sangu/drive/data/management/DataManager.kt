package ge.edu.sangu.drive.data.management

import org.bson.Document

/**
 * @author Davit Abulashvili
 */

public interface DataManager {

    public fun saveFile(info: Map<String, Any>, meta: Map<String, String>): String

    public fun getFiles(): List<Document?>
}
