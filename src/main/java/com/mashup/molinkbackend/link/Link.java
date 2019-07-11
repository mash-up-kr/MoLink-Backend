package com.mashup.molinkbackend.link;

import com.mashup.molinkbackend.entity.BaseTimeEntity;
import com.mashup.molinkbackend.folder.Folder;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Link extends BaseTimeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long linkId;

  @Column(length = 50)
  private String name;

  @Column
  private String url;

  @ManyToOne
  @JoinColumn(name = "folder_id")
  private Folder folder;

  @Builder
  public Link(String name, String url, Folder folder) {
    this.name = name;
    this.url = url;
    this.folder = folder;
  }
}
