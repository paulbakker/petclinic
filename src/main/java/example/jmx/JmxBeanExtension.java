package example.jmx;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * @Author Paul Bakker - paul.bakker@luminis.eu
 */
@Startup
@Singleton
public class JmxBeanExtension  {
    @Inject @JMXBean Instance<Object> jmxBeans;
    private MBeanServer mBeanServer;
    
    @PostConstruct
    public void exportBean() throws Exception {
        mBeanServer = ManagementFactory.getPlatformMBeanServer();

        for (Object bean : jmxBeans) {
            String annotationValue = bean.getClass().getAnnotation(JMXBean.class).objectName();
            ObjectName objectName;
            if(annotationValue.equals("")) {
                objectName = new ObjectName(bean.getClass().getName() + ":type=" + bean.getClass().getName());
            } else {
                objectName = new ObjectName(annotationValue + ":type=" + bean.getClass().getName());
            }

            mBeanServer.registerMBean(bean, objectName);
            System.out.println("Registered " + objectName);
        }
    }
}
