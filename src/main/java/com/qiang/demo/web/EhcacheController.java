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
        EhcacheUtil.getInstance().put("userCache","name","qiang");//会触发 cacheEvent的 put 事件
        System.out.println(EhcacheUtil.getInstance().get("userCache","name"));//会触发 cacheEvent的 get 事件

        EhcacheUtil.getInstance().addCache("age");//会触发 cacheManagerEvent的 add 事件
        EhcacheUtil.getInstance().removeCache("age");//会触发 cacheManagerEvent的 remove 事件
    }
}
