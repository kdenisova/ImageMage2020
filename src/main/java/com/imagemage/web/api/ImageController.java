package com.imagemage.web.api;

import com.imagemage.web.api.models.ImageModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("api/img")
public class ImageController {

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ImageModel get(@PathVariable String id) {
        ImageModel imageModel = new ImageModel();
        imageModel.setId("750209350923f");
        imageModel.setUrl("https://avatars.mds.yandex.net/get-pdb/1599133/ec09bb0d-fe5a-408a-8fcb-ca3422703460/s1200");

        return imageModel;
    }
}
