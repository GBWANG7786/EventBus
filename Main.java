/**
 * @Author GBWANG7786(UseRPG)
 */
public enum Main {
        INSTANCE;
        EventManager eventManager = new EventManager();
    public static void main(String[] args) {
        Main.INSTANCE.eventManager.Register(new Test());//register
        new UpdateEvent().call();
    }
    static class Test {
        @Subscribe
        public void on(UpdateEvent e) {
            System.out.println("Event Bus By:UseRPG");
        }
    }

    }
/**
 * @Author GBWANG7786(UseRPG)
 */
/**
 * @Author GBWANG7786(UseRPG)
 */
/**
 * @Author GBWANG7786(UseRPG)
 */
/**
 * @Author GBWANG7786(UseRPG)
 */
/**
 * @Author GBWANG7786(UseRPG)
 */
/**
 * @Author GBWANG7786(UseRPG)
 */
/**
 * @Author GBWANG7786(UseRPG)
 *//**
 * @Author GBWANG7786(UseRPG)
 */


