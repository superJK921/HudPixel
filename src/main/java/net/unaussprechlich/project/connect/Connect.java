package net.unaussprechlich.project.connect;

import com.palechip.hudpixelmod.extended.util.LoggerHelper;
import net.unaussprechlich.managedgui.lib.GuiManagerMG;
import net.unaussprechlich.managedgui.lib.ManagedGui;
import net.unaussprechlich.managedgui.lib.helper.SetupHelper;
import net.unaussprechlich.project.connect.gui.ConnectGUI;
import net.unaussprechlich.project.connect.socket.io.SocketConnection;

/**
 * Connect Created by unaussprechlich on 20.12.2016.
 * Description:
 **/
public class Connect {

    private static Connect INSTANCE;

    public static Connect getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new Connect();
        return INSTANCE;
    }

    private Connect() {
        //TODO: Autogenerated Singletone
    }

    public static void setup(){
        LoggerHelper.logInfo("Setting up Connect!");
        ManagedGui.setup(new SetupHelper());
        ManagedGui.setIsDisabled(false);

        GuiManagerMG.addGUI("ConnectGUI", new ConnectGUI());
        SocketConnection.getINSTANCE().setup();

    }

}