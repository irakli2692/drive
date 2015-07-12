package ge.edu.sangu.drive.service

import ge.edu.sangu.drive.data.utils.ConfigUtils
import sun.plugin.com.JavaClass
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author Davit Abulashvili
 */

WebServlet(name = "Files", value = "/files")
public class FilesController: HttpServlet() {
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        resp?.getWriter()?.write("Hello, World!")
    }
}

WebServlet(name = "Upload", value = "/file/upload")
public class FileUpload: HttpServlet() {
    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val description = req?.getParameter("description") // Retrieves <input type="text" name="description">
        val filePart = req?.getPart("file") // Retrieves <input type="file" name="file">
        val fileContent = filePart?.getInputStream();
    }
}

WebServlet(name = "Nodes", value = "/nodes")
public class NodesController: HttpServlet() {
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        resp?.getWriter()?.write("Hello, Nodes!")
    }
}

