package nl.stijngroenen.tradfri.device.event;

import java.lang.reflect.ParameterizedType;

public abstract class DeviceEventHandler<T extends DeviceEvent> {

    public abstract void handle(T event);

    public Class<T> getEventType(){
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
