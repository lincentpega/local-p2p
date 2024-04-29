package com.lincentpega.localp2p.asset.api;

import com.lincentpega.localp2p.asset.domain.Asset;
import com.lincentpega.localp2p.asset.application.AssetService;
import com.lincentpega.localp2p.api.ErrorResponse;
import com.lincentpega.localp2p.exceptions.AlreadyExistsException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;


@RestController
@RequestMapping("/api/assets")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping
    public ResponseEntity<?> getAssets() {
        return ResponseEntity.ok(assetService.getAssets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAsset(@PathVariable("id") Long id) {
        Optional<Asset> asset = assetService.getAssetById(id);
        return asset.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createAsset(@Valid @RequestBody CreateAssetRequest asset) {
        Asset savedAsset = assetService.saveAsset(new Asset(asset.getName()));
        URI location = getUri(savedAsset);
        return ResponseEntity.created(location).build();
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<?> handleAlreadyExistsException() {
        return ResponseEntity.badRequest().body(new ErrorResponse("Asset already exists"));
    }

    private static URI getUri(Asset savedAsset) {
        return MvcUriComponentsBuilder.fromMethodCall(
                        on(AssetController.class).getAsset(savedAsset.getId())
                ).build()
                .toUri();
    }
}
