package com.controller; /**
 * @project FSOFT
 * @author Will
 * @date 6/30/2023
 */

import com.model.Service;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;

@WebServlet(urlPatterns = {"/checkLog"})
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Service test = new Service();
        if (test.ReadFile(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("infor.jsp");
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/fail.jsp");
            rd.forward(request, response);
        }
    }

//    public static boolean ReadFile(String username, String password) {
//        boolean isExist = false;
//        JSONParser jsonParser = new JSONParser();
//        File file = new File("");
//        String currentDirectory = file.getAbsolutePath();
//
//        String filePath = "src/main/Data/users.json";
//        try (FileReader reader = new FileReader(filePath)) {
//            // Read JSON file
//            Object obj = jsonParser.parse(reader);
//            JSONArray employeeList = (JSONArray) obj;
////            System.out.println(doCheck(employeeList, username, password));
//            isExist = doCheck(employeeList, username, password);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//        return isExist;
//    }
//
//    public static boolean doCheck(JSONArray a, String u, String p) {
//
//        return doCheckUsername(a, u) && doCheckPassword(a, p);
//    }
//
//    private static boolean doCheckUsername(JSONArray a, String username) {
//        for (Object us : a) {
//            JSONObject userJson = (JSONObject) us;
//            String username1 = (String) userJson.get("username");
//            if (username1.equals(username)) return true;
//        }
//        return false;
//    }
//
//    private static boolean doCheckPassword(JSONArray a, String password) {
//        for (Object us : a) {
//            JSONObject userJson = (JSONObject) us;
//            String password1 = (String) userJson.get("password");
//            if (password1.equals(password)) return true;
//        }
//        return false;
//    }


}
