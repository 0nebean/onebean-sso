package com.onebean.kepler.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 统一异常处理类
 * @author 0neBean
 */
@RequestMapping("error")
@Controller
public class ErrorController extends BaseController{

    @RequestMapping("403")
    public String page_403(Model model){
        initModelAttr(model);
        model.addAttribute("code","403");
        return "/error/error";
    }

    @RequestMapping("404")
    public String page_404(Model model){
        initModelAttr(model);
        model.addAttribute("code","404");
        return "/error/error";
    }

    @RequestMapping("500")
    public String page_500(Model model){
        initModelAttr(model);
        model.addAttribute("code","500");
        return "/error/error";
    }

    @RequestMapping("400")
    public String page_400(Model model){
        initModelAttr(model);
        model.addAttribute("code","400");
        return "/error/error";
    }

    @RequestMapping("401")
    public String page_401(Model model){
        initModelAttr(model);
        model.addAttribute("code","401");
        return "/error/error";
    }

    @RequestMapping("408")
    public String page_408(Model model){
        initModelAttr(model);
        model.addAttribute("code","408");
        return "/error/error";
    }

    @RequestMapping("518")
    public String page_518(Model model){
        initModelAttr(model);
        model.addAttribute("code","518");
        return "/error/error";
    }

    @RequestMapping("501")
    public String page_501(Model model){
        initModelAttr(model);
        model.addAttribute("code","501");
        return "/error/error";
    }

}
