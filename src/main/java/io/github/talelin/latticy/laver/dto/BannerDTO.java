package io.github.talelin.latticy.laver.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class BannerDTO {

    @NotBlank
    @Length(min=2,max=20,message = "Banner")
    private String name;

    @Length(min=2,max = 30)
    private String title;

    @Length(min=2,max=256)
    private String img;

    @Length(min=2,max=256)
    private String description;


}
