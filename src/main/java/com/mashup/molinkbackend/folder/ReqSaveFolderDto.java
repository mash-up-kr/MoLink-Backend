package com.mashup.molinkbackend.folder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReqSaveFolderDto {

    private String name;
    private String color;
    private Long parentId;
}
