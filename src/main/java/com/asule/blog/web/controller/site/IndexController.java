package com.asule.blog.web.controller.site;

import com.asule.blog.base.lang.Consts;
import com.asule.blog.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * created by asule on 2020-04-25 19:15
 */
@Controller
public class IndexController extends BaseController {

    @RequestMapping(value= {"/", "/index"})
    public String root(ModelMap model, HttpServletRequest request) {
        String order = ServletRequestUtils.getStringParameter(request, "order", Consts.order.NEWEST);
        int pageNo = ServletRequestUtils.getIntParameter(request, "pageNo", 1);

        model.put("order", order);
        model.put("pageNo", pageNo);
        model.put("welcome","阿苏勒");
        return view(Views.INDEX);
    }


}
