package com.onebean.kepler.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 网站入口servlet
 * @author 0neBean
 */
@Controller
public class MainController extends BaseController{



    /**
     * 网站首页
     * @param model m&v
     * @return page
     */
    @RequestMapping({"","index"})
    public String page(Model model){
        initModelAttr(model);
        return "index";
    }


    /**
     * 文档详情页
     * @param version 版本
     * @param path 资源地址
     * @param model m&v
     * @return page
     */
    @RequestMapping("/content/{version}/{path}")
    public String content(@PathVariable("version")String version,@PathVariable("path")String path,Model model){
        initModelAttr(model);
        return "doc"+"/"+version+"/content/"+path;
    }

    /**
     * 文档入口
     * @param version 版本
     * @param model m&v
     * @return page
     */
    @RequestMapping("/doc/{version}/{path}")
    public String doc(@PathVariable("version")String version,@PathVariable("path")String path,Model model){
        initModelAttr(model);
        model.addAttribute("doc_version",DOC_VERSION);
        model.addAttribute("doc_content_url","/content/"+DOC_VERSION+"/"+path);
        return "doc"+"/"+version+"/main/main";
    }

    /**
     * 文档入口
     * @param version 版本
     * @param model m&v
     * @return page
     */
    @RequestMapping("/doc/{version}")
    public String doc(@PathVariable("version")String version,Model model){
        initModelAttr(model);
        version = (version.contains("RELEASE"))?version:version+".RELEASE";
        return "doc"+"/"+version+"/main/main";
    }

    /**
     * 文档头资源
     * @param path 资源地址
     * @return page
     */
    @RequestMapping("{version}/header/{path}")
    public String header(@PathVariable("version")String version,@PathVariable("path")String path){
        return "doc/"+version+"/header/"+path;
    }

    /**
     * demo
     * @return page
     */
    @RequestMapping("/demo")
    public String demo(){
        return "demo/demo";
    }

}
