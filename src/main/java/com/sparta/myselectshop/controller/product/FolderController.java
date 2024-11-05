package com.sparta.myselectshop.controller.product;

import com.sparta.myselectshop.dto.request.FolderRequestDto;
import com.sparta.myselectshop.security.userdetails.UserDetailsImpl;
import com.sparta.myselectshop.service.product.FolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class FolderController {

    private final FolderService folderService;

    @PostMapping("/folders")
    public void addFolders(@RequestBody FolderRequestDto dto,
                           @AuthenticationPrincipal UserDetailsImpl userDetails) {

        List<String> folderNames = dto.getFolderNames();
        folderService.addFolder(folderNames, userDetails.getUser());

    }

}
