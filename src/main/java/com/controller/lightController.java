package com.controller;

import com.impl.lightImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class lightController {

@Autowired
    private lightImpl lightimpl;


      @RequestMapping("/light/{id}")
      @ResponseBody
       public Map<String,Object> checkLight(@PathVariable int id)
      {

          return lightimpl.checkLight(id);

      }

    @RequestMapping("/updatelight/{belongto}/{switch}/{luminance}/{men}/{chuanglian}")
    @ResponseBody
    public Map<String,Object>updateLight(@PathVariable("belongto") int belongto,@PathVariable("switch") int s,
                                         @PathVariable("luminance") int luminance,
                                         @PathVariable("men") int men,
                                         @PathVariable("chuanglian") int chuanglian)
    {

        return lightimpl.updateLight(belongto,s,luminance,men,chuanglian);

    }

}
