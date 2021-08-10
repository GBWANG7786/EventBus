import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CopyOnWriteArrayList;
/**
 * @Author GBWANG7786(UseRPG)
 */
public class Listener {
    public void call() {
        CopyOnWriteArrayList<MethodBean> methodBeans = Main.INSTANCE.eventManager.getEvent(this.getClass());

        if(methodBeans == null) {
            return;
        }

        methodBeans.forEach(event -> {
            try {
                event.getMethod().invoke(event.getObject(), this);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }
}

