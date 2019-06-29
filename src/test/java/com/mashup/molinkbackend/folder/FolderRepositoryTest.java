package com.mashup.molinkbackend.folder;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FolderRepositoryTest {

    @Autowired
    FolderRepository folderRepository;

    @After
    public void cleanup() {
        folderRepository.deleteAll();
    }

    @Test
    @Transactional
    public void 폴더_생성() {
        //given
        LocalDateTime now = LocalDateTime.now();
        folderRepository.save(Folder.builder()
                .name("테스트 폴더 이름")
                .color("#1234")
                .parentId(null)
                .build());

        //when
        List<Folder> folders = folderRepository.findAll();

        //then
        Folder folder = folders.get(0);
        assertTrue(folder.getCreatedDate().isAfter(now));
        assertTrue(folder.getModifiedDate().isAfter(now));
    }
}
