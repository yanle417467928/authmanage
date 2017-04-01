package com.yanle.mapper;

import com.yanle.entity.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  @author yanle
 */
@Mapper
public interface ResourceMapper {

    List<Resource> selectByResourceType( @Param("resourceType")Integer resourceType);

    List<Resource> selectAll();

    Resource selectById(Long id);

    void updateResource(Resource resource);

    void deleteById(Long id);

    void insert(Resource resource);
}
