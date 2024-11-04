package com.sparta.myselectshop.controller.naver;

import com.sparta.myselectshop.dto.response.ItemForm;
import com.sparta.myselectshop.service.naver.NaverApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class NaverApiController {

    private final NaverApiService naverApiService;

    @GetMapping("/search")
    public List<ItemForm> searchItems(@RequestParam String query)  {
        return naverApiService.searchItems(query);
    }
}
