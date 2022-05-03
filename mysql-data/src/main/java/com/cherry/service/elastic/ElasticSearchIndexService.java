package com.cherry.service.elastic;

import cn.hutool.core.collection.CollectionUtil;
import com.cherry.common.dtos.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Cherry
 * @Date: 2020/12/8
 * @Desc: ElasticSearchIndexService
 */
@Slf4j
@Service
public class ElasticSearchIndexService {

    private RestHighLevelClient restHighLevelClient;

    public List<String> createIndexes(List<String> indexes) {
        if (CollectionUtil.isEmpty(indexes)) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        for (String index : indexes) {
            result.add(createIndex(index));
        }
        return result;
    }

    private String createIndex(String index) {
        //创建请求
        CreateIndexRequest request = new CreateIndexRequest(index);
        try {
            if (this.getIndex(index) == true) {
                log.info("索引创建失败，索引{}已存在", index);
                return String.format("索引创建失败，索引%s已存在！", index);
            }
            CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
            log.info("索引{}创建成功！", index);
            return String.format("索引%s创建成功！", index);
        } catch (Exception e) {
            log.error("索引{}创建失败：", index);
            log.error("索引创建失败:", e);
            return String.format("索引%s创建失败！--Exception", index);
        }
    }

    public boolean getIndex(String index) throws IOException {
        GetIndexRequest request = new GetIndexRequest(index);
        return restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
    }

    public CommonResult<String> deleteIndex(String index) {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(index);
        try {
            AcknowledgedResponse delete = restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
            log.info("索引{}删除成功！", index);
            return new CommonResult<String>().success("索引删除成功！");
        } catch (Exception e) {
            log.error("索引{}删除失败：", index);
            log.error("索引删除失败:", e);
            return new CommonResult<String>().error(e.getMessage());
        }
    }

    @Autowired
    public void setRestHighLevelClient(RestHighLevelClient restHighLevelClient) {
        this.restHighLevelClient = restHighLevelClient;
    }
}
