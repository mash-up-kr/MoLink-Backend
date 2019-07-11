package com.mashup.molinkbackend.folder;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FolderServiceImpl implements FolderService {

    private final FolderRepository folderRepository;

    @Override
    public void save(ReqSaveFolderDto folderSaveRequestDto) {
        Folder folder = Folder.builder()
                .name(folderSaveRequestDto.getName())
                .color(folderSaveRequestDto.getColor())
                .parentId(folderSaveRequestDto.getParentId())
                .build();
        folderRepository.save(folder);
    }
}
