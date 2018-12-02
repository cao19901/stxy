package com.bootdo.clouddocommon.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class RouterDTO implements Serializable {
    private String path;
    private String component;
    private Long id;
    private String name;

    private String redirect;

    private boolean leaf;
    private boolean menuShow;
    private Long parentId;
    private String iconCls;
    List<RouterDTO> children;


    public static List<RouterDTO> buildList(List<RouterDTO> nodes, Long idParam) {
        if (nodes == null) {
            return null;
        }
        List<RouterDTO> topNodes = new ArrayList<RouterDTO>();
        for (RouterDTO child : nodes) {
            Long pid = child.getParentId();
            if (pid == null || idParam == pid) {
                topNodes.add(child);
                continue;
            }
            for (RouterDTO parent : nodes) {
                Long id = parent.getId();
                if (id != null && id.equals(pid)) {
                    parent.getChildren().add(child);



                    continue;
                } else {

                }
            }
        }
        return topNodes;
    }
}
