import java.lang.reflect.Method;
/**
 * @Author GBWANG7786(UseRPG)
 */
public class MethodBean {
    private final Object object;
    private final Method method;
    public MethodBean(Object object,Method method){
        this.method=method;
        this.object=object;
    }

    public Object getObject() {
        return object;
    }

    public Method getMethod() {
        return method;
    }
}
