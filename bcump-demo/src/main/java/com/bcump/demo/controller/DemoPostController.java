package com.bcump.demo.controller;

import com.bcump.common.annotation.Anonymous;
import com.bcump.common.constant.UserConstants;
import com.bcump.common.core.controller.BaseController;
import com.bcump.common.core.domain.AjaxResult;
import com.bcump.common.utils.SecurityUtils;
import com.bcump.demo.domain.DemoPost;
import com.bcump.demo.domain.DemoUser;
import com.bcump.demo.service.DemoPostService;
import com.bcump.demo.service.DemoUserService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Anonymous
@RestController
@AllArgsConstructor
@RequestMapping("/demo/post")
public class DemoPostController extends BaseController {

    private final DemoPostService demoPostService;

    /**
     * 新增岗位
     * @param demoPost
     * @return
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody DemoPost demoPost){
        return toAjax(demoPostService.addPost(demoPost));
    }

    /**
     * 根据id查询岗位信息
     * @param postId
     * @return
     */
    @GetMapping("/{postId}")
    public AjaxResult selectPostById(@PathVariable Long postId){
        return AjaxResult.success(demoPostService.selectPostById(postId));
    }

    /**
     * 更新岗位信息
     * @param demoPost
     * @return
     */
    @PutMapping("/update")
    public AjaxResult update(@RequestBody DemoPost demoPost) {
        return toAjax(demoPostService.updatePost(demoPost));
    }

    /**
     * 根据id删除岗位
     * @param postId
     * @return
     */
    @DeleteMapping("/{postId}")
    public AjaxResult remove(@PathVariable Long postId){
        return toAjax(demoPostService.deletePostById(postId));
    }

}
