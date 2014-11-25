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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/android")
public class AndroidPostController {
    @Autowired
    public UserService userService;
    @Autowired
    public UsersWinService usersWinService;
    @Autowired
    public SuggestionService suggestionService;
    @Autowired
    public UsersForgetService usersForgetService;
    @Autowired
    public GoodsSubmitService goodsSubmitService;
    @Autowired
    public CityService cityService;
    @Autowired
    public NoticeService noticeService;
    @Autowired
    public GoodsInfoService goodsInfoService;
    @Autowired
    public OpenWinService openWinService;

    @RequestMapping(value = "/login")
    public String appLogin(Model model, HttpServletRequest request) throws DaoException{
        String name, grade, tel, address;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user_ByTelAndPwd = userService.findByTelAndPwd(username, password);
        User user_ByNameAndPwd = userService.findByNameAndPwd(username, password);
        if(user_ByNameAndPwd == null && user_ByTelAndPwd == null){
            model.addAttribute("info", "用户名或密码错误");
        }else {
            if (user_ByNameAndPwd != null){
                name = user_ByNameAndPwd.getName();
                grade = Integer.toString(user_ByNameAndPwd.getGrade());
                tel = user_ByNameAndPwd.getTel();
                address = user_ByNameAndPwd.getAddress();

            }else {
                name = user_ByTelAndPwd.getName();
                grade = Integer.toString(user_ByTelAndPwd.getGrade());
                tel = user_ByTelAndPwd.getTel();
                address = user_ByTelAndPwd.getAddress();
            }
            StringBuffer info = new StringBuffer();
            info.append(name);
            info.append("|");
            info.append(grade);
            info.append("|");
            info.append(tel);
            info.append("|");
            info.append(address);
            info.append("|");
            model.addAttribute("info", info.toString());
        }
        return "android_login_result";
    }
    @RequestMapping(value = "/suggestion")
    public void suggestion(HttpServletRequest request) throws DaoException, ServiceException{
        String content = request.getParameter("content");
        String username = request.getParameter("username");
        Suggestion suggestion = new Suggestion();
        suggestion.setContent(content);
        suggestion.setUsername(username);
        suggestionService.save(suggestion);
    }
    @RequestMapping(value = "register")
    public String register(Model model, HttpServletRequest request) throws DaoException, ServiceException{
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String tel = request.getParameter("tel");
        String address = request.getParameter("address");
        User user_ByTel = userService.findByTel(tel);
        User user_ByName = userService.findByName(name);
        if (user_ByName != null && user_ByTel != null){
            model.addAttribute("info", "用户名和手机号都已被注册");
        }else if (user_ByName != null){
            model.addAttribute("info", "用户名已被注册");
        }else if(user_ByTel != null){
            model.addAttribute("info", "手机号已被注册");
        }else {
            java.util.Date date = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            User user = new User();
            user.setName(name);
            user.setPwd(pwd);
            user.setTel(tel);
            user.setGrade(0);
            user.setDateRegister(sqlDate);
            user.setAddress(address);
            userService.save(user);
            model.addAttribute("info", "注册成功");
        }
        return "android_register_result";
    }
    @RequestMapping(value = "/goodssubmit")
    public String goodsDetails(Model model, HttpServletRequest request) throws DaoException, ServiceException{
        String goods_name = request.getParameter("goods_name");
        String goods_value = request.getParameter("goods_value");
        String goods_num = request.getParameter("goods_num");
        String goods_date_final = request.getParameter("goods_date_final");
        String goods_date_submit = request.getParameter("goods_date_submit");
        String goods_username = request.getParameter("goods_username");
        String goods_figure = request.getParameter("goods_figure");

        java.util.Date date = new java.util.Date();//今天的日期
        java.util.Date yesDate = new Date(date.getTime()- 1 * 24 * 60 * 60 * 1000);//昨天的日期
        String pat = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pat);
        String todayDate = simpleDateFormat.format(date);

//        GoodsSubmit lastGoodsSubmit = goodsSubmitService.findLastByUsername(goods_username);//得到最后一条用户信息
//        if (lastGoodsSubmit != null){
//            todayDate  = lastGoodsSubmit.getDatesubmit();
//        }
        int submitNum = goodsSubmitService.getSubmitNumByTodayDateAndUsername(todayDate, goods_username);
        if (submitNum >= 10){
            model.addAttribute("info", "亲，每天最多当10次土匪哦……");
        }else {
            GoodsSubmit goodsSubmit = new GoodsSubmit();
            goodsSubmit.setName(goods_name);
            goodsSubmit.setValue(goods_value);
            goodsSubmit.setNumber(goods_num);
            goodsSubmit.setDatefinal(goods_date_final);
            goodsSubmit.setDatesubmit(todayDate);//保存提交时间（当前系统）
            goodsSubmit.setUsername(goods_username);
            goodsSubmit.setFigure(goods_figure);
            goodsSubmitService.save(goodsSubmit);

            User user_ByTel = userService.findByTel(goods_username);
            User user_ByName = userService.findByName(goods_username);
            if (user_ByName != null){
                int grade = user_ByName.getGrade() + 1;
                userService.updateGradeByName(grade, goods_username);
            }else if (user_ByTel != null){
                int grade = user_ByTel.getGrade() + 1;
                userService.updateGradeByName(grade, goods_username);
            }
            model.addAttribute("info", "提交成功");
        }
        return "android_goodssubmit_result";
    }
    @RequestMapping(value = "/noteswin")
    public String notesWin(Model model, HttpServletRequest request) throws DaoException, ServiceException{
        String username = request.getParameter("username");
        List<UsersWin> usersWinList = new ArrayList<UsersWin>();
        if(usersWinService.findByName(username) != null){
            usersWinList = usersWinService.findByName(username);
        }else if(usersWinService.findByTel(username) != null){
            usersWinList = usersWinService.findByTel(username);
        }
        StringBuffer info = new StringBuffer();

        for (int i=0; i < usersWinList.size(); i++){
            UsersWin usersWin = new UsersWin();
            usersWin = usersWinList.get(i);
            String id = Integer.toString(usersWin.getId());
            String goodsName = usersWin.getGoodsname();
            String goodsValue = usersWin.getGoodsvalue();
            String convertDateFinal = usersWin.getConvertdatefinal();
            info.append(id);
            info.append("|");
            info.append(goodsName);
            info.append("|");
            info.append(goodsValue);
            info.append("|");
            info.append(convertDateFinal);
            info.append("|");

        }
        model.addAttribute("info", info.toString());

        return "android_noteswin_result";
    }
    @RequestMapping(value = "/updateuserinfo")
    public String updateUserInfo(Model model, HttpServletRequest request) throws DaoException, ServiceException{
        String index = request.getParameter("index");
        String username = request.getParameter("username");
        String tel = request.getParameter("tel");
        String edit = request.getParameter("edit");
        if (index.equals("1")){
            User user_ByName = userService.findByName(edit);
            if (user_ByName != null){
                model.addAttribute("info", "此用户名已被注册");
            }else {
                userService.updateUsernameByTel(edit, tel);
                model.addAttribute("info", "修改成功");
            }
        }else if (index.equals("2")){
            userService.updatePwdByUsername(edit, username);
            model.addAttribute("info", "修改成功");
        }else if (index.equals("3")){
            User user_ByTel = userService.findByTel(edit);
            if (user_ByTel != null){
                model.addAttribute("info", "此手机号已被注册");
            }else {
                userService.updateTelByUsername(edit, username);
                model.addAttribute("info", "修改成功");
            }
        }else if (index.equals("4")){
            userService.updateAddressByUsername(edit, username);
            model.addAttribute("info", "修改成功");
        }

        return "android_updateuserinfo_result";
    }
    @RequestMapping(value = "/usersforget")
    public String usersForget(Model model, HttpServletRequest request) throws DaoException, ServiceException{
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        User byNameAndTel = userService.findByNameAndTel(name, tel);
        if (byNameAndTel != null){
            userService.updatePwdByUsername("123456", name);
            model.addAttribute("info", "验证成功");
        }else {
            model.addAttribute("info", "验证失败");
        }
        return "android_userforget_result";
    }
    @RequestMapping("/getAllCity")
    public String getAllCity(Model model, HttpServletRequest request) throws DaoException{
        List<City> allCity = cityService.findAllCity("from City");
        StringBuffer info = new StringBuffer();
        for (int i=0; i<allCity.size(); i++){
            City city = new City();
            city = allCity.get(i);
            String cityenglish = city.getCityenglish();
            String citychinese = city.getCitychinese();
            info.append(cityenglish);
            info.append("|");
            info.append(citychinese);
            info.append("#");
        }
        model.addAttribute("info", info.toString());
        return "android_getallcity_result";
    }
    @RequestMapping("/getAllNotice")
    public String getAllNotice(Model model, HttpServletRequest request) throws DaoException, ServiceException{
        List<Notice> allNotice = noticeService.findAllNotice("from Notice");
        StringBuffer info = new StringBuffer();
        for (int i=0; i<allNotice.size(); i++){
            Notice notice = new Notice();
            notice = allNotice.get(i);
            String title = notice.getTitle();
            String content = notice.getContent();
            String date = notice.getDatepublish();
            info.append(title);
            info.append("|");
            info.append(content);
            info.append("|");
            info.append(date);
            info.append("#");
        }
        model.addAttribute("info", info.toString());
        return "android_getallnotice_result";
    }
    @RequestMapping("/getGoodsInfo")
    public String getGoodsInfo(Model model, HttpServletRequest request) throws DaoException, ServiceException{
        String category = request.getParameter("category");
        String locationFlag = request.getParameter("locationFlag");
        StringBuffer imageNameString = new StringBuffer();
        imageNameString.append(category);
        imageNameString.append("_");
        imageNameString.append(locationFlag);
        imageNameString.append("_1");
        String imageName = imageNameString.toString();
        GoodsInfo byImageName = goodsInfoService.findByImageName(imageName);

        StringBuffer info = new StringBuffer();
        info.append(byImageName.getGoodsname());
        info.append("|");
        info.append(byImageName.getPrice());
        info.append("|");
        info.append(byImageName.getNumber());
        info.append("|");
        info.append(byImageName.getDetail());
        info.append("|");

        String finalDate = byImageName.getDatefinal();//商品截止日期
        String currentDate;//当前日期
        java.util.Date now;
        java.util.Date date;
        SimpleDateFormat sdf;
        long l, day, hour, min, second;
        try{
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            currentDate = sdf.format(new Date());
            now = sdf.parse(currentDate);
            date = sdf.parse(finalDate);
            l = date.getTime() - now.getTime();
            day = l/(24*60*60*1000);
            hour = (l/(60*60*1000)-day*24);
            min = ((l/(60*1000))-day*24*60-hour*60);
            second = (l/1000-day*24*60*60-hour*60*60-min*60);
            if (second < 0){
                day = 0;
                hour = 0;
                min = 0;
                second = 0;
            }
            info.append(day);
            info.append("|");
            info.append(hour);
            info.append("|");
            info.append(min);
            info.append("|");
            info.append(second);
            info.append("|");
        }catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("info", info.toString());
        return "android_getgoodsinfo_result";
    }
    @RequestMapping("/getUserValue")
    public String getUserJifenAndTodayShouru(Model model, HttpServletRequest request) throws DaoException, ServiceException{
        String grade, todayValue;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user_ByTelAndPwd = userService.findByTelAndPwd(username, password);
        User user_ByNameAndPwd = userService.findByNameAndPwd(username, password);
        if(user_ByNameAndPwd == null && user_ByTelAndPwd == null){
            model.addAttribute("info", "用户名或密码错误");
        }else {
            if (user_ByNameAndPwd != null){
                grade = Integer.toString(user_ByNameAndPwd.getGrade());
            }else {
                grade = Integer.toString(user_ByTelAndPwd.getGrade());
            }
            java.util.Date date = new java.util.Date();//今天的日期
            String pat = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pat);
            String todayDate = simpleDateFormat.format(date);
            todayValue = Integer.toString(goodsSubmitService.getSubmitNumByTodayDateAndUsername(todayDate, username));
            StringBuffer info = new StringBuffer();
            info.append(grade);
            info.append("|");
            info.append(todayValue);
            info.append("|");
            model.addAttribute("info", info.toString());
        }

        return "android_uservalue_result";
    }
    @RequestMapping("/getOpenWin")
    public String getOpenWin(Model model) throws DaoException{
        java.util.Date date = new java.util.Date();
        java.util.Date yesDate = new Date(date.getTime()- 1 * 24 * 60 * 60 * 1000);//昨天的日期
        String pat = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pat);
        String yestoday = simpleDateFormat.format(yesDate);
        List<OpenWin> byHqlString = openWinService.findByDateFinal(yestoday);
        StringBuffer info = new StringBuffer();
        if (byHqlString != null) {
            for (int i = 0; i < byHqlString.size(); i++) {
                StringBuffer buffer = new StringBuffer();
                OpenWin openWin = byHqlString.get(i);
                buffer.append(openWin.getDatefinal());
                buffer.append("/");
                int a = Integer.parseInt(openWin.getFigure());//分别得到个位，十位，百位
                int b = a / 10;
                int c = b / 10;
                buffer.append(Integer.toString(c % 10));
                buffer.append("/");
                buffer.append(Integer.toString(b % 10));
                buffer.append("/");
                buffer.append(Integer.toString(a % 10));
                buffer.append("/");
                buffer.append(openWin.getPersonnumber());
                buffer.append("/");
                buffer.append(openWin.getGoodsname());
                buffer.append("/");
                buffer.append(openWin.getGoodsnumber());
                buffer.append("/");
                buffer.append(openWin.getPrice());
                buffer.append("/");
                buffer.append(openWin.getUserswin());

                info.append(buffer.toString());
                info.append("#");

            }
        }
        model.addAttribute("info", info.toString());
        return "android_getopenwin_result";
    }
    @RequestMapping("/getRecommendNum")
    public String getRecommendNum(Model model) throws DaoException{
        String hql = "from GoodsInfo g where g.imagename like 'recommend%'";
        int recommendNum = goodsInfoService.getRecommendNum(hql);
        model.addAttribute("info", recommendNum);
        return "android_recommendnum_result";
    }
    @RequestMapping("/getFreeAreaNum")
    public String getFreeAreaNum(Model model) throws DaoException{
        String hql = "from GoodsInfo g where g.imagename like 'free%'";
        int recommendNum = goodsInfoService.getRecommendNum(hql);
        model.addAttribute("info", recommendNum);
        return "android_recommendnum_result";
    }
    @RequestMapping("/getGradeAreaNum")
    public String getGradeAreaNum(Model model) throws DaoException{
        String hql = "from GoodsInfo g where g.imagename like 'grade%'";
        int recommendNum = goodsInfoService.getRecommendNum(hql);
        model.addAttribute("info", recommendNum);
        return "android_recommendnum_result";
    }
    @RequestMapping("/reduceUserValue")
    public void reduceUserValue(HttpServletRequest request) throws DaoException{
        String grade;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user_ByTelAndPwd = userService.findByTelAndPwd(username, password);
        User user_ByNameAndPwd = userService.findByNameAndPwd(username, password);
        if(user_ByNameAndPwd == null && user_ByTelAndPwd == null){

        }else {
            if (user_ByNameAndPwd != null){
                grade = Integer.toString(user_ByNameAndPwd.getGrade());
                int g = Integer.parseInt(grade) - 100;
                userService.updateGradeByName(g, username);
            }else {
                grade = Integer.toString(user_ByTelAndPwd.getGrade());
                int g = Integer.parseInt(grade) - 100;
                userService.updateGradeByTel(g, username);
            }

        }


    }

}
