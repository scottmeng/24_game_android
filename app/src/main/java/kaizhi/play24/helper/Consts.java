package kaizhi.play24.helper;

/**
 * @author kaizhimeng on 14/1/15.
 */
public class Consts {
    public static final int PLUS        = -1;
    public static final int MINUS       = -2;
    public static final int MULTIPLY    = -3;
    public static final int DIVIDE      = -4;

    public static boolean isElementOperator(int element) {
        return element < 0;
    }
}
