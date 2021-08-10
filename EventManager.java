import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/**
 * @Author GBWANG7786(UseRPG)
 */
public class EventManager {
    private final HashMap<Class<?extends Listener>, CopyOnWriteArrayList<MethodBean>> events = new HashMap<>();
    public void Register(Object o){
        Class<?> type = o.getClass();
        for(Method method:type.getDeclaredMethods()){
            if(method.getParameterTypes().length==1 && method.isAnnotationPresent(Subscribe.class)){
                method.setAccessible(true);
                Class<? extends Listener> listener = (Class<? extends Listener>) method.getParameterTypes()[0];
                MethodBean methodBean = new MethodBean(o, method);
                if (events.containsKey(listener)) {
                    if (!events.get(listener).contains(methodBean)) {
                        events.get(listener).add(methodBean);
                    }
                } else {
                    events.put(listener, new CopyOnWriteArrayList<>(Collections.singletonList(methodBean)));
                }
            }
        }
    }
    public void UnRegister(Object o){
        events.values().forEach(methodBeans -> methodBeans.removeIf(methodMethodBean -> methodMethodBean.getObject().equals(o)));
        events.entrySet().removeIf(event -> event.getValue().isEmpty());
    }
    public CopyOnWriteArrayList<MethodBean> getEvent(Class<? extends Listener> type) {
        return events.get(type);
    }
}
