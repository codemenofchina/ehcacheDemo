package com.qiang.demo.web;

import com.qiang.demo.cache.ehcache.EhcacheUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xiaoqiang on 2017/6/27.
 */
@Controller
@RequestMapping("/ehcache")
public class EhcacheController {

    @ResponseBody
    @RequestMapping(value="addElement", method = RequestMethod.GET)
    public void addElement(Model model, String key, String value){
        System.out.println("OKdasd");
        EhcacheUtil.getInstance().put("userCache","name","qiang");
        System.out.println(EhcacheUtil.getInstance().get("userCache","name"));

        EhcacheUtil.getInstance().addCache("age");
        EhcacheUtil.getInstance().removeCache("age");
    }
}
