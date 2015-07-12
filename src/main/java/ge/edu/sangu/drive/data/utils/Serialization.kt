package ge.edu.sangu.drive.data.utils

import com.fasterxml.jackson.databind.ObjectMapper

/**
 * @author Davit Abulashvili
 */
val mapper = ObjectMapper()

public fun toJson(obj: Any) :String {
    return mapper.writeValueAsString(obj)
}