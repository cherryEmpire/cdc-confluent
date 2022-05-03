package com.cherry.controller;

import com.cherry.common.dtos.CommonResult;
import com.cherry.dtos.ELKDocumentDto;
import com.cherry.service.elastic.ElasticSearchDocumentService;
import com.cherry.service.elastic.ElasticSearchIndexService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @Author : 翁鑫豪
 * @Date : 2022/2/2 18:48
 * @Description: ElasticSearchController
 */
@RestController
@RequestMapping({"/elk"})
public class ElasticSearchController {

    @Autowired
    private ElasticSearchIndexService elasticSearchIndexService;

    @Autowired
    private ElasticSearchDocumentService elasticSearchDocumentService;


    @RequestMapping(value = {"/index"}, method = {RequestMethod.POST})
    public CommonResult<String> createIndex(@RequestBody List<String> indexes) {
        List<String> result = elasticSearchIndexService.createIndexes(indexes);
        return CommonResult.succeed(result);
    }

    @RequestMapping(value = {"/index/{index}"}, method = {RequestMethod.GET})
    public CommonResult<String> getIndex(@PathVariable("index") String index) throws IOException {
        boolean exists = elasticSearchIndexService.getIndex(index);
        return CommonResult.succeed(exists);
    }

    @RequestMapping(value = {"/index/{index}"}, method = {RequestMethod.DELETE})
    public CommonResult<String> deleteIndex(@PathVariable("index") String index) {
        return elasticSearchIndexService.deleteIndex(index);
    }

    @RequestMapping(value = {"/document/list/{index}"}, method = {RequestMethod.GET})
    public CommonResult<String> createDocument(@PathVariable("index") String index) {
        return elasticSearchDocumentService.listDocuments(index);
    }

    @RequestMapping(value = {"/document"}, method = {RequestMethod.POST})
    public CommonResult<String> createDocument(@RequestBody ELKDocumentDto documentVo) throws JsonProcessingException {
        return elasticSearchDocumentService.createDocument(documentVo);
    }

    @RequestMapping(value = {"/document"}, method = {RequestMethod.PUT})
    public CommonResult<String> updateDocument(@RequestBody ELKDocumentDto documentVo) throws JsonProcessingException {
        return elasticSearchDocumentService.updateDocument(documentVo);
    }

    @RequestMapping(value = {"/document/{index}/{docId}"}, method = {RequestMethod.GET})
    public CommonResult<String> getDocument(@PathVariable("index") String index, @PathVariable("docId") String docId) {
        return elasticSearchDocumentService.getDocument(index, docId);
    }

    @RequestMapping(value = {"/document/{index}"}, method = {RequestMethod.DELETE})
    public CommonResult<String> deleteDocument(@PathVariable("index") String index) {
        return elasticSearchDocumentService.deleteDocument(index);
    }
}
