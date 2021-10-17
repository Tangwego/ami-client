package top.wdcc.ast.ami.client;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Ami Message Implement
 *
 * @author Wavin
 */
public class AmiMessageImpl implements AmiMessage {
    private Type type;
    private Map<String, String> params;

    public AmiMessageImpl(){
        params = new HashMap<>();
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String getParam(String field){
        return params.get(field);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

    @Override
    public boolean isSuccess() {
        if (type == Type.RESPONSE) {
            return StringUtils.equalsIgnoreCase(params.get(AMI_RESPONSE), "SUCCESS");
        }
        return true;
    }

    @Override
    public String getResponseText() {
        return params.get(AMI_RESPONSE);
    }

    @Override
    public String getMessage() {
        return params.get("Message");
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void addParams(String field, String value) {
        params.put(field, value);
    }

//    @Override
//    public String toString() {
//        return "AmiMessage[" +
//                "type=" + type +
//                ", params=has [" + params.size() +
//                "] fields]";
//    }


    @Override
    public String toString() {
        return "AmiMessageImpl{" +
                "type=" + type +
                ", params=" + params +
                '}';
    }
}
