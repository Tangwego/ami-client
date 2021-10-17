package top.wdcc.ast.ami;

import top.wdcc.ast.ami.actions.AmiAction;
import top.wdcc.ast.ami.actions.OriginateAction;
import top.wdcc.ast.ami.client.*;

public class OriginateActionTest {
    public static void main(String[] args) throws InterruptedException {
        AmiConfig amiConfig = new AmiConfig();
        amiConfig.setUsername("asterisk");
        amiConfig.setSecret("asterisk");
        amiConfig.setHost("192.168.0.120");
        amiConfig.setPort(5038);
        AmiClient amiClient = new AmiClient(amiConfig);
        amiClient.setEventListener(new AmiEventListener() {
            @Override
            public void onLogin(boolean success) {
                // TODO login
            }

            @Override
            public void onEvent(AmiEvent event) {
                // TODO received event
            }
        });

        amiClient.login();
        AmiAction action = new OriginateAction("asterisk", "1001", "");
        AmiMessage amiMessage = amiClient.sendAction(action);
        System.out.println(amiMessage);
    }
}
