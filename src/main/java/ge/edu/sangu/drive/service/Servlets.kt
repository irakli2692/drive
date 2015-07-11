package ge.edu.sangu.drive.service

import ge.edu.sangu.drive.data.management.DBManager
import ge.edu.sangu.drive.data.management.createDataManager
import org.apache.commons.io.IOUtils
import java.io.ByteArrayOutputStream
import java.io.File
import javax.servlet.annotation.MultipartConfig
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author Davit Abulashvili
 */

WebServlet(name = "Files", value = "/files")
public class FilesController : HttpServlet() {
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        resp?.getWriter()?.write("files info")
    }
}

WebServlet(name = "Upload", value = "/file/upload")
MultipartConfig
public class FileUpload : HttpServlet() {
    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val filePart = req!!.getPart("_file")
        val fileContent = filePart!!.getInputStream()
        println(fileContent)

        val bytes = IOUtils.toByteArray(fileContent)

        val parameterNames = req.getParameterNames()
        val map = hashMapOf<String, String>()

        while (parameterNames!!.hasMoreElements()) {
            val paramName = parameterNames.nextElement()
            val paramValues = req.getParameterValues(paramName);
            map.put(paramName, paramValues[0])
        }

        val db = createDataManager()
        val id = db.saveFile(bytes, map)
        resp!!.setStatus(HttpServletResponse.SC_OK)
        resp.getWriter()!!.write(id)
    }
}

WebServlet(name = "Delete", value = "/file/delete")
public class FileDelete : HttpServlet() {
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val fileId = req?.getParameter("fileId")
        resp?.getWriter()?.write("delete file $fileId")
    }
}

WebServlet(name = "Nodes", value = "/nodes")
public class NodesController : HttpServlet() {
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        resp?.getWriter()?.write("nodes info")
    }
}

