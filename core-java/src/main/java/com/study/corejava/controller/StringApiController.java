package com.study.corejava.controller;

import com.study.corejava.service.StringService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Avaruus Studios
 * @name StringApiController
 * @date 7/11/2024
 */
@Tag(name = "StringApi", description = "Core Java study APIs")
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/corejava/streampi")
public class StringApiController {

    @Autowired
    private StringService stringService;

    @Operation(
            summary = "Find the first non repeated character in a given string input",
            description = "1- Find the first non repeated character in a given string input",
            tags = { "StringApi" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping("/findRepeatedCharsCount")
    public String getRepeatedCharCount(@RequestBody String inputStr) {
        return stringService.findRepeatedStrCount(inputStr);
    }
}
