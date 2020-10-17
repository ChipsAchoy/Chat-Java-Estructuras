package Chatver2.Logics.Listeners;

import Chatver2.AppMain;
import Chatver2.GUI.AppInterface;
import Chatver2.Logics.ChatsList;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * ListReact is a ListListener based class which adds contacts to a list
 * 
 */
public class ListReact implements ListSelectionListener {
    private AppInterface frame;
    private ChatsList listch;
    private int puertoEnvio;
    private String ip;
    private SendText evento;
    private Logger bitacora = AppMain.bitacora;
    /**
     * Class Constructor
     * @param fr AppInterface where the changes will be seen
     * @param l1 ChatList where the contacts will be written
     * @param ev SendText object where the port and ip will be written
     */
    public ListReact(AppInterface fr, ChatsList l1, SendText ev){
        frame = fr;
        listch = l1;
        evento = ev;
    }
        
    @Override
    /**
     * Listener that will be action when the value of the list changes
     */
    public void valueChanged(ListSelectionEvent e) {
        
        if (!frame.listaContacts.isSelectionEmpty()) {
            try{
                String[] paramsOut = ((String) frame.listaContacts.getSelectedValue()).split(":");
                puertoEnvio = Integer.parseInt(paramsOut[1]);
                ip = paramsOut[0];
                evento.setPortOut(ip,puertoEnvio);
                frame.chat_space.setText(listch.getChat(ip+":"+Integer.toString(puertoEnvio)));
            }
            catch (ArrayIndexOutOfBoundsException e1){
                //Throws an exception if the information is incomplete
                bitacora.severe("Puerto invalido: "+e1.getMessage());
            }
            catch (NumberFormatException e2){
                //Throws an exception if the given port is not int-casteable
                bitacora.severe("Puerto invalido: "+e2.getMessage());
            }
        }
    }
}
