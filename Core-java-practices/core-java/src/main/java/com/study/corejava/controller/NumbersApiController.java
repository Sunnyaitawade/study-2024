package com.study.corejava.controller;/**
 * @name NumbersApiController
 * @author NSA Studios
 * @date 8/24/2024
 */

import com.study.corejava.service.NumberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @name NumbersApiController
 * @author NSA Studios
 * @date 8/24/2024
 */
@Tag(name = "NumberApi", description = "Core Java study APIs for numbers using java 8")
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/corejava/streampi")
public class NumbersApiController {

    @Autowired
    private   NumberService numberService;

    @Operation(
            summary = "Check if a list of integers contains a prime number using Java streams",
            description = "1- Check if a list of integers contains a prime number using Java streams",
            tags = { "NumberApi" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ArrayList.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping("/findPrimeNumbers")
    public List<Integer> getPrimeNumbers(@RequestBody Integer inputNumber) {

       return numberService.getPrimeNumbers(inputNumber);

    }



}
