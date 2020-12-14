package io.github.talelin.latticy.controller.v1;


import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.dto.SpuDTO;
import io.github.talelin.latticy.model.SpuDetailDO;
import io.github.talelin.latticy.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.github.talelin.latticy.model.SpuDO;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;

import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;

/**
* @author generator@TaleLin
* @since 2020-12-05
*/
@RestController
@RequestMapping("/v1/spu")
public class SpuController {

    @Autowired
    private SpuService spuService;

    @PostMapping("/create")
    public CreatedVO create(@RequestBody SpuDTO spuDTO) {
        this.spuService.ceateSpu(spuDTO);
        return new CreatedVO();
    }

    @PutMapping("/{id}")
    public UpdatedVO update(@PathVariable @Positive(message = "{id.positive}") Long id) {
        return new UpdatedVO();
    }

    @DeleteMapping("/{id}")
    public DeletedVO delete(@PathVariable @Positive(message = "{id.positive}") Long id) {
        return new DeletedVO();
    }

    @GetMapping("/{id}")
    public SpuDO get(@PathVariable(value = "id") @Positive(message = "{id.positive}") Long id) {
        return null;
    }

    /**
     * 获取spu详情 带有规格  bannerimg
     * @param id
     * @return
     */
    @GetMapping("/{id}/detail")
    public SpuDetailDO getDetail(@PathVariable(value = "id") @Positive(message = "{id.positive}") Long id) {
        // 单表查询也可以
        SpuDetailDO derail = this.spuService.getDerail(id);
        return  derail;
    }

    @GetMapping("/page")
    public PageResponseVO<SpuDO> page(
            @RequestParam(name = "count", required = false, defaultValue = "10")
            @Min(value = 1, message = "{page.count.min}")
            @Max(value = 30, message = "{page.count.max}") Long count,
            @RequestParam(name = "page", required = false, defaultValue = "0")
            @Min(value = 0, message = "{page.number.min}") Long page
    ) {
        // 从0 开始
        Page<SpuDO> objectPage = new Page<>(page,count);
        Page<SpuDO> selectPage = spuService.getBaseMapper().selectPage(objectPage, null);
//        PageUtil.build()
        return new PageResponseVO<>(selectPage.getTotal(),selectPage.getRecords(),selectPage.getCurrent(),selectPage.getSize());
    }
}
