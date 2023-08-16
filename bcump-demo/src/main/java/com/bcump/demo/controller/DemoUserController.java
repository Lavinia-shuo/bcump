package com.bcump.demo.controller;

import com.bcump.common.annotation.Anonymous;
import com.bcump.common.constant.UserConstants;
import com.bcump.common.core.controller.BaseController;
import com.bcump.common.core.domain.AjaxResult;
import com.bcump.common.core.page.TableDataInfo;
import com.bcump.common.utils.SecurityUtils;
import com.bcump.demo.domain.DemoUser;
import com.bcump.demo.service.DemoUserService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/demo/user")
public class DemoUserController extends BaseController {

    private final DemoUserService demoUserService;

    /**
     * 新增用户
     * @param demoUser
     * @return
     */
    @Anonymous
    @PostMapping("/add")
    public AjaxResult add(@Validated @RequestBody DemoUser demoUser){
        if(UserConstants.NOT_UNIQUE.equals(demoUserService.checkNumberUnique(demoUser))){
            return AjaxResult.error("新增用户'" + demoUser.getName() + "'失败，身份证号已存在");
        }
        demoUser.setPassword(SecurityUtils.encryptPassword(demoUser.getPassword()));
        return toAjax(demoUserService.add(demoUser));
    }

    /**
     * 修改用户
     * @param demoUser
     * @return
     */
    @Anonymous
    @PutMapping("/update")
    public AjaxResult update(@Validated @RequestBody DemoUser demoUser)
    {
        if (UserConstants.NOT_UNIQUE.equals(demoUserService.checkNumberUnique(demoUser))) {
            return AjaxResult.error("修改用户'" + demoUser.getName() + "'失败，身份证号已存在");
        }
        return toAjax(demoUserService.updateUser(demoUser));
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @Anonymous
    @DeleteMapping("/{userId}")
    public AjaxResult remove(@PathVariable Long userId) {
        return toAjax(demoUserService.deleteUserById(userId));
    }

    /**
     * 根据条件分页查询用户列表
     * @param demoUser
     * @return
     */
    @Anonymous
    @GetMapping("/list")
    public TableDataInfo list(DemoUser demoUser)
    {
        startPage();
        List<DemoUser> list = demoUserService.selectUserList(demoUser);
        return getDataTable(list);
    }



//    /**
//     * 分页查询所有用户信息
//     * @param pageNum
//     * @param pageSize
//     * @return
//     */
//    @Anonymous
//    @GetMapping("/list/{pageNum}/{pageSize}")
//    public AjaxResult findAll(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize){
//        if(pageNum == null || pageNum <= 0){
//            pageNum = 1;    //若当前页面为空，设置当前页面为1
//        }
//        if(pageSize == null || pageSize <= 0){
//            pageSize = 3;   //若每页条数为空，设置每页条数为3
//        }
//        PageResult pageResult = demoUserService.findAll(pageNum, pageSize);
//        return AjaxResult.success(pageResult);
//    }
}
