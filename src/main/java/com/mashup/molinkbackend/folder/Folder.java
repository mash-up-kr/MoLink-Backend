package com.mashup.molinkbackend.folder;

import com.mashup.molinkbackend.entity.BaseTimeEntity;
import com.mashup.molinkbackend.link.Link;
import com.mashup.molinkbackend.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Builder
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode(of = "id")
@Entity
public class Folder extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40)
    private String name;

    @Column(length = 20)
    private String color;

    // Parent Folder 필드
    @ManyToOne
    @JoinColumn(name = "parent_folder")
    private Folder parentFolder;

    @ManyToOne
    @JoinColumn(name = "user")
    @Column(name = "user_id", length = 20)
    private User user;

    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Folder> folders = new ArrayList<>();

    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Link> links = new ArrayList<>();

}
