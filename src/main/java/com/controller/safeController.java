package com.controller;



import com.impl.safeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class safeController {

    @Autowired
    private safeImpl safeimpl;
    @ResponseBody
    @RequestMapping("/safe/{id}")
    public Map<String,Object> selectSafe(@PathVariable(name = "id")Integer id)
    {

        return safeimpl.sel(id);
    }

}
