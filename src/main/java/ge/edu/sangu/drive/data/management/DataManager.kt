package ge.edu.sangu.drive.data.management

import java.io.File

/**
 * @author Davit Abulashvili
 */

public interface DataManager {

    public fun saveFile(file: ByteArray, meta: Map<String, String>) : String
}
