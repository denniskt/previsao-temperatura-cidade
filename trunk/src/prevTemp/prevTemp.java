/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prevTemp;

import java.util.Vector;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Fatec
 */
public class prevTemp extends MIDlet implements CommandListener {

    private boolean midletPaused = false;

    private Vector dia = new Vector();
    private Vector tempMaxima = new Vector();
    private Vector tempMinima = new Vector();

    private String codCidade;

    private String replace( String str, String pattern, String replace )
{
    int s = 0;
    int e = 0;
    StringBuffer result = new StringBuffer();

    while ( (e = str.indexOf( pattern, s ) ) >= 0 )
    {
        result.append(str.substring( s, e ) );
        result.append( replace );
        s = e+pattern.length();
    }
    result.append( str.substring( s ) );
    return result.toString();
}

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command exitCommand;
    private Command avisosCommand;
    private Command backToListCommand;
    private Command backCommand1;
    private Command detalhesCommand;
    private Command itemCommand;
    private Command itemCommand1;
    private Command buscarCommand;
    private Form form;
    private TextField cidadetextField;
    private StringItem stringItem;
    private List list;
    private Form detalhesform;
    private StringItem minimaStringItem;
    private StringItem dataStringItem;
    private StringItem maximaStringItem;
    private StringItem cidadeStringItem;
    private Image buttonImage;
    //</editor-fold>//GEN-END:|fields|0|

