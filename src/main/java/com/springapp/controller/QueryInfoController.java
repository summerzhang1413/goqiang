package com.springapp.controller;

import com.springapp.domain.*;
import com.springapp.exception.DaoException;
import com.springapp.exception.ServiceException;
import com.springapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/info")
public class QueryInfoController {
    @Autowired
    public GoodsSubmitService goodsSubmitService;
    @Autowired
    public UserService userService;
    @Autowired
    public UsersWinService usersWinService;
    @Autowired
    public OpenWinService openWinService;
    @Autowired
    public CityService cityService;
    @Autowired
    public SuggestionService suggestionService;
    @Autowired
    public NoticeService noticeService;
    @RequestMapping("/showQueryInfoPage")
    public String showPage(){

        return "showQueryInfoPage";
    }
    @RequestMapping("/showGoodsSubmit")
    public String showGoodsSubmit(){
        return "showGoodsSubmit";
    }
    @RequestMapping("/findGoodsSubmit")
    public String findGoodsSubmit(Model model,HttpServletRequest request) throws DaoException, ServiceException{
        String goodsname = request.getParameter("goodsname");
        String datesubmit = request.getParameter("datesubmit");
        String figure = request.getParameter("figure");
        if (!(goodsname.equals("")) & !(datesubmit.equals("")) & !(figure.equals(""))){
            String hql = "from GoodsSubmit g where g.name='" + goodsname + "'" + " and g.datesubmit='" + datesubmit + "'" + " and g.figure='" + figure + "'" ;
            List<GoodsInfo> goodsInfoList = goodsSubmitService.findByHqlString(hql);
            model.addAttribute("allGoodsSubmit", goodsInfoList);
        }else if (!(goodsname.equals("")) & !(datesubmit.equals("")) & (figure.equals(""))){
            String hql = "from GoodsSubmit g where g.name='" + goodsname + "'" + " and g.datesubmit='" + datesubmit + "'" ;
            List<GoodsInfo> goodsInfoList = goodsSubmitService.findByHqlString(hql);
            model.addAttribute("allGoodsSubmit", goodsInfoList);
        }else if (!(goodsname.equals("")) & !(figure.equals("")) & (datesubmit.equals(""))){
            String hql = "from GoodsSubmit g where g.name='" + goodsname + "'" + " and g.figure='" + figure + "'" ;
            List<GoodsInfo> goodsInfoList = goodsSubmitService.findByHqlString(hql);
            model.addAttribute("allGoodsSubmit", goodsInfoList);
        }else if (!(datesubmit.equals("")) & !(figure.equals("")) & (goodsname.equals(""))){
            String hql = "from GoodsSubmit g where g.datesubmit='" + datesubmit + "'" + " and g.figure='" + figure + "'" ;
            List<GoodsInfo> goodsInfoList = goodsSubmitService.findByHqlString(hql);
            model.addAttribute("allGoodsSubmit", goodsInfoList);
        }else if (!(goodsname.equals("")) & (datesubmit.equals("")) & (figure.equals(""))){
            String hql = "from GoodsSubmit  g where g.name='" + goodsname + "'";
            List<GoodsInfo> goodsInfoList = goodsSubmitService.findByHqlString(hql);
            model.addAttribute("allGoodsSubmit", goodsInfoList);
        }else if ((goodsname.equals("")) & !(datesubmit.equals("")) & (figure.equals(""))){
            String hql = "from GoodsSubmit  g where g.datesubmit='" + datesubmit + "'";
            List<GoodsInfo> goodsInfoList = goodsSubmitService.findByHqlString(hql);
            model.addAttribute("allGoodsSubmit", goodsInfoList);
        }else if ((goodsname.equals("")) & (datesubmit.equals("")) & !(figure.equals(""))){
            String hql = "from GoodsSubmit  g where g.figure='" + figure + "'";
            List<GoodsInfo> goodsInfoList = goodsSubmitService.findByHqlString(hql);
            model.addAttribute("allGoodsSubmit", goodsInfoList);
        }
        return "showGoodsSubmit";
    }
    @RequestMapping("/showUser")
    public String showUser(){
        return "showUser";
    }
    @RequestMapping("/findUser")
    public String findUser(Model model, HttpServletRequest request) throws DaoException, ServiceException{
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        String date_rigister = request.getParameter("date_register");
        if (!(name.equals("")) & !(tel.equals("")) & !(date_rigister.equals(""))){
            String hql = "from User u where u.name='" + name + "'" + " and u.tel='" + tel + "'" + " and u.dateRegister='" + date_rigister + "'" ;
            List<User> userList = userService.findByHqlString(hql);
            model.addAttribute("allUser", userList);
        }else if (!(name.equals("")) & !(tel.equals("")) & (date_rigister.equals(""))){
            String hql = "from User u where u.name='" + name + "'" + " and u.tel='" + tel + "'" ;
            List<User> userList = userService.findByHqlString(hql);
            model.addAttribute("allUser", userList);
        }else if (!(name.equals("")) & !(date_rigister.equals("")) & (tel.equals(""))){
            String hql = "from User u where u.name='" + name + "'" + " and u.dateRegister='" + date_rigister + "'" ;
            List<User> userList = userService.findByHqlString(hql);
            model.addAttribute("allUser", userList);
        }else if (!(tel.equals("")) & !(date_rigister.equals("")) & (name.equals(""))){
            String hql = "from User u where u.tel='" + tel + "'" + " and u.dateRegister='" + date_rigister + "'" ;
            List<User> userList = userService.findByHqlString(hql);
            model.addAttribute("allUser", userList);
        }else if (!(name.equals("")) & (tel.equals("")) & (date_rigister.equals(""))){
            String hql = "from User u where u.name='" + name + "'";
            List<User> userList = userService.findByHqlString(hql);
            model.addAttribute("allUser", userList);
        }else if ((name.equals("")) & !(tel.equals("")) & (date_rigister.equals(""))){
            String hql = "from User u where u.tel='" + tel + "'";
            List<User> userList = userService.findByHqlString(hql);
            model.addAttribute("allUser", userList);
        }else if ((name.equals("")) & (tel.equals("")) & !(date_rigister.equals(""))){
            String hql = "from User u where u.dateRegister='" + date_rigister + "'";
            List<User> userList = userService.findByHqlString(hql);
            model.addAttribute("allUser", userList);
        }
        return "showUser";
    }
    @RequestMapping("/showUsersWin")
    public String showUsersWin(){
        return "showUsersWin";
    }
    @RequestMapping("/findUsersWin")
    public String findUsersWin(Model model, HttpServletRequest request) throws DaoException, ServiceException{
        String goodsname = request.getParameter("goodsname");
        String username = request.getParameter("username");
        if (!(goodsname.equals("")) & !(username.equals(""))){
            String hql = "from UsersWin u where u.goodsname='" + goodsname + "'" + " and u.username='" + username + "'" ;
            List<UsersWin> usersWinList = usersWinService.findByHqlString(hql);
            model.addAttribute("allUsersWin", usersWinList);
        }else if (!(goodsname.equals("")) & (username.equals(""))) {
            String hql = "from UsersWin u where u.goodsname='" + goodsname + "'" ;
            List<UsersWin> usersWinList = usersWinService.findByHqlString(hql);
            model.addAttribute("allUsersWin", usersWinList);
        }
        else if ((goodsname.equals("")) & !(username.equals(""))) {
            String hql = "from UsersWin u where u.username='" + username + "'" ;
            List<UsersWin> usersWinList = usersWinService.findByHqlString(hql);
            model.addAttribute("allUsersWin", usersWinList);
        }
        return "showUsersWin";
    }
    @RequestMapping("/showUpdateUsersWin")
     public String showUpdateUsersWin(Model model, HttpServletRequest request) throws  DaoException{
        String id = request.getParameter("id");
        String hql = "from UsersWin u where u.id='" + id + "'" ;
        List<UsersWin> usersWinList = usersWinService.findByHqlString(hql);
        model.addAttribute("allUsersWin", usersWinList);
        return "showUpdateUsersWin";
    }
    @RequestMapping("/updateUsersWin")
    public String updateUsersWin(UsersWin usersWin, Model model, HttpServletRequest request) throws  DaoException{
        usersWinService.update(usersWin);
        model.addAttribute("msg", "修改成功");
        return "showResult";
    }
    @RequestMapping("/showInsertUsersWin")
    public String showInsertUsersWin(){

        return "showInsertUsersWin";
    }
    @RequestMapping("/insertUsersWin")
    public String insertUsersWin(UsersWin usersWin, Model model, HttpServletRequest request) throws  DaoException{
        usersWinService.save(usersWin);
        model.addAttribute("msg", "修改成功");
        return "showResult";
    }
    @RequestMapping("/showOpenWin")
    public String showOpenWin(Model model) throws DaoException{
        List<City> allCity = cityService.findAllCity("from City");
        model.addAttribute("allCity", allCity);
        return "showOpenWin";
    }
    @RequestMapping("/findOpenWin")
    public String findOpenWin(Model model, HttpServletRequest request) throws DaoException{
        String goodsname = request.getParameter("goodsname");
        String city = request.getParameter("city");
        String datefinal = request.getParameter("datefinal");
        if (!(goodsname.equals("")) & !(city.equals("")) & !(datefinal.equals(""))){
            String hql = "from OpenWin o where o.goodsname='" + goodsname + "'" + " and o.city='" + city + "'" + " and o.datefinal='" + datefinal + "'" ;
            List<OpenWin> openWinList = openWinService.findByHqlString(hql);
            model.addAttribute("allOpenWin", openWinList);
        }else if (!(goodsname.equals("")) & !(city.equals("")) & (datefinal.equals(""))){
            String hql = "from OpenWin o where o.goodsname='" + goodsname + "'" + " and o.city='" + city + "'"  ;
            List<OpenWin> openWinList = openWinService.findByHqlString(hql);
            model.addAttribute("allOpenWin", openWinList);
        }else if (!(goodsname.equals("")) & (city.equals("")) & !(datefinal.equals(""))){
            String hql = "from OpenWin o where o.goodsname='" + goodsname + "'" + " and o.datefinal='" + datefinal + "'" ;
            List<OpenWin> openWinList = openWinService.findByHqlString(hql);
            model.addAttribute("allOpenWin", openWinList);
        }else if ((goodsname.equals("")) & !(city.equals("")) & !(datefinal.equals(""))){
            String hql = "from OpenWin o where o.city='" + city + "'" + " and o.datefinal='" + datefinal + "'" ;
            List<OpenWin> openWinList = openWinService.findByHqlString(hql);
            model.addAttribute("allOpenWin", openWinList);
        }else if (!(goodsname.equals("")) & (city.equals("")) & (datefinal.equals(""))){
            String hql = "from OpenWin o where o.goodsname='" + goodsname + "'";
            List<OpenWin> openWinList = openWinService.findByHqlString(hql);
            model.addAttribute("allOpenWin", openWinList);
        }else if ((goodsname.equals("")) & !(city.equals("")) & (datefinal.equals(""))){
            String hql = "from OpenWin o where o.city='" + city + "'";
            List<OpenWin> openWinList = openWinService.findByHqlString(hql);
            model.addAttribute("allOpenWin", openWinList);
        }else if ((goodsname.equals("")) & (city.equals("")) & !(datefinal.equals(""))){
            String hql = "from OpenWin o where o.datefinal='" + datefinal + "'" ;
            List<OpenWin> openWinList = openWinService.findByHqlString(hql);
            model.addAttribute("allOpenWin", openWinList);
        }
        List<City> allCity = cityService.findAllCity("from City");
        model.addAttribute("allCity", allCity);
        return "showOpenWin";
    }
    @RequestMapping("/showInsertOpenWin")
    public String showInsertOpenWin(Model model) throws DaoException{
        List<City> allCity = cityService.findAllCity("from City");
        model.addAttribute("allCity", allCity);
        return "showInsertOpenWin";
    }
    @RequestMapping("/insertOpenWin")
    public String insertOpenWin(OpenWin openWin, Model model) throws  DaoException{
        openWinService.save(openWin);
        model.addAttribute("msg", "修改成功");
        return "showResult";
    }
    @RequestMapping("/showUpdateOpenWin")
    public String showUpdateOpenWin(Model model, HttpServletRequest request) throws  DaoException{
        String id = request.getParameter("id");
        String hql = "from OpenWin o where o.id='" + id + "'" ;
        List<OpenWin> openWinList = openWinService.findByHqlString(hql);
        model.addAttribute("allOpenWin", openWinList);
        return "showUpdateOpenWin";
    }
    @RequestMapping("/updateOpenWin")
    public String updateOpenWin(OpenWin openWin, Model model, HttpServletRequest request) throws  DaoException{
        openWinService.update(openWin);
        model.addAttribute("msg", "修改成功");
        return "showResult";
    }
    @RequestMapping("/deleteOpenWinById")
    public String deleteOpenWinById(Model model, HttpServletRequest request) throws DaoException{
        String id = request.getParameter("id");
        boolean b = openWinService.deleteById(id);
        if (b){
            model.addAttribute("msg", "删除成功");
        }else{
            model.addAttribute("msg", "删除失败");
        }
        return "showResult";
    }
    @RequestMapping("/showSuggestion")
    public String showSuggestion(Model model) throws DaoException, ServiceException {
        List<Suggestion> suggestionList = suggestionService.find("from Suggestion");
        model.addAttribute("allSuggestion", suggestionList);
        return "showSuggestion";
    }
    @RequestMapping("/deleteSuggestion")
    public String deleteSuggestion(Model model, HttpServletRequest request) throws DaoException, ServiceException {
        String id = request.getParameter("id");
        boolean b = suggestionService.deleteById(id);
        if (!b){
            model.addAttribute("msg", "删除失败");
            return "showResult";
        }else {
            List<Suggestion> suggestionList = suggestionService.find("from Suggestion");
            model.addAttribute("allSuggestion", suggestionList);
            return "showSuggestion";
        }

    }
    @RequestMapping("/showNotice")
    public String showNotice(Model model) throws DaoException, ServiceException {
        List<Notice> noticeList = noticeService.findAllNotice("from Notice");
        model.addAttribute("allNotice", noticeList);
        return "showNotice";
    }
    @RequestMapping("/showInsertNotice")
    public String showInsertNotice() throws  DaoException, ServiceException{
        return "showInsertNotice";
    }
    @RequestMapping("/insertNotice")
    public String insertNotice(Notice notice, Model model) throws  DaoException, ServiceException{
        noticeService.insert(notice);
        model.addAttribute("msg", "添加成功");
        return "showResult";
    }
    @RequestMapping("/showUpdateNotice")
    public String showUpdateNotice(Model model, HttpServletRequest request) throws  DaoException, ServiceException{
        String id = request.getParameter("id");
        String hql = "from Notice n where n.id='" + id + "'" ;
        List<Notice> noticeList = noticeService.findAllNotice(hql);
        model.addAttribute("allNotice", noticeList);
        return "showUpdateNotice";
    }
    @RequestMapping("/updateNotice")
    public String updateNotice(Notice notice, Model model) throws  DaoException, ServiceException{
        noticeService.update(notice);
        model.addAttribute("msg", "修改成功");
        return "showResult";
    }

}
