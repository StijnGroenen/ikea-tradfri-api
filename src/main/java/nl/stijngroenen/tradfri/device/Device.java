package nl.stijngroenen.tradfri.device;

public abstract class Device {

    private String name;

    private Long creationDate;

    private Integer instanceId;

    public Device(String name, Long creationDate, Integer instanceId){
        this.name = name;
        this.creationDate = creationDate;
        this.instanceId = instanceId;
    }

    public abstract boolean applyUpdates();

    public Light toLight(){
        if(this.getClass() == Light.class){
            return (Light) this;
        }
        return null;
    }

    public Plug toPlug(){
        if(this.getClass() == Plug.class){
            return (Plug) this;
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

    public Long getCreationDate() {
        return this.creationDate;
    }

    public Integer getInstanceId() {
        return this.instanceId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
    }

    public void setInstanceId(Integer instanceId) {
        this.instanceId = instanceId;
    }
}