    /**
     * The prevTemp constructor.
     */
    public prevTemp() {
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getForm());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == detalhesform) {//GEN-BEGIN:|7-commandAction|1|30-preAction
            if (command == backToListCommand) {//GEN-END:|7-commandAction|1|30-preAction
                // write pre-action user code here
                switchDisplayable(null, getList());//GEN-LINE:|7-commandAction|2|30-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|3|57-preAction
        } else if (displayable == form) {
            if (command == buscarCommand) {//GEN-END:|7-commandAction|3|57-preAction
                String cidade = cidadetextField.getString();
                cidade = replace(cidade, " ", "%20");
                String uf = "";
                String url = "http://servicos.cptec.inpe.br/XML/listaCidades?city="+cidade;
                try{
                    getList().deleteAll();
                    StreamConnection connection = (StreamConnection) Connector.open(url, Connector.READ_WRITE);
                    SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
                    saxParser.parse(connection.openDataInputStream(), new DefaultHandler(){
                        private String currentName = "";
                        public void startElement(String uri, String lName, String name, Attributes att) throws SAXException {
                            currentName = name;
                        }
                        public void characters(char[] ch, int start, int lenght) throws SAXException{
                            String chars = new String(ch, start, lenght).trim();
                            if(chars.length() > 0){
                                if (currentName.equals("nome")){
                                    getList().append(chars, getButtonImage());
                                }else if(currentName.equals("id")){
                                    codCidade = chars;
                                }
                            }
                        }
                    });
                } catch (Exception error) {
                    Alert mensagem = new Alert("Falha");
                    mensagem.setString(error.getMessage());
                    mensagem.setTimeout(3000);
                    getDisplay().setCurrent(mensagem);
                }


                url = "http://servicos.cptec.inpe.br/XML/cidade/"+codCidade+"/previsao.xml";
                try{
                    //getList().deleteAll();
                    StreamConnection connection = (StreamConnection) Connector.open(url, Connector.READ_WRITE);
                    SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
                    saxParser.parse(connection.openDataInputStream(), new DefaultHandler(){
                        private String currentName = "";
                        public void startElement(String uri, String lName, String name, Attributes att) throws SAXException {
                            currentName = name;
                        }
                        public void characters(char[] ch, int start, int lenght) throws SAXException{
                            String chars = new String(ch, start, lenght).trim();
                            if(chars.length() > 0){
                                if(currentName.equals("dia")){
                                    dia.addElement(chars);
                                }if(currentName.equals("maxima")){
                                    tempMaxima.addElement(chars);
                                }else if(currentName.equals("minima")){
                                    tempMinima.addElement(chars);
                                }
                            }
                        }
                    });
                } catch (Exception error) {
                    Alert mensagem = new Alert("Falha");
                    mensagem.setString(error.getMessage());
                    mensagem.setTimeout(3000);
                    getDisplay().setCurrent(mensagem);
                }
                switchDisplayable(null, getList());//GEN-LINE:|7-commandAction|4|57-postAction

            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|5|19-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|6|19-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|7|26-preAction
        } else if (displayable == list) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|7|26-preAction
                // write pre-action user code here
                listAction();//GEN-LINE:|7-commandAction|8|26-postAction
                // write post-action user code here
            } else if (command == backCommand1) {//GEN-LINE:|7-commandAction|9|32-preAction
                // write pre-action user code here
                switchDisplayable(null, getForm());//GEN-LINE:|7-commandAction|10|32-postAction
                // write post-action user code here
            } else if (command == detalhesCommand) {//GEN-LINE:|7-commandAction|11|37-preAction
                // write pre-action user code here
                switchDisplayable(null, getDetalhesform());//GEN-LINE:|7-commandAction|12|37-postAction
                // write post-action user code here
                String cidade = getList().getString(getList().getSelectedIndex());
                String dataCidade = (String) dia.elementAt(getList().getSelectedIndex());
                String tempMaximaCidade = (String) tempMaxima.elementAt(getList().getSelectedIndex());
                String tempMinimoCidade = (String) tempMinima.elementAt(getList().getSelectedIndex());
                cidadeStringItem.setText(cidade);
                dataStringItem.setText(dataCidade);
                maximaStringItem.setText(tempMaximaCidade+" Cº");
                minimaStringItem.setText(tempMinimoCidade+" Cº");
            }//GEN-BEGIN:|7-commandAction|13|7-postCommandAction
        }//GEN-END:|7-commandAction|13|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|14|
    //</editor-fold>//GEN-END:|7-commandAction|14|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
            exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
        }//GEN-BEGIN:|18-getter|2|
        return exitCommand;
    }
    //</editor-fold>//GEN-END:|18-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: form ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initiliazed instance of form component.
     * @return the initialized component instance
     */
    public Form getForm() {
        if (form == null) {//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
            form = new Form("Previs\u00E3o de Temperatura Hoje", new Item[] { getStringItem(), getCidadetextField() });//GEN-BEGIN:|14-getter|1|14-postInit
            form.addCommand(getExitCommand());
            form.addCommand(getBuscarCommand());
            form.setCommandListener(this);//GEN-END:|14-getter|1|14-postInit
            // write post-init user code here
        }//GEN-BEGIN:|14-getter|2|
        return form;
    }
    //</editor-fold>//GEN-END:|14-getter|2|



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: avisosCommand ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initiliazed instance of avisosCommand component.
     * @return the initialized component instance
     */
    public Command getAvisosCommand() {
        if (avisosCommand == null) {//GEN-END:|22-getter|0|22-preInit
            // write pre-init user code here
            avisosCommand = new Command("avisos", Command.ITEM, 0);//GEN-LINE:|22-getter|1|22-postInit
            // write post-init user code here
        }//GEN-BEGIN:|22-getter|2|
        return avisosCommand;
    }
    //</editor-fold>//GEN-END:|22-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backToListCommand ">//GEN-BEGIN:|29-getter|0|29-preInit
    /**
     * Returns an initiliazed instance of backToListCommand component.
     * @return the initialized component instance
     */
    public Command getBackToListCommand() {
        if (backToListCommand == null) {//GEN-END:|29-getter|0|29-preInit
            // write pre-init user code here
            backToListCommand = new Command("Voltar", Command.BACK, 0);//GEN-LINE:|29-getter|1|29-postInit
            // write post-init user code here
        }//GEN-BEGIN:|29-getter|2|
        return backToListCommand;
    }
    //</editor-fold>//GEN-END:|29-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand1 ">//GEN-BEGIN:|31-getter|0|31-preInit
    /**
     * Returns an initiliazed instance of backCommand1 component.
     * @return the initialized component instance
     */
    public Command getBackCommand1() {
        if (backCommand1 == null) {//GEN-END:|31-getter|0|31-preInit
            // write pre-init user code here
            backCommand1 = new Command("Voltar", Command.BACK, 0);//GEN-LINE:|31-getter|1|31-postInit
            // write post-init user code here
        }//GEN-BEGIN:|31-getter|2|
        return backCommand1;
    }
    //</editor-fold>//GEN-END:|31-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: detalhesCommand ">//GEN-BEGIN:|36-getter|0|36-preInit
    /**
     * Returns an initiliazed instance of detalhesCommand component.
     * @return the initialized component instance
     */
    public Command getDetalhesCommand() {
        if (detalhesCommand == null) {//GEN-END:|36-getter|0|36-preInit
            // write pre-init user code here
            detalhesCommand = new Command("Temperatura", Command.ITEM, 0);//GEN-LINE:|36-getter|1|36-postInit
            // write post-init user code here
        }//GEN-BEGIN:|36-getter|2|
        return detalhesCommand;
    }
    //</editor-fold>//GEN-END:|36-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem ">//GEN-BEGIN:|39-getter|0|39-preInit
    /**
     * Returns an initiliazed instance of stringItem component.
     * @return the initialized component instance
     */
    public StringItem getStringItem() {
        if (stringItem == null) {//GEN-END:|39-getter|0|39-preInit
            // write pre-init user code here
            stringItem = new StringItem("", "Digite o nome da cidade para verificar a previs\u00E3o de temperatura m\u00E1xima e m\u00EDnima.");//GEN-LINE:|39-getter|1|39-postInit
            // write post-init user code here
        }//GEN-BEGIN:|39-getter|2|
        return stringItem;
    }
    //</editor-fold>//GEN-END:|39-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: list ">//GEN-BEGIN:|24-getter|0|24-preInit
    /**
     * Returns an initiliazed instance of list component.
     * @return the initialized component instance
     */
    public List getList() {
        if (list == null) {//GEN-END:|24-getter|0|24-preInit
            // write pre-init user code here
            list = new List("list", Choice.IMPLICIT);//GEN-BEGIN:|24-getter|1|24-postInit
            list.addCommand(getBackCommand1());
            list.addCommand(getDetalhesCommand());
            list.setCommandListener(this);//GEN-END:|24-getter|1|24-postInit
            // write post-init user code here
        }//GEN-BEGIN:|24-getter|2|
        return list;
    }
    //</editor-fold>//GEN-END:|24-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: listAction ">//GEN-BEGIN:|24-action|0|24-preAction
    /**
     * Performs an action assigned to the selected list element in the list component.
     */
    public void listAction() {//GEN-END:|24-action|0|24-preAction
        // enter pre-action user code here
        String __selectedString = getList().getString(getList().getSelectedIndex());//GEN-LINE:|24-action|1|24-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|24-action|2|
    //</editor-fold>//GEN-END:|24-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: detalhesform ">//GEN-BEGIN:|28-getter|0|28-preInit
    /**
     * Returns an initiliazed instance of detalhesform component.
     * @return the initialized component instance
     */
    public Form getDetalhesform() {
        if (detalhesform == null) {//GEN-END:|28-getter|0|28-preInit
            // write pre-init user code here
            detalhesform = new Form("Temperatura Hoje", new Item[] { getDataStringItem(), getCidadeStringItem(), getMaximaStringItem(), getMinimaStringItem() });//GEN-BEGIN:|28-getter|1|28-postInit
            detalhesform.addCommand(getBackToListCommand());
            detalhesform.setCommandListener(this);//GEN-END:|28-getter|1|28-postInit
            // write post-init user code here
        }//GEN-BEGIN:|28-getter|2|
        return detalhesform;
    }
    //</editor-fold>//GEN-END:|28-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand ">//GEN-BEGIN:|47-getter|0|47-preInit
    /**
     * Returns an initiliazed instance of itemCommand component.
     * @return the initialized component instance
     */
    public Command getItemCommand() {
        if (itemCommand == null) {//GEN-END:|47-getter|0|47-preInit
            // write pre-init user code here
            itemCommand = new Command("Item", Command.ITEM, 0);//GEN-LINE:|47-getter|1|47-postInit
            // write post-init user code here
        }//GEN-BEGIN:|47-getter|2|
        return itemCommand;
    }
    //</editor-fold>//GEN-END:|47-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand1 ">//GEN-BEGIN:|49-getter|0|49-preInit
    /**
     * Returns an initiliazed instance of itemCommand1 component.
     * @return the initialized component instance
     */
    public Command getItemCommand1() {
        if (itemCommand1 == null) {//GEN-END:|49-getter|0|49-preInit
            // write pre-init user code here
            itemCommand1 = new Command("Item", Command.ITEM, 0);//GEN-LINE:|49-getter|1|49-postInit
            // write post-init user code here
        }//GEN-BEGIN:|49-getter|2|
        return itemCommand1;
    }
    //</editor-fold>//GEN-END:|49-getter|2|
    //</editor-fold>



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cidadeStringItem ">//GEN-BEGIN:|53-getter|0|53-preInit
    /**
     * Returns an initiliazed instance of cidadeStringItem component.
     * @return the initialized component instance
     */
    public StringItem getCidadeStringItem() {
        if (cidadeStringItem == null) {//GEN-END:|53-getter|0|53-preInit
            // write pre-init user code here
            cidadeStringItem = new StringItem("Cidade:", "");//GEN-LINE:|53-getter|1|53-postInit
            // write post-init user code here
        }//GEN-BEGIN:|53-getter|2|
        return cidadeStringItem;
    }
    //</editor-fold>//GEN-END:|53-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: maximaStringItem ">//GEN-BEGIN:|54-getter|0|54-preInit
    /**
     * Returns an initiliazed instance of maximaStringItem component.
     * @return the initialized component instance
     */
    public StringItem getMaximaStringItem() {
        if (maximaStringItem == null) {//GEN-END:|54-getter|0|54-preInit
            // write pre-init user code here
            maximaStringItem = new StringItem("Temperatura M\u00EDnima:", "");//GEN-LINE:|54-getter|1|54-postInit
            // write post-init user code here
        }//GEN-BEGIN:|54-getter|2|
        return maximaStringItem;
    }
    //</editor-fold>//GEN-END:|54-getter|2|
    //</editor-fold>





    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: buscarCommand ">//GEN-BEGIN:|56-getter|0|56-preInit
    /**
     * Returns an initiliazed instance of buscarCommand component.
     * @return the initialized component instance
     */
    public Command getBuscarCommand() {
        if (buscarCommand == null) {//GEN-END:|56-getter|0|56-preInit
            // write pre-init user code here
            buscarCommand = new Command("Buscar Cidade", Command.ITEM, 0);//GEN-LINE:|56-getter|1|56-postInit
            // write post-init user code here
        }//GEN-BEGIN:|56-getter|2|
        return buscarCommand;
    }
    //</editor-fold>//GEN-END:|56-getter|2|



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: buttonImage ">//GEN-BEGIN:|60-getter|0|60-preInit
    /**
     * Returns an initiliazed instance of buttonImage component.
     * @return the initialized component instance
     */
    public Image getButtonImage() {
        if (buttonImage == null) {//GEN-END:|60-getter|0|60-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|60-getter|1|60-@java.io.IOException
                buttonImage = Image.createImage("/hello/images/seta.jpg");
            } catch (java.io.IOException e) {//GEN-END:|60-getter|1|60-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|60-getter|2|60-postInit
            // write post-init user code here
        }//GEN-BEGIN:|60-getter|3|
        return buttonImage;
    }
    //</editor-fold>//GEN-END:|60-getter|3|



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cidadetextField ">//GEN-BEGIN:|64-getter|0|64-preInit
    /**
     * Returns an initiliazed instance of cidadetextField component.
     * @return the initialized component instance
     */
    public TextField getCidadetextField() {
        if (cidadetextField == null) {//GEN-END:|64-getter|0|64-preInit
            // write pre-init user code here
            cidadetextField = new TextField("Nome da cidade:", "", 32, TextField.ANY);//GEN-LINE:|64-getter|1|64-postInit
            // write post-init user code here
        }//GEN-BEGIN:|64-getter|2|
        return cidadetextField;
    }
    //</editor-fold>//GEN-END:|64-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: minimaStringItem ">//GEN-BEGIN:|69-getter|0|69-preInit
    /**
     * Returns an initiliazed instance of minimaStringItem component.
     * @return the initialized component instance
     */
    public StringItem getMinimaStringItem() {
        if (minimaStringItem == null) {//GEN-END:|69-getter|0|69-preInit
            // write pre-init user code here
            minimaStringItem = new StringItem("Temperatura M\u00EDnima:", "");//GEN-LINE:|69-getter|1|69-postInit
            // write post-init user code here
        }//GEN-BEGIN:|69-getter|2|
        return minimaStringItem;
    }
    //</editor-fold>//GEN-END:|69-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: dataStringItem ">//GEN-BEGIN:|70-getter|0|70-preInit
    /**
     * Returns an initiliazed instance of dataStringItem component.
     * @return the initialized component instance
     */
    public StringItem getDataStringItem() {
        if (dataStringItem == null) {//GEN-END:|70-getter|0|70-preInit
            // write pre-init user code here
            dataStringItem = new StringItem("Data", "");//GEN-LINE:|70-getter|1|70-postInit
            // write post-init user code here
        }//GEN-BEGIN:|70-getter|2|
        return dataStringItem;
    }
    //</editor-fold>//GEN-END:|70-getter|2|





    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay () {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable (null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet ();
        } else {
            initialize ();
            startMIDlet ();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }

}
