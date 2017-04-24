package com.yanle.controller;

import com.yanle.entity.PageInfo;
import com.yanle.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 角色请求控制器
 *
 * @author yanle
 * @create 2017-03-06 11:03
 **/
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

    @Autowired
    private IRoleService roleService;
    /**
     *  角色管理页
     * @return
     */
    @RequestMapping(value = "/manager",method = RequestMethod.GET)
    public String manager(){
        return "role";
    }

    @RequestMapping("/dataGrid")
    @ResponseBody
    public Object dataGrid(Integer page,Integer rows,String sort,String order){
        PageInfo pageInfo = new PageInfo(page,rows,sort,order);
        Map<String,Object> condition = new HashMap<String,Object>();
        pageInfo.setCondition(condition);
        roleService.selectDataGrid(pageInfo);
        return pageInfo;
    }

    @GetMapping("/addPage")
    public String addPage(){
        return "roleAdd";
    }


}
