package com.yanle.controller;

import com.yanle.entity.Resource;
import com.yanle.entity.ShiroUser;
import com.yanle.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 资源请求控制器
 *
 * @author yanle
 * @create 2017-03-01 15:28
 **/
@Controller
@RequestMapping("/resource")
public class ResourceController extends BaseController {

    @Autowired
    private IResourceService resourceService;

    /**
     * 菜单树
     * @return
     */

    @RequestMapping(value = "/tree",method = RequestMethod.POST)
    @ResponseBody
    public Object tree(){
        ShiroUser shiroUser = getShiroUser();
        return resourceService.selectTree(shiroUser);
    }

    /**
     * 资源管理页
     * @return
     */
    @RequestMapping(value = "/manager",method = RequestMethod.GET)
    public String manager(){
        return "resource";

    }

    @RequestMapping(value = "/treeGrid",method =RequestMethod.POST)
    @ResponseBody
    public Object treeGrid(){
        return resourceService.selectAll();
    }

    /**
     * 编辑资源页
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/editPage")
    public String editPage(Model model,Long id){
        Resource resource = resourceService.selectById(id);
        model.addAttribute("resource",resource);
        return "resourceEdit";
    }

    /**
     * 编辑资源
     * @param resource
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public Object edit(Resource resource){
        //选择菜单时讲openMode设置为null
        Integer type = resource.getResourceType();
        if (null != type && type==0){
            resource.setOpenMode(null);
        }
        resourceService.updateSelectiveById(resource);
        return renderSuccess("编辑成功!");
    }

    /**
     * 删除资源
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(Long id){
        resourceService.deleteById(id);
        return renderSuccess("删除成功!");
    }

    /**
     * 添加资源页
     * @return
     */
    @RequestMapping(value = "/addPage",method = RequestMethod.GET)
    public String addPage(){
        return "resourceAdd";
    }

    /**
     * 添加资源
     * @param resource
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Object add(Resource resource){
        resource.setCreateTime(new Date());
        //选择菜单时将openMode设置为null
        Integer type = resource.getResourceType();
        if (null != type && type==0){
            resource.setOpenMode(null);
        }
        resourceService.insert(resource);
        return  renderSuccess("添加成功!");
    }

    /**
     * 查询所有的菜单
     * @return
     */
    @RequestMapping("/allTree")
    @ResponseBody
    public Object allMenu(){
        return resourceService.selectAllTree();
    }

}
