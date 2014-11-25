package com.springapp.controller;

import com.springapp.domain.Manager;
import com.springapp.exception.DaoException;
import com.springapp.exception.ServiceException;
import com.springapp.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/managerpage")
public class ManagerController {

    @Autowired
    public ManagerService managerService;
    @Autowired
    public HttpSession httpSession;

    @RequestMapping(value = "test")
    public String test(){
        return "test";
    }

    @RequestMapping("/login2")
    public String login(){
        return "hello";
    }

    @RequestMapping(value = "/login",  method = RequestMethod.POST)
    public void login(Manager manager, HttpServletResponse response) throws DaoException,IOException {
        Manager manager2 = managerService.findByNameAndPwd(manager.getmName(), manager.getmPwd());
        if (manager2 == null) {
            response.sendRedirect("/goqiang/managerpage/login2");
            httpSession.setAttribute("login_error", "用户名或密码错误");
            return;
        }
        httpSession.setAttribute("sessionManager", manager2);
        response.sendRedirect("/goqiang/managerpage/login2");

    }

    @RequestMapping(value = "/logout2")
    public String logout(){
        return "logout";
    }

    @RequestMapping(value = "/logout")
    public void logout(HttpServletResponse response) throws IOException {
        Object sessionManager = httpSession.getAttribute("sessionManager");
        if (sessionManager == null){
            response.sendRedirect("/goqiang/managerpage/logout2");
            httpSession.setAttribute("logout_error",  "请先登录！");
            return;
        }
        httpSession.removeAttribute("sessionManager");
        response.sendRedirect("/goqiang/managerpage/logout2");
    }

    @RequestMapping(value = "allmanager")
    public String getAllManager(Model model) throws IOException, DaoException {
        String hql = "from Manager";
        List<Manager> allManager = managerService.findAllManager(hql);
        model.addAttribute("allmanager", allManager);
        return "all_manager";
    }

    @RequestMapping(value = "delete")
    public void deleteManager(HttpServletRequest request, HttpServletResponse response) throws DaoException, IOException {
        String manager_name = request.getParameter("name");
        boolean isDelete = managerService.deleteByName(manager_name);
        if (isDelete){
            response.sendRedirect("/goqiang/managerpage/allmanager");
        }
    }

    @RequestMapping(value = "updatepage")
    public String updateManager(Model model, HttpServletRequest request, HttpServletResponse response) throws DaoException, IOException{
        String manager_name = request.getParameter("name");
        Manager manager = managerService.findByName(manager_name);
        model.addAttribute("manager", manager);
        return "manager_update";
    }

    @RequestMapping(value = "update")
    public void updateManager(Manager manager, HttpServletResponse response) throws ServiceException, DaoException, IOException {
        managerService.updateManager(manager);
        response.sendRedirect("/goqiang/managerpage/allmanager");
    }

    @RequestMapping(value = "insertpage")
    public String insertManager(){
        return "manager_insert";
    }

    @RequestMapping(value = "insert")
    public void insertManager(Manager manager, HttpServletResponse response) throws ServiceException, DaoException, IOException {
        managerService.saveManager(manager);
        response.sendRedirect("/goqiang/managerpage/allmanager");
    }

}
