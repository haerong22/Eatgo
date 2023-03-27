package com.example.loan.controller;

import com.example.loan.dto.JudgementDto;
import com.example.loan.dto.ResponseDto;
import com.example.loan.service.JudgementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/judgements")
public class JudgementController extends AbstractController {

    private final JudgementService judgementService;

    @PostMapping
    public ResponseDto<JudgementDto.Response> create(@RequestBody JudgementDto.Request request) {
        return ok(judgementService.create(request));
    }

    @GetMapping("/{judgementId}")
    public ResponseDto<JudgementDto.Response> get(
            @PathVariable Long judgementId
    ) {
        return ok(judgementService.get(judgementId));
    }

    @GetMapping("/applications/{applicationId}")
    public ResponseDto<JudgementDto.Response> getJudgementOfApplication(
            @PathVariable Long applicationId
    ) {
        return ok(judgementService.getJudgementOfApplication(applicationId));
    }
}
