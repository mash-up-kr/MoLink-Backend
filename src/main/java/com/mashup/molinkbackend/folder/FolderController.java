package com.mashup.molinkbackend.folder;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class FolderController {

    private final FolderService folderService;

    @PostMapping("/folders/new")
    public ResponseEntity<Void> saveFolder(@RequestBody ReqSaveFolderDto folderSaveRequestDto) {
        folderService.save(folderSaveRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
