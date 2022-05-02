package lab3;
import java.util.*;

public class FindSum {
static class Node{
	int nodeData;
	Node leftNode,rightNode;
};
static Node NewNode(int nodeData) {
	Node temp = new Node();
	temp.nodeData = nodeData;
	temp.leftNode = null;
	temp.rightNode = null;
	return temp;
}
public Node insert(Node root, int key) {
	if(root==null)
		return NewNode(key);
	if(key<root.nodeData)
		root.leftNode = insert(root.leftNode,key);
	else
		root.rightNode =insert(root.rightNode,key);
	return root;
}
public boolean findpairutil(Node root,int sum,HashSet<Integer>set) {
	if(root ==null)
		return false;
	if(findpairutil(root.leftNode,sum,set))
		return true;
	if(set.contains(sum-root.nodeData)) {
		System.out.println("pair is found ("+(sum - root.nodeData)+","+root.nodeData + ")");	
		return true;
//		set.add(root.nodeData);
}else
		set.add(root.nodeData);
	return findpairutil(root.rightNode,sum,set);
}
public void findPairWithGivenSum( Node root, int sum) {
	HashSet<Integer>set = new HashSet<Integer>();
	if(!findpairutil(root,sum,set))
		System.out.println("Pair donot exist" +"\n");

}
public static void main(String[]args) {
	Node root = null;
	FindSum findSP = new FindSum();
	root = findSP.insert(root, 40);
	root = findSP.insert(root, 20);
	root = findSP.insert(root, 60);
	root = findSP.insert(root, 10);
	root = findSP.insert(root, 30);
	root = findSP.insert(root, 50);
	root = findSP.insert(root, 70);
	int sum =60;
	findSP.findPairWithGivenSum(root, sum);
}
}
