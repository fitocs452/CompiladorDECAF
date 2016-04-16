
import javax.swing.JTree;
import DECAF2.DECAF2Parser;
import javax.swing.tree.DefaultMutableTreeNode;
import org.antlr.v4.runtime.tree.ParseTree;
/**
 *
 * @author GustavoAdolfo
 */
public class TreeBuilder {
    // Crear árbol desde root
    public JTree crearArbol (ParseTree arbol ,DECAF2Parser parser) {
        // Tomo root 
        String[] split = arbol.toStringTree(parser).split(" ");
        String word = arbol.toStringTree(parser);
        if (split[0].charAt(0) == '(') {
            word = split[0] + ")";
        }
        DefaultMutableTreeNode cabezaArbol = new DefaultMutableTreeNode(word);

        // Tomo la cantidad de nodos que tiene el árbol
        int count = arbol.getChildCount();

        for(int i = 0; i < count; i++) {
            // obtengo el arbol del nodo
            ParseTree subtree = arbol.getChild(i);
            /*Creates a tree node with no parent, no children, initialized with
             * the specified user object, and that allows children only if
             * specified */
            String[] split2 = subtree.toStringTree(parser).split(" ");
            String word2 = subtree.toStringTree(parser);
            if (split2[0].charAt(0) == '(') {
                word2 = split2[0] + ")";
            }
            DefaultMutableTreeNode ch = new DefaultMutableTreeNode(word2);
            
            // Le agrego el arbol del nodo a root o nodo inicial
            cabezaArbol.add(crearArbolNodo(ch, subtree, parser));
        }
        // Retorno el árbol en JTree
        return new JTree(cabezaArbol);
    }
    
    // Crear árbol para nodos
    public DefaultMutableTreeNode crearArbolNodo(DefaultMutableTreeNode nodoPadre, ParseTree arbol, DECAF2Parser parser)
    {
        int count = arbol.getChildCount();
        for(int i=0; i<count; i++) {
            ParseTree subtree = arbol.getChild(i);
            String[] split2 = subtree.toStringTree(parser).split(" ");
            String word2 = subtree.toStringTree(parser);
            if (split2[0].charAt(0) == '(') {
                word2 = split2[0] + ")";
            }
            DefaultMutableTreeNode ch = new DefaultMutableTreeNode(word2);
                       
            nodoPadre.add(crearArbolNodo(ch, subtree, parser));
        }
        
        return nodoPadre;
    }
}
