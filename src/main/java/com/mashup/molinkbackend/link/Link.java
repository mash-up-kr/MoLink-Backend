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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
@EqualsAndHashCode(of = "id")
@Entity
public class Link extends BaseTimeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 50)
  private String name;

  @Column
  private String url;

  @ManyToOne
  @JoinColumn(name = "parent_id")
  private Folder folder;
}
