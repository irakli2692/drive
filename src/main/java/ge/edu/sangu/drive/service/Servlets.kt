package ge.edu.sangu.drive.service

import ge.edu.sangu.drive.data.management.createDataManager
import ge.edu.sangu.drive.data.utils.toJson
import org.apache.commons.io.IOUtils
import java.lang
import java.util.Date
import javax.servlet.annotation.MultipartConfig
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.Part

/**
 * @author Davit Abulashvili
 */

WebServlet(name = "Files", value = "/files")
public class FilesController : HttpServlet() {
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val db = createDataManager()
        val files = db.getFiles()
        resp!!.setStatus(HttpServletResponse.SC_OK)
        resp.setContentType("application/json")
        resp.getWriter()!!.write(toJson(files))
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
        val fileName = getFileName(filePart)
        val info = hashMapOf<String, Any>()
        info.put("_fileName", fileName)
        info.put("_size", bytes.size())
        info.put("_date", Date().getTime())
        info.put("_data", bytes)

        val parameterNames = req.getParameterNames()
        val map = hashMapOf<String, String>()

        while (parameterNames!!.hasMoreElements()) {
            val paramName = parameterNames.nextElement()
            val paramValues = req.getParameterValues(paramName);
            map.put(paramName, paramValues[0])
        }

        val db = createDataManager()
        val id = db.saveFile(info, map)
        resp!!.setStatus(HttpServletResponse.SC_OK)
        resp.getWriter()!!.write(id)
    }

    private fun getFileName(part: Part): String {
        val partHeader = part.getHeader("content-disposition")
        val strings = partHeader.split('\"')
        return strings[strings.size() - 2];
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

