import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Function;

public class TreeTraversals {

    static <E extends Comparable<E>> List<E> preOrderList(BinaryTree<E> tree) {
        if(tree.isEmpty()){
            return new ArrayList<>();
        }
        else{
            try {
                List<E> result = new ArrayList<>();
                result.add(tree.getData());
                result.addAll(preOrderList(tree.getLeftBT()));
                result.addAll(preOrderList(tree.getRightBT()));
                return result;
            } catch (EmptyTreeE emptyTreeE) {
                throw new RuntimeException(emptyTreeE);
            }
        }
    }

    static <E extends Comparable<E>> List<E> inOrderList(BinaryTree<E> tree) {
        if(tree.isEmpty()){
            return new ArrayList<>();
        }
        else{
            try {
                List<E> result = new ArrayList<>(inOrderList(tree.getLeftBT()));
                result.add(tree.getData());
                result.addAll(inOrderList(tree.getRightBT()));
                return result;
            } catch (EmptyTreeE emptyTreeE) {
                throw new RuntimeException(emptyTreeE);
            }
        }
    }

    static <E extends Comparable<E>> List<E> postOrderList(BinaryTree<E> tree) {
        if(tree.isEmpty()){
            return new ArrayList<>();
        }
        else{
            try {
                List<E> result = new ArrayList<>();
                result.addAll(postOrderList(tree.getLeftBT()));
                result.addAll(postOrderList(tree.getRightBT()));
                result.add(tree.getData());
                return result;
            } catch (EmptyTreeE emptyTreeE) {
                throw new RuntimeException(emptyTreeE);
            }
        }
    }

    static <E extends Comparable<E>> List<E> breadthFirstList (BinaryTree<E> tree) {
        if(tree.isEmpty()){
            return new ArrayList<>();
        }
        else{
            try {
                List<E> result = new ArrayList<>();
                Queue<BinaryTree<E>> queue = new LinkedList<>();
                queue.add(tree);
                while(!queue.isEmpty()){
                    BinaryTree<E> temp = queue.poll();
                    result.add(temp.getData());
                    if(!temp.getLeftBT().isEmpty()){
                        queue.add(temp.getLeftBT());
                    }
                    if(!temp.getRightBT().isEmpty()){
                        queue.add(temp.getRightBT());
                    }
                }
                return result;
            } catch (EmptyTreeE emptyTreeE) {
                throw new RuntimeException(emptyTreeE);
            }
        }
    }

    static <E extends Comparable<E>, F extends Comparable<F>> BinaryTree<F>
    map (Function<E,F> f, BinaryTree<E> tree) {
        if(tree.isEmpty()){
            return new EmptyBT<>();
        }
        else{
            try {
                return new NodeBT<>(f.apply(tree.getData()), map(f, tree.getLeftBT()), map(f, tree.getRightBT()));
            } catch (EmptyTreeE emptyTreeE) {
                throw new RuntimeException(emptyTreeE);
            }
        }
    }
    static int sum (BinaryTree<Integer> tree) {
        if (tree.isEmpty()) {
            return 0;
        } else {
            try {
                return tree.getData() + sum(tree.getLeftBT()) + sum(tree.getRightBT());
            } catch (EmptyTreeE e) {
                throw new RuntimeException(e);
            }
        }
    }
    static int mul (BinaryTree<Integer> tree) {
        if(tree.isEmpty()){
            return 1;
        }
        else{
            try {
                return tree.getData() * mul(tree.getLeftBT()) * mul(tree.getRightBT());
            } catch (EmptyTreeE emptyTreeE) {
                throw new RuntimeException(emptyTreeE);
            }
        }
    }
    static <E extends Comparable<E>> BinaryTree<E> mirror (BinaryTree<E> tree) {
        if(tree.isEmpty()){
            return new EmptyBT<>();
        }
        else{
            try {
                return new NodeBT<>(tree.getData(), mirror(tree.getRightBT()), mirror(tree.getLeftBT()));
            } catch (EmptyTreeE emptyTreeE) {
                throw new RuntimeException(emptyTreeE);
            }
        }
    }
}
