package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.mapper.CategoryMapper;
import io.github.talelin.latticy.model.BookDO;
import io.github.talelin.latticy.dto.book.CreateOrUpdateBookDTO;
import io.github.talelin.latticy.model.CategoryDO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pedro@TaleLin
 */
public interface BookService {

    boolean createBook(CreateOrUpdateBookDTO validator);

    List<BookDO> getBookByKeyword(String q);

    boolean updateBook(BookDO book, CreateOrUpdateBookDTO validator);

    BookDO getById(Long id);

    List<BookDO> findAll();

    boolean deleteById(Long id);

    /**
     * <p>
     *  服务实现类
     * </p>
     *
     * @author generator@TaleLin
     * @since 2020-12-09
     */
    @Service
    class CategoryService extends ServiceImpl<CategoryMapper, CategoryDO> {
        public CategoryDO getByCategoryId(Integer id){
            CategoryDO categoryDO = this.getById(id);
    //        this.baseMappe
            System.out.println("id = " + categoryDO);
            if(categoryDO==null){
                throw new NotFoundException(20001);
            }
            return categoryDO;
        }
    }
}
