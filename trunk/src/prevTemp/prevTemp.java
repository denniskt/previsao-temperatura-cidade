/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prevTemp;

import java.util.Vector;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
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
    private Vector tempo = new Vector();
    //private Vector uf = new Vector();
    private Vector tempMaxima = new Vector();
    private Vector tempMinima = new Vector();

    private String codCidade;
    private Image imgTempo;
    private String cidadeEstado;

    //substitui o ' ' por %20, por causa da URL
    private String replace( String str, String pattern, String replace ){
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

    private void limpar(){
        getList().deleteAll();
        dia.removeAllElements();
        tempo.removeAllElements();
        tempMaxima.removeAllElements();
        tempMinima.removeAllElements();

        codCidade = "";
        imgTempo = null;
        cidadeEstado = "";
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command exitCommand;
    private Command avisosCommand;
    private Command homeBackCommand;
    private Command homeListBackCommand;
    private Command previsaoCommand;
    private Command proxCommand;
    private Command itemCommand1;
    private Command buscarCommand;
    private Command okCommand;
    private Command backCommand;
    private Command okCommand1;
    private Command hojeBackCommand;
    private Command provCommand;
    private Form form;
    private TextField cidadetextField;
    private ImageItem imageItem;
    private StringItem stringItem;
    private List list;
    private Form previsaoForm;
    private StringItem temperaturaStringItem;
    private StringItem localdataSringItem;
    private StringItem tempoStringItem;
    private ImageItem tempoImageItem;
    private Form proxForm;
    private StringItem data1StringItem;
    private StringItem temp1StringItem;
    private StringItem data2StringItem;
    private StringItem temp2StringItem;
    private Image buttonImage;
    private Image pn;
    private Image in;
    private Image ppm;
    private Image ncn;
    private Image pnt;
    private Image n;
    private Image g;
    private Image psc;
    private Image ec;
    private Image ps;
    private Image ncm;
    private Image pp;
    private Image ppn;
    private Image ppt;
    private Image npm;
    private Image npn;
    private Image pcm;
    private Image t;
    private Image pct;
    private Image pcn;
    private Image npp;
    private Image pm;
    private Image ch;
    private Image nct;
    private Image ne;
    private Image np;
    private Image nv;
    private Image npt;
    private Image pt;
    private Image pc;
    private Image cl;
    private Image ci;
    private Image vn;
    private Image e;
    private Image cv;
    private Image ct;
    private Image c;
    private Image nd;
    private Image logo;
    private Image cm;
    private Image cn;
    private Font fontTemp;
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
        if (displayable == form) {//GEN-BEGIN:|7-commandAction|1|57-preAction
            if (command == buscarCommand) {//GEN-END:|7-commandAction|1|57-preAction
                String cidade = cidadetextField.getString();
                if(cidade.length()<3){
                    Alert mensagemCidade = new Alert("Digite no mínimo de 3 caracteres");
                    mensagemCidade.setTimeout(5000);
                    getDisplay().setCurrent(mensagemCidade);
                }else{
                    cidade = replace(cidade, " ", "%20"); // Substitui espaço em %20 por causa da URL
                    String url = "http://servicos.cptec.inpe.br/XML/listaCidades?city="+cidade;
                    codCidade = "";

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
                                    if (currentName.equals("nome")){ // nome da cidade
                                        cidadeEstado = chars;
                                    }if(currentName.equals("uf")){
                                        // Inserir a sigla da UF depois do nome da cidade na lista
                                        getList().append(cidadeEstado+" - "+chars, getButtonImage());
                                    }if(currentName.equals("id")){ // id necessária pois a url da xml, necessita do código da cidade para realiza a consulta
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
                                    if(currentName.equals("dia")){ // Data no formato AAAA-MM-DD
                                        // Mudar o formato da data DD/MM/AAAA
                                        String a = chars.substring(0, 4);
                                        String m = chars.substring(5, 7);
                                        String d = chars.substring(8, 10);
                                        String data = d+"/"+m+"/"+a;
                                        dia.addElement(data);
                                    }else if(currentName.equals("maxima")){
                                        tempMaxima.addElement(chars);
                                    }else if(currentName.equals("minima")){
                                        tempMinima.addElement(chars);
                                    }else if(currentName.equals("tempo")){
                                        /*XML retorna a previsão com siglas (ec, ci, c...),
                                         foi criado condicionais para atribuir a descrição
                                         e a imagem de acordo com a sigla */
                                        if(chars.equals("ec")){
                                            chars = "Encoberto com Chuvas Isoladas";
                                            imgTempo = getEc();
                                        }else if(chars.equals("ci")){
                                            chars = "Previsão de Chuvas Isoladas";
                                            imgTempo = getCi();
                                        }else if(chars.equals("c")){
                                            chars = "Previsão de Chuva durante o dia";
                                            imgTempo = getC();
                                        }else if(chars.equals("in")){
                                            chars = "Previsão de Tempo Instável";
                                            imgTempo = getIn();
                                        }else if(chars.equals("pp")){
                                            chars = "Poss. de Pancadas de Chuva";
                                            imgTempo = getPp();
                                        }else if(chars.equals("cm")){
                                            chars = "Previsão de Chuva pela Manhã";
                                            imgTempo = getCm();
                                        }else if(chars.equals("cn")){
                                            chars = "Previsão de Chuva a Noite";
                                            imgTempo = getCn();
                                        }else if(chars.equals("pt")){
                                            chars = "Pancadas de Chuva a Tarde";
                                            imgTempo = getPt();
                                        }else if(chars.equals("pm")){
                                            chars = "Pancadas de Chuva pela Manhã";
                                            imgTempo = getPm();
                                        }else if(chars.equals("np")){
                                            chars = "Nublado e Pancadas de Chuva";
                                            imgTempo = getNp();
                                        }else if(chars.equals("pc")){
                                            chars = "Previsão de Pancadas de Chuva";
                                            imgTempo = getPc();
                                        }else if(chars.equals("pn")){
                                            chars = "Previsão de tempo parcialmente Nublado";
                                            imgTempo = getPn();
                                        }else if(chars.equals("cv")){
                                            chars = "Previsão de Chuvisco durante o dia";
                                            imgTempo = getCv();
                                        }else if(chars.equals("ch")){
                                            chars = "Tempo Chuvoso durante o dia";
                                            imgTempo = getCh();
                                        }else if(chars.equals("t")){
                                            chars = "Previsão de Tempestade durante o dia";
                                            imgTempo = getT();
                                        }else if(chars.equals("ps")){
                                            chars = "Predomínio de Sol durante o dia";
                                            imgTempo = getPs();
                                        }else if(chars.equals("e")){
                                            chars = "Previsão de tempo Encoberto";
                                            imgTempo = getE();
                                        }else if(chars.equals("n")){
                                            chars = "Previsão de tempo Nublado";
                                            imgTempo = getN();
                                        }else if(chars.equals("cl")){
                                            chars = "Previsão de Céu Claro";
                                            imgTempo = getCl();
                                        }else if(chars.equals("nv")){
                                            chars = "Previsão de Nevoeiro";
                                            imgTempo = getNv();
                                        }else if(chars.equals("g")){
                                            chars = "Previsão de Geada";
                                            imgTempo = getG();
                                        }else if(chars.equals("ne")){
                                            chars = "Previsão de Neve";
                                            imgTempo = getNe();
                                        }else if(chars.equals("pnt")){
                                            chars = "Pancadas de Chuva a Noite";
                                            imgTempo = getPnt();
                                        }else if(chars.equals("psc")){
                                            chars = "Possibilidade de Chuva";
                                            imgTempo = getPsc();
                                        }else if(chars.equals("pcm")){
                                            chars = "Possibilidade de Chuva pela Manhã";
                                            imgTempo = getPsc();
                                        }else if(chars.equals("pct")){
                                            chars = "Possibilidade de Chuva a Tarde";
                                            imgTempo = getPct();
                                        }else if(chars.equals("pcn")){
                                            chars = "Possibilidade de Chuva a Noite";
                                            imgTempo = getPcn();
                                        }else if(chars.equals("npt")){
                                            chars = "Nublado com Pancadas a Tarde";
                                            imgTempo = getNpt();
                                        }else if(chars.equals("npn")){
                                            chars = "Nublado com Pancadas a Noite";
                                            imgTempo = getNpn();
                                        }else if(chars.equals("ncn")){
                                            chars = "Nublado com Poss. de Chuva a Noite";
                                            imgTempo = getNcn();
                                        }else if(chars.equals("nct")){
                                            chars = "Nublado com Poss. de Chuva a Tarde";
                                            imgTempo = getNct();
                                        }else if(chars.equals("ncm")){
                                            chars = "Nubl. c/ Poss. de Chuva pela Manhã";
                                            imgTempo = getNcm();
                                        }else if(chars.equals("npm")){
                                            chars = "Nublado com Pancadas pela Manhã";
                                            imgTempo = getNpm();
                                        }else if(chars.equals("npp")){
                                            chars = "Nublado com Possibilidade de Chuva";
                                            imgTempo = getNpp();
                                        }else if(chars.equals("vn")){
                                            chars = "Variação de Nebulosidade";
                                            imgTempo = getVn();
                                        }else if(chars.equals("ct")){
                                            chars = "Previsão de chuva a Tarde";
                                            imgTempo = getCt();
                                        }else if(chars.equals("ppn")){
                                            chars = "Poss. de Panc. de Chuva a Noite";
                                            imgTempo = getPpn();
                                        }else if(chars.equals("ppt")){
                                            chars = "Poss. de Panc. de Chuva a Tarde";
                                            imgTempo = getPpt();
                                        }else if(chars.equals("ppm")){
                                            chars = "Poss. de Panc. de Chuva pela Manhã";
                                            imgTempo = getPpm();
                                        }else{
                                            chars = "Não Definido";
                                        }
                                        tempo.addElement(chars);
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

                    switchDisplayable(null, getList());//GEN-LINE:|7-commandAction|2|57-postAction
}
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|3|19-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|4|19-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|5|26-preAction
        } else if (displayable == list) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|5|26-preAction
                // write pre-action user code here
                listAction();//GEN-LINE:|7-commandAction|6|26-postAction
                // write post-action user code here
            } else if (command == homeListBackCommand) {//GEN-LINE:|7-commandAction|7|32-preAction
                // write pre-action user code here
                switchDisplayable(null, getForm());//GEN-LINE:|7-commandAction|8|32-postAction
                // write post-action user code here
                limpar();
            } else if (command == previsaoCommand) {//GEN-LINE:|7-commandAction|9|37-preAction
                // write pre-action user code here
                switchDisplayable(null, getPrevisaoForm());//GEN-LINE:|7-commandAction|10|37-postAction
                // write post-action user code here
                String cidade = getList().getString(getList().getSelectedIndex()); // Obtem o nome da cidade na lista
                String tempMaximaCidade = (String) tempMaxima.elementAt(getList().getSelectedIndex()); // Obtem a temp máxima da lista
                String tempMinimoCidade = (String) tempMinima.elementAt(getList().getSelectedIndex()); // Obtem a temp minima da lista
                String tempoCidade = (String) tempo.elementAt(getList().getSelectedIndex()); // Obtem a descrição do tempo da lista

                previsaoForm.setTitle(cidade); // Nome da cidade no detalhesForm
                temperaturaStringItem.setText(tempMaximaCidade+"ºC Máxima\n"+tempMinimoCidade+"ºC Mínima"); // Temp. Min e Max no detalhesForm
                tempoStringItem.setText(tempoCidade); //Descrição da previsão do tempo no detalhesForm
                tempoImageItem.setImage(imgTempo); // Iagem da previsão do tempo no detalhesForm
            }//GEN-BEGIN:|7-commandAction|11|30-preAction
        } else if (displayable == previsaoForm) {
            if (command == homeBackCommand) {//GEN-END:|7-commandAction|11|30-preAction
                // write pre-action user code here
                switchDisplayable(null, getForm());//GEN-LINE:|7-commandAction|12|30-postAction
                // write post-action user code here
                limpar();
            } else if (command == proxCommand) {//GEN-LINE:|7-commandAction|13|132-preAction
                // write pre-action user code here
                switchDisplayable(null, getProxForm());//GEN-LINE:|7-commandAction|14|132-postAction
                // write post-action user code here
                proxForm.setTitle(getList().getString(getList().getSelectedIndex())); // Nome da cidade no detalhesForm

                data1StringItem.setText((String) dia.elementAt(getList().getSelectedIndex()+1)+"\n"+(String) tempo.elementAt(getList().getSelectedIndex()+1)); //Descrição da data no detalhesForm
                temp1StringItem.setText((String) tempMaxima.elementAt(getList().getSelectedIndex()+1)+"ºC Máxima\n"+(String) tempMinima.elementAt(getList().getSelectedIndex()+1)+"ºC Minima"); // Temp. Min e Max no detalhesForm
                //prev1StringItem.setText((String) tempo.elementAt(getList().getSelectedIndex()+1)); //Descrição da previsão do tempo no detalhesForm

                data2StringItem.setText("--------------------------\n"+(String) dia.elementAt(getList().getSelectedIndex()+2)+"\n"+(String) tempo.elementAt(getList().getSelectedIndex()+2)); //Descrição da data da previsão no detalhesForm
                temp2StringItem.setText((String) tempMaxima.elementAt(getList().getSelectedIndex()+2)+"ºC Máxima\n"+(String) tempMinima.elementAt(getList().getSelectedIndex()+2)+"ºC Minima"); // Temp. Min e Max no detalhesForm
                //prev2StringItem.setText((String) tempo.elementAt(getList().getSelectedIndex()+2)); //Descrição da previsão do tempo no detalhesForm

            }//GEN-BEGIN:|7-commandAction|15|137-preAction
        } else if (displayable == proxForm) {
            if (command == hojeBackCommand) {//GEN-END:|7-commandAction|15|137-preAction
                // write pre-action user code here
                switchDisplayable(null, getPrevisaoForm());//GEN-LINE:|7-commandAction|16|137-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|17|7-postCommandAction
        }//GEN-END:|7-commandAction|17|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|18|
    //</editor-fold>//GEN-END:|7-commandAction|18|





    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
            exitCommand = new Command("Sair", Command.EXIT, 0);//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
        }//GEN-BEGIN:|18-getter|2|
        return exitCommand;
    }
    //</editor-fold>//GEN-END:|18-getter|2|





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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: homeBackCommand ">//GEN-BEGIN:|29-getter|0|29-preInit
    /**
     * Returns an initiliazed instance of homeBackCommand component.
     * @return the initialized component instance
     */
    public Command getHomeBackCommand() {
        if (homeBackCommand == null) {//GEN-END:|29-getter|0|29-preInit
            // write pre-init user code here
            homeBackCommand = new Command("Voltar", Command.BACK, 0);//GEN-LINE:|29-getter|1|29-postInit
            // write post-init user code here
        }//GEN-BEGIN:|29-getter|2|
        return homeBackCommand;
    }
    //</editor-fold>//GEN-END:|29-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: homeListBackCommand ">//GEN-BEGIN:|31-getter|0|31-preInit
    /**
     * Returns an initiliazed instance of homeListBackCommand component.
     * @return the initialized component instance
     */
    public Command getHomeListBackCommand() {
        if (homeListBackCommand == null) {//GEN-END:|31-getter|0|31-preInit
            // write pre-init user code here
            homeListBackCommand = new Command("Voltar", Command.BACK, 0);//GEN-LINE:|31-getter|1|31-postInit
            // write post-init user code here
        }//GEN-BEGIN:|31-getter|2|
        return homeListBackCommand;
    }
    //</editor-fold>//GEN-END:|31-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: previsaoCommand ">//GEN-BEGIN:|36-getter|0|36-preInit
    /**
     * Returns an initiliazed instance of previsaoCommand component.
     * @return the initialized component instance
     */
    public Command getPrevisaoCommand() {
        if (previsaoCommand == null) {//GEN-END:|36-getter|0|36-preInit
            // write pre-init user code here
            previsaoCommand = new Command("Previs\u00E3o", "Previs\u00E3o do tempo para hoje", Command.ITEM, 0);//GEN-LINE:|36-getter|1|36-postInit
            // write post-init user code here
        }//GEN-BEGIN:|36-getter|2|
        return previsaoCommand;
    }
    //</editor-fold>//GEN-END:|36-getter|2|



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: list ">//GEN-BEGIN:|24-getter|0|24-preInit
    /**
     * Returns an initiliazed instance of list component.
     * @return the initialized component instance
     */
    public List getList() {
        if (list == null) {//GEN-END:|24-getter|0|24-preInit
            // write pre-init user code here
            list = new List("Selecione a cidade", Choice.IMPLICIT);//GEN-BEGIN:|24-getter|1|24-postInit
            list.addCommand(getHomeListBackCommand());
            list.addCommand(getPrevisaoCommand());
            list.setCommandListener(this);
            list.setFitPolicy(Choice.TEXT_WRAP_DEFAULT);//GEN-END:|24-getter|1|24-postInit
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

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: previsaoForm ">//GEN-BEGIN:|28-getter|0|28-preInit
    /**
     * Returns an initiliazed instance of previsaoForm component.
     * @return the initialized component instance
     */
    public Form getPrevisaoForm() {
        if (previsaoForm == null) {//GEN-END:|28-getter|0|28-preInit
            // write pre-init user code here
            previsaoForm = new Form("Previs\u00E3o do Tempo p/ Hoje", new Item[] { getTempoImageItem(), getTempoStringItem(), getTemperaturaStringItem(), getLocaldataSringItem() });//GEN-BEGIN:|28-getter|1|28-postInit
            previsaoForm.addCommand(getHomeBackCommand());
            previsaoForm.addCommand(getProxCommand());
            previsaoForm.setCommandListener(this);//GEN-END:|28-getter|1|28-postInit
            // write post-init user code here
        }//GEN-BEGIN:|28-getter|2|
        return previsaoForm;
    }
    //</editor-fold>//GEN-END:|28-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: proxCommand ">//GEN-BEGIN:|47-getter|0|47-preInit
    /**
     * Returns an initiliazed instance of proxCommand component.
     * @return the initialized component instance
     */
    public Command getProxCommand() {
        if (proxCommand == null) {//GEN-END:|47-getter|0|47-preInit
            // write pre-init user code here
            proxCommand = new Command("Pr\u00F3x. Dias", Command.ITEM, 0);//GEN-LINE:|47-getter|1|47-postInit
            // write post-init user code here
        }//GEN-BEGIN:|47-getter|2|
        return proxCommand;
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



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: temperaturaStringItem ">//GEN-BEGIN:|53-getter|0|53-preInit
    /**
     * Returns an initiliazed instance of temperaturaStringItem component.
     * @return the initialized component instance
     */
    public StringItem getTemperaturaStringItem() {
        if (temperaturaStringItem == null) {//GEN-END:|53-getter|0|53-preInit
            // write pre-init user code here
            temperaturaStringItem = new StringItem("", "");//GEN-BEGIN:|53-getter|1|53-postInit
            temperaturaStringItem.setLayout(ImageItem.LAYOUT_DEFAULT);
            temperaturaStringItem.setFont(getFontTemp());//GEN-END:|53-getter|1|53-postInit
            // write post-init user code here
        }//GEN-BEGIN:|53-getter|2|
        return temperaturaStringItem;
    }
    //</editor-fold>//GEN-END:|53-getter|2|
    //</editor-fold>


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
                buttonImage = Image.createImage("/prevTemp/images/seta.jpg");
            } catch (java.io.IOException e) {//GEN-END:|60-getter|1|60-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|60-getter|2|60-postInit
            // write post-init user code here
        }//GEN-BEGIN:|60-getter|3|
        return buttonImage;
    }
    //</editor-fold>//GEN-END:|60-getter|3|




    //</editor-fold>



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: localdataSringItem ">//GEN-BEGIN:|70-getter|0|70-preInit
    /**
     * Returns an initiliazed instance of localdataSringItem component.
     * @return the initialized component instance
     */
    public StringItem getLocaldataSringItem() {
        if (localdataSringItem == null) {//GEN-END:|70-getter|0|70-preInit
            // write pre-init user code here
            localdataSringItem = new StringItem("", "");//GEN-LINE:|70-getter|1|70-postInit
            // write post-init user code here
        }//GEN-BEGIN:|70-getter|2|
        return localdataSringItem;
    }
    //</editor-fold>//GEN-END:|70-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|71-getter|0|71-preInit
    /**
     * Returns an initiliazed instance of okCommand component.
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {//GEN-END:|71-getter|0|71-preInit
            // write pre-init user code here
            okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|71-getter|1|71-postInit
            // write post-init user code here
        }//GEN-BEGIN:|71-getter|2|
        return okCommand;
    }
    //</editor-fold>//GEN-END:|71-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: form ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initiliazed instance of form component.
     * @return the initialized component instance
     */
    public Form getForm() {
        if (form == null) {//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
            form = new Form("Previs\u00E3o do Tempo", new Item[] { getImageItem(), getStringItem(), getCidadetextField() });//GEN-BEGIN:|14-getter|1|14-postInit
            form.addCommand(getExitCommand());
            form.addCommand(getBuscarCommand());
            form.setCommandListener(this);//GEN-END:|14-getter|1|14-postInit
            // write post-init user code here
        }//GEN-BEGIN:|14-getter|2|
        return form;
    }
    //</editor-fold>//GEN-END:|14-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cidadetextField ">//GEN-BEGIN:|64-getter|0|64-preInit
    /**
     * Returns an initiliazed instance of cidadetextField component.
     * @return the initialized component instance
     */
    public TextField getCidadetextField() {
        if (cidadetextField == null) {//GEN-END:|64-getter|0|64-preInit
            // write pre-init user code here
            cidadetextField = new TextField("", "", 32, TextField.ANY | TextField.INITIAL_CAPS_WORD);//GEN-BEGIN:|64-getter|1|64-postInit
            cidadetextField.setInitialInputMode("ABC");//GEN-END:|64-getter|1|64-postInit
            // write post-init user code here
        }//GEN-BEGIN:|64-getter|2|
        return cidadetextField;
    }
    //</editor-fold>//GEN-END:|64-getter|2|



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tempoStringItem ">//GEN-BEGIN:|72-getter|0|72-preInit
    /**
     * Returns an initiliazed instance of tempoStringItem component.
     * @return the initialized component instance
     */
    public StringItem getTempoStringItem() {
        if (tempoStringItem == null) {//GEN-END:|72-getter|0|72-preInit
            // write pre-init user code here
            tempoStringItem = new StringItem("", "");//GEN-BEGIN:|72-getter|1|72-postInit
            tempoStringItem.setLayout(ImageItem.LAYOUT_DEFAULT);//GEN-END:|72-getter|1|72-postInit
            // write post-init user code here
        }//GEN-BEGIN:|72-getter|2|
        return tempoStringItem;
    }
    //</editor-fold>//GEN-END:|72-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tempoImageItem ">//GEN-BEGIN:|73-getter|0|73-preInit
    /**
     * Returns an initiliazed instance of tempoImageItem component.
     * @return the initialized component instance
     */
    public ImageItem getTempoImageItem() {
        if (tempoImageItem == null) {//GEN-END:|73-getter|0|73-preInit
            // write pre-init user code here
            tempoImageItem = new ImageItem("", null, ImageItem.LAYOUT_CENTER | Item.LAYOUT_TOP | Item.LAYOUT_BOTTOM | Item.LAYOUT_VCENTER | Item.LAYOUT_SHRINK | Item.LAYOUT_VSHRINK | Item.LAYOUT_EXPAND | Item.LAYOUT_VEXPAND, "SEM PREVIS\u00C3O", Item.PLAIN);//GEN-LINE:|73-getter|1|73-postInit
            // write post-init user code here
        }//GEN-BEGIN:|73-getter|2|
        return tempoImageItem;
    }
    //</editor-fold>//GEN-END:|73-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: pnt ">//GEN-BEGIN:|74-getter|0|74-preInit
    /**
     * Returns an initiliazed instance of pnt component.
     * @return the initialized component instance
     */
    public Image getPnt() {
        if (pnt == null) {//GEN-END:|74-getter|0|74-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|74-getter|1|74-@java.io.IOException
                pnt = Image.createImage("/prevTemp/images/pnt.png");
            } catch (java.io.IOException e) {//GEN-END:|74-getter|1|74-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|74-getter|2|74-postInit
            // write post-init user code here
        }//GEN-BEGIN:|74-getter|3|
        return pnt;
    }
    //</editor-fold>//GEN-END:|74-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: n ">//GEN-BEGIN:|75-getter|0|75-preInit
    /**
     * Returns an initiliazed instance of n component.
     * @return the initialized component instance
     */
    public Image getN() {
        if (n == null) {//GEN-END:|75-getter|0|75-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|75-getter|1|75-@java.io.IOException
                n = Image.createImage("/prevTemp/images/n.png");
            } catch (java.io.IOException e) {//GEN-END:|75-getter|1|75-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|75-getter|2|75-postInit
            // write post-init user code here
        }//GEN-BEGIN:|75-getter|3|
        return n;
    }
    //</editor-fold>//GEN-END:|75-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: pn ">//GEN-BEGIN:|76-getter|0|76-preInit
    /**
     * Returns an initiliazed instance of pn component.
     * @return the initialized component instance
     */
    public Image getPn() {
        if (pn == null) {//GEN-END:|76-getter|0|76-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|76-getter|1|76-@java.io.IOException
                pn = Image.createImage("/prevTemp/images/pn.png");
            } catch (java.io.IOException e) {//GEN-END:|76-getter|1|76-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|76-getter|2|76-postInit
            // write post-init user code here
        }//GEN-BEGIN:|76-getter|3|
        return pn;
    }
    //</editor-fold>//GEN-END:|76-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: in ">//GEN-BEGIN:|77-getter|0|77-preInit
    /**
     * Returns an initiliazed instance of in component.
     * @return the initialized component instance
     */
    public Image getIn() {
        if (in == null) {//GEN-END:|77-getter|0|77-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|77-getter|1|77-@java.io.IOException
                in = Image.createImage("/prevTemp/images/in.png");
            } catch (java.io.IOException e) {//GEN-END:|77-getter|1|77-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|77-getter|2|77-postInit
            // write post-init user code here
        }//GEN-BEGIN:|77-getter|3|
        return in;
    }
    //</editor-fold>//GEN-END:|77-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ppm ">//GEN-BEGIN:|78-getter|0|78-preInit
    /**
     * Returns an initiliazed instance of ppm component.
     * @return the initialized component instance
     */
    public Image getPpm() {
        if (ppm == null) {//GEN-END:|78-getter|0|78-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|78-getter|1|78-@java.io.IOException
                ppm = Image.createImage("/prevTemp/images/ppm.png");
            } catch (java.io.IOException e) {//GEN-END:|78-getter|1|78-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|78-getter|2|78-postInit
            // write post-init user code here
        }//GEN-BEGIN:|78-getter|3|
        return ppm;
    }
    //</editor-fold>//GEN-END:|78-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ncn ">//GEN-BEGIN:|79-getter|0|79-preInit
    /**
     * Returns an initiliazed instance of ncn component.
     * @return the initialized component instance
     */
    public Image getNcn() {
        if (ncn == null) {//GEN-END:|79-getter|0|79-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|79-getter|1|79-@java.io.IOException
                ncn = Image.createImage("/prevTemp/images/ncn.png");
            } catch (java.io.IOException e) {//GEN-END:|79-getter|1|79-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|79-getter|2|79-postInit
            // write post-init user code here
        }//GEN-BEGIN:|79-getter|3|
        return ncn;
    }
    //</editor-fold>//GEN-END:|79-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: pp ">//GEN-BEGIN:|80-getter|0|80-preInit
    /**
     * Returns an initiliazed instance of pp component.
     * @return the initialized component instance
     */
    public Image getPp() {
        if (pp == null) {//GEN-END:|80-getter|0|80-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|80-getter|1|80-@java.io.IOException
                pp = Image.createImage("/prevTemp/images/pp.png");
            } catch (java.io.IOException e) {//GEN-END:|80-getter|1|80-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|80-getter|2|80-postInit
            // write post-init user code here
        }//GEN-BEGIN:|80-getter|3|
        return pp;
    }
    //</editor-fold>//GEN-END:|80-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ncm ">//GEN-BEGIN:|81-getter|0|81-preInit
    /**
     * Returns an initiliazed instance of ncm component.
     * @return the initialized component instance
     */
    public Image getNcm() {
        if (ncm == null) {//GEN-END:|81-getter|0|81-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|81-getter|1|81-@java.io.IOException
                ncm = Image.createImage("/prevTemp/images/ncm.png");
            } catch (java.io.IOException e) {//GEN-END:|81-getter|1|81-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|81-getter|2|81-postInit
            // write post-init user code here
        }//GEN-BEGIN:|81-getter|3|
        return ncm;
    }
    //</editor-fold>//GEN-END:|81-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ppt ">//GEN-BEGIN:|82-getter|0|82-preInit
    /**
     * Returns an initiliazed instance of ppt component.
     * @return the initialized component instance
     */
    public Image getPpt() {
        if (ppt == null) {//GEN-END:|82-getter|0|82-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|82-getter|1|82-@java.io.IOException
                ppt = Image.createImage("/prevTemp/images/ppt.png");
            } catch (java.io.IOException e) {//GEN-END:|82-getter|1|82-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|82-getter|2|82-postInit
            // write post-init user code here
        }//GEN-BEGIN:|82-getter|3|
        return ppt;
    }
    //</editor-fold>//GEN-END:|82-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ppn ">//GEN-BEGIN:|83-getter|0|83-preInit
    /**
     * Returns an initiliazed instance of ppn component.
     * @return the initialized component instance
     */
    public Image getPpn() {
        if (ppn == null) {//GEN-END:|83-getter|0|83-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|83-getter|1|83-@java.io.IOException
                ppn = Image.createImage("/prevTemp/images/ppn.png");
            } catch (java.io.IOException e) {//GEN-END:|83-getter|1|83-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|83-getter|2|83-postInit
            // write post-init user code here
        }//GEN-BEGIN:|83-getter|3|
        return ppn;
    }
    //</editor-fold>//GEN-END:|83-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: psc ">//GEN-BEGIN:|84-getter|0|84-preInit
    /**
     * Returns an initiliazed instance of psc component.
     * @return the initialized component instance
     */
    public Image getPsc() {
        if (psc == null) {//GEN-END:|84-getter|0|84-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|84-getter|1|84-@java.io.IOException
                psc = Image.createImage("/prevTemp/images/psc.png");
            } catch (java.io.IOException e) {//GEN-END:|84-getter|1|84-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|84-getter|2|84-postInit
            // write post-init user code here
        }//GEN-BEGIN:|84-getter|3|
        return psc;
    }
    //</editor-fold>//GEN-END:|84-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: g ">//GEN-BEGIN:|85-getter|0|85-preInit
    /**
     * Returns an initiliazed instance of g component.
     * @return the initialized component instance
     */
    public Image getG() {
        if (g == null) {//GEN-END:|85-getter|0|85-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|85-getter|1|85-@java.io.IOException
                g = Image.createImage("/prevTemp/images/g.png");
            } catch (java.io.IOException e) {//GEN-END:|85-getter|1|85-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|85-getter|2|85-postInit
            // write post-init user code here
        }//GEN-BEGIN:|85-getter|3|
        return g;
    }
    //</editor-fold>//GEN-END:|85-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ps ">//GEN-BEGIN:|86-getter|0|86-preInit
    /**
     * Returns an initiliazed instance of ps component.
     * @return the initialized component instance
     */
    public Image getPs() {
        if (ps == null) {//GEN-END:|86-getter|0|86-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|86-getter|1|86-@java.io.IOException
                ps = Image.createImage("/prevTemp/images/ps.png");
            } catch (java.io.IOException e) {//GEN-END:|86-getter|1|86-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|86-getter|2|86-postInit
            // write post-init user code here
        }//GEN-BEGIN:|86-getter|3|
        return ps;
    }
    //</editor-fold>//GEN-END:|86-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ec ">//GEN-BEGIN:|87-getter|0|87-preInit
    /**
     * Returns an initiliazed instance of ec component.
     * @return the initialized component instance
     */
    public Image getEc() {
        if (ec == null) {//GEN-END:|87-getter|0|87-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|87-getter|1|87-@java.io.IOException
                ec = Image.createImage("/prevTemp/images/ec.png");
            } catch (java.io.IOException e) {//GEN-END:|87-getter|1|87-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|87-getter|2|87-postInit
            // write post-init user code here
        }//GEN-BEGIN:|87-getter|3|
        return ec;
    }
    //</editor-fold>//GEN-END:|87-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: pcn ">//GEN-BEGIN:|88-getter|0|88-preInit
    /**
     * Returns an initiliazed instance of pcn component.
     * @return the initialized component instance
     */
    public Image getPcn() {
        if (pcn == null) {//GEN-END:|88-getter|0|88-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|88-getter|1|88-@java.io.IOException
                pcn = Image.createImage("/prevTemp/images/pcn.png");
            } catch (java.io.IOException e) {//GEN-END:|88-getter|1|88-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|88-getter|2|88-postInit
            // write post-init user code here
        }//GEN-BEGIN:|88-getter|3|
        return pcn;
    }
    //</editor-fold>//GEN-END:|88-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: pct ">//GEN-BEGIN:|89-getter|0|89-preInit
    /**
     * Returns an initiliazed instance of pct component.
     * @return the initialized component instance
     */
    public Image getPct() {
        if (pct == null) {//GEN-END:|89-getter|0|89-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|89-getter|1|89-@java.io.IOException
                pct = Image.createImage("/prevTemp/images/pct.png");
            } catch (java.io.IOException e) {//GEN-END:|89-getter|1|89-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|89-getter|2|89-postInit
            // write post-init user code here
        }//GEN-BEGIN:|89-getter|3|
        return pct;
    }
    //</editor-fold>//GEN-END:|89-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: pm ">//GEN-BEGIN:|90-getter|0|90-preInit
    /**
     * Returns an initiliazed instance of pm component.
     * @return the initialized component instance
     */
    public Image getPm() {
        if (pm == null) {//GEN-END:|90-getter|0|90-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|90-getter|1|90-@java.io.IOException
                pm = Image.createImage("/prevTemp/images/pm.png");
            } catch (java.io.IOException e) {//GEN-END:|90-getter|1|90-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|90-getter|2|90-postInit
            // write post-init user code here
        }//GEN-BEGIN:|90-getter|3|
        return pm;
    }
    //</editor-fold>//GEN-END:|90-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: npp ">//GEN-BEGIN:|91-getter|0|91-preInit
    /**
     * Returns an initiliazed instance of npp component.
     * @return the initialized component instance
     */
    public Image getNpp() {
        if (npp == null) {//GEN-END:|91-getter|0|91-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|91-getter|1|91-@java.io.IOException
                npp = Image.createImage("/prevTemp/images/npp.png");
            } catch (java.io.IOException e) {//GEN-END:|91-getter|1|91-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|91-getter|2|91-postInit
            // write post-init user code here
        }//GEN-BEGIN:|91-getter|3|
        return npp;
    }
    //</editor-fold>//GEN-END:|91-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: npn ">//GEN-BEGIN:|92-getter|0|92-preInit
    /**
     * Returns an initiliazed instance of npn component.
     * @return the initialized component instance
     */
    public Image getNpn() {
        if (npn == null) {//GEN-END:|92-getter|0|92-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|92-getter|1|92-@java.io.IOException
                npn = Image.createImage("/prevTemp/images/npn.png");
            } catch (java.io.IOException e) {//GEN-END:|92-getter|1|92-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|92-getter|2|92-postInit
            // write post-init user code here
        }//GEN-BEGIN:|92-getter|3|
        return npn;
    }
    //</editor-fold>//GEN-END:|92-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: npm ">//GEN-BEGIN:|93-getter|0|93-preInit
    /**
     * Returns an initiliazed instance of npm component.
     * @return the initialized component instance
     */
    public Image getNpm() {
        if (npm == null) {//GEN-END:|93-getter|0|93-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|93-getter|1|93-@java.io.IOException
                npm = Image.createImage("/prevTemp/images/npm.png");
            } catch (java.io.IOException e) {//GEN-END:|93-getter|1|93-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|93-getter|2|93-postInit
            // write post-init user code here
        }//GEN-BEGIN:|93-getter|3|
        return npm;
    }
    //</editor-fold>//GEN-END:|93-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: t ">//GEN-BEGIN:|94-getter|0|94-preInit
    /**
     * Returns an initiliazed instance of t component.
     * @return the initialized component instance
     */
    public Image getT() {
        if (t == null) {//GEN-END:|94-getter|0|94-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|94-getter|1|94-@java.io.IOException
                t = Image.createImage("/prevTemp/images/t.png");
            } catch (java.io.IOException e) {//GEN-END:|94-getter|1|94-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|94-getter|2|94-postInit
            // write post-init user code here
        }//GEN-BEGIN:|94-getter|3|
        return t;
    }
    //</editor-fold>//GEN-END:|94-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: pcm ">//GEN-BEGIN:|95-getter|0|95-preInit
    /**
     * Returns an initiliazed instance of pcm component.
     * @return the initialized component instance
     */
    public Image getPcm() {
        if (pcm == null) {//GEN-END:|95-getter|0|95-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|95-getter|1|95-@java.io.IOException
                pcm = Image.createImage("/prevTemp/images/pcm.png");
            } catch (java.io.IOException e) {//GEN-END:|95-getter|1|95-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|95-getter|2|95-postInit
            // write post-init user code here
        }//GEN-BEGIN:|95-getter|3|
        return pcm;
    }
    //</editor-fold>//GEN-END:|95-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: pt ">//GEN-BEGIN:|96-getter|0|96-preInit
    /**
     * Returns an initiliazed instance of pt component.
     * @return the initialized component instance
     */
    public Image getPt() {
        if (pt == null) {//GEN-END:|96-getter|0|96-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|96-getter|1|96-@java.io.IOException
                pt = Image.createImage("/prevTemp/images/pt.png");
            } catch (java.io.IOException e) {//GEN-END:|96-getter|1|96-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|96-getter|2|96-postInit
            // write post-init user code here
        }//GEN-BEGIN:|96-getter|3|
        return pt;
    }
    //</editor-fold>//GEN-END:|96-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: pc ">//GEN-BEGIN:|97-getter|0|97-preInit
    /**
     * Returns an initiliazed instance of pc component.
     * @return the initialized component instance
     */
    public Image getPc() {
        if (pc == null) {//GEN-END:|97-getter|0|97-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|97-getter|1|97-@java.io.IOException
                pc = Image.createImage("/prevTemp/images/pc.png");
            } catch (java.io.IOException e) {//GEN-END:|97-getter|1|97-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|97-getter|2|97-postInit
            // write post-init user code here
        }//GEN-BEGIN:|97-getter|3|
        return pc;
    }
    //</editor-fold>//GEN-END:|97-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: nv ">//GEN-BEGIN:|98-getter|0|98-preInit
    /**
     * Returns an initiliazed instance of nv component.
     * @return the initialized component instance
     */
    public Image getNv() {
        if (nv == null) {//GEN-END:|98-getter|0|98-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|98-getter|1|98-@java.io.IOException
                nv = Image.createImage("/prevTemp/images/nv.png");
            } catch (java.io.IOException e) {//GEN-END:|98-getter|1|98-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|98-getter|2|98-postInit
            // write post-init user code here
        }//GEN-BEGIN:|98-getter|3|
        return nv;
    }
    //</editor-fold>//GEN-END:|98-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: npt ">//GEN-BEGIN:|99-getter|0|99-preInit
    /**
     * Returns an initiliazed instance of npt component.
     * @return the initialized component instance
     */
    public Image getNpt() {
        if (npt == null) {//GEN-END:|99-getter|0|99-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|99-getter|1|99-@java.io.IOException
                npt = Image.createImage("/prevTemp/images/npt.png");
            } catch (java.io.IOException e) {//GEN-END:|99-getter|1|99-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|99-getter|2|99-postInit
            // write post-init user code here
        }//GEN-BEGIN:|99-getter|3|
        return npt;
    }
    //</editor-fold>//GEN-END:|99-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ne ">//GEN-BEGIN:|100-getter|0|100-preInit
    /**
     * Returns an initiliazed instance of ne component.
     * @return the initialized component instance
     */
    public Image getNe() {
        if (ne == null) {//GEN-END:|100-getter|0|100-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|100-getter|1|100-@java.io.IOException
                ne = Image.createImage("/prevTemp/images/ne.png");
            } catch (java.io.IOException e) {//GEN-END:|100-getter|1|100-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|100-getter|2|100-postInit
            // write post-init user code here
        }//GEN-BEGIN:|100-getter|3|
        return ne;
    }
    //</editor-fold>//GEN-END:|100-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: np ">//GEN-BEGIN:|101-getter|0|101-preInit
    /**
     * Returns an initiliazed instance of np component.
     * @return the initialized component instance
     */
    public Image getNp() {
        if (np == null) {//GEN-END:|101-getter|0|101-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|101-getter|1|101-@java.io.IOException
                np = Image.createImage("/prevTemp/images/np.png");
            } catch (java.io.IOException e) {//GEN-END:|101-getter|1|101-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|101-getter|2|101-postInit
            // write post-init user code here
        }//GEN-BEGIN:|101-getter|3|
        return np;
    }
    //</editor-fold>//GEN-END:|101-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ch ">//GEN-BEGIN:|102-getter|0|102-preInit
    /**
     * Returns an initiliazed instance of ch component.
     * @return the initialized component instance
     */
    public Image getCh() {
        if (ch == null) {//GEN-END:|102-getter|0|102-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|102-getter|1|102-@java.io.IOException
                ch = Image.createImage("/prevTemp/images/ch.png");
            } catch (java.io.IOException e) {//GEN-END:|102-getter|1|102-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|102-getter|2|102-postInit
            // write post-init user code here
        }//GEN-BEGIN:|102-getter|3|
        return ch;
    }
    //</editor-fold>//GEN-END:|102-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: nct ">//GEN-BEGIN:|103-getter|0|103-preInit
    /**
     * Returns an initiliazed instance of nct component.
     * @return the initialized component instance
     */
    public Image getNct() {
        if (nct == null) {//GEN-END:|103-getter|0|103-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|103-getter|1|103-@java.io.IOException
                nct = Image.createImage("/prevTemp/images/nct.png");
            } catch (java.io.IOException e) {//GEN-END:|103-getter|1|103-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|103-getter|2|103-postInit
            // write post-init user code here
        }//GEN-BEGIN:|103-getter|3|
        return nct;
    }
    //</editor-fold>//GEN-END:|103-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: c ">//GEN-BEGIN:|104-getter|0|104-preInit
    /**
     * Returns an initiliazed instance of c component.
     * @return the initialized component instance
     */
    public Image getC() {
        if (c == null) {//GEN-END:|104-getter|0|104-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|104-getter|1|104-@java.io.IOException
                c = Image.createImage("/prevTemp/images/c.png");
            } catch (java.io.IOException e) {//GEN-END:|104-getter|1|104-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|104-getter|2|104-postInit
            // write post-init user code here
        }//GEN-BEGIN:|104-getter|3|
        return c;
    }
    //</editor-fold>//GEN-END:|104-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: nd ">//GEN-BEGIN:|105-getter|0|105-preInit
    /**
     * Returns an initiliazed instance of nd component.
     * @return the initialized component instance
     */
    public Image getNd() {
        if (nd == null) {//GEN-END:|105-getter|0|105-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|105-getter|1|105-@java.io.IOException
                nd = Image.createImage("/prevTemp/images/nd.png");
            } catch (java.io.IOException e) {//GEN-END:|105-getter|1|105-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|105-getter|2|105-postInit
            // write post-init user code here
        }//GEN-BEGIN:|105-getter|3|
        return nd;
    }
    //</editor-fold>//GEN-END:|105-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cv ">//GEN-BEGIN:|106-getter|0|106-preInit
    /**
     * Returns an initiliazed instance of cv component.
     * @return the initialized component instance
     */
    public Image getCv() {
        if (cv == null) {//GEN-END:|106-getter|0|106-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|106-getter|1|106-@java.io.IOException
                cv = Image.createImage("/prevTemp/images/cv.png");
            } catch (java.io.IOException e) {//GEN-END:|106-getter|1|106-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|106-getter|2|106-postInit
            // write post-init user code here
        }//GEN-BEGIN:|106-getter|3|
        return cv;
    }
    //</editor-fold>//GEN-END:|106-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ct ">//GEN-BEGIN:|107-getter|0|107-preInit
    /**
     * Returns an initiliazed instance of ct component.
     * @return the initialized component instance
     */
    public Image getCt() {
        if (ct == null) {//GEN-END:|107-getter|0|107-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|107-getter|1|107-@java.io.IOException
                ct = Image.createImage("/prevTemp/images/ct.png");
            } catch (java.io.IOException e) {//GEN-END:|107-getter|1|107-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|107-getter|2|107-postInit
            // write post-init user code here
        }//GEN-BEGIN:|107-getter|3|
        return ct;
    }
    //</editor-fold>//GEN-END:|107-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: vn ">//GEN-BEGIN:|108-getter|0|108-preInit
    /**
     * Returns an initiliazed instance of vn component.
     * @return the initialized component instance
     */
    public Image getVn() {
        if (vn == null) {//GEN-END:|108-getter|0|108-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|108-getter|1|108-@java.io.IOException
                vn = Image.createImage("/prevTemp/images/vn.png");
            } catch (java.io.IOException e) {//GEN-END:|108-getter|1|108-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|108-getter|2|108-postInit
            // write post-init user code here
        }//GEN-BEGIN:|108-getter|3|
        return vn;
    }
    //</editor-fold>//GEN-END:|108-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: e ">//GEN-BEGIN:|109-getter|0|109-preInit
    /**
     * Returns an initiliazed instance of e component.
     * @return the initialized component instance
     */
    public Image getE() {
        if (e == null) {//GEN-END:|109-getter|0|109-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|109-getter|1|109-@java.io.IOException
                e = Image.createImage("/prevTemp/images/e.png");
            } catch (java.io.IOException e) {//GEN-END:|109-getter|1|109-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|109-getter|2|109-postInit
            // write post-init user code here
        }//GEN-BEGIN:|109-getter|3|
        return e;
    }
    //</editor-fold>//GEN-END:|109-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cl ">//GEN-BEGIN:|110-getter|0|110-preInit
    /**
     * Returns an initiliazed instance of cl component.
     * @return the initialized component instance
     */
    public Image getCl() {
        if (cl == null) {//GEN-END:|110-getter|0|110-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|110-getter|1|110-@java.io.IOException
                cl = Image.createImage("/prevTemp/images/cl.png");
            } catch (java.io.IOException e) {//GEN-END:|110-getter|1|110-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|110-getter|2|110-postInit
            // write post-init user code here
        }//GEN-BEGIN:|110-getter|3|
        return cl;
    }
    //</editor-fold>//GEN-END:|110-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ci ">//GEN-BEGIN:|111-getter|0|111-preInit
    /**
     * Returns an initiliazed instance of ci component.
     * @return the initialized component instance
     */
    public Image getCi() {
        if (ci == null) {//GEN-END:|111-getter|0|111-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|111-getter|1|111-@java.io.IOException
                ci = Image.createImage("/prevTemp/images/ci.png");
            } catch (java.io.IOException e) {//GEN-END:|111-getter|1|111-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|111-getter|2|111-postInit
            // write post-init user code here
        }//GEN-BEGIN:|111-getter|3|
        return ci;
    }
    //</editor-fold>//GEN-END:|111-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cn ">//GEN-BEGIN:|112-getter|0|112-preInit
    /**
     * Returns an initiliazed instance of cn component.
     * @return the initialized component instance
     */
    public Image getCn() {
        if (cn == null) {//GEN-END:|112-getter|0|112-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|112-getter|1|112-@java.io.IOException
                cn = Image.createImage("/prevTemp/images/cn.png");
            } catch (java.io.IOException e) {//GEN-END:|112-getter|1|112-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|112-getter|2|112-postInit
            // write post-init user code here
        }//GEN-BEGIN:|112-getter|3|
        return cn;
    }
    //</editor-fold>//GEN-END:|112-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cm ">//GEN-BEGIN:|113-getter|0|113-preInit
    /**
     * Returns an initiliazed instance of cm component.
     * @return the initialized component instance
     */
    public Image getCm() {
        if (cm == null) {//GEN-END:|113-getter|0|113-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|113-getter|1|113-@java.io.IOException
                cm = Image.createImage("/prevTemp/images/cm.png");
            } catch (java.io.IOException e) {//GEN-END:|113-getter|1|113-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|113-getter|2|113-postInit
            // write post-init user code here
        }//GEN-BEGIN:|113-getter|3|
        return cm;
    }
    //</editor-fold>//GEN-END:|113-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: imageItem ">//GEN-BEGIN:|118-getter|0|118-preInit
    /**
     * Returns an initiliazed instance of imageItem component.
     * @return the initialized component instance
     */
    public ImageItem getImageItem() {
        if (imageItem == null) {//GEN-END:|118-getter|0|118-preInit
            // write pre-init user code here
            imageItem = new ImageItem("", getLogo(), ImageItem.LAYOUT_CENTER | Item.LAYOUT_TOP | Item.LAYOUT_BOTTOM | Item.LAYOUT_VCENTER | ImageItem.LAYOUT_NEWLINE_AFTER | Item.LAYOUT_SHRINK | Item.LAYOUT_VSHRINK | Item.LAYOUT_EXPAND | Item.LAYOUT_VEXPAND, "<Missing Image>");//GEN-BEGIN:|118-getter|1|118-postInit
            imageItem.setPreferredSize(20, -1);//GEN-END:|118-getter|1|118-postInit
            // write post-init user code here
        }//GEN-BEGIN:|118-getter|2|
        return imageItem;
    }
    //</editor-fold>//GEN-END:|118-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: logo ">//GEN-BEGIN:|117-getter|0|117-preInit
    /**
     * Returns an initiliazed instance of logo component.
     * @return the initialized component instance
     */
    public Image getLogo() {
        if (logo == null) {//GEN-END:|117-getter|0|117-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|117-getter|1|117-@java.io.IOException
                logo = Image.createImage("/prevTemp/images/_logo150xnv2.png");
            } catch (java.io.IOException e) {//GEN-END:|117-getter|1|117-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|117-getter|2|117-postInit
            // write post-init user code here
        }//GEN-BEGIN:|117-getter|3|
        return logo;
    }
    //</editor-fold>//GEN-END:|117-getter|3|







    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand1 ">//GEN-BEGIN:|122-getter|0|122-preInit
    /**
     * Returns an initiliazed instance of okCommand1 component.
     * @return the initialized component instance
     */
    public Command getOkCommand1() {
        if (okCommand1 == null) {//GEN-END:|122-getter|0|122-preInit
            // write pre-init user code here
            okCommand1 = new Command("Ok", Command.OK, 0);//GEN-LINE:|122-getter|1|122-postInit
            // write post-init user code here
        }//GEN-BEGIN:|122-getter|2|
        return okCommand1;
    }
    //</editor-fold>//GEN-END:|122-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|126-getter|0|126-preInit
    /**
     * Returns an initiliazed instance of backCommand component.
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {//GEN-END:|126-getter|0|126-preInit
            // write pre-init user code here
            backCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|126-getter|1|126-postInit
            // write post-init user code here
        }//GEN-BEGIN:|126-getter|2|
        return backCommand;
    }
    //</editor-fold>//GEN-END:|126-getter|2|



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: provCommand ">//GEN-BEGIN:|128-getter|0|128-preInit
    /**
     * Returns an initiliazed instance of provCommand component.
     * @return the initialized component instance
     */
    public Command getProvCommand() {
        if (provCommand == null) {//GEN-END:|128-getter|0|128-preInit
            // write pre-init user code here
            provCommand = new Command("Pr\u00F3ximos DIas", Command.ITEM, 0);//GEN-LINE:|128-getter|1|128-postInit
            // write post-init user code here
        }//GEN-BEGIN:|128-getter|2|
        return provCommand;
    }
    //</editor-fold>//GEN-END:|128-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: hojeBackCommand ">//GEN-BEGIN:|136-getter|0|136-preInit
    /**
     * Returns an initiliazed instance of hojeBackCommand component.
     * @return the initialized component instance
     */
    public Command getHojeBackCommand() {
        if (hojeBackCommand == null) {//GEN-END:|136-getter|0|136-preInit
            // write pre-init user code here
            hojeBackCommand = new Command("Voltar", Command.BACK, 0);//GEN-LINE:|136-getter|1|136-postInit
            // write post-init user code here
        }//GEN-BEGIN:|136-getter|2|
        return hojeBackCommand;
    }
    //</editor-fold>//GEN-END:|136-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: proxForm ">//GEN-BEGIN:|135-getter|0|135-preInit
    /**
     * Returns an initiliazed instance of proxForm component.
     * @return the initialized component instance
     */
    public Form getProxForm() {
        if (proxForm == null) {//GEN-END:|135-getter|0|135-preInit
            // write pre-init user code here
            proxForm = new Form("Previs\u00E3o p/ Pr\u00F3ximos Dias", new Item[] { getData1StringItem(), getTemp1StringItem(), getData2StringItem(), getTemp2StringItem() });//GEN-BEGIN:|135-getter|1|135-postInit
            proxForm.addCommand(getHojeBackCommand());
            proxForm.setCommandListener(this);//GEN-END:|135-getter|1|135-postInit
            // write post-init user code here
        }//GEN-BEGIN:|135-getter|2|
        return proxForm;
    }
    //</editor-fold>//GEN-END:|135-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: data1StringItem ">//GEN-BEGIN:|140-getter|0|140-preInit
    /**
     * Returns an initiliazed instance of data1StringItem component.
     * @return the initialized component instance
     */
    public StringItem getData1StringItem() {
        if (data1StringItem == null) {//GEN-END:|140-getter|0|140-preInit
            // write pre-init user code here
            data1StringItem = new StringItem("", "data1");//GEN-BEGIN:|140-getter|1|140-postInit
            data1StringItem.setLayout(ImageItem.LAYOUT_DEFAULT);//GEN-END:|140-getter|1|140-postInit
            // write post-init user code here
        }//GEN-BEGIN:|140-getter|2|
        return data1StringItem;
    }
    //</editor-fold>//GEN-END:|140-getter|2|



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: temp1StringItem ">//GEN-BEGIN:|142-getter|0|142-preInit
    /**
     * Returns an initiliazed instance of temp1StringItem component.
     * @return the initialized component instance
     */
    public StringItem getTemp1StringItem() {
        if (temp1StringItem == null) {//GEN-END:|142-getter|0|142-preInit
            // write pre-init user code here
            temp1StringItem = new StringItem("", "temp1");//GEN-BEGIN:|142-getter|1|142-postInit
            temp1StringItem.setLayout(ImageItem.LAYOUT_DEFAULT);
            temp1StringItem.setFont(getFontTemp());//GEN-END:|142-getter|1|142-postInit
            // write post-init user code here
        }//GEN-BEGIN:|142-getter|2|
        return temp1StringItem;
    }
    //</editor-fold>//GEN-END:|142-getter|2|



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: data2StringItem ">//GEN-BEGIN:|144-getter|0|144-preInit
    /**
     * Returns an initiliazed instance of data2StringItem component.
     * @return the initialized component instance
     */
    public StringItem getData2StringItem() {
        if (data2StringItem == null) {//GEN-END:|144-getter|0|144-preInit
            // write pre-init user code here
            data2StringItem = new StringItem("", "data2");//GEN-BEGIN:|144-getter|1|144-postInit
            data2StringItem.setLayout(ImageItem.LAYOUT_DEFAULT);//GEN-END:|144-getter|1|144-postInit
            // write post-init user code here
        }//GEN-BEGIN:|144-getter|2|
        return data2StringItem;
    }
    //</editor-fold>//GEN-END:|144-getter|2|



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: temp2StringItem ">//GEN-BEGIN:|146-getter|0|146-preInit
    /**
     * Returns an initiliazed instance of temp2StringItem component.
     * @return the initialized component instance
     */
    public StringItem getTemp2StringItem() {
        if (temp2StringItem == null) {//GEN-END:|146-getter|0|146-preInit
            // write pre-init user code here
            temp2StringItem = new StringItem("", "temp2");//GEN-BEGIN:|146-getter|1|146-postInit
            temp2StringItem.setLayout(ImageItem.LAYOUT_DEFAULT);
            temp2StringItem.setFont(getFontTemp());//GEN-END:|146-getter|1|146-postInit
            // write post-init user code here
        }//GEN-BEGIN:|146-getter|2|
        return temp2StringItem;
    }
    //</editor-fold>//GEN-END:|146-getter|2|
    //</editor-fold>









    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: fontTemp ">//GEN-BEGIN:|151-getter|0|151-preInit
    /**
     * Returns an initiliazed instance of fontTemp component.
     * @return the initialized component instance
     */
    public Font getFontTemp() {
        if (fontTemp == null) {//GEN-END:|151-getter|0|151-preInit
            // write pre-init user code here
            fontTemp = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_LARGE);//GEN-LINE:|151-getter|1|151-postInit
            // write post-init user code here
        }//GEN-BEGIN:|151-getter|2|
        return fontTemp;
    }
    //</editor-fold>//GEN-END:|151-getter|2|







    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem ">//GEN-BEGIN:|154-getter|0|154-preInit
    /**
     * Returns an initiliazed instance of stringItem component.
     * @return the initialized component instance
     */
    public StringItem getStringItem() {
        if (stringItem == null) {//GEN-END:|154-getter|0|154-preInit
            // write pre-init user code here
            stringItem = new StringItem("", "Digite o nome da cidade que deseja verificar a previs\u00E3o do tempo.");//GEN-LINE:|154-getter|1|154-postInit
            // write post-init user code here
        }//GEN-BEGIN:|154-getter|2|
        return stringItem;
    }
    //</editor-fold>//GEN-END:|154-getter|2|















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
