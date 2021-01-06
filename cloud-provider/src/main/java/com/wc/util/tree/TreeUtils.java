

package com.wc.util.tree;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 树形结构工具类，如：菜单、部门等
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0
 */
public class TreeUtils {

    /**
     * 根据pid，构建树节点
     */
    public static <T extends TreeNode> List<T> build(List<T> treeNodes, Long pid) {
        //pid不能为空
//        AssertUtils.isNull(pid, "pid");

        List<T> treeList = new ArrayList<>();
        for(T treeNode : treeNodes) {
            if (pid.equals(treeNode.getPid())) {
                treeList.add(findChildren(treeNodes, treeNode));
            }
        }

        return treeList;
    }

    /**
     * 查找子节点
     */
    private static <T extends TreeNode> T findChildren(List<T> treeNodes, T rootNode) {
        for(T treeNode : treeNodes) {
            if(rootNode.getId().equals(treeNode.getPid())) {
                rootNode.getChildren().add(findChildren(treeNodes, treeNode));
            }
        }
        return rootNode;
    }

    /**
     * 构建树节点
     */
    public static <T extends TreeNode> List<T> build(List<T> treeNodes) {
        List<T> result = new ArrayList<>();

        //list转map
        Map<Long, T> nodeMap = new LinkedHashMap<>(treeNodes.size());
        for(T treeNode : treeNodes){
            //key=id  value=自己本身
            nodeMap.put(treeNode.getId(), treeNode);
        }

        for(T node : nodeMap.values()) {
            //获取元素的上级组织
            T parent = nodeMap.get(node.getPid());
            //如果有上级组织将自己放入children中
            if(parent != null && !(node.getId().equals(parent.getId()))){
                parent.getChildren().add(node);
                continue;
            }
            result.add(node);
        }

        return result;
    }

    public static void main(String[] args) {
        //自测demo
        List<TestNode> testNodes=new ArrayList<>();
        TestNode testNode = new TestNode(1L,0L,"最上级");
        TestNode testNode1 = new TestNode(222L,1L,"下级1");
        TestNode testNode2 = new TestNode(333L,1L,"下级2");
        TestNode testNode3 = new TestNode(2221L,222L,"下级12");
        testNodes.add(testNode1);
        testNodes.add(testNode2);
        testNodes.add(testNode);
        testNodes.add(testNode3);

        List<TestNode> build = TreeUtils.build(testNodes);
        System.out.println(build);
    }

}
