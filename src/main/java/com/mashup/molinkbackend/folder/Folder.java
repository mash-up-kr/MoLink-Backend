package com.mashup.molinkbackend.folder;

import com.mashup.molinkbackend.entity.BaseTimeEntity;
import com.mashup.molinkbackend.link.Link;
import java.util.HashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Folder extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer folder_id;

    @Column(length = 40)
    private String name;

    @Column(length = 20)
    private String color;

    @Column(name = "parent_id")
    private Integer parentId;

    @Builder
    public Folder(String name, String color, Integer parentId) {
        this.name = name;
        this.color = color;
        this.parentId = parentId;
    }
}
