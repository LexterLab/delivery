package com.tuvarna.delivery.city.controller;

import com.tuvarna.delivery.city.payload.CityDTO;
import com.tuvarna.delivery.city.service.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/cities")
@RequiredArgsConstructor
@Tag(name = "City REST APIs")
public class CityController {

    private final CityService cityService;

    @Operation(
            summary = "Cities Retrieval REST API",
            description = "Cities Retrieval REST API is used to extract every city"
    )
    @ApiResponses( value = {
            @ApiResponse( responseCode = "200", description = "Http Status 200 SUCCESS"),
            @ApiResponse( responseCode = "401", description = "Http Status 401 UNAUTHORIZED"),
            @ApiResponse( responseCode = "403", description = "Http Status 403 FORBIDDEN")
    })
    @SecurityRequirement(
            name = "Bearer Authentication"
    )
    @PreAuthorize("hasAnyRole('USER', 'COURIER')")
    @GetMapping("")
    public ResponseEntity<List<CityDTO>> retrieveAllCities() {
        return ResponseEntity.ok(cityService.getAllCities());
    }
}
