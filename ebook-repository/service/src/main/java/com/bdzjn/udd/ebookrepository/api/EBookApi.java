package com.bdzjn.udd.ebookrepository.api;

import com.bdzjn.udd.ebookrepository.dto.EBookDTO;
import com.bdzjn.udd.ebookrepository.dto.SearchDTO;
import com.bdzjn.udd.ebookrepository.dto.SearchHitDTO;
import com.bdzjn.udd.ebookrepository.dto.mapper.EBookMapper;
import com.bdzjn.udd.ebookrepository.model.EBook;
import com.bdzjn.udd.ebookrepository.service.EBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/books")
@CrossOrigin("http://localhost:8081")
public class EBookApi {

    @Autowired
    private EBookService eBookService;

    @Autowired
    private EBookMapper eBookMapper;

    @PostMapping("")
    public ResponseEntity save(@RequestBody EBookDTO eBookDTO) {
        EBook eBook = eBookMapper.toEBook(eBookDTO);
        eBookService.save(eBook);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("upload")
    public ResponseEntity uploadEBook(@RequestParam("file")MultipartFile multipartFile) {
        String originalFileName = multipartFile.getOriginalFilename();

        EBook ebook = null;
        File storedFile = eBookService.storeFile(multipartFile);
        ebook = eBookService.getMetadata(storedFile);
        return new ResponseEntity<>(ebook, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity getAll() {
        List<EBook> ebookList  = eBookService.findAll();
        List<EBookDTO> eBookDTOList = ebookList
                .stream()
                .map(eBookMapper::toEBookDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(eBookDTOList, HttpStatus.OK);
    }

    @PostMapping("search")
    public ResponseEntity search(@RequestBody SearchDTO searchDTO) {
        List<SearchHitDTO> eBookDTOList = eBookService.search(searchDTO);
        return new ResponseEntity<>(eBookDTOList, HttpStatus.OK);
    }

    @GetMapping("/download/{fileName:.+}")
    public ResponseEntity downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        Optional<Resource> resource = eBookService.loadBookAsResource(fileName);
        String contentType="application/pdf";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.get().getFilename() + "\"")
                .body(resource);
    }

}
