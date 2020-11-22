package io.github.talelin.latticy.dto.banner;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class UpdateBanner {

    @NotBlank
    @Length(min = 2,max = 20)
    private String name;
    @Length(min = 2,max = 20)
    private String description;
    @Length(min = 2,max = 20)
    private String title;
    @Length(min = 2,max = 256)
    private String img;
}
