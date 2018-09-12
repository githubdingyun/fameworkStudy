package cn.a52going.controller;

import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 建议使用@ExceptionHandler 来统一处理业务逻辑异常
 * 使用simple MappingEXceptionResvler统一处理系统异常
 */

@Controller
@RequestMapping("/demo")
public class ExCon {

    /**
     * @param e
     * @param request
     * @param response
     * @return view
     * 使用注解处理Controller中的特定异常
     * 当然也可以使用bean
     */
    @ExceptionHandler
    public String handlerException(Exception e, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (e instanceof NumberFormatException) {
            request.setAttribute("message", "亲，请输入数字哦！");
            return "message";
        } else if (e instanceof NullPointerException) {
            return "message";
        } else {
//            处理不了的异常扔给spring容器，容器中有配置
            throw e;
        }
    }


    @RequestMapping("test1.do")
    public String test1() {

        return "hello";
    }

    /**
     * 用来测试字符串格式异常
     *
     * @return
     */
    @RequestMapping("test2.do")
    public String test2() {
        Integer.valueOf("sdf");
        return "hello";
    }

    /**
     * 空指针会上抛到error异常
     *
     * @return
     */
    @RequestMapping("test3.do")
    public String test3() {

        String a = null;
        a.charAt(0);
        return "hello";
    }
}