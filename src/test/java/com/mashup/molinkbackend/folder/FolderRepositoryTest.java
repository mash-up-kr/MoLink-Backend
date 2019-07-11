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

import static org.junit.Assert.assertEquals;
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

    @Test
    public void 폴더_자기_참조() {
        folderRepository.save(Folder.builder()
                .name("폴더1")
                .color("#1111")
                .parentId(null)
                .build());
        List<Folder> folders1 = folderRepository.findAll();
        Folder folder = folders1.get(0);

        folderRepository.save(Folder.builder()
                .name("폴더2")
                .color("#2222")
                .parentId(folder.getFolderId())
                .build());
        List<Folder> folders2 = folderRepository.findAll();
        Folder folder1 = folders2.get(0);
        Folder folder2 = folders2.get(1);
        assertEquals(folder1.getFolderId(), folder2.getParentId());
    }
}
