package com.springapp.controller;

import com.springapp.domain.City;
import com.springapp.domain.GoodsInfo;
import com.springapp.exception.DaoException;
import com.springapp.exception.ServiceException;
import com.springapp.services.CityService;
import com.springapp.services.GoodsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/images")
public class AndroidImageController {
    @Autowired
    public GoodsInfoService goodsInfoService;
    @Autowired
    public CityService cityService;
    @RequestMapping(value = "/homeviewpager")
    public String manageHomeViewpagerImage(Model model) throws DaoException, ServiceException{
        List<GoodsInfo> allGoodsInfo = goodsInfoService.findAllGoodsInfo("from GoodsInfo where id between 1 and 5");
        model.addAttribute("allGoodsInfo", allGoodsInfo);
        return "uploadHomeViewpager";
    }
    @RequestMapping(value = "/homeblock")
    public String manageHomeBlockImage(Model model) throws DaoException{
        List<City> allCity = cityService.findAllCity("from City");
        model.addAttribute("allCity", allCity);
        model.addAttribute("city", "chengdu");
        return "uploadHomeBlock";
    }
    @RequestMapping(value = "/showHomeBlock")
    public String showHomeBlock(Model model, HttpServletRequest request) throws IOException,DaoException {
        List<City> allCity = cityService.findAllCity("from City");
        model.addAttribute("allCity", allCity);
        model.addAttribute("city", request.getParameter("cityname"));
        return "uploadHomeBlock";
    }
    @RequestMapping(value = "/recommend")
    public String manageRecommendImage(Model model) throws DaoException, ServiceException{
        List<GoodsInfo> allGoodsInfo = goodsInfoService.findAllGoodsInfo("from GoodsInfo where id between 6 and 13");
        model.addAttribute("allGoodsInfo", allGoodsInfo);
        return "uploadRecommend";
    }
    @RequestMapping(value = "/city")
    public String manageCity(Model model) throws IOException,DaoException{
        List<City> allCity = cityService.findAllCity("from City");
        model.addAttribute("allCity", allCity);
        return "uploadCity";
    }
    @RequestMapping(value = "/blockgoods")
    public String manageBlockGoodsInfo(Model model) throws DaoException{
        List<City> allCity = cityService.findAllCity("from City");
        model.addAttribute("allCity", allCity);
        model.addAttribute("city", "chengdu");
        model.addAttribute("block", "homeblock1");
        return "uploadHomeBlockGoods";
    }
    @RequestMapping(value = "/showBlockGoods")
    public String showBlockGoods(Model model, HttpServletRequest request) throws IOException,DaoException {
        List<City> allCity = cityService.findAllCity("from City");
        model.addAttribute("allCity", allCity);
        model.addAttribute("city", request.getParameter("cityname"));
        model.addAttribute("block", request.getParameter("blockname"));
        return "uploadHomeBlockGoods";
    }
    @RequestMapping(value = "/doHomeViewpagerUpload")
    public String uploadHomeViewpagerImage(@RequestParam("file1")MultipartFile file1, @RequestParam("file2")MultipartFile file2,
                  @RequestParam("file3")MultipartFile file3, HttpServletRequest request) throws IOException,DaoException,ServiceException {
        //得到服务器的根路径
        String rootPath = request.getSession().getServletContext().getRealPath("/");

        String imagename = request.getParameter("imagename");
        String goodsname = request.getParameter("goodsname");
        String price = request.getParameter("price");
        String number = request.getParameter("number");
        String detail = request.getParameter("detail");
        String datefinal = request.getParameter("datefinal");
        String city = request.getParameter("city");
        goodsInfoService.updateGoodsInfo(imagename, goodsname, price, number, detail, datefinal, city);

        if(!file1.isEmpty()){
            file1.transferTo(new File(rootPath + "/resources/homeviewpager/" + file1.getOriginalFilename()));
        }
        if(!file2.isEmpty()){
            file2.transferTo(new File(rootPath + "/resources/homeviewpager/" + file2.getOriginalFilename()));
        }
        if(!file3.isEmpty()){
            file3.transferTo(new File(rootPath + "/resources/homeviewpager/" + file3.getOriginalFilename()));
        }

        return "uploadSuccess";
    }
    @RequestMapping(value = "/doHomeBlockUpload")
    public String uploadHomeBlockImage(@RequestParam("file")MultipartFile file, HttpServletRequest request) throws IOException {
        String cityHidden = request.getParameter("cityHidden");
        if(!file.isEmpty()){
            //得到服务器的根路径
            String rootPath = request.getSession().getServletContext().getRealPath("/");
            file.transferTo(new File(rootPath + "/resources/" + cityHidden +"/homeblock/" + file.getOriginalFilename()));
            return "uploadSuccess";
        }else {
            return "uploadFail";
        }
    }
    @RequestMapping(value = "/doRecommendUpload")
     public String uploadRecommendImage(@RequestParam("file1")MultipartFile file1, @RequestParam("file2")MultipartFile file2,
                                            @RequestParam("file3")MultipartFile file3, HttpServletRequest request) throws IOException,DaoException,ServiceException {
        //得到服务器的根路径
        String rootPath = request.getSession().getServletContext().getRealPath("/");

        String imagename = request.getParameter("imagename");
        String goodsname = request.getParameter("goodsname");
        String price = request.getParameter("price");
        String number = request.getParameter("number");
        String detail = request.getParameter("detail");
        String datefinal = request.getParameter("datefinal");
        String city = request.getParameter("city");
        goodsInfoService.updateGoodsInfo(imagename, goodsname, price, number, detail, datefinal, city);

        if(!file1.isEmpty()){
            file1.transferTo(new File(rootPath + "/resources/recommend/" + file1.getOriginalFilename()));
        }
        if(!file2.isEmpty()){
            file2.transferTo(new File(rootPath + "/resources/recommend/" + file2.getOriginalFilename()));
        }
        if(!file3.isEmpty()){
            file3.transferTo(new File(rootPath + "/resources/recommend/" + file3.getOriginalFilename()));
        }

        return "uploadSuccess";
    }
    @RequestMapping(value = "/doCity")
    public String uploadCity(Model model, HttpServletRequest request) throws IOException, DaoException {
        String hidden = request.getParameter("hid");
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        if (hidden.equals("insert")){
            String englishName = request.getParameter("englishName");
            String chineseName = request.getParameter("chineseName");
            List<City> cityByCityEnglish = cityService.findCityByCityEnglish("from City c where c.cityenglish='" + englishName + "'");
            if (cityByCityEnglish.isEmpty()){
                City city = new City();
                city.setCityenglish(englishName);
                city.setCitychinese(chineseName);
                cityService.save(city);
                File newCity = new File(rootPath + "resources" + File.separator + englishName );
                File newCity0 = new File(rootPath + "resources" + File.separator + englishName + File.separator + "homeblock");
                File newCity1 = new File(rootPath + "resources" + File.separator + englishName + File.separator + "homeblock1");
                File newCity2 = new File(rootPath + "resources" + File.separator + englishName + File.separator + "homeblock2");
                File newCity3 = new File(rootPath + "resources" + File.separator + englishName + File.separator + "homeblock3");
                File newCity4 = new File(rootPath + "resources" + File.separator + englishName + File.separator + "homeblock4");
                File newCity5 = new File(rootPath + "resources" + File.separator + englishName + File.separator + "homeblock5");
                File newCity6 = new File(rootPath + "resources" + File.separator + englishName + File.separator + "homeblock6");
                File newCity7 = new File(rootPath + "resources" + File.separator + englishName + File.separator + "homeblock7");
                File newCity8 = new File(rootPath + "resources" + File.separator + englishName + File.separator + "homeblock8");
                File newCityFile[] = {newCity, newCity0, newCity1, newCity2, newCity3, newCity4, newCity5,  newCity6, newCity7, newCity8};
                for (int i=0; i<newCityFile.length; i++){
                    newCityFile[i].mkdir();
                }

                model.addAttribute("msg", "添加成功！");
            }else {
                model.addAttribute("msg", "此城市已有，不能重复添加！");
            }

        }else if(hidden.equals("delete")){
            model.addAttribute("msg", "暂未开放权限！");
        }else if(hidden.equals("update")){
            String cityName = request.getParameter("cityname");
            int id = cityService.findIdByEnglishName(cityName);
            String englishName = request.getParameter("englishName");
            String chineseName = request.getParameter("chineseName");
            City city = new City();
            city.setId(id);
            city.setCityenglish(englishName);
            city.setCitychinese(chineseName);
            cityService.update(city);
            model.addAttribute("msg", "修改成功！");
        }
        return "showResult";
    }
    @RequestMapping(value = "/doBlockGoodsUpload")
    public String uploadBlockGoodsImage(@RequestParam("file1")MultipartFile file1, @RequestParam("file2")MultipartFile file2,
                                       @RequestParam("file3")MultipartFile file3, HttpServletRequest request) throws IOException,DaoException,ServiceException {
        //得到服务器的根路径
        String rootPath = request.getSession().getServletContext().getRealPath("/");

        String blockname_update = request.getParameter("blockname_update");
        String imagename_update = request.getParameter("imagename_update");

        String imagename = blockname_update + imagename_update;
        String goodsname = request.getParameter("goodsname");
        String price = request.getParameter("price");
        String number = request.getParameter("number");
        String detail = request.getParameter("detail");
        String datefinal = request.getParameter("datefinal");
        String city = request.getParameter("city_update");
        if (goodsInfoService.findByImageName(imagename)==null){
            GoodsInfo goodsInfo = new GoodsInfo();
            goodsInfo.setImagename(imagename);
            goodsInfo.setGoodsname(goodsname);
            goodsInfo.setPrice(price);
            goodsInfo.setNumber(number);
            goodsInfo.setDetail(detail);
            goodsInfo.setDatefinal(datefinal);
            goodsInfo.setCity(city);
            goodsInfoService.insertGoodsInfo(goodsInfo);
        }else {
            goodsInfoService.updateGoodsInfo(imagename, goodsname, price, number, detail, datefinal, city);
        }
        if(!file1.isEmpty()){
            file1.transferTo(new File(rootPath + "/resources/" + city + "/" + blockname_update + "/" + file1.getOriginalFilename()));
        }
        if(!file2.isEmpty()){
            file2.transferTo(new File(rootPath + "/resources/" + city + "/" + blockname_update + "/" + file2.getOriginalFilename()));
        }
        if(!file3.isEmpty()){
            file3.transferTo(new File(rootPath + "/resources/" + city + "/" + blockname_update + "/" + file3.getOriginalFilename()));
        }

        return "uploadSuccess";
    }
    @RequestMapping(value = "/doGoodsInfo")
    public String uploadGoodsInfo(@RequestParam("file")MultipartFile file, HttpServletRequest request) throws IOException {
        if(!file.isEmpty()){
            //得到服务器的根路径
            String rootPath = request.getSession().getServletContext().getRealPath("/");
            file.transferTo(new File(rootPath + "/resources/xml/" + file.getOriginalFilename()));
            return "uploadSuccess";
        }else {
            return "uploadFail";
        }
    }
}
