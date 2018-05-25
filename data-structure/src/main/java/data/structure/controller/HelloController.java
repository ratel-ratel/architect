package data.structure.controller;


import data.structure.utils.BackResponseUtil;
import data.structure.utils.BaseResponse;
import data.structure.utils.ReturnCodeEnum;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 * 短链生成控制器
 * </p>
 *
 * @author wangliang
 * @since 2017/8/31
 */
@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/hello")
public class HelloController extends BaseController {


    @RequestMapping(value = "/hello")
    @ResponseBody
    public BaseResponse hello() {
        BaseResponse baseResponse = BackResponseUtil.getBaseResponse(ReturnCodeEnum.CODE_1000.getCode());
        baseResponse.setDataInfo("hello");
        return baseResponse;
    }
}
