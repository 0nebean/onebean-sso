package com.onebean.kepler.index;

import org.springframework.ui.Model;

public class BaseController {

    protected static final String STATIC_FILE_VERSION = "?v=1.0.1";
    protected static final String DOC_VERSION = "1.1.0.4.RELEASE";
    protected static final String DOC_MAIN_URL = "/doc/"+DOC_VERSION;
    protected static final String DOC_CONTENT_URL = "/content/"+DOC_VERSION+"/a0000";

    /**
     * 添加model基本属性
     * @param model m&v
     */
    protected void initModelAttr(Model model){
        model.addAttribute("version",STATIC_FILE_VERSION);
        model.addAttribute("doc_version",DOC_VERSION);
        model.addAttribute("doc_content_url",DOC_CONTENT_URL);
        model.addAttribute("doc_url",DOC_MAIN_URL);
    }
}
