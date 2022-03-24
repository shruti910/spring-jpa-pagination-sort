package com.pagination.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
	
	@Autowired
    private BlogRepository blogRepository;
	
	
	/*
	 * localhost:8080/getBlogPaged?size=2
	 */
    @GetMapping(value = "/getBlogPaged")
    Page<Blog> blogPageable(Pageable pageable) {
        return blogRepository.findAll(pageable);

    }
    
    /*
	 * localhost:8080/getBlogSorted?sort=blogTitle
	 */
    @GetMapping(value = "/getBlogSorted")
    Page<Blog> blogPageableSorted(Pageable pageable) {
        return blogRepository.findAll(pageable);

    }
    
    /*
	 * localhost:8080/getBlogPagedSorted?size=2&sort=blogTitle
	 */
    @GetMapping(value = "/getBlogPagedSorted")
    Page<Blog> blogPageablePagedSorted(Pageable pageable) {
        return blogRepository.findAll(pageable);

    }
    
    /*
	 * localhost:8080/getBlogs
	 */
    @GetMapping(value = "/getBlogs")
    Page<Blog> blogs() {
    	
    	/* get first page with 3 elements sorted*/
    	Pageable pageFormat = PageRequest.of(0, 3, Sort.by("blogTitle").descending());
        return blogRepository.findAll(pageFormat);

    }
    

}
